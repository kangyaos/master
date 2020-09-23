package com.sxhalo.lmb.controller.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.SigninAwardRecord;
import com.sxhalo.lmb.domain.SigninMonthTask;
import com.sxhalo.lmb.domain.SigninRecord;
import com.sxhalo.lmb.service.ISigninAwardRecordService;
import com.sxhalo.lmb.service.ISigninMonthTaskService;
import com.sxhalo.lmb.service.ISigninRecordService;
import com.sxhalo.lmb.util.ClientUtils;
import com.sxhalo.lmb.util.DataTablesParam;
import com.sxhalo.lmb.util.DataTablesParamUtility;
import com.sxhalo.lmb.util.DateUtil;
import com.sxhalo.lmb.util.PageData;

@Controller
public class SigninController extends BaseController {

	@Autowired
	private ISigninAwardRecordService awardService;
	@Autowired
	private ISigninMonthTaskService taskService;
	@Autowired
	private ISigninRecordService recordService;

	@RequestMapping(value = "/signin.html", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest req){
		Map<String, String> header = getHeader(req);
		String userid = header.get("userid");
		String appname = header.get("appname");
		System.out.println("userid:"+userid);
		if (userid != null && appname != null) {
			userid = userid==null?"80000000":userid;
			appname = appname==null?"lmb":appname;
			req.getSession().setAttribute("userid", userid);
			req.getSession().setAttribute("appname", appname);
			SigninRecord key = new SigninRecord();
			key.setUserId(Integer.parseInt(userid));
			key.setSigninDate(new Date());
			//今天是否签到
			SigninRecord record = recordService.selectByPrimaryKey(key);
			model.put("disable", record == null ? "" : "class=\"disable\"");
			//连续签到天数，昨天没签从0计算
			key.setSigninDate(DateUtil.addDay(new Date(), -1));
			SigninRecord yesterday = recordService.selectByPrimaryKey(key);
			Integer days = yesterday == null ? 0 : yesterday.getSigninDays();
			model.put("signinDays", record == null ? days : record.getSigninDays());
			//当前月获得的奖励
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String startday = sdf.format(new Date()) + "-01 00:00:00";
			String endday = DateUtil.addMonth(startday, 1);
			String where = "user_id=" + userid + " and award_time between '" + startday + "' and '" + endday + "'";
			List<SigninAwardRecord> awardlist = awardService.findWhereList(where, "award_time desc");
			List<SigninMonthTask> tadklist = taskService.findWhereList("", "");
			for (SigninMonthTask task : tadklist) {
				for (SigninAwardRecord award : awardlist) {
					if(task.getTaskId() == award.getTaskId()) {
						task.setTermValidity(1);
					}
				}
			}
			model.put("tadks", tadklist);
			model.put("prizes", awardlist);
			model.put("asize", awardlist.size());
			Boolean activityState = ClientUtils.activityState("signin_total_money", "签到活动获得");
			model.put("state", activityState);
		    return "/view/activity/signin";
		} else {
			return "/view/activity/login";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public Map<?,?> signin(ModelMap model, HttpServletRequest req){
		String userid = req.getSession().getAttribute("userid").toString();
		System.out.println("userid:"+userid);
		SigninRecord key = new SigninRecord();
		key.setUserId(Integer.parseInt(userid));
		key.setSigninDate(new Date());
		SigninRecord record = recordService.selectByPrimaryKey(key);
		if(record == null) {
			record = new SigninRecord();
			record.setUserId(Integer.parseInt(userid));
			record.setSigninDate(new Date());
			record.setSigninDatetime(new Date());
			key.setSigninDate(DateUtil.addDay(new Date(), -1));
			SigninRecord yesterday = recordService.selectByPrimaryKey(key);
			if (yesterday == null) {
				record.setSigninDays(1);
			} else {
				//跨月份归零
				int todayMonth = DateUtil.getMonth(record.getSigninDate());
				int yesterdayMonth = DateUtil.getMonth(yesterday.getSigninDate());
				if (todayMonth == yesterdayMonth) {
					record.setSigninDays(yesterday.getSigninDays() + 1);
				} else {
					record.setSigninDays(1);
				}
			}
			recordService.insertSelective(record);
			//根据任务判断是否获奖
			SigninAwardRecord award = null;
			List<SigninMonthTask> tadklist = taskService.findWhereList("", "");
			for (SigninMonthTask task : tadklist) {
				if(record.getSigninDays() == task.getCumulative()) {
					award = saveAwardRecord(Integer.parseInt(userid), task.getTaskId());
				}
			}
			//累计次数
			Map<String,String> data = new HashMap<>();
			data.put("days", record.getSigninDays().toString());
			//中奖了
			if (award != null) {
				data.put("id", award.getTaskId().toString());
				data.put("name", "签到" + award.getCumulative() + "次 奖品");
				data.put("validity", DateUtil.sdf5.format(award.getValidityTime()));
				data.put("awardtime", DateUtil.sdf5.format(award.getAwardTime()));
			}
			return data;
		}
		return null;
	}
	
	private SigninAwardRecord saveAwardRecord(Integer userId, Integer taskId) {
		SigninMonthTask task = taskService.selectByPrimaryKey(taskId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String startday = sdf.format(new Date()) + "-01 00:00:00";
		String endday = DateUtil.addMonth(startday, 1);
		String where = "user_id=" + userId + " and task_id= " + taskId
				+ " and validity_time between '" + startday + "' and '" + endday + "'";
		List<SigninAwardRecord> list = awardService.findWhereList(where, "");
		//每月只能得一次
		if (task != null && list.size() == 0) {
			Date strDate = DateUtil.StringToDate(startday);
			Date endDate = DateUtil.addMonth(strDate, 1);
			Date validityTime = DateUtil.addDay(endDate, -1);
			SigninAwardRecord award = new SigninAwardRecord();
			Integer maxId = awardService.getMaxId();
			award.setRecordId(maxId + 1);
			award.setUserId(userId);
			award.setTaskId(task.getTaskId());
			award.setAwardType(task.getAwardType());
			award.setCumulative(task.getCumulative());
			award.setAwardAmount(task.getAwardAmount());
			award.setAwardTime(new Date());
			award.setValidityTime(validityTime);
			award.setWhetherCash(0);
			awardService.insertSelective(award);
			return award;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public Boolean cashAward(Integer taskId, HttpServletRequest req){
		String userid = req.getSession().getAttribute("userid").toString();
		String appname = req.getSession().getAttribute("appname").toString();
		System.out.println("userid:"+userid+",taskId:"+taskId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String startday = sdf.format(new Date()) + "-01 00:00:00";
		String endday = DateUtil.addMonth(startday, 1);
		String where = "user_id=" + userid + " and task_id= " + taskId
				+ " and whether_cash=0 and validity_time between '" + startday + "' and '" + endday + "'";
		List<SigninAwardRecord> awardlist = awardService.findWhereList(where, "");
		if(awardlist.size() > 0) {
			SigninAwardRecord award = awardlist.get(0);
			Boolean sendOk = ClientUtils.sendRedEnvelope(userid, appname, award.getAwardAmount(), "签到活动获得");
			if (sendOk) {
				award.setWhetherCash(1);//已经兑奖
				award.setPrizeTime(new Date());
				awardService.updateByPrimaryKeySelective(award);
				return true;
			}
		}
		return true;	
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinRecordList.json", method = RequestMethod.POST)
	public PageData<SigninRecord> signinRecordList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {

		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		PageData<SigninRecord> pageData = new PageData<>();
		Integer count = recordService.getCount(where);
		List<SigninRecord> data = recordService.findPagerList(start, length, where, "signin_datetime desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@ResponseBody
	@RequestMapping(value = "/awardRecordList.json", method = RequestMethod.POST)
	public PageData<SigninAwardRecord> awardRecordList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {

		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<SigninAwardRecord> pageData = new PageData<>();
		String where = param.getDefaultFilter();

		Integer count = awardService.getCount(where);
		List<SigninAwardRecord> data = awardService.findPagerList(start, length, where, "award_time desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
}
