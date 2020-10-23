package com.jiaoda.edu.controller.admin.question;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.QuestionChapter;
import com.jiaoda.edu.domain.QuestionInfo;
import com.jiaoda.edu.service.IQuestionChapterService;
import com.jiaoda.edu.service.IQuestionInfoService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.ImportWordResult;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.Util;
import com.jiaoda.edu.util.WordUtils;



@Controller
@RequestMapping("/admin")
public class QuestionInfoController {
	
	@Autowired
	private IQuestionInfoService infoService;
	@Autowired
	private IQuestionChapterService chapterService;
	
	
	@ResponseBody
    @RequestMapping(value="/importQuestions.do",method=RequestMethod.POST)
    public Boolean importExcel(MultipartFile file) {
		Boolean flag=false; 
		try {
			Integer num = infoService.importExcel(file);
			flag=true;
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			return flag;
		}
      
    }
	
	@RequestMapping(value = "/questionlist.html", method = RequestMethod.GET)
	public String mineMouthList(ModelMap model) {
		return "view/admin/question/questionlist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/questionList.json", method = RequestMethod.POST)
	public PageData<QuestionInfo> getquestionList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		PageData<QuestionInfo> pageData = new PageData<QuestionInfo>();
		Integer count = infoService.getCount(where);
		List<QuestionInfo> data = infoService.findPagerList(start, length, where, "");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@RequestMapping(value = "/addquestion.html", method = RequestMethod.GET)
	public String addquestion(ModelMap model) {
		QuestionInfo question = new QuestionInfo();
		model.put("question", question);
		List<QuestionChapter> chapter=chapterService.findWhereList(" delete_flag=0", "");
		model.put("chapter", chapter);
		return "view/admin/question/questionform";
	}
	
	@RequestMapping(value = "/editquestion.html", method = RequestMethod.GET)
	public String editquestion(Integer questionId, ModelMap model) {
		QuestionInfo question = infoService.selectByPrimaryKey(questionId);
		question = question != null ? question : new QuestionInfo();
		model.put("question", question);
		List<QuestionChapter> chapter=chapterService.findWhereList(" delete_flag=0", "");
		model.put("chapter", chapter);
		return "view/admin/question/questionform";
	}
	
	@RequestMapping(value = "/savequestion.do", method = RequestMethod.POST)
	public String savequestion(QuestionInfo question) throws ParseException {
		Timestamp date =new Timestamp(System.currentTimeMillis());
		if (question.getQuestionId() == null) {
			question.setUpdateTime(date);
			question.setCreateTime(date);
			question.setDeleteFlag(0);
			infoService.insertSelective(question);
		} else {
			QuestionInfo entity = infoService.selectByPrimaryKey(question.getQuestionId());
			entity.setQuestion(question.getQuestion());
			entity.setQuestionType(question.getQuestionType());
			entity.setOptionNum(question.getOptionNum());
			entity.setOptionA(question.getOptionA());
			entity.setChapterId(question.getChapterId());
			entity.setOptionB(question.getOptionB());
			entity.setOptionC(question.getOptionC());
			entity.setOptionD(question.getOptionD());
			entity.setOptionE(question.getOptionE());
			entity.setAnswer(question.getAnswer());
			entity.setArticle1(question.getArticle1());
			entity.setArticle2(question.getArticle2());
			entity.setArticle3(question.getArticle3());
			
			question.setUpdateTime(date);
			infoService.updateByPrimaryKeySelective(entity);
		}
		return "redirect:/admin/questionlist.html";
	}

	@ResponseBody
	@RequestMapping(value = "/questiondel.do", method = RequestMethod.POST)
	public String articlequestiondel(ModelMap model, Integer questionId) {
		QuestionInfo question=infoService.selectByPrimaryKey(questionId);
		question.setDeleteFlag(1);
		infoService.updateByPrimaryKeySelective(question);
		return "";
	}
	
	
	

	
}
