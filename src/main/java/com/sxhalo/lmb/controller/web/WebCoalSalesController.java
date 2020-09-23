package com.sxhalo.lmb.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.CoalGoods;
import com.sxhalo.lmb.domain.CoalSales;
import com.sxhalo.lmb.domain.CoalTransport;
import com.sxhalo.lmb.service.ICoalGoodsService;
import com.sxhalo.lmb.service.ICoalSalesService;
import com.sxhalo.lmb.service.ICoalTransportService;
import com.sxhalo.lmb.util.AESCode;

@Controller
public class WebCoalSalesController extends BaseController {

	@Autowired
	private ICoalTransportService tranService;
	@Autowired
	private ICoalGoodsService coalGoodsService;
	@Autowired
	private ICoalSalesService coalSalesService;
	
	// 信息部详情页面
	@RequestMapping(value = "/coalSaleDetails.html", method = RequestMethod.GET)
	public String coalSaleDetails(String coalSaleIdStr, HttpServletRequest request, ModelMap map) throws Exception {
		coalSaleIdStr = coalSaleIdStr.replace(" ", "+");
		String coalSaleId = AESCode.Decrypt(coalSaleIdStr);
		CoalSales coalSale = coalSalesService.selectByPrimaryKey(coalSaleId);
		map.put("coalSaleId", coalSaleId);
		map.put("coalSalePhone", getTransformatPhone(coalSale.getContactPhone()));
		map.put("coalSale", coalSale);
		return "/view/web/coalSaleDetails";
	}

	// 信息部列表页面
	@RequestMapping(value = "/coalSaleList.html", method = RequestMethod.GET)
	public String coalSaleList(HttpServletRequest request, ModelMap map) {
		return "/view/web/coalsalelist";
	}

	// 信息部列表数据
	@ResponseBody
	@RequestMapping(value = "/coalSaleList.json", method = RequestMethod.POST)
	public List<CoalSales> coalSaleListjson(String dicregion, HttpServletRequest request, ModelMap map) {
		List<CoalSales> coals = coalSalesService.findWhereList("", "");
		/*
		 * for (CoalSales coalSales : coals) {
		 * coalSales.setCoalSalesIdStr(AESCode.Encrypt(coalSales.getCoalSalesId()+""));
		 * }
		 */
		return coals;
	}

	// 信息部详情页 煤炭列表数据
	@ResponseBody
	@RequestMapping(value = "/coalSaleProduct.json", method = RequestMethod.GET)
	public Map<String, Object> coalSaleProduct(Long coalSaleId, Integer page, Integer length,
			HttpServletRequest request, ModelMap map) {
		Map<String, Object> data = new HashMap<String, Object>();
		String where = "coal_sales_id=" + coalSaleId	+ " and publish_state=1 and delete_flag=0";
		List<CoalGoods> coals = coalGoodsService.findPagerList(page * length, length, where, null);
		int ccount = coalGoodsService.getCount(where);
		data.put("list", coals);
		data.put("count", ccount);
		return data;
	}

	// 信息部详情页 货运列表数据
	@ResponseBody
	@RequestMapping(value = "/wayBill.json", method = RequestMethod.GET)
	public Map<String, Object> wayBill(Long coalSaleId, Integer page, Integer length, HttpServletRequest request,
			ModelMap map) {
		Map<String, Object> data = new HashMap<String, Object>();
		String where = "coal_sales_id=" + coalSaleId	+ " and publish_state=1 and delete_flag=0";
		List<CoalTransport> waybills = tranService.findPagerList(page * length, length,	where, null);
		int ccount = tranService.getCount(where);
		data.put("list", waybills);
		data.put("count", ccount);
		return data;
	}
	
	// 分隔电话号码
	public String getTransformatPhone(String strNumber) {
		if (null == strNumber)
			return "";
		String s1 = strNumber.substring(0, 3);
		String s2 = strNumber.substring(3, 7);
		String s3 = strNumber.substring(7, 11);
		return s1 + "-" + s2 + "-" + s3;
	}
}
