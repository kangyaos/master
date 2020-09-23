package com.sxhalo.lmb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class WXAuthUtil {

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url   发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			/*
			 * // 获取所有响应头字段 Map<String, List<String>> map = connection.getHeaderFields(); //
			 * 遍历所有的响应头字段 for (String key : map.keySet()) { System.out.println(key + "--->"
			 * + map.get(key)); }
			 */
			// 定义 BufferedReader输入流来读取URL的响应
			InputStream is = connection.getInputStream();
			in = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	private WXAuthUtil() {

	}

	private static WXAuthUtil single = null;

	// 静态工厂方法
	public static WXAuthUtil getInstance() {
		if (single == null) {
			single = new WXAuthUtil();
		}
		return single;
	}

	private Map<String, String> map = new HashMap<String,String>();

	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	private static final String appid = "wx97e45c6f6c111e49";
			
	private static final String appsecret = "36db82c7a835448dc89ec72b69c5385a";
	
	//微信测试号
//	private static final String appid = "wx1d02908ac68cdb00";
//			
//	private static final String appsecret = "b8a2b30b7fe7e79eafa1f109b0745663";
	

	
	public static String getJsapiTicket() {
		return getJsapiTicket(appid, appsecret);
	}

	public static String getJsapiTicket(String appid, String appsecret) {
		String result = "";
		WXAuthUtil singleton = WXAuthUtil.getInstance();
		Map<String, String> map = singleton.getMap();
		String time = map.get("getTime");// 从缓存中拿数据
		String accessToken = map.get("accessToken");// 从缓存中拿数据
		String jsapiTicket = map.get("jsapiTicket");// 从缓存中拿数据
		Long nowDate = System.currentTimeMillis();
		// 这里设置过期时间 3000*1000就好了
		if (accessToken != null&&accessToken!="" && time != null && nowDate - Long.parseLong(time) < 30) {
			System.out.println("-----从缓存读取access_token：" + accessToken);
			// 从缓存中拿数据为返回结果赋值
			result = jsapiTicket;
		} else {
			//调用微信接口去获取accessToken和jsapiticket
			try {
				accessToken = getAccessToken(appid, appsecret);
				jsapiTicket = getJsapiTicket(accessToken);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 将信息放置缓存中
			map.put("getTime", nowDate.toString());
			map.put("accessToken", accessToken);
			map.put("jsapiTicket", jsapiTicket);
			// 为返回结果赋值
			result = map.get("jsapiTicket");
		}
		return result;
	}

	public static String getAccessToken(String appid, String appsecret) throws IOException {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		String getAccessToken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HttpGet httpGet = new HttpGet(getAccessToken);

			CloseableHttpResponse response = httpclient.execute(httpGet);

			try {
				String resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
				// 解析json
				map = JSON.parseObject(resStr);

			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		if (map.get("access_token") != null) {
			return map.get("access_token").toString();
		} else {
			return "";
		}
	}

	public static String getJsapiTicket(String access_token) throws IOException {
		// https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
		String getJsapi = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token	+ "&type=jsapi";
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HttpGet httpGet = new HttpGet(getJsapi);

			CloseableHttpResponse response = httpclient.execute(httpGet);

			try {
				String resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
				// 解析json
				map = JSON.parseObject(resStr);

			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		if (map.get("ticket") != null) {
			return map.get("ticket").toString();
		} else {
			return "";
		}
	}
}
