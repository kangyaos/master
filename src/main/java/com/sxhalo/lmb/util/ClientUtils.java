package com.sxhalo.lmb.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


public class ClientUtils {

	private static String url = "https://h5.sxhalo.com:8443/";
	
	private static String accessKey = "66d6c4bb-411e-408a-8b56-2bdf7dc7a908";

	public static Boolean sendRedEnvelope(String userId, String appName, Integer amount, String memo){
		Boolean result = false;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	
        	List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("userId", userId));
			param.add(new BasicNameValuePair("appName", appName));
			param.add(new BasicNameValuePair("amount", amount.toString()));
			param.add(new BasicNameValuePair("memo", memo));
			String urlpar = EntityUtils.toString(new UrlEncodedFormEntity(param, "UTF-8"));
			
			HttpGet httpget = new HttpGet(url + "lmbapi/Interface/sendRedEnvelope" + "?" + urlpar);
			httpget.setHeader("appName", "signin");
			httpget.setHeader("platform", "android");
			httpget.setHeader("appversion", "1.0");
			httpget.setHeader("apiversion", "1.0");
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				Integer statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String resStr = null;
					resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
					result = "true".equals(resStr);
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	public static Boolean sendSMS(String phoneNumber){
		Boolean result = false;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	String timeStamp = "" + System.currentTimeMillis();
			String encparam = "{\"timeStamp\":\"" + timeStamp + "\",\"phoneNumber\":\"" + phoneNumber + "\",\"password\":\"96e79218965eb72c92a549dd5a330112\"}";
			String sign = MD5Util.MD5Encode(accessKey + encparam + timeStamp, "utf-8");
			encparam = encparam.substring(0, encparam.length()-1)+",\"sign\":\""+sign+"\"}";
			String secretKey = MD5Util.MD5Encode(accessKey);
			secretKey = secretKey.toUpperCase().substring(16);
			encparam = AESCode.Encrypt(encparam, secretKey);
        	List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("data", encparam));
			String urlpar = EntityUtils.toString(new UrlEncodedFormEntity(param));
			
			HttpGet httpget = new HttpGet(url + "lmbapi/sendSMS" + "?" + urlpar);
			httpget.setHeader("appName", "17web");
			httpget.setHeader("platform", "android");
			httpget.setHeader("appversion", "1.0.17");
			httpget.setHeader("apiversion", "5.0.3");
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				Integer statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String resStr = null;
					resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
					resStr = AESCode.Decrypt(resStr,secretKey);
					Map<String, Object> map = JSON.parseObject(resStr);
					result = "SUCCESS".equals(map.get("msg").toString());
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Boolean verificationCode(String phoneNumber, String verificationCode){
		Boolean result = false;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	String timeStamp = "" + System.currentTimeMillis();
			String encparam = "{\"timeStamp\":\"" + timeStamp + "\",\"phoneNumber\":\"" + phoneNumber + "\",\"verificationCode\":\""+verificationCode+"\"}";
			String sign = MD5Util.MD5Encode(accessKey + encparam + timeStamp, "utf-8");
			encparam = encparam.substring(0, encparam.length()-1)+",\"sign\":\""+sign+"\"}";
			String secretKey = MD5Util.MD5Encode(accessKey);
			secretKey = secretKey.toUpperCase().substring(16);
			encparam = AESCode.Encrypt(encparam, secretKey);
        	List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("data", encparam));
			String urlpar = EntityUtils.toString(new UrlEncodedFormEntity(param));
			
			HttpGet httpget = new HttpGet(url + "lmbapi/verificationCode" + "?" + urlpar);
			httpget.setHeader("appName", "17web");
			httpget.setHeader("platform", "android");
			httpget.setHeader("appversion", "1.0.17");
			httpget.setHeader("apiversion", "5.0.3");
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				Integer statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String resStr = null;
					resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
					resStr = AESCode.Decrypt(resStr,secretKey);
					Map<String, Object> map = JSON.parseObject(resStr);
					result = "SUCCESS".equals(map.get("msg").toString());
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Boolean lmbRegister(String phoneNumber, String password, String nickname){
		Boolean result = false;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	String timeStamp = "" + System.currentTimeMillis();
        	Map<String, Object> mparam = new HashMap<String, Object>();
        	mparam.put("phoneNumber", phoneNumber);
        	if (password != null && !"".equals(password)) {
				mparam.put("password", password);
			}else {
				mparam.put("password", "111111");
			}
        	if (nickname != null && !"".equals(nickname)) {
				mparam.put("nickname", nickname);
			}
			mparam.put("timeStamp", timeStamp);
			String encparam = JSON.toJSONString(mparam);
			String sign = MD5Util.MD5Encode(accessKey + encparam + timeStamp, "utf-8");
			encparam = encparam.substring(0, encparam.length()-1)+",\"sign\":\""+sign+"\"}";
			String secretKey = MD5Util.MD5Encode(accessKey);
			secretKey = secretKey.toUpperCase().substring(16);
			encparam = AESCode.Encrypt(encparam, secretKey);
        	List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("data", encparam));
			String urlpar = EntityUtils.toString(new UrlEncodedFormEntity(param));
			
			HttpGet httpget = new HttpGet(url + "lmbapi/user/register" + "?" + urlpar);
			httpget.setHeader("appName", "17web");
			httpget.setHeader("platform", "android");
			httpget.setHeader("appversion", "1.0.17");
			httpget.setHeader("apiversion", "5.0.3");
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				Integer statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String resStr = null;
					resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
					resStr = AESCode.Decrypt(resStr,secretKey);
					Map<String, Object> map = JSON.parseObject(resStr);
					result = "SUCCESS".equals(map.get("msg").toString());
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static Boolean kmbRegister(String phoneNumber, String password, String recommend){
		Boolean result = false;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	String timeStamp = "" + System.currentTimeMillis();
        	Map<String, Object> mparam = new HashMap<String, Object>();
        	mparam.put("userMobile", phoneNumber);
			mparam.put("password", password);
			mparam.put("recommend", recommend);
			mparam.put("timeStamp", timeStamp);
			String encparam = JSON.toJSONString(mparam);
			String sign = MD5Util.MD5Encode(accessKey + encparam + timeStamp, "utf-8");
			encparam = encparam.substring(0, encparam.length()-1)+",\"sign\":\""+sign+"\"}";
			String secretKey = MD5Util.MD5Encode(accessKey);
			secretKey = secretKey.toUpperCase().substring(16);
			encparam = AESCode.Encrypt(encparam, secretKey);
        	List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("data", encparam));
			String urlpar = EntityUtils.toString(new UrlEncodedFormEntity(param));
			
			HttpGet httpget = new HttpGet(url + "kmbapi/userInfo/login" + "?" + urlpar);
			httpget.setHeader("appName", "17web");
			httpget.setHeader("platform", "android");
			httpget.setHeader("appversion", "1.0.17");
			httpget.setHeader("apiversion", "5.0.4");
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				Integer statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String resStr = null;
					resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
					resStr = AESCode.Decrypt(resStr,secretKey);
					Map<String, Object> map = JSON.parseObject(resStr);
					result = "SUCCESS".equals(map.get("msg").toString());
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static Boolean activityState(String settingsKey, String memo) {
		Boolean result = false;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	
        	List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("settingsKey", settingsKey));
			param.add(new BasicNameValuePair("memo", memo));
			String urlpar = EntityUtils.toString(new UrlEncodedFormEntity(param, "UTF-8"));
			
			HttpGet httpget = new HttpGet(url + "lmbapi/Interface/activityState" + "?" + urlpar);
			httpget.setHeader("appName", "signin");
			httpget.setHeader("platform", "android");
			httpget.setHeader("appversion", "1.0");
			httpget.setHeader("apiversion", "1.0");
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				Integer statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String resStr = null;
					resStr = EntityUtils.toString(response.getEntity(), "UTF-8");
					result = "true".equals(resStr);
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
