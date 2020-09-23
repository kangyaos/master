package com.sxhalo.lmb.controller.app;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.CoalGoods;
import com.sxhalo.lmb.domain.CoalGoodsHis;
import com.sxhalo.lmb.domain.CoalTransport;
import com.sxhalo.lmb.domain.OperateAdvertisement;
import com.sxhalo.lmb.domain.OperateAdvertisementCategory;
import com.sxhalo.lmb.domain.UserQuickOrder;
import com.sxhalo.lmb.service.ICoalGoodsHisService;
import com.sxhalo.lmb.service.ICoalGoodsService;
import com.sxhalo.lmb.service.ICoalTransportService;
import com.sxhalo.lmb.service.IOperateAdvertisementCategoryService;
import com.sxhalo.lmb.service.IOperateAdvertisementService;
import com.sxhalo.lmb.service.IUserQuickOrderService;
import com.sxhalo.lmb.util.DateUtil;
import com.sxhalo.lmb.util.MD5Util;
import com.sxhalo.lmb.util.WXAuthUtil;


@Controller
public class AppShareGoodsController extends BaseController {
	
	@Autowired
	private ICoalGoodsService goodsService;
	@Autowired
	private ICoalGoodsHisService hisService;
	@Autowired
	private IOperateAdvertisementService adverService;
	@Autowired
	private IOperateAdvertisementCategoryService adCategoryService;

	@RequestMapping(value = "/coalGoodsInfo.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String coalGoodsInfo(HttpServletRequest req, ModelMap model, String goodsId, String username,String mobile) {
		// 获取数据
		try {
			CoalGoods goods = goodsService.selectByPrimaryKey(goodsId);
			model.put("goods", goods == null ? new CoalGoods() : goods);
			
			model.put("mineRegionName", goods == null ? "" : getFullRegionName(goods.getCompanies().getRegionCode()));
			model.put("salesRegionName", goods == null ? "" : getFullRegionName(goods.getSales().getRegionCode()));
			// coalReportPicUrl
			String coalReportPicUrl = getPictureUrl(goods.getCoalReportPicCode());
			model.put("coalReportPicUrl", "".equals(coalReportPicUrl) ? null : coalReportPicUrl);
			// coalSalePicUrl
			String coalSalePicUrl = getPictureUrl(goods.getSales().getCoalSalePicCode());
			model.put("coalSalePicUrl", "".equals(coalSalePicUrl) ? null : coalSalePicUrl);
			// mineMouthPicUrl
			String mineMouthPicUrl = getPictureUrl(goods.getCompanies().getMineMouthPicCode());
			model.put("mineMouthPicUrl", "".equals(mineMouthPicUrl) ? null : mineMouthPicUrl);
			model.put("userMobile", goods.getUserInfo().getUserMobile());

			Timestamp nowtime = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatTime = sdf.format(nowtime);
			String adwhere = "begin_time<='" + formatTime + "' and end_time>='" + formatTime
					+ "' and delete_flag=0 and ad_state=1 and ad_cotegory_code='coalGoodsInfo'";
			List<OperateAdvertisement> adlist = adverService.findWhereList(adwhere, "order_index desc");
			OperateAdvertisementCategory category = adCategoryService.selectByPrimaryKey("coalGoodsInfo");
			OperateAdvertisement adver = new OperateAdvertisement();
			adver.setAdPicCode(category.getAdPlaceholderPicCode());
			if(adlist.size() > 0) {
				adver = adlist.get(0);
				if (adver.getAdPicCode() == null) {
					adver.setAdPicCode(category.getAdPlaceholderPicCode());
				}
			}
			String adPicUrl = getPictureUrl(adver.getAdPicCode());
			model.put("adver", adver);
			model.put("adPicUrl", adPicUrl);
			model.put("username", username==null?"000":username);
			model.put("mobile", mobile==null?"000":mobile);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return "/view/appshare/coalinfo";
	}

	@ResponseBody
	@RequestMapping(value = "/coalpricechart.json", method = RequestMethod.GET)
	public Map<String, Object> coalpricechart(HttpServletRequest req, String goodsId, Integer day) {
		Map<String, Object> chardata = new HashMap<String, Object>();
		try {
			Timestamp nowtime = new Timestamp(System.currentTimeMillis());
			Date today = DateUtil.addDay(nowtime, -day + 1);
			List<Map<String, Object>> list = hisService.getChartData(goodsId, DateUtil.sdf5.format(today));
			for (Map<String, Object> map : list) {
				chardata.put(map.get("ptime").toString(), map.get("one_quote"));
			}
			List<String> categories = new ArrayList<String>();
			List<Integer> oneQuote = new ArrayList<Integer>();
			List<Integer> yearQuote = new ArrayList<Integer>();
			for (int i = 0; i < day; i++) {
				Date date = DateUtil.addDay(today, i);
				String datestr = DateUtil.sdf2.format(date);
				if ((i % 3 == 0 && day == 30) || day == 7) {
					categories.add(DateUtil.sdf2.format(date));
				} else if (day == 30) {
					categories.add("");
				}
				if (chardata.get(DateUtil.sdf5.format(date)) == null) {
					if (i == 0) {
						String where = "publish_time <'" + DateUtil.sdf5.format(date) + "' and  goods_release_num like '" + goodsId + "%'";
						List<CoalGoodsHis> GoodsHislist = hisService.findPagerList(0, 1, where,	"publish_time desc");
						if (GoodsHislist.isEmpty()) {
							oneQuote.add(0);
						} else {
							oneQuote.add(GoodsHislist.get(0).getOneQuote().intValue());
						}
					} else {
						oneQuote.add(oneQuote.get(i - 1));
					}
				} else {
					BigDecimal decimal = (BigDecimal) chardata.get(DateUtil.sdf5.format(date));
					oneQuote.add(decimal.intValue());
				}
				if (day == 180 && i % 10 == 0) {
					if (i % 20 == 0) {
						categories.add(DateUtil.sdf2.format(date));
					} else {
						categories.add("");
					}
					yearQuote.add(oneQuote.get(i));
				}
				if (day == 365 && (datestr.endsWith("01"))) {
					if (categories.size() % 2 == 0) {
						categories.add(DateUtil.sdf2.format(date));
					} else {
						categories.add("");
					}
					yearQuote.add(oneQuote.get(i));
				}
			}
			chardata.put("categories", categories);
			chardata.put("oneQuote", oneQuote);
			if (day == 365 || day == 180) {
				chardata.put("oneQuote", yearQuote);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return chardata;
	}

	@RequestMapping(value = "/shareGoods.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String shareCoalGoods(HttpServletRequest req, ModelMap model, String releaseNum, Integer share) {
		String url = req.getScheme() // 当前链接使用的协议
				+ "://" + req.getServerName()// 服务器地址
				+ req.getContextPath() // 应用名称，如果应用名称为
				+ req.getServletPath() // 请求的相对url
				+ "?" + req.getQueryString(); // 请求参数
		String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);// 随机字符串
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);// 时间戳
		String jsapi_ticket = WXAuthUtil.getJsapiTicket();
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ url; // 微信票据 随机数 时间戳
		String signature = MD5Util.getSha1(str);

		model.put("appId", "wx97e45c6f6c111e49"); // appId
		model.put("nonceStr", noncestr); // 随机字符串
		model.put("timeStamp", timestamp); // 时间戳
		model.put("signature", signature); // 签名
		model.put("url", url);
		// 获取数据
		try {
			model.put("share", share == null ? 0 : share);
			CoalGoodsHis goodsHis = hisService.selectByPrimaryKey(releaseNum);
			CoalGoods goods = null;
			if (goodsHis != null) {
				goods = goodsHis.getCoalGoods();
			}else {
				String goodsId = releaseNum.substring(0, 21);
				goods = goodsService.selectByPrimaryKey(goodsId);
			}
			model.put("goods", goods == null ? new CoalGoods() : goods);
			model.put("mineRegionName", goods == null ? "" : getFullRegionName(goods.getCompanies().getRegionCode()));
			model.put("salesRegionName", goods == null ? "" : getFullRegionName(goods.getSales().getRegionCode()));
			// coalReportPicUrl
			String coalReportPicUrl = getPictureUrl(goods.getCoalReportPicCode());
			model.put("coalReportPicUrl", "".equals(coalReportPicUrl) ? null : coalReportPicUrl);
			// coalSalePicUrl
			String coalSalePicUrl = getPictureUrl(goods.getSales().getCoalSalePicCode());
			model.put("coalSalePicUrl", "".equals(coalSalePicUrl) ? null : coalSalePicUrl);
			// mineMouthPicUrl
			String mineMouthPicUrl = getPictureUrl(goods.getCompanies().getMineMouthPicCode());
			model.put("mineMouthPicUrl", "".equals(mineMouthPicUrl) ? null : mineMouthPicUrl);
			// 价格曲线数据
			List<String> categories = new ArrayList<String>();
			List<String> oneQuote = new ArrayList<String>();
			List<CoalGoodsHis> list = hisService.findPagerList(0, 7, "goods_id='" + goods.getGoodsId() + "'",
					"publish_time desc");
			if (list.size() > 0) {
				for (int i = 0; i < 7; i++) {
					if (i >= list.size()) {
						list.add(list.get(0));
					}
				}
				Collections.reverse(list);
				Timestamp nowtime = new Timestamp(System.currentTimeMillis());
				SimpleDateFormat sdf7 = new SimpleDateFormat("dd日");
				Date today = DateUtil.addDay(nowtime, -6);
				for (int i = 0; i < 7; i++) {
					CoalGoodsHis his = list.get(i);
					Date date = DateUtil.addDay(today, i);
					categories.add("'" + sdf7.format(date) + "'");
					if (i == 6) {
						oneQuote.add(goods.getOneQuote().toString());
					} else {
						oneQuote.add(his.getOneQuote().toString());
					}
				}
			}
			model.put("userMobile", goods.getUserInfo().getUserMobile());
			model.put("categories", categories.toString());
			model.put("oneQuote", oneQuote.toString());
			model.put("base", req.getContextPath());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return "/view/appshare/shareCoalGoods";
	}
	
	/**
	 * 煤炭对比雷达图
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/coalcompare.html", method = RequestMethod.GET)
	public String coalcompare(HttpServletRequest request, String goodsId1, String goodsId2, String goodsId3,
			ModelMap map) {
		try {
			List<Object> goodlist = new ArrayList<Object>();
			goodlist.add(goodsService.selectByPrimaryKey(goodsId1));
			goodlist.add(goodsService.selectByPrimaryKey(goodsId2));
			goodlist.add(goodsService.selectByPrimaryKey(goodsId3));
			Map<String, Object> data = new HashMap<String, Object>();
			List quotalist = new ArrayList<Object>();
			List tittlelist = new ArrayList<Object>();
			List colors = new ArrayList<String>();
			colors.add("#2f4554");
			colors.add("#c23531");
			colors.add("#547b95");
			for (int i = 0; i < goodlist.size(); i++) {
				Map quota = new HashMap<String, Object>();
				if (goodlist.get(i) != null) {
					CoalGoods good = (CoalGoods) goodlist.get(i);
					String name = (i + 1) + "." + good.getCoalName();
					List value = setValue(good);
					quota.put("value", value);
					quota.put("name", name);
					tittlelist.add(name);
					quotalist.add(quota);
				}
				data.put("tittle", tittlelist);
				data.put("datavalue", quotalist);
			}
			String json = JSON.toJSONString(data);
			map.put("data", json);
			map.put("tabledata", data);
			map.put("color", colors);
			map.put("colors", JSON.toJSONString(colors));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "/view/appshare/coalcompare";
	}
	
	private List<Object> setValue(CoalGoods good) {
		List<Object> list = new ArrayList<Object>();
		list.add(Long.parseLong(good.getCalorificValue().toString()) > 7000 ? 7000 : good.getCalorificValue());
		list.add(good.getVolatileValue() == null ? null
				: (Double.parseDouble(good.getVolatileValue().toString()) > 70 ? 70 : good.getVolatileValue()));
		list.add(good.getTotalSulfur() == null ? null
				: (Double.parseDouble(good.getTotalSulfur().toString()) > 2 ? 0
						: String.format("%.2f", 2 - Double.parseDouble(good.getTotalSulfur().toString()))));
		list.add(good.getTotalMoisture() == null ? null
				: (Double.parseDouble(good.getTotalMoisture().toString()) > 20 ? 0
						: String.format("%.2f", 20 - Double.parseDouble(good.getTotalMoisture().toString()))));
		list.add(good.getAshValue() == null ? null
				: (Double.parseDouble(good.getAshValue().toString()) > 35 ? 0
						: String.format("%.2f", 35 - Double.parseDouble(good.getAshValue().toString()))));
		list.add(good.getFixedCarbon() == null ? null
				: ((Double.parseDouble(good.getFixedCarbon().toString()) > 100 ? 100 : good.getFixedCarbon())));

		return list;

	}
	
	@Autowired
	private ICoalTransportService transService;

	// 拉煤宝app 分享页面 货运详情页
	@RequestMapping(value = "/shareTransport.html", method = RequestMethod.GET)
	public String shareTransport(String transportId, HttpServletRequest request, ModelMap model) {
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ "?" + request.getQueryString(); // 请求参数
		String url = requestUrl;
		String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);// 随机字符串
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);// 时间戳
		String jsapi_ticket = WXAuthUtil.getJsapiTicket();
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ url; // 微信票据 随机数 时间戳
		String signature = MD5Util.getSha1(str);

		model.put("appId", "wx97e45c6f6c111e49"); // appId
		model.put("nonceStr", noncestr); // 随机字符串
		model.put("timeStamp", timestamp); // 时间戳
		model.put("signature", signature); // 签名
		model.put("url", url);

		CoalTransport trans = transService.selectByPrimaryKey(transportId);
		model.put("trans", trans == null ? new CoalTransport() : trans);
		model.put("userMobile", trans.getContactPhone());
		model.put("fromPlace", getShortRegionName(trans.getFromPlace()));
		model.put("toPlace", getShortRegionName(trans.getToPlace()));

		return "/view/appshare/shareCoalTransport";
	}
	
	
	@Autowired
	private IUserQuickOrderService orderService;
	
	@RequestMapping(value = "/quickorder.html", method = RequestMethod.GET)
	public String quickorder(String orderNumber,HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		UserQuickOrder order=orderService.selectDetailByPrimaryKey(orderNumber);
		model.put("order", order);
		model.put("createTime",DateUtil.sdf.format(order.getCreateTime()) );
		return "view/appshare/quickorder";
	}
}
