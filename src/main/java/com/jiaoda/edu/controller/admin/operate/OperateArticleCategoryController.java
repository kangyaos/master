package com.jiaoda.edu.controller.admin.operate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
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

import com.jiaoda.edu.domain.OperateArticleCategory;
import com.jiaoda.edu.service.IOperateArticleCategoryService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.Util;



@Controller
public class OperateArticleCategoryController {
	
	@Autowired
	private IOperateArticleCategoryService categoryService;
	/**
	 *煤炭生活 栏目管理
	 */
	@RequestMapping(value = "/categorylist.html", method = RequestMethod.GET)
	public String mineMouthList(ModelMap model) {
		return "operate/categorylist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/categoryList.json", method = RequestMethod.POST)
	public PageData<OperateArticleCategory> getCategoryList(Integer draw, Integer start,
			Integer length,Integer pId, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		PageData<OperateArticleCategory> pageData = new PageData<OperateArticleCategory>();
		if("".equals(where)){
			where = pId == null ? "" : " parentCategory= " + pId+" or categoryId="+pId;
		}else{
			where = "(" + where + ")" + (pId == null ? "" : " and parentCategory= " + pId +" or categoryId="+pId);
		}		
		Integer count = categoryService.getCount(where);
		List<OperateArticleCategory> data = categoryService.findPagerList(start, length, where, "parentCategory,sort asc");
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
		List<OperateArticleCategory> clist = categoryService.findPagerList(0, -1, "deleteFlag=0", "sort asc");
		model.put("mlist",clist );
		return "operate/categoryform";
	}
	
	@RequestMapping(value = "/editcategory.html", method = RequestMethod.GET)
	public String editcategory(Integer categoryId, ModelMap model) {
		OperateArticleCategory category = categoryService.selectByPrimaryKey(categoryId);
		category = category != null ? category : new OperateArticleCategory();
		model.put("category", category);	
		model.put("mlist", categoryService.findPagerList(0, -1, "deleteFlag=0", "sort asc"));
		return "operate/categoryform";
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
			entity.setImage(category.getImage());
			entity.setCategoryPicCode(category.getCategoryPicCode());
			entity.setUpdateTime(date);
			entity.setUseStatus(category.getUseStatus());
			categoryService.updateByPrimaryKeySelective(entity);
		}
		return "redirect:/categorylist.html";
	}

	@RequestMapping(value = "/categorydel.do", method = RequestMethod.GET)
	public String articlecategorydel(ModelMap model, Integer categoryId) {
		OperateArticleCategory category=categoryService.selectByPrimaryKey(categoryId);
		category.setDeleteFlag(1);
		categoryService.updateByPrimaryKeySelective(category);
		return "redirect:/categorylist.html";
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
	
	
	/**
	 * 资讯栏目树状显示父级菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/categorytree.json")
	public List<Map<String, Object>> getcategorytree() {
		List<Map<String, Object>> list = getTreeData(categoryService.findPagerList(0, -1, "deleteFlag=0 and parentCategory=0", "sort"));
		return list;
	}
	
	private List<Map<String, Object>> getTreeData(List<OperateArticleCategory> list) {		
		List<Map<String, Object>> tree = new ArrayList<Map<String, Object>>();
		for (OperateArticleCategory category : list) {
				Map<String, Object> node = new HashMap<String, Object>();
				Map<String, Object> state = new HashMap<String, Object>();
				node.put("id", category.getCategoryId());
				node.put("text",category.getCategoryName().replace("<br/>", "").trim());
		        node.put("state", state);
				List<Map<String, Object>> child = getTreeData(categoryService.findPagerList(0, -1, "deleteFlag=0 and parentCategory="+category.getCategoryId(), "sort"));
				if (child.size() > 0) {
					state.put("opened", false);
					node.put("children", child);
				}
				tree.add(node);
			}
		return tree;
	}
	
	
	
}
