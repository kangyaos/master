package com.jiaoda.edu.controller.admin.operate;

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

import com.jiaoda.edu.domain.OperateArticleCategory;
import com.jiaoda.edu.service.IOperateArticleCategoryService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.Util;



@Controller
@RequestMapping("/admin")
public class OperateArticleCategoryController {
	
	@Autowired
	private IOperateArticleCategoryService categoryService;
	/**
	 *煤炭生活 栏目管理
	 */
	@RequestMapping(value = "/categorylist.html", method = RequestMethod.GET)
	public String mineMouthList(ModelMap model) {
		return "view/admin/operate/categorylist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/categoryList.json", method = RequestMethod.POST)
	public PageData<OperateArticleCategory> getCategoryList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		PageData<OperateArticleCategory> pageData = new PageData<OperateArticleCategory>();
		Integer count = categoryService.getCount(where);
		List<OperateArticleCategory> data = categoryService.findPagerList(start, length, where, "sort asc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@RequestMapping(value = "/addcategory.html", method = RequestMethod.GET)
	public String addcategory(ModelMap model) {
		OperateArticleCategory category = new OperateArticleCategory();
		model.put("category", category);
		List<OperateArticleCategory> clist = categoryService.findPagerList(0, -1, "delete_flag=0", "sort asc");
		model.put("mlist",clist );
		return "view/admin/operate/categoryform";
	}
	
	@RequestMapping(value = "/editcategory.html", method = RequestMethod.GET)
	public String editcategory(Integer categoryId, ModelMap model) {
		OperateArticleCategory category = categoryService.selectByPrimaryKey(categoryId);
		category = category != null ? category : new OperateArticleCategory();
		model.put("category", category);	
		model.put("mlist", categoryService.findPagerList(0, -1, "delete_flag=0", "sort asc"));
		return "view/admin/operate/categoryform";
	}
	
	@RequestMapping(value = "/saveCategory.do", method = RequestMethod.POST)
	public String savecategory(OperateArticleCategory category) throws ParseException {
		Timestamp date =new Timestamp(System.currentTimeMillis());
		if (category.getCategoryId() == null) {
 			category.setCategoryName(Util.replaceBlank(category.getCategoryName()));
			category.setUseStatus(0);
			category.setUpdateTime(date);
			category.setDeleteFlag(0);
			categoryService.insertSelective(category);
		} else {
			OperateArticleCategory entity = categoryService.selectByPrimaryKey(category.getCategoryId());
			entity.setCategoryName(Util.replaceBlank(category.getCategoryName()));
			entity.setUpdateTime(date);
			entity.setUseStatus(category.getUseStatus());
			categoryService.updateByPrimaryKeySelective(entity);
		}
		return "redirect:/admin/categorylist.html";
	}

	@RequestMapping(value = "/categorydel.do", method = RequestMethod.GET)
	public String articlecategorydel(ModelMap model, Integer categoryId) {
		OperateArticleCategory category=categoryService.selectByPrimaryKey(categoryId);
		category.setDeleteFlag(1);
		categoryService.updateByPrimaryKeySelective(category);
		return "redirect:/admin/categorylist.html";
	}
	
	// 栏目管理 排序
	@ResponseBody
	@RequestMapping(value = "/categorysort.do", method = RequestMethod.POST)
	public String articlesort(Integer value,Integer id,ModelMap model) {
		OperateArticleCategory category=categoryService.selectByPrimaryKey(id);
		category.setSort(value);
		categoryService.updateByPrimaryKeySelective(category);
		return "";
	}
	

	
}
