package com.jiaoda.edu.controller.admin.user;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.service.ICertificateService;
import com.jiaoda.edu.service.ICourseInfoService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.Util;



@Controller
@RequestMapping("/admin")
public class CertificateController {
	@Autowired
	private IUserInfoService userService;
	@Autowired
	private ICertificateService certService;

	@Autowired
	private ICourseInfoService infoService;
	/**
	 *证书管理
	 */
	@RequestMapping(value = "/certificatelist.html", method = RequestMethod.GET)
	public String certificatelist(Integer uId,ModelMap model) {
		if(uId!=null) {
			Certificate cc=certService.findWhere("user_id="+uId+" and type=1 and delete_flag=0", "");
			if(cc!=null) {
				model.put("pinshu", 1);
			}
		}
		model.put("uId", uId);
		return "view/admin/user/certificatelist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/certificateList.json", method = RequestMethod.POST)
	public PageData<Certificate> getCertificateList(Integer uId,Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		if("".equals(where)){
			where = "a.delete_flag=0 "+(uId!=null?" and a.user_id="+uId:"");
		}else if(!"".equals(where)){
			where = "(" +where+") and a.delete_flag=0 "+(uId!=null?" and a.user_id="+uId:"");
			
		}
		PageData<Certificate> pageData = new PageData<Certificate>();
		Integer count = certService.getCount(where);
		List<Certificate> data = certService.findPagerList(start, length, where, "a.create_time desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	

	
	@ResponseBody
	@RequestMapping(value = "/certcourselist.json", method = RequestMethod.POST)
	public PageData<CourseInfo> getCourselist(HttpSession session,Integer uId,Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		String order="publish_time desc";
		if("".equals(where)){
			where = " publish_state=1 and delete_flag=0 and course_id not in (select course_id from certificate  where delete_flag=0  and user_id="+uId+"  and  course_id is not null) ";
		}else if(!"".equals(where)){
			where = "(" +where+") and publish_state=1 and  delete_flag=0 and course_id not in (select course_id from certificate     where delete_flag=0  and user_id="+uId+"  and  course_id is not null) ";
			order ="sort desc,publish_time desc";
		}
		PageData<CourseInfo> pageData = new PageData<CourseInfo>();
		Integer count = infoService.getCount(where);
		List<CourseInfo> data = infoService.findPagerList(start, length, where,order);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	@ResponseBody
	@RequestMapping(value = "/delcertificate.do", method = RequestMethod.POST)
	public Boolean delcertificate(Integer certificateId, ModelMap model) {
		Certificate category = certService.selectByPrimaryKey(certificateId);
		category.setDeleteFlag(1);
		certService.updateByPrimaryKeySelective(category);
		return true;
	}
	
	
	@RequestMapping(value = "/downloadcertificate", method = RequestMethod.GET)
	public void download(String url,String userName,HttpServletResponse response) throws Exception {
		String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/zhengshu/"+url;
		downloadFile(response, path, userName+".jpg");
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
