package com.sxhalo.lmb.controller.web;

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

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.CoalSales;
import com.sxhalo.lmb.domain.OperateArticle;
import com.sxhalo.lmb.domain.SysApp;
import com.sxhalo.lmb.domain.UserCoalOrder;
import com.sxhalo.lmb.service.ICoalSalesService;
import com.sxhalo.lmb.service.IOperateArticleService;
import com.sxhalo.lmb.service.ISysAppService;
import com.sxhalo.lmb.service.IUserCoalOrderService;
import com.sxhalo.lmb.util.AESCode;

@Controller
public class WebIndexController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/index.html";
	}

	// 网站首页
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap map) throws Exception {
//		List<CoalSales> cslist = coalSalesService.findPagerList(0, 5, " delete_flag=0 ",
//				"credit_rating desc,create_time desc");
//		for (CoalSales coalSales : cslist) {
//			coalSales.setCoalSalesIdStr(AESCode.Encrypt(coalSales.getCoalSalesId() + ""));
//		}
//		List<UserCoalOrder> orders = userOrderService.findPagerList(0, 20, "", "create_time desc");
//		map.put("coalSales", cslist);
//		map.put("orders", orders);
//		map.put("picPath", UPLOAD_URL + "/picture");
//		// 资讯数据
//		List<OperateArticle> olist = articleService.findPagerList(0, 12, " a.category_id=3", "a.publish_time DESC");
//		OperateArticle oneArticle = new OperateArticle();
//		OperateArticle twoArticle = new OperateArticle();
//		List<OperateArticle> olist1 = new ArrayList<OperateArticle>();
//		List<OperateArticle> olist2 = new ArrayList<OperateArticle>();
//		List<OperateArticle> olist3 = new ArrayList<OperateArticle>();
//		for (int i = 0; i < olist.size(); i++) {
//			if (i == 0)
//				oneArticle = olist.get(0);
//			else if (i > 0 && i < 6)
//				olist1.add(olist.get(i));
//			else if (i > 5 && i < 9)
//				olist2.add(olist.get(i));
//			else if (i == 9)
//				twoArticle = olist.get(i);
//			else if (i > 9)
//				olist3.add(olist.get(i));
//		}
//		map.put("oneArticle", oneArticle);
//		map.put("twoArticle", twoArticle);
//		map.put("olist1", olist1);
//		map.put("olist2", olist2);
//		map.put("olist3", olist3);

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
			

	// APP下载页面
	@RequestMapping(value = "/appDownload.html", method = RequestMethod.GET)
	public String appDownload(ModelMap map, HttpServletRequest request) {
		List<SysApp> lmb = appService.findWhereList("app_name='lmb' and app_type='Android'", "issuance_time desc");
		List<SysApp> kmb = appService.findWhereList("app_name='kmb' and app_type='Android'", "issuance_time desc");
		map.put("lmbPath", lmb.size() > 0 ? lmb.get(0).getAppPath() : "");
		map.put("kmbPath", kmb.size() > 0 ? kmb.get(0).getAppPath() : "");
		return "/view/web/appDownload";
	}

	// 关于拉煤宝
	@RequestMapping(value = "/intrpduce.html", method = RequestMethod.GET)
	public String enterIntroduction(HttpServletRequest request) {
		return "/view/web/intrpduce";
	}

	@RequestMapping(value = "/browser.html", method = RequestMethod.GET)
	public String browser(HttpServletRequest request) {
		return "/view/web/include/Browser";
	}

	// 联系我们页面
	@RequestMapping(value = "/contactus.html", method = RequestMethod.GET)
	public String contactus(HttpServletRequest request) {

		return "/view/web/contactus";
	}

	// 企业介绍
	@RequestMapping(value = "/about.html", method = RequestMethod.GET)
	public String about(HttpServletRequest request) {
		return "/view/web/about";
	}

	

	@RequestMapping(value = "/join.html", method = RequestMethod.GET)
	public String join(HttpServletRequest request, ModelMap map) {
		// 热点资讯
		List<OperateArticle> olist = articleService.findPagerList(0, 10, "", "RAND()");
		map.put("olist", olist);
		return "/view/web/join";
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

	@Autowired
	private ISysAppService appService;
	@Autowired
	private IOperateArticleService articleService;
	@Autowired
	private ICoalSalesService coalSalesService;
	@Autowired
	private IUserCoalOrderService userOrderService;
	
}
