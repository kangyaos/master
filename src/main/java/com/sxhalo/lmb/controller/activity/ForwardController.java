package com.sxhalo.lmb.controller.activity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.ForwardBrowseRecord;
import com.sxhalo.lmb.domain.ForwardShareRecord;
import com.sxhalo.lmb.domain.UserInfo;
import com.sxhalo.lmb.service.IForwardBrowseRecordService;
import com.sxhalo.lmb.service.IForwardShareRecordService;
import com.sxhalo.lmb.service.IUserInfoService;
import com.sxhalo.lmb.util.ClientUtils;
import com.sxhalo.lmb.util.DataTablesParam;
import com.sxhalo.lmb.util.DataTablesParamUtility;
import com.sxhalo.lmb.util.MD5Util;
import com.sxhalo.lmb.util.PageData;
import com.sxhalo.lmb.util.WXAuthUtil;

@Controller
public class ForwardController extends BaseController {

	@Autowired
	private IUserInfoService userService;
	@Autowired
	private IForwardShareRecordService shareService;
	@Autowired
	private IForwardBrowseRecordService browseService;
	
	@RequestMapping(value = "/forwardwinprize.html", method = RequestMethod.GET)
	public String forwardwinprize(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String userId) {
		Map<String, String> header = getHeader(request);
		String appname = header.get("appname");
		String userid = header.get("userid");
		model.put("isapp", 0);
		if (appname != null) {
			model.put("isapp", 1);
			model.put("appname", appname);
		}
		model.put("userId", userId);
		String userPhone = "";
		userId=userId==null?userid:userId;
		if (userId != null) {
			UserInfo user = userService.selectByPrimaryKey(userId);
			if (user != null) {
				userPhone = user.getUserMobile();
			}
			ForwardBrowseRecord record = new ForwardBrowseRecord();
			record.setCreateTime(new Date());
			record.setUserId(Integer.parseInt(userId));
			record.setAppVersion(header.get("appversion"));
			record.setDeviceType(header.get("platform"));
			record.setDeviceBrand(header.get("deviceid"));
			record.setDeviceVersion(header.get("platformversion"));
			record.setShareType("lmb".equals(appname)?0:"kmb".equals(appname)?1:2);
			record.setMachineCode(header.get("machinecode")==null?getIpAddress(request):header.get("machinecode"));
			browseService.insertSelective(record);
		}
		model.put("sharetitle", "拉煤宝转发赢大奖");
		model.put("sharevalue", "打开此页面点击去领奖进入APP，马上分享活动给好友一起领红包吧~");
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ "?" + request.getQueryString(); // 请求参数
		String url = requestUrl;
		String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);// 随机字符串
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);// 时间戳
		String jsapi_ticket = WXAuthUtil.getJsapiTicket();
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ url; // 微信票据 随机数 时间戳
		
		String signature = MD5Util.getSha1(str);
	
		//model.put("appId", "wx1d02908ac68cdb00"); // 测试公众号appId
		model.put("appId", "wx97e45c6f6c111e49"); // appId
		model.put("nonceStr", noncestr); // 随机字符串
		model.put("timeStamp", timestamp); // 时间戳
		model.put("signature", signature); // 签名
		model.put("url", url);
		model.put("userPhone", userPhone);
		Boolean activityState = ClientUtils.activityState("forward_total_money", "转发赢大奖活动");
		model.put("state", activityState);
		return "/view/activity/forwardwinprize";
	}
	
	@ResponseBody
	@RequestMapping(value = "/createShareRecord.do", method = RequestMethod.GET)
	public Boolean createShareRecord(HttpServletRequest request,Integer userId) {
		try {
			Map<String, String> header = getHeader(request);
			if(header.get("userid")!=null&&header.get("userid")!="") {
				userId=Integer.parseInt(header.get("userid"));
			}
			//目前只有转发活动回掉做记录
			if (header.get("shareurl") != null && !header.get("shareurl").contains("forwardwinprize.html")) {
				return false;
			}
			String appname = header.get("appname");
			ForwardShareRecord record=new ForwardShareRecord();
			record.setUserId(userId);
			record.setCreateTime(new Date());
			record.setShareType("lmb".equals(appname)?0:"kmb".equals(appname)?1:2);
			record.setMachineCode(header.get("machinecode")==null?getIpAddress(request):header.get("machinecode"));
			shareService.insertSelective(record);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}	
	}
	
	@ResponseBody
	@RequestMapping(value = "/sharerecordlist.json", method = RequestMethod.POST)
	public PageData<ForwardShareRecord> sharerecordlist(Integer draw, Integer start, Integer length,
			HttpServletRequest request, HttpServletResponse res) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<ForwardShareRecord> pageData = new PageData<ForwardShareRecord>();
		String where = param.getDefaultFilter();

		Integer count = shareService.getCount(where);
		List<ForwardShareRecord> data = shareService.findPagerList(start, length, where, " a.create_time desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
}
