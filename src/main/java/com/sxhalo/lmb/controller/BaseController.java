package com.sxhalo.lmb.controller;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sxhalo.lmb.util.DateUtil;
import com.sxhalo.lmb.domain.SysDicRegion;
import com.sxhalo.lmb.service.ISysDicRegionService;

@Controller
public class BaseController {

	protected String UPLOAD_URL = "https://picture.sxhalo.com/";
	
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
	
	@Autowired
	private ISysDicRegionService regionService;
	
	/**
	 * 格式化RegionCode
	 */
	protected String getFullRegionName(Integer regionCode) {
		String regionName = "";
		if (regionCode != null) {
			if (regionCode == 0) {
				return "全国";
			}
			SysDicRegion region = regionService.selectByPrimaryKey(regionCode);
			if (region != null) {
				regionName = region.getFullRegionName();
			}
		}
		return regionName;
	}

	protected String getShortRegionName(Integer regionCode) {
		String regionName = "";
		if (regionCode != null) {
			if (regionCode == 0) {
				return "全国";
			}
			SysDicRegion region = regionService.selectByPrimaryKey(regionCode);
			if (region != null) {
				regionName = region.getShortRegionName();
			}
		}
		return regionName;
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
}
