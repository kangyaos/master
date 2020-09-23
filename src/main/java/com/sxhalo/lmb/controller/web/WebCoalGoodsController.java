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
import com.sxhalo.lmb.domain.CoalTransport;
import com.sxhalo.lmb.domain.UserCoalOrder;
import com.sxhalo.lmb.domain.UserTransportOrder;
import com.sxhalo.lmb.service.ICoalGoodsService;
import com.sxhalo.lmb.service.ICoalTransportService;
import com.sxhalo.lmb.service.IUserCoalOrderService;
import com.sxhalo.lmb.service.IUserTransportOrderService;

@Controller
public class WebCoalGoodsController extends BaseController {

	@Autowired
	private ICoalGoodsService coalGoodsService;
	@Autowired
	private IUserCoalOrderService userOrderService;
	
	// 煤炭列表页面
	@RequestMapping(value = "/coallist.html", method = RequestMethod.GET)
	public String coallist(HttpServletRequest request, ModelMap map) {
		List<UserCoalOrder> orders = userOrderService.findPagerList(0, 20, "", "create_time desc");
		for (UserCoalOrder userOrders : orders) {
			String contactPhone = userOrders.getContactPhone()==null?"":userOrders.getContactPhone();
			userOrders.setContactPhone(contactPhone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
		}
		map.put("orders", orders);
		return "/view/web/coallist";
	}

	// 煤炭列表数据
	@ResponseBody
	@RequestMapping(value = "/coallist.json", method = RequestMethod.POST)
	public Map<String, Object> coallist(String search, Integer page, Integer length, HttpServletRequest request,
			ModelMap map) {
		Map<String, Object> m = new HashMap<String, Object>();
		String where = "";
		if (null != search && !("").equals(search)) {
			where = "";
		}
		List<CoalGoods> coals = coalGoodsService.findPagerList(page * length, length, where, null);
		int count = coalGoodsService.getCount(where);
		count = count > 45 ? 45 : count;
		m.put("list", coals);
		m.put("count", count);
		return m;
	}
	
	@Autowired
	private ICoalTransportService tranService;
	@Autowired
	private IUserTransportOrderService tranOrderService;
	
	/**
	 * 货运信息
	 */
	@RequestMapping(value = "/waybill.html", method = RequestMethod.GET)
	public String waybill( HttpServletRequest request,ModelMap map,Integer type) {
		return "/view/web/waybill";
	}
	
	
	/*
	 * 货运列表
	 */
	@ResponseBody
	@RequestMapping(value = "/waybill.do", method = RequestMethod.POST)
	public Map<String, Object> WebWayWill( HttpServletRequest request,String where,Integer p) {	
		Map<String,Object> map = new HashMap<String, Object>();
		if(where.equals("null") || where.equals(""))where = "";
		Integer count = tranService.getCount(where);
		count=count>50?50:count;
	    int size = 7;
	    int lit = 0;
	    int pageCount=count/size;
		if(count%size!=0){
			 pageCount++;
		}		
		int pageIndex=0;		
		if(p !=null){
			lit=size*p;
			pageIndex=p;			
		}		
		if(pageIndex>pageCount-1){ pageIndex=pageCount-1;lit=pageIndex*size;}
		if(pageIndex<0){ pageIndex=0;lit=0;	}	
		List<CoalTransport> waybills = tranService.findPagerList(lit, size, where, " update_time desc");
		map.put("list", waybills);		
	    map.put("where", where);	   
	    map.put("pageCount", pageCount);
	    map.put("pageIndex", pageIndex);	
		return map;
	}
	
	
	/*
	 * 货运单记录
	 */
	@ResponseBody
	@RequestMapping(value = "/WebWayWillOrder.do", method = RequestMethod.POST)
	public List<UserTransportOrder> WebWayWillOrder( HttpServletRequest request,ModelMap map,Integer type) {	
		List<UserTransportOrder> orderlist = tranOrderService.findPagerList(0, 30, "","update_time desc"); 
		return orderlist;
	}
}
