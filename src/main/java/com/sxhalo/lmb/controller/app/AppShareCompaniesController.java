package com.sxhalo.lmb.controller.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.CoalCompanies;
import com.sxhalo.lmb.domain.CoalCompanyRealtimeInfo;
import com.sxhalo.lmb.domain.CoalGoods;
import com.sxhalo.lmb.domain.CoalSales;
import com.sxhalo.lmb.domain.CoalTransport;
import com.sxhalo.lmb.service.ICoalCompaniesService;
import com.sxhalo.lmb.service.ICoalCompanyRealtimeInfoService;
import com.sxhalo.lmb.service.ICoalGoodsService;
import com.sxhalo.lmb.service.ICoalSalesService;
import com.sxhalo.lmb.service.ICoalTransportService;
import com.sxhalo.lmb.service.IUserCoalOrderService;
import com.sxhalo.lmb.util.DateUtil;
import com.sxhalo.lmb.util.MD5Util;
import com.sxhalo.lmb.util.WXAuthUtil;

@Controller
public class AppShareCompaniesController extends BaseController {

	@Autowired
	private ICoalCompaniesService compService;
	@Autowired
	private ICoalSalesService salesService;
	@Autowired
	private ICoalCompanyRealtimeInfoService realtimeService;
	@Autowired
	private ICoalTransportService coalTransportService;
	@Autowired
	private ICoalGoodsService goodsService;
	@Autowired 
	private IUserCoalOrderService userOrderService;

	// 拉煤宝矿口详情分享
	@RequestMapping(value = "/shareCompanies.html", method = RequestMethod.GET)
	public String shareCompanies(HttpServletRequest request, Long mineMouthId, ModelMap model, Integer share) {
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ "?" + request.getQueryString(); // 请求参数
		String url = requestUrl;
		// 用于提交后的跳转
		String url2 = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ ":" + request.getLocalPort()// 端口
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ "?" + request.getQueryString(); // 请求参数
		String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);// 随机字符串
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);// 时间戳
		String jsapi_ticket = WXAuthUtil.getJsapiTicket();
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="	+ url; // 微信票据 随机数 时间戳
		String signature = MD5Util.getSha1(str);

		model.put("appId", "wx97e45c6f6c111e49"); // appId
		model.put("nonceStr", noncestr); // 随机字符串
		model.put("timeStamp", timestamp); // 时间戳
		model.put("signature", signature); // 签名
		model.put("url", url);
		model.put("url2", url2);

		CoalCompanies coalComp = compService.selectByPrimaryKey(mineMouthId);
		Map<String, Object> map = new HashMap<String, Object>();
		if (coalComp != null) {
			map.put("mineMouthName", coalComp.getMineMouthName());
			map.put("mtypeId", coalComp.getTypeId());

			String regionName = getFullRegionName(coalComp.getRegionCode());
			map.put("regionName", regionName);
			map.put("address", regionName + (coalComp.getAddress() == null ? "" : coalComp.getAddress()));
			map.put("profile", coalComp.getProfile() == null ? "暂无" : coalComp.getProfile());
			map.put("mineMouthPicUrl1", getPictureUrl(coalComp.getMineMouthPicCode()));
			map.put("mineMouthPicUrl2", getPictureUrl(coalComp.getMineMouthPicCode2()));
			map.put("mineMouthPicUrl3", getPictureUrl(coalComp.getMineMouthPicCode3()));
			model.put("map", map);
			model.put("operatingStatus", coalComp.getOperatingStatus());
			model.put("longitude", coalComp.getLongitude());
			model.put("latitude", coalComp.getLatitude());
			model.put("share", share == null ? 0 : share);
		} else {
			model.put("map", map);
		}

		String where = "coal_sales_id in (select coal_sales_id from coal_goods as model where model.delete_flag=0 and model.publish_state=1 and model.mine_mouth_id="
				+ mineMouthId + ")";
		List<CoalSales> coallist = salesService.findWhereList(where, "");
		List<Object> list1 = new ArrayList<Object>();
		if (coallist.size() > 0) {
			for (CoalSales coalSales : coallist) {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("creditRating", coalSales.getCreditRating() == null ? 0 : coalSales.getCreditRating());
				map1.put("transTotal", coalSales.getTransTotal() == null ? 0 : coalSales.getTransTotal());
				map1.put("goodsTotal", coalSales.getGoodsTotal() == null ? 0 : coalSales.getGoodsTotal());
				map1.put("companyName", coalSales.getCompanyName());
				map1.put("operatingStatus", coalSales.getOperatingStatus());
				list1.add(map1);
			}
		}

		model.put("list1", list1);
		String cwhere = "verify_state=1 and mine_mouth_id=" + mineMouthId;
		List<CoalCompanyRealtimeInfo> list = realtimeService.findWhereList(cwhere, "report_time desc");
		if (list.size() > 0) {
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("mineMouthName", list.get(0).getMineMouthName());
			String summary = "";
			Timestamp now = new Timestamp(System.currentTimeMillis());
			Timestamp reportTime = new Timestamp(list.get(0).getReportTime().getTime());
			map3.put("reportTime", getDifferMinute(list.get(0).getReportTime()));
			Integer days = DateUtil.getIntervalDays(now, reportTime);
			if (days < 4 && list.get(0).getOperatingStatus() != null && list.get(0).getOperatingStatus() == 1) {
				summary = "正常生产，";
			}
			if (list.get(0).getVehicleQueueLength() != null) {
				if (list.get(0).getVehicleQueueLength() == 0) {
					summary = summary + "当前没有车辆排队，";
				}
				if (list.get(0).getVehicleQueueLength() > 0 && list.get(0).getVehicleQueueLength() < 6) {
					summary = summary + "排队车辆较少；有" + list.get(0).getVehicleQueueLength() + "辆车在排队中，";
				}
				if (list.get(0).getVehicleQueueLength() > 5) {
					summary = summary + "排队车辆较多；有" + list.get(0).getVehicleQueueLength() + "辆车在排队中，";
				}
			}
			if (list.get(0).getIsCongestion() != null) {
				if (list.get(0).getIsCongestion() == 0) {
					summary = summary + "秒装，";
				}
				if (list.get(0).getIsCongestion() == 1) {
					summary = summary + "缓慢，";
				}
				if (list.get(0).getIsCongestion() == 2) {
					summary = summary + "拥堵，";
				}
			}
			// 是否有货:1、有；0、没有
			summary = summary + (list.get(0).getGoodsAvailable() == 1 ? "有现货。" : "无现货。");
			map3.put("summary", summary + (list.get(0).getSummary() == null ? "" : list.get(0).getSummary()));
			map3.put("scenePicUrl1", getPictureUrl(list.get(0).getScenePicCode1()));
			map3.put("scenePicUrl2", getPictureUrl(list.get(0).getScenePicCode2()));
			map3.put("scenePicUrl3", getPictureUrl(list.get(0).getScenePicCode3()));
			map3.put("scenePicUrl4", getPictureUrl(list.get(0).getScenePicCode4()));
			map3.put("scenePicUrl5", getPictureUrl(list.get(0).getScenePicCode5()));
			map3.put("scenePicUrl6", getPictureUrl(list.get(0).getScenePicCode6()));
			map3.put("scenePicUrl7", getPictureUrl(list.get(0).getScenePicCode7()));
			map3.put("scenePicUrl8", getPictureUrl(list.get(0).getScenePicCode8()));
			map3.put("scenePicUrl9", getPictureUrl(list.get(0).getScenePicCode9()));
			model.put("map3", map3);
		}
		List<Object> map4 = new ArrayList<Object>();
		for (CoalCompanyRealtimeInfo realtime : list) {
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("mineMouthName", realtime.getMineMouthName());
			String summary = "";
			Timestamp now = new Timestamp(System.currentTimeMillis());
			Timestamp reportTime = new Timestamp(realtime.getReportTime().getTime());
			map3.put("reportTime", getDifferMinute(realtime.getReportTime()));
			Integer days = DateUtil.getIntervalDays(now, reportTime);
			if (days < 4 && realtime.getOperatingStatus() != null && realtime.getOperatingStatus() == 1) {
				summary = "正常生产，";
			}
			if (realtime.getVehicleQueueLength() != null) {
				if (realtime.getVehicleQueueLength() == 0) {
					summary = summary + "当前没有车辆排队，";
				}
				if (realtime.getVehicleQueueLength() > 0 && list.get(0).getVehicleQueueLength() < 6) {
					summary = summary + "排队车辆较少；有" + realtime.getVehicleQueueLength() + "辆车在排队中，";
				}
				if (realtime.getVehicleQueueLength() > 5) {
					summary = summary + "排队车辆较多；有" + realtime.getVehicleQueueLength() + "辆车在排队中，";
				}
			}
			if (realtime.getIsCongestion() != null) {
				if (realtime.getIsCongestion() == 0) {
					summary = summary + "秒装，";
				}
				if (realtime.getIsCongestion() == 1) {
					summary = summary + "缓慢，";
				}
				if (realtime.getIsCongestion() == 2) {
					summary = summary + "拥堵，";
				}
			}
			// 是否有货:1、有；0、没有
			summary = summary + (realtime.getGoodsAvailable() == 1 ? "有现货。" : "无现货。");
			map3.put("summary", summary + (realtime.getSummary() == null ? "" : realtime.getSummary()));
			map3.put("scenePicUrl1", getPictureUrl(realtime.getScenePicCode1()));
			map3.put("scenePicUrl2", getPictureUrl(realtime.getScenePicCode2()));
			map3.put("scenePicUrl3", getPictureUrl(realtime.getScenePicCode3()));
			map3.put("scenePicUrl4", getPictureUrl(realtime.getScenePicCode4()));
			map3.put("scenePicUrl5", getPictureUrl(realtime.getScenePicCode5()));
			map3.put("scenePicUrl6", getPictureUrl(realtime.getScenePicCode6()));
			map3.put("scenePicUrl7", getPictureUrl(realtime.getScenePicCode7()));
			map3.put("scenePicUrl8", getPictureUrl(realtime.getScenePicCode8()));
			map3.put("scenePicUrl9", getPictureUrl(realtime.getScenePicCode9()));
			map4.add(map3);
		}
		model.put("list4", map4);
		return "view/appshare/shareCoalCompanies";
	}
	
	// 信息部详情分享
	@RequestMapping(value = "/shareSales.html", method = RequestMethod.GET)
	public String shareSales(HttpServletRequest request, String coalSalesId, ModelMap model, Integer share) {
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ "?" + request.getQueryString(); // 请求参数
		String url = requestUrl;

		// 用于提交后的跳转
		String url2 = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ ":" + request.getLocalPort()// 端口
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ "?" + request.getQueryString(); // 请求参数
		String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);// 随机字符串
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);// 时间戳
		String jsapi_ticket = WXAuthUtil.getJsapiTicket();
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="	+ url; // 微信票据 随机数 时间戳
		String signature = MD5Util.getSha1(str);

		model.put("appId", "wx97e45c6f6c111e49"); // appId
		model.put("nonceStr", noncestr); // 随机字符串
		model.put("timeStamp", timestamp); // 时间戳
		model.put("signature", signature); // 签名
		model.put("url", url);
		model.put("url2", url2);// 用于提交后的跳转

		if (coalSalesId != null) {
			if(coalSalesId.contains("?")) {
				String[] strArr = coalSalesId.split("\\?");
				coalSalesId = strArr[0];
			}
			List<CoalSales> coals = salesService.findWhereList("delete_flag=0 and coal_sales_id=" + coalSalesId, "");
			CoalSales sale = coals.size() > 0 ? coals.get(0) : new CoalSales();
			model.put("coalSalesId", sale.getCoalSalesId());
			model.put("typeId", sale.getTypeId());
			model.put("operatingStatus", sale.getOperatingStatus() == null ? 0 : sale.getOperatingStatus());
			model.put("creditRating", sale.getCreditRating());
			model.put("companyName", sale.getCompanyName());
			model.put("contactPhone", sale.getContactPhone());
			model.put("mineMouthLongitude", sale.getLongitude());
			model.put("mineMouthLatitude", sale.getLatitude());
			model.put("coalSalePicCode", getPictureUrl(sale.getCoalSalePicCode()));
			model.put("share", share == null ? 0 : share);
			// 累计订单
			Integer orderNum = userOrderService.getCount("coal_sales_id=" + coalSalesId);
			model.put("orderNum", orderNum == null ? "0" : orderNum);
			// 累计运单
			Integer transport = coalTransportService.getCount("coal_sales_id=" + coalSalesId);
			model.put("transport", transport == null ? "0" : transport);
			model.put("address", sale.getAddress());
			model.put("contactPhone", sale.getContactPhone());

			// 煤炭
			String where = "delete_flag=0 and publish_state=1 and coal_sales_id=" + coalSalesId;
			String order = "publish_time desc";
			List<CoalGoods> coalList = goodsService.findPagerList(0, 10, where, order);
			for (CoalGoods coalGoodsView : coalList) {
				coalGoodsView.setReportTime(getDifferMinute(coalGoodsView.getUpdateTime()));
			}
			model.put("coalList", coalList);
			// 货运
			String transportWhere = "delete_flag=0 and publish_state=1 and coal_sales_id=" + coalSalesId;
			List<CoalTransport> transportsList = coalTransportService.findPagerList(0, 10, transportWhere, "");

			for (CoalTransport coalTransport : transportsList) {
				coalTransport.setReportTime(getDifferMinute(coalTransport.getPublishTime()));
			}
			model.put("transportsList", transportsList);
		}

		model.put("phonestate", 1);
		return "view/appshare/salesInfoShare";
	}
	
	private String getDifferMinute(Date publishTime) {
		if (publishTime == null)
			return "未知";
		String differMinute = "";
		long time = Math.abs(System.currentTimeMillis() - publishTime.getTime());
		long days = time / (24 * 60 * 60 * 1000);// 天
		long hours = time / (60 * 60 * 1000);// 小时
		long minutes = time / (60 * 1000);// 分钟
		if (minutes < 60) {
			differMinute = minutes <= 0 ? "刚刚" : (minutes + "分钟前");
		} else {
			if (hours < 24) {
				differMinute = hours + "小时前";
			} else {
				if (days < 31) {
					differMinute = days + "天前";
				} else {
					differMinute = DateUtil.sdf5.format(publishTime);
				}
			}
		}
		return differMinute;
	}

}