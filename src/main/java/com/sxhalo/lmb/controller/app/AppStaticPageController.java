package com.sxhalo.lmb.controller.app;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppStaticPageController {
	
	@RequestMapping(value = "/download.html", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response) {
		return "download";
	}
	
	//隐私政策
	@RequestMapping(value = "/privacypolicy.html", method = RequestMethod.GET)
	public String privacypolicy(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/privacypolicy";
	}
	
	//用户手册（交易秘籍）
	@RequestMapping(value = "/tradingcheats.html", method = RequestMethod.GET)
	public String tradingcheats(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/tradingcheats";
	}
	
	//商户端隐私政策
	@RequestMapping(value = "/sellprivacypolicy.html", method = RequestMethod.GET)
	public String sellprivacypolicy(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/sellprivacypolicy";
	}
	
	//关于拉煤宝
	@RequestMapping(value = "/aboutlmb.html", method = RequestMethod.GET)
	public String aboutlmb(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/aboutlmb";
	}
	
	//免责声明
	@RequestMapping(value = "/disclaimer.html", method = RequestMethod.GET)
	public String disclaimer(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/disclaimer";
	}
	
	//商户端用户协议
	@RequestMapping(value = "/selluseragreement.html", method = RequestMethod.GET)
	public String selluseragreement(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/selluseragreement";
	}
	
	//拉煤宝用户协议
	@RequestMapping(value = "/useragreement.html", method = RequestMethod.GET)
	public String useragreement(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/useragreement";
	}

	//拉煤宝平台入驻规则
	@RequestMapping(value = "/mobile/joinrule.html", method = RequestMethod.GET)
	public String joinrule( HttpServletRequest request,ModelMap map) {
		return "/view/mobile/lmbjoinrule";
	}
	
	/**
	 * 拉煤宝Q&A基础问答模板
	 */
	//买家常见问题帮助
	@RequestMapping(value = "/mobile/lmbusersquestions.html", method = RequestMethod.GET)
	public String useraskedandquestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbusersquestions";
	}
	
	//订单常见问题帮助
	@RequestMapping(value = "/mobile/lmborderquestions.html", method = RequestMethod.GET)
	public String lmborderquestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmborderquestions";
	}
	
	//司机常见问题帮助
	@RequestMapping(value = "/mobile/lmbtruckquestions.html", method = RequestMethod.GET)
	public String lmbtruckquestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbtruckquestions";
	}
	
	//接单拉煤常见问题帮助
	@RequestMapping(value = "/mobile/lmbdrawingquestions.html", method = RequestMethod.GET)
	public String lmbdrawingquestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbdrawingquestions";
	}
	
	//常见问题帮助
	@RequestMapping(value = "/mobile/lmballquestions.html", method = RequestMethod.GET)
	public String lmballquestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmballquestions";
	}
	
	//内容详情所有
	@RequestMapping(value = "/mobile/detailAll.html", method = RequestMethod.GET)
	public String detailAll(String type,ModelMap map,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String title = URLDecoder.decode(request.getParameter("title"),"UTF-8");
		map.put("type", type);
		map.put("title", title);
		return "/view/mobile/lmbquestiondetailall";
	}
	
	//资讯费Q&A 
	@RequestMapping(value = "/mobile/lmbconsultingfeequestions.html", method = RequestMethod.GET)
	public String lmbconsultingfeequestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbconsultingfeequestions";
	}
	
	//拉煤宝优惠券使用须知
	@RequestMapping(value = "/mobile/lmbcouponquestions.html", method = RequestMethod.GET)
	public String lmbcouponquestions(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbcouponquestions";
	}
	
	//优惠券的类型和规则
	@RequestMapping(value = "/mobile/lmbcoupontypesandrules.html", method = RequestMethod.GET)
	public String coupontypesandrules(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbcoupontypesandrules";
	}
	
	//在线买煤常见问题说明
	@RequestMapping(value = "/mobile/lmbbuycoalonline.html", method = RequestMethod.GET)
	public String lmbbuycoalonline(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbbuycoalonline";
	}
	
	//保证金规则
	@RequestMapping(value = "/mobile/lmbuserdemand.html", method = RequestMethod.GET)
	public String lmbuserdemand(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/lmbuserdemand";
	}
	/**
	 * 快煤宝Q&A基础问答模板
	 */
	//快煤宝 用户认证审核问题解答
	@RequestMapping(value = "/mobile/kmbuserauthenticationaudit.html", method = RequestMethod.GET)
	public String kmbuserauthenticationaudit(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/kmbuserauthenticationaudit";
	}
	//用户操作说明
	@RequestMapping(value = "/mobile/kmbuseoperation.html", method = RequestMethod.GET)
	public String kmbuseoperation(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/kmbuseoperation";
	}
	//用户常见问题说明
	@RequestMapping(value = "/mobile/kmbcommonproblem.html", method = RequestMethod.GET)
	public String kmbcommonproblem(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/kmbcommonproblem";
	}
	
	@RequestMapping(value = "/mobile/kmbactivity.html", method = RequestMethod.GET)
	public String kmbactivity(HttpServletRequest request, HttpServletResponse response) {
		return "/view/mobile/kmbactivity";
	}

	//内容详情
	@RequestMapping(value = "/mobile/detail.html", method = RequestMethod.GET)
	public String askedandquestionsdetail(String type,ModelMap map,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String title = URLDecoder.decode(request.getParameter("title"),"UTF-8");
		map.put("type", type);
		map.put("title", title);
		return "/view/mobile/askedandquestiondetail";
	}

	//商户端常见问题解答
	@RequestMapping(value = "/mobile/sellcommonproblem.html", method = RequestMethod.GET)
	public String sellcommonproblem(ModelMap map,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		map.put("type", 1);
		return "/view/mobile/sellcommonproblem";
	}
	
	//商户端认证审核问题解答
	@RequestMapping(value = "/mobile/selluserauthenticationaudit.html", method = RequestMethod.GET)
	public String selluserauthenticationaudit(ModelMap map,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		map.put("type", 2);
		return "/view/mobile/sellcommonproblem";
	}

	//商户端使用操作问题解答
	@RequestMapping(value = "/mobile/selluseoperation.html", method = RequestMethod.GET)
	public String selluseoperation(ModelMap map,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		map.put("type",3);
		return "/view/mobile/sellcommonproblem";
	}
	
	//敬请期待
	@RequestMapping(value = "/comingsoon.html", method = RequestMethod.GET)
	public String comingsoon(HttpServletRequest req, ModelMap model) {
		
		return "kmb/comingsoon";
	}
	
	/**
	 * 快煤宝下载页面
	 */
	@RequestMapping(value = "/{typeName}/download.html", method = RequestMethod.GET)
	public String typeDownload(@PathVariable("typeName") String typeName) {
		return "kmb/"+typeName+"/download";
	}
	
	@RequestMapping(value = "/{typeName}/kmb.html", method = RequestMethod.GET)
	public String typeKmb(@PathVariable("typeName") String typeName) {
		return "kmb/"+typeName+"/kmb";
	}
}
