package com.jiaoda.edu.controller.admin;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.HashMap;








import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.util.ExecuteCodecs;

import org.bytedeco.javacv.FFmpegFrameGrabber;


import org.bytedeco.javacv.Java2DFrameConverter;








@Controller
@RequestMapping("/admin")
public class UploadController {



	@ResponseBody
	@RequestMapping(value = "/imageUpload.do", method = RequestMethod.POST)
	public HashMap<String,String> imageUpload(MultipartFile file,String fieldName, HttpServletRequest request) throws Exception {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());	    
		HashMap<String,String> map=new HashMap<String,String>();
		  Frame frame = null;
		  int flag = 0;

		if (file.getSize() > 0) {
			// 获取上传物理路径
			String uploadPath = getUploadPath(request)+fieldName+"\\";
 			String prefix = getServerUrl(request) + "/upload/"+fieldName+"/";
			// 重命名上传后的文件名
			String fileName = file.getOriginalFilename();
	  	    String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		    String newfileName = nowTime.getTime() + "." + fileSuffix;
			// 定义上传路径
			String picPath = uploadPath + newfileName;
			File localFile = new File(picPath);
		
			 // 自定义方式产生文件名
            String serialName = String.valueOf(System.currentTimeMillis());
			try {
				file.transferTo(localFile);
				map.put("url", prefix+newfileName);
				map.put("name", newfileName);
				map.put("oldname", fileName);
				if(fileSuffix.equals("mp4"))	{
					ExecuteCodecs.executeCodecs(prefix+newfileName, uploadPath, serialName);

					
		      map.put("serialName", serialName+".jpg");
			  map.put("suoluetu", prefix+serialName+".jpg");
				}
				 
				return map;
			
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return map;
		}
		
	

	}
	
	  public static BufferedImage FrameToBufferedImage(Frame frame) {
	        //创建BufferedImage对象
	        Java2DFrameConverter converter = new Java2DFrameConverter();
	        BufferedImage bufferedImage = converter.getBufferedImage(frame);
	        return bufferedImage;
	    }
	
	public static String getServerUrl(HttpServletRequest request) {
		String selfUrl = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();
		return selfUrl;
	}	
	
    public static String getUploadPath(HttpServletRequest request){
    	ServletContext servletContext = request.getSession().getServletContext();
    	String uploadPath = servletContext.getRealPath("/") + "WEB-INF\\classes\\static\\upload\\";
		return  uploadPath;		
	}
    

 



}
