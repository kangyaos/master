package com.jiaoda.edu.controller.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiaoda.edu.controller.BaseController;


@Controller
public class WebIndexController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/index.html";
	}

	// 网站首页
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap map) throws Exception {
		return "view/web/index";
	}
	
	// 网站首页
	@RequestMapping(value = "/trainingcourse.html", method = RequestMethod.GET)
	public String trainingcourse(HttpServletRequest request, ModelMap map) throws Exception {
		
		return "view/web/trainingcourse";
	}
	// 网站首页
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public String contact(HttpServletRequest request, ModelMap map) throws Exception {
		
		return "view/web/contact";
	}
	// 网站首页
	@RequestMapping(value = "/teacher.html", method = RequestMethod.GET)
	public String teacher(HttpServletRequest request, ModelMap map) throws Exception {
		
		return "view/web/teacher";
	}
	
	// 网站首页
	@RequestMapping(value = "/news.html", method = RequestMethod.GET)
	public String news(HttpServletRequest request, ModelMap map) throws Exception {
		
		return "view/web/news";
	}
	//证书
	@RequestMapping(value = "/certificate.html", method = RequestMethod.GET)
	public String certificate(HttpServletRequest request, ModelMap map) throws Exception {
		return "view/web/certificate";
	}
	
	//新闻详情
	@RequestMapping(value = "/newsdetail.html", method = RequestMethod.GET)
	public String newsdetail(Integer newsid,HttpServletRequest request, ModelMap map) throws Exception {
		return "view/web/newsdetail";
	}
	//课程详情
	@RequestMapping(value = "/coursedetail.html", method = RequestMethod.GET)
	public String coursedetail(Integer pid,HttpServletRequest request, ModelMap map) throws Exception {
		return "view/web/coursedetail";
	}
	//课程详情
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap map) throws Exception {
		return "view/web/login";
	}
			



	

	@RequestMapping(value = "/download/temp", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws Exception {
		String path = ResourceUtils.getURL("classpath:").getPath() + "static/assets/web/企业加入审批表.docx";
		downloadFile(response, path, "企业加入审批表.docx");
		return;

	}
	
	public void downloadFile(HttpServletResponse response, String path, String fileName) throws IOException {
		
		File file = new File(path);
		if (file.exists()) {
			/** 将文件名称进行编码 */
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("content-type:octet-stream");
			/** 读取服务器端模板文件 */
			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			/** 将流中内容写出去 . */
			OutputStream outputStream = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			inputStream.close();
			outputStream.close();
		}else {
			System.out.println("路径有误，文件不存在！");
		}
	}


	
}
