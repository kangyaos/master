package com.sxhalo.lmb.controller.web;

import java.io.UnsupportedEncodingException;
import java.util.Map;

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
import com.sxhalo.lmb.domain.UserInfo;
import com.sxhalo.lmb.service.IUserInfoService;
import com.sxhalo.lmb.util.ClientUtils;
import com.sxhalo.lmb.util.WXAuthUtil;

@Controller
public class WebRegisterController extends BaseController {

	@Autowired
	private IUserInfoService infoService;

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public String register(HttpServletRequest request, ModelMap map) {
		return "/view/web/register";
	}
	
	@RequestMapping(value = "/checkregister.html", method = RequestMethod.GET)
	public String register(HttpServletRequest request, ModelMap map, String phonenum) {
		map.put("phonenum", phonenum);
		map.put("user", new UserInfo());
		return "/view/web/submitregister";
	}

	@ResponseBody
	@RequestMapping(value = "/isexist.html", method = RequestMethod.GET)
	public String isexist(HttpServletRequest request, String phonenum) {
		UserInfo entity = infoService.selectByUserMobile(phonenum);
		if (entity == null) {
			return "200";
		} else {
			return "100";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendSMS.do", method = RequestMethod.GET)
	public Boolean sendSMS(String phonenum) {
		return ClientUtils.sendSMS(phonenum);
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkSMS.do", method = RequestMethod.GET)
	public Boolean checkSMS(String phonenum, String code) {
		return ClientUtils.verificationCode(phonenum, code);
	}
	
	@ResponseBody
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	public Boolean submit(String userName, String userPwd, String nickname, String recommend) {
		if (recommend != null && !"".equals(recommend)) {
			return ClientUtils.kmbRegister(userName, userPwd, recommend);
		} else {
			return ClientUtils.lmbRegister(userName, userPwd, nickname);
		}
	}

	/**
	 * 微信获取用户信息
	 */
	private static String getOpenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token"; // 获取openid
	private static String gerinfo_url = "https://api.weixin.qq.com/sns/userinfo"; // 获取用户信息
	private static String appId = "wx21c61308a6d56bd1"; // appId
	private static String appsecret = "d28e6ef24236ae0e3a577d544f563733"; // appsecret

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/redirectWx.html", method = RequestMethod.GET)
	public String qqredirect(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {
		String code = request.getParameter("code");
		String param_code = "appid=" + appId + "&secret=" + appsecret + "&code=" + code
				+ "&grant_type=authorization_code";
		String result = WXAuthUtil.sendGet(getOpenid_url, param_code);
		Map mapTypes = JSON.parseObject(result);
		String param_token = "access_token=" + mapTypes.get("access_token") + "&openid=" + mapTypes.get("openid");
		String info = WXAuthUtil.sendGet(gerinfo_url, param_token);
		Map user = JSON.parseObject(info);
		map.put("nickname", user.get("nickname"));
		map.put("headimgurl", user.get("headimgurl"));
		map.put("openId", user.get("openid"));
		return "web/bindphone";
	}

	private static String lmb_appId = "wx97e45c6f6c111e49"; // appId
	private static String lmb_appsecret = "36db82c7a835448dc89ec72b69c5385a"; // appsecret

	@RequestMapping(value = "/getwxopenid.html", method = RequestMethod.GET)
	public String qqredirect(HttpServletRequest request, ModelMap map, HttpServletResponse resp) throws Exception {
		String code = request.getParameter("code");
		String state = request.getParameter("state");

		String param_code = "appid=" + lmb_appId + "&secret=" + lmb_appsecret + "&code=" + code
				+ "&grant_type=authorization_code";
		String result = WXAuthUtil.sendGet(getOpenid_url, param_code);
		System.out.println("--------------------------------result");
		System.out.println(result);
		Map<?, ?> mapTypes = JSON.parseObject(result);

		return "redirect:http://mobile.sxhalo.com:88/livecode/" + state + ".html?openId=" + mapTypes.get("openid");
	}

}
