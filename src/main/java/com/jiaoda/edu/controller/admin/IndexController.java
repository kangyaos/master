package com.jiaoda.edu.controller.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiaoda.edu.controller.BaseController;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.PasswordEncoder;





@Controller

public class IndexController extends BaseController {
	
	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "view/admin/index";
	}
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		return "view/login";
	}

	@RequestMapping(value = "/500.html", method = RequestMethod.GET)
	public String error(HttpServletRequest request, HttpServletResponse response) {
		return "view/500";
	}
	
	@RequestMapping(value = "/403.html", method = RequestMethod.GET)
	public String error1(HttpServletRequest request, HttpServletResponse response) {
		return "view/403";
	}

	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)  
    public String login(HttpSession session,UserInfo userinfo,String remFlag,Integer web,
    		ModelMap map,HttpServletRequest request, HttpServletResponse response) throws Exception{     
			try {
				UserInfo user=userinfoService.findByWhere("user_name='"+userinfo.getUserName()+"'","" );
				if(user!=null){
					if(user.getUserPwd().equals(PasswordEncoder.MD5(userinfo.getUserPwd()))){
						session.setAttribute("userName", user.getUserName());
						session.setAttribute("remFlag", remFlag);
						 if("1".equals(remFlag)){ //"1"表示用户勾选记住密码
				            String loginInfo = user.getUserName()+","+userinfo.getUserPwd();
				             Cookie userCookie=new Cookie("loginInfo",loginInfo); 
				             userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
				             userCookie.setPath("/");
				             response.addCookie(userCookie); 
						 }
						 if(web!=null){
							 return "redirect:index.html";
						 }
						return "redirect:/admin/index.html";
					}else{
						map.put("msg", "密码不正确!");
						return "view/login";
					}
				}else{
					map.put("msg", "用户名不存在!");
					return "view/login";
				}
			} catch (Exception e) {
				System.out.println(e);
				return "redirect:login.html";
			}
		
           
    }

	@Autowired
	private IUserInfoService userinfoService;
}
