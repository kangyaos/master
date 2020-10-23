package com.jiaoda.edu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jiaoda.edu.controller.admin.UploadController;
import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.service.ICertificateService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.DateUtil;
import com.jiaoda.edu.util.PrintImage;

@Controller
public class BaseController {

	protected String UPLOAD_URL = "https://picture.sxhalo.com/";
	
	@Autowired
	private IUserInfoService userService;
	@Autowired
	private ICertificateService certService;
	
	/**
	 * 获取图片位置
	 */
	protected String getPictureUrl(String code) {
		if (code != null && !"".equals(code)) {
			return UPLOAD_URL + "picture/" + code;
		} else {
			return "";
		}
	}
	
	public static String getServerUrl(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
	}
	
	/**
	 * 获取请求Header信息
	 * */
	protected Map<String, String> getHeader(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = headerNames.nextElement().toString();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
	
	


	
	/**
	 * 格式化发布时间
	 * */
	protected String getDifferMinute(Timestamp publishTime) {
		if (publishTime == null) return "未知";
		String differMinute = "";
		long time = Math.abs(System.currentTimeMillis() - publishTime.getTime());
		long days = time / (24 * 60 * 60 * 1000);//天
		long hours = time / (60 * 60 * 1000);//小时
		long minutes = time / (60 * 1000);//分钟
		if (minutes < 60) {
			differMinute = minutes <= 0 ? "刚刚" : (minutes + "分钟前");
		} else {
			if (hours < 24) {
				differMinute = hours + "小时前";
			} else {
				if (days < 4) {
					differMinute = days + "天前";
				} else {
					differMinute = DateUtil.sdf5.format(publishTime);
				}
			}
		}
		return differMinute;
	}
	
	protected String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
	
	public  void loadImageLocal(Integer userId,Integer leantime, Integer cid,HttpServletRequest request){
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());	
		SimpleDateFormat sdf=DateUtil.sdf5;
		String time=sdf.format(nowTime);
		String[] times=time.split("-");

	    PrintImage tt = new PrintImage();
	  
	    ServletContext servletContext = request.getSession().getServletContext();
		String url = servletContext.getRealPath("/") + "WEB-INF\\classes\\static\\assets\\web\\images\\zhengshu.jpg";
	    BufferedImage d = tt.loadImageLocal(url);
		UserInfo info= userService.selectByPrimaryKey(userId);
	    String year =times[0];
	    String month =times[1];
	    String day = times[2];
	   
	
	    tt.setFont(new Font("宋体",Font.PLAIN,90));
	    if(info.getRealName().length()==2) {
	    	 tt.modifyImage(d, info.getRealName(), -1110, -150,new Color(6,37,102));
	    	
	    }else {
	    	
	    	 tt.modifyImage(d, info.getRealName(), -1300, -180,new Color(6,37,102));
	    }
	   
	    tt.modifyImage(d, year, -1075,15,new Color(6,37,102));
	    tt.modifyImage(d, month, -760, 15,new Color(6,37,102));
	    tt.modifyImage(d, day, -535, 15,new Color(6,37,102));
	    tt.modifyImage(d, year, -210, 15,new Color(6,37,102));
	    tt.modifyImage(d, month, 115, 15,new Color(6,37,102));
	    tt.modifyImage(d, day, 330, 15,new Color(6,37,102));
	    tt.modifyImage(d, leantime, -1110, 352,new Color(6,37,102));
	    tt.setFont(new Font("宋体",Font.PLAIN,80));
	    tt.modifyImage(d, year, 330, 830,new Color(6,37,102));
	    tt.modifyImage(d, month, 583, 830,new Color(6,37,102));
	    tt.modifyImage(d, day, 740, 830,new Color(6,37,102));
	     
	    //tt.modifyImage(d, str, -830, -100);
		String uploadPath = UploadController.getUploadPath(request)+"zhengshu\\";
		 String newfileName = nowTime.getTime() + ".jpg" ;
	    tt.writeImageLocal(uploadPath+newfileName, d);
	    System.out.println("success");
	 
	     
	     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	     String[] fontList = ge.getAvailableFontFamilyNames();
//	     for(int i=0;i<fontList.length;i++)
//	     {
//	        System.out.println("字体："+fontList[i]);
//	     }
	     Certificate cc=new Certificate();
	     cc.setCreateTime(nowTime);
	     cc.setUserId(userId);
	     cc.setType(2);
	     cc.setCourseId(cid);
	     cc.setRemark("测试");
	     cc.setUrl(newfileName);
	     certService.insertSelective(cc);
	     
	 }
	
	
	public  void loadImageLocal(Integer userId,String userName,HttpServletRequest request){
		Certificate  c=certService.findWhere(" user_id="+userId+" and type=1", "");
		if(c!=null) {
			return;
		}
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());	
		SimpleDateFormat sdf=DateUtil.sdf5;
		String time=sdf.format(nowTime);
		String[] times=time.split("-");

	    PrintImage tt = new PrintImage();
	    ServletContext servletContext = request.getSession().getServletContext();
		String url = servletContext.getRealPath("/") + "WEB-INF\\classes\\static\\assets\\web\\images\\pinshu.jpg";
	    BufferedImage d = tt.loadImageLocal(url);
	    String year =times[0];
	    String month =times[1];
	    String day = times[2];
	    tt.setFont(new Font("宋体",Font.BOLD,120));
	    if(userName.length()==2) {
	    	 tt.modifyImage(d, userName, -1180, -90,new Color(7,36,102));
	    }else {
	    	 tt.modifyImage(d, userName, -1300, -90,new Color(7,36,102));
	    }
	   
	    tt.setFont(new Font("宋体",Font.PLAIN,80));
	    tt.modifyImage(d, year, 225, 940,new Color(7,36,102));
	  
	    tt.modifyImage(d, month, 475, 940,new Color(7,36,102));
	    tt.modifyImage(d, day, 655, 940,new Color(7,36,102));
		String uploadPath = UploadController.getUploadPath(request)+"zhengshu\\";
		 String newfileName = nowTime.getTime() + ".jpg" ;
	    tt.writeImageLocal(uploadPath+newfileName, d);
	    System.out.println("success");
	     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	     String[] fontList = ge.getAvailableFontFamilyNames();
	     Certificate cc=new Certificate();
	     cc.setCreateTime(nowTime);
	     cc.setUserId(userId);
	     cc.setType(1);
	     cc.setRemark("测试");
	     cc.setUrl(newfileName);
	     certService.insertSelective(cc);
	     
	 }
	
}
