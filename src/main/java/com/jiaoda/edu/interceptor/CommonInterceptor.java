package com.jiaoda.edu.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jiaoda.edu.domain.SysModules;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.service.IOperateArticleService;
import com.jiaoda.edu.service.ISysModulesService;
import com.jiaoda.edu.service.IUserInfoService;






@Configuration
public class CommonInterceptor extends HandlerInterceptorAdapter {
	/** 
	* 免登入 免检查地址 
	*/ 
	private  List<String> uncheckUrls;
	
	
	public List<String> getUncheckUrls() {
		return uncheckUrls;
	}



	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}

	/**
	 * 部署路径属性名称
	 */
	public static final String CONTEXT_PATH = "base";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		String requestUrl = request.getRequestURI(); 
       
		return true;
	}
	

	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
   		String requestUrl = request.getRequestURI(); 
		boolean boolen=false;
 		if (modelAndView != null ) {
 			request.setAttribute("base", request.getContextPath());
 			System.out.println(request.getServletPath()  +(request.getQueryString()==null?"":( "?" + request.getQueryString())));
 			
 			request.setAttribute("pagepath", request.getServletPath()  +(request.getQueryString()==null?"":( "?" + request.getQueryString())));
 			modelAndView.addObject(CONTEXT_PATH, request.getContextPath());
			modelAndView.addObject("localhost", request.getLocalAddr() + ":" + request.getLocalPort());
			modelAndView.addObject("title", "西安交大附小");
//		
		
		}
		
  		if(requestUrl.contains("/admin/")){
			boolen= true;
		}
		
		if(boolen){
			if (modelAndView != null ) {
				String viewName = modelAndView.getViewName();
				if (!viewName.contains("redirect:")){					
					HttpSession session = request.getSession();  
			        String userName = (String)session.getAttribute("userName");
			        if(userName!=null){
						String sidebar = "";
						UserInfo user = uService.findByWhere("delete_flag=0 and user_name='"+userName+"'", "");
						if(user==null){
							// 提示无权限，退出并返回首页							
							modelAndView.setViewName("redirect:/403.html");							
						}else{
							modelAndView.addObject("userId", user.getUserId());
							modelAndView.addObject("roleId", user.getRoleId());							
//							if (!"403".equals(viewName)) {
//								// 提示无权限，退出并返回首页								
//								modelAndView.setViewName("redirect:403.html");
//							}
							sidebar = getSidebar(userName);
							modelAndView.addObject("userName", userName==null?"":userName);
							modelAndView.addObject("remFlag", (String)session.getAttribute("remFlag"));
							modelAndView.addObject("sidebar", sidebar);	
						}
			        }else{
			        	modelAndView.setViewName("redirect:/login.html");
			        } 
				}
			}
		}
	}

	private String getSidebar(String username) {
		StringBuffer str = new StringBuffer();
		List<SysModules> data = getUserModules(username);
		if (data != null) {
			createMenuli(str, data);
		}
		return str.toString();
	}
	
	
	@Autowired
	private ISysModulesService mService;
	@Autowired
	private IUserInfoService uService;
	

	@Autowired
	private IOperateArticleService articleService;
	

	

	
	
	public List<SysModules> getUserModules(String username) {
		List<SysModules> data = new ArrayList<SysModules>();
	    data = mService.findWhereList("delete_flag=0", "");
		return data;
	}

	private void createMenuli(StringBuffer str, List<SysModules> source) {
		Collections.sort(source,new Comparator<SysModules>(){
			public int compare(SysModules arg0, SysModules arg1){
				return arg0.getModuleSort().compareTo(arg1.getModuleSort());
			}
		});
		List<SysModules> list = source;
		if (str.length() == 0) {
			list = getChildren(0, source);
		}
		for (int i = 0; i < list.size(); i++) {
			SysModules nav = list.get(i);
			if (str.length() == 0) {
				str.append("<li id='" + nav.getModuleId() + "' class='start'>");
			} else {
				str.append("<li id='" + nav.getModuleId() + "'>");
			}
			List<SysModules> children = getChildren(nav.getModuleId(), source);
			if (children != null && children.size() > 0) {
				str.append("<a href='" + nav.getModulePath() + "'>");
				str.append("<i class='" + nav.getModuleClass() + "'></i>");
				str.append("<span class='title'>" + nav.getModuleName()	+ "</span>");
				str.append("<span class='arrow'></span></a>");
				str.append("<ul class='sub-menu'>");
				createMenuli(str, children);
				str.append("</ul>");
			} else {
				str.append("<a href='" + nav.getModulePath() + "'>");
				str.append("<i class='" + nav.getModuleClass() + "'></i>");
				str.append("<span class='title'>" + nav.getModuleName()	+ "</span>");
				str.append("</a>");
			}
			str.append("</li>");
		}
	}

	private List<SysModules> getChildren(Integer parentId, List<SysModules> list) {
		List<SysModules> data = new ArrayList<SysModules>();
		for (SysModules modules : list) {
			if (parentId == modules.getModuleParent()) {
				data.add(modules);
			}
		}
		return data;
	}
}
