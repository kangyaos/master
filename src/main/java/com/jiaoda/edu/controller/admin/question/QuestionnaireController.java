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
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.Questionnaire;
import com.jiaoda.edu.service.IQuestionnaireService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;




@Controller
@RequestMapping("/admin")
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireService naireService;
	
	
	@ResponseBody
    @RequestMapping(value="/importQuestionnaire.do",method=RequestMethod.POST)
    public Boolean importExcel(MultipartFile file,Integer id) {
		Boolean flag=false; 
		try {
			Integer num = naireService.importExcel(file,id);
			flag=true;
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			return flag;
		}
      
    }
	
	/**
	 *问卷管理
	 */
	@RequestMapping(value = "/nairelist.html", method = RequestMethod.GET)
	public String mineMouthList(ModelMap model) {
		return "view/admin/question/nairelist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/naireList.json", method = RequestMethod.POST)
	public PageData<Questionnaire> getCategoryList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		PageData<Questionnaire> pageData = new PageData<Questionnaire>();
		Integer count = naireService.getCount(where);
		List<Questionnaire> data = naireService.findPagerList(start, length, where, "");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@RequestMapping(value = "/addnaire.html", method = RequestMethod.GET)
	public String addcategory(ModelMap model) {
		Questionnaire category = new Questionnaire();
		model.put("category", category);
		return "view/admin/question/naireform";
	}
	
	@RequestMapping(value = "/editnaire.html", method = RequestMethod.GET)
	public String editcategory(Integer id, ModelMap model) {
		
		Questionnaire category = naireService.selectByPrimaryKey(id);
		category = category != null ? category : new Questionnaire();
		model.put("category", category);	
		return "view/admin/question/naireform";
	}
	
	@RequestMapping(value = "/saveNaire.do", method = RequestMethod.POST)
	public String savecategory(Questionnaire naire) throws ParseException {
		Timestamp date =new Timestamp(System.currentTimeMillis());
		if (naire.getId() == null) {
			naire.setCreateTime(date);
			naire.setUpdateTime(date);
			naire.setDeleteFlag(0);
			naireService.insertSelective(naire);
		} else {
			Questionnaire entity = naireService.selectByPrimaryKey(naire.getId());
			entity.setStartTime(naire.getStartTime());
			entity.setEndTime(naire.getEndTime());
			entity.setUpdateTime(date);
		
			naireService.updateByPrimaryKeySelective(entity);
		}
		return "redirect:/admin/nairelist.html";
	}

	@ResponseBody
	@RequestMapping(value = "/nairedel.do", method = RequestMethod.POST)
	public String articlecategorydel(ModelMap model, Integer id) {
		Questionnaire naire=naireService.selectByPrimaryKey(id);
		naire.setDeleteFlag(1);
		naireService.updateByPrimaryKeySelective(naire);
		return "";
	}
	


	
}
