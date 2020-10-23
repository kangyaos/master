package com.jiaoda.edu.controller.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.controller.BaseController;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.DateUtil;
import com.jiaoda.edu.util.PasswordEncoder;
import com.jiaoda.edu.util.PrintImage;
import com.jiaoda.edu.util.PrintJobToImg;





@Controller

public class IndexController extends BaseController {
	
	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public String index(HttpServletRequest request,ModelMap model, HttpServletResponse response) {
		Map map=userinfoService.getindexCount("");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		model.put("nowtime", "2020/10/20");
		model.put("nowyear", 2020);
		model.put("nowweek", 42);
		model.put("maxweek", 52);
		model.put("nowmonth", 9);
		model.put("data", map);
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
    public String login(HttpSession session,UserInfo userinfo,String remFlag,
    		ModelMap map,HttpServletRequest request, HttpServletResponse response) throws Exception{     
			try {
				UserInfo user=userinfoService.findByWhere("user_name='"+userinfo.getUserName()+"'","" );
				if(user!=null){
					if(user.getUserPwd().equals(PasswordEncoder.MD5(userinfo.getUserPwd()))){
						session.setAttribute("userName", user.getUserName());
						session.setAttribute("userId", user.getUserId());
						session.setAttribute("remFlag", remFlag);
						 if("1".equals(remFlag)){ //"1"表示用户勾选记住密码
				            String loginInfo = user.getUserName()+","+userinfo.getUserPwd();
				             Cookie userCookie=new Cookie("loginInfo",loginInfo); 
				             userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
				             userCookie.setPath("/");
				             response.addCookie(userCookie); 
						 }
						return "redirect:/admin/courselist.html";
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
	
	@RequestMapping(value="/web/login.do", method = RequestMethod.POST)  
    public String weblogin(HttpSession session,UserInfo userinfo,String remFlag,Integer cid,String url,
    		ModelMap map,HttpServletRequest request, HttpServletResponse response) throws Exception{     
			try {
				UserInfo user=userinfoService.findByWhere("user_name='"+userinfo.getUserName()+"'","" );
				if(user!=null){
					if(user.getUserPwd().equals(PasswordEncoder.MD5(userinfo.getUserPwd()))){
						session.setAttribute("userName", user.getUserName());
						session.setAttribute("userId", user.getUserId());
						session.setAttribute("remFlag", remFlag);
						 if("1".equals(remFlag)){ //"1"表示用户勾选记住密码
				            String loginInfo = user.getUserName()+","+userinfo.getUserPwd();
				             Cookie userCookie=new Cookie("loginInfo",loginInfo); 
				             userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
				             userCookie.setPath("/");
				             response.addCookie(userCookie); 
						 }
							if(cid!=null&&!cid.equals("")) {
								 return "redirect:/learncoursedetail.html?cid="+cid;
							}else {
								url=url==null||url.equals("")?"/index.html":url;
								return "redirect:"+url;
							}
							
						
						
					}else{
						map.put("msg", "密码不正确!");
						map.put("cid", cid);
						return "view/web/login";
					}
				}else{
					map.put("cid", cid);
					map.put("msg", "用户名不存在!");
					return "view/web/login";
				}
			} catch (Exception e) {
				System.out.println(e);
				return "redirect:web/login.html?cid="+cid;
			}
           
    }
	@RequestMapping(value="/admin/logout.do", method = RequestMethod.GET)  
    public String admlogin(HttpSession session,
    		ModelMap map,HttpServletRequest request, HttpServletResponse response) throws Exception{   
		session.removeAttribute("userName"); 
		session.removeAttribute("userId"); 
		session.removeAttribute("remFlag");
		
		return "redirect:/login.html";
	}

	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)  
    public String weblogin(HttpSession session,
    		ModelMap map,HttpServletRequest request, HttpServletResponse response) throws Exception{   
		session.removeAttribute("userName"); 
		session.removeAttribute("userId"); 
		session.removeAttribute("remFlag");
		
		return "redirect:/index.html";
	}


	

	@ResponseBody
	@RequestMapping(value = "/interfacecharts.json", method = RequestMethod.GET)
	public Map<String, Object[]> interfacecharts(Integer day,Integer type,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> lmbList = new ArrayList<>();
		List<Object[]> kmbList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		Map<String, Object[]> value = new HashMap<String, Object[]>();
		Object[] total1 = new Object[day];
		Object[] total2 = new Object[day];
		Object[] total3 = new Object[day];
		Object[] dateMonth = new Object[day];
		for (int i = 0; i < 7; i++) {
			total1[i] =i;
			total2[i] = i;
			total3[i] = i;
			dateMonth[i] ="2020/10/2"+i;
		}
		
		value.put("total1", total1);
		value.put("total2", total2);
		value.put("total3", total3);
		value.put("dateMonth", dateMonth);
		return value;
	}
   
   
	@Autowired
	private IUserInfoService userinfoService;
}
