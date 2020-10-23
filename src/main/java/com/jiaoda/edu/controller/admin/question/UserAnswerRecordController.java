package com.jiaoda.edu.controller.admin.question;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.domain.UserAnswerRecord;
import com.jiaoda.edu.service.IUserAnswerRecordService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.Util;



@Controller
@RequestMapping("/admin")
public class UserAnswerRecordController {
	
	@Autowired
	private IUserAnswerRecordService answerrecordService;
	/**
	 *煤炭生活 栏目管理
	 */
	@RequestMapping(value = "/answerrecordlist.html", method = RequestMethod.GET)
	public String mineMouthList(ModelMap model) {
		return "view/admin/question/answerrecordlist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/answerrecordList.json", method = RequestMethod.POST)
	public PageData<UserAnswerRecord> getanswerrecordList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		PageData<UserAnswerRecord> pageData = new PageData<UserAnswerRecord>();
		Integer count = answerrecordService.getCount(where);
		List<UserAnswerRecord> data = answerrecordService.findPagerList(start, length, where, "");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@RequestMapping(value = "/addanswerrecord.html", method = RequestMethod.GET)
	public String addanswerrecord(ModelMap model) {
		UserAnswerRecord answerrecord = new UserAnswerRecord();
		model.put("answerrecord", answerrecord);
	
		return "view/admin/operate/answerrecordform";
	}
	
	@RequestMapping(value = "/editanswerrecord.html", method = RequestMethod.GET)
	public String editanswerrecord(Integer answerrecordId, ModelMap model) {
		UserAnswerRecord answerrecord = answerrecordService.selectByPrimaryKey(answerrecordId);
		answerrecord = answerrecord != null ? answerrecord : new UserAnswerRecord();
		model.put("answerrecord", answerrecord);	
		return "view/admin/question/answerrecordform";
	}
	
	@RequestMapping(value = "/saveanswerrecord.do", method = RequestMethod.POST)
	public String saveanswerrecord(UserAnswerRecord answerrecord) throws ParseException {
		Timestamp date =new Timestamp(System.currentTimeMillis());
		
		return "redirect:/admin/answerrecordlist.html";
	}

	@ResponseBody
	@RequestMapping(value = "/answerrecorddel.do", method = RequestMethod.POST)
	public String articleanswerrecorddel(ModelMap model, Integer answerrecordId) {
		UserAnswerRecord answerrecord=answerrecordService.selectByPrimaryKey(answerrecordId);
		answerrecord.setDeleteFlag(1);
		answerrecordService.updateByPrimaryKeySelective(answerrecord);
		return "";
	}

	

	
}
