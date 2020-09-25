package com.jiaoda.edu.controller.admin.operate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.controller.BaseController;
import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.OperateArticleCategory;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.service.IOperateArticleCategoryService;
import com.jiaoda.edu.service.IOperateArticleService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;


@Controller
@RequestMapping("/admin")
public class OperateArticleController extends BaseController {
	
	@Autowired
	private IOperateArticleService articleService;
	@Autowired
	private IOperateArticleCategoryService categoryService;
	
	/**
	 煤炭资讯*/
	@RequestMapping(value = "/articlelist.html", method = RequestMethod.GET)
	public String mineMouthList(ModelMap model) {
		model.put("mlist", categoryService.findPagerList(0, -1, "useStatus=0 and deleteFlag=0 and (categoryId!=1 and categoryId!=2)", "sort asc"));
		return "admin/operate/articlelist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/articleList.json", method = RequestMethod.POST)
	public PageData<OperateArticle> getArticleList(Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		String order="publishTime desc";
		if("".equals(where)){
			where = "deleteFlag=0";
		}else if(!"".equals(where)){
			where = "(" +where+") and deleteFlag=0";
			order ="sort desc,publishTime desc";
		}
		PageData<OperateArticle> pageData = new PageData<OperateArticle>();
		Integer count = articleService.getCount(where);
		List<OperateArticle> data = articleService.findPagerList(start, length, where,order);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@RequestMapping(value = "/addarticle.html", method = RequestMethod.GET)
	public String addArticle(ModelMap model) {
		OperateArticle article = new OperateArticle();
		//煤炭资讯1//货运资讯2数据从快煤宝读取
		List<OperateArticleCategory> category = categoryService.findPagerList(0, -1, 
				"useStatus=0 and deleteFlag=0 and (categoryId!=1 and categoryId!=2)", "sort");
		article.setClickNum((int)(Math.random()*(10000-100+1)+100));
		model.put("category", category);
		model.put("article", article);
		return "admin/operate/articleform";
	}
	
	@RequestMapping(value = "/editarticle.html", method = RequestMethod.GET)
	public String editArticle(Integer articleId, ModelMap model) {
		OperateArticle article = articleService.selectByPrimaryKey(articleId);
		article = article != null ? article : new OperateArticle();
		//煤炭资讯1//货运资讯2数据从快煤宝读取
		List<OperateArticleCategory> category = categoryService.findPagerList(0, -1, 
				"useStatus=0 and deleteFlag=0 and (categoryId!=1 and categoryId!=2)", "sort");
		model.put("category", category);
		model.put("article", article);		
		return "admin/operate/articleform";
	}

	
	@RequestMapping(value = "/savearticle.do", method = RequestMethod.POST)
	public String saveArticle(OperateArticle article,HttpServletRequest request) throws ParseException {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String url = getServerUrl(request);
		if (article.getArticleId() == null) {
			article.setPublishTime(date);
			article.setCreateTime(date);
			article.setUpdateTime(date);
			article.setIsSend(0);
			article.setPublishState(0);
			article.setDeleteFlag(0);			
			article.setSort(null);
			article.setTumb(article.getTumb().equals("")?null:article.getTumb());
			articleService.insertSelective(article);
			article.setPublishUrl(url+"articledetail/"+article.getArticleId()+".htm");			
			articleService.updateByPrimaryKeySelective(article);
			getAddChangeSort(article);
		} else {
			OperateArticle entity = articleService.selectByPrimaryKey(article.getArticleId());
			entity.setTitle(article.getTitle());
			entity.setCategoryId(article.getCategoryId());
			entity.setTumb(article.getTumb().equals("")?null:article.getTumb());
			entity.setTumbPicCode(article.getTumbPicCode().equals("")?null:article.getTumbPicCode());
			entity.setTumbPicCode2(article.getTumbPicCode2().equals("")?null:article.getTumbPicCode2());
			entity.setTumbPicCode3(article.getTumbPicCode3().equals("")?null:article.getTumbPicCode3());
			entity.setSummary(article.getSummary());
			entity.setIsSpecial(article.getIsSpecial());
			entity.setIsPicture(article.getIsPicture());
			entity.setClickNum(article.getClickNum());
			entity.setAuthor(article.getAuthor());
			entity.setSource(article.getSource());
			entity.setContent(article.getContent());
			entity.setUpdateTime(date);
			articleService.updateByPrimaryKeySelective(entity);
			getChangeSort(entity);
		}
		return "redirect:admin/articlelist.html";
	}
	
	/**
	 * 新增时判断是不是头条或者幻灯片，进行默认排序
	 * @param entity
	 */
	private void getAddChangeSort(OperateArticle entity) {		
		OperateArticle article =new OperateArticle();
		if(entity.getCategoryId()==4 && entity.getSort()==null){
			article = articleService.findWhere(" categoryId="+entity.getCategoryId(),"sort desc");
			int num =0;
			if(article !=null){
				num = (article.getSort()==null || article.getSort().equals(""))?num:(article.getSort()+1);									
			}
			entity.setSort(num);
		}else{
			if(entity.getIsSpecial()==1 && entity.getSort()==null){
				article = articleService.findWhere(" categoryId="+entity.getCategoryId()+" and isSpecial=1","sort desc");
				int num =0;
				if(article !=null){
					if(article.getSort()!=null || !article.getSort().equals("")){
						num = article.getSort()+1;
					}					
				}
				entity.setSort(num);
			}
		}
		articleService.updateByPrimaryKeySelective(entity);
	}
	
	/**
	 * 编辑判断是不是头条或者幻灯片，进行默认排序
	 * @param entity
	 */
	private void getChangeSort(OperateArticle entity) {		
		OperateArticle article =new OperateArticle();
		if(entity.getCategoryId()==4 && entity.getSort()==null){
			article = articleService.findWhere(" categoryId="+entity.getCategoryId(),"sort desc");
			int num =0;
			if(article !=null){
				if(article.getSort()==null || article.getSort().equals("")){
					num=0;
				}else{
					num = article.getSort()+1;
				}
			}
			entity.setSort(num);
			articleService.updateByPrimaryKeySelective(entity);
		}else{
			if(entity.getIsSpecial()==1 && entity.getSort()==null){
				article = articleService.findWhere(" categoryId="+entity.getCategoryId()+" and isSpecial=1","sort desc");
				int num =0;
				if(article !=null){
					if(article.getSort()!=null &&!"".equals(article.getSort())){
						num = article.getSort()+1;
					}					
				}
				entity.setSort(num);
				articleService.updateByPrimaryKeySelective(entity);
			}else if(entity.getIsSpecial()==1 && entity.getSort()!=null){
				List<OperateArticle> list =  articleService.findWhereList(" categoryId="+entity.getCategoryId()+" and isSpecial=1","sort asc");
				for (int i = 0; i < list.size(); i++) {
					article = articleService.findWhere("articleId="+ list.get(i).getArticleId(),"");
					article.setSort(i);
					articleService.updateByPrimaryKeySelective(article);
				}
			}else if(entity.getIsSpecial()==0 && entity.getSort()!=null){
				entity.setSort(null);
				articleService.updateByPrimaryKeySelective(entity);
				List<OperateArticle> list =  articleService.findWhereList(" categoryId="+entity.getCategoryId()+" and isSpecial=1","sort asc");
				for (int i = 0; i < list.size(); i++) {
					article = articleService.findWhere("articleId="+list.get(i).getArticleId(),"");
					article.setSort(i);
					articleService.updateByPrimaryKeySelective(article);
				}
			}
		}		
	}

	//上移  下移
	@ResponseBody
	@RequestMapping(value = "/articleUpAndDown.do", method = RequestMethod.POST)
	@LogDesc(desc="排序幻灯头条")
	public String GetArticleUpAndDown(Integer articleId,Integer otherId,String typeId, ModelMap model) {
		OperateArticleCategory category= categoryService.findWhere("categoryName="+typeId, "");
		Integer type = category==null?0:category.getCategoryId();
		OperateArticle sort = articleService.findWhere(" articleId="+articleId+" and categoryId="+type, "");
		OperateArticle sort2 = articleService.findWhere(" articleId="+otherId+" and categoryId="+type, "");
		Integer num = sort.getSort();
		Integer num2 = sort2.getSort();	
		sort.setSort(num2);
		sort2.setSort(num);
		articleService.updateByPrimaryKeySelective(sort);			
		articleService.updateByPrimaryKeySelective(sort2);
		return null;
	}
	
	
	
   /**资讯详情页*/
	@RequestMapping(value = "articledetail/{articleId}.htm", method = RequestMethod.GET)
	public String articlalert(@PathVariable("articleId") Integer articleId,
			ModelMap model,HttpServletRequest request) {
		String url = getServerUrl(request);
		OperateArticle article = articleService.selectByPrimaryKey(articleId);		
		model.put("article", article);
		model.put("base", request.getContextPath());
		SimpleDateFormat sdf9 = new SimpleDateFormat("MM/dd");
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String today = sdf9.format(date);
		String publishTime = sdf9.format(article.getPublishTime());
		if(today.equals(publishTime)) {
			model.put("date", sdf9.format(article.getPublishTime()));
		}
		if (article.getClickNum() == null) {
			article.setClickNum(5);
		} else {
			article.setClickNum(article.getClickNum() + 1);
		}		
		article.setPublishUrl(url+"articledetail/"+article.getArticleId()+".htm");
		articleService.updateByPrimaryKeySelective(article);
		return "admin/operate/articledetail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/articledel.do", method = RequestMethod.POST)
	public boolean articledel(ModelMap model, @RequestParam(value = "ids[]") Integer[] ids) {		
		for (Integer id : ids) {
			OperateArticle a = articleService.selectByPrimaryKey(id);
			a.setDeleteFlag(1);
			a.setSort(null);
			a.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			articleService.updateByPrimaryKeySelective(a);
		}		
		return true;
	}

	/**
	 *设置头条
	 */
	@ResponseBody
	@RequestMapping(value = "/ArticleIsSpecial.do", method = RequestMethod.POST)
	public boolean IsSpecial(@RequestParam(value = "ids[]") Integer[] ids,Integer value) {
		for (Integer id : ids) {
			OperateArticle a = articleService.selectByPrimaryKey(id);
			if(value==1 ){
				OperateArticle article = articleService.findWhere(" categoryId="+a.getCategoryId(), "sort desc");				
				int num =article.getSort()==null?0:article.getSort()+1;
				a.setSort(num);
				a.setIsSpecial(value);
				articleService.updateByPrimaryKeySelective(a);
			}else if(value==0){
				a.setSort(null);
				a.setIsSpecial(value);
				articleService.updateByPrimaryKeySelective(a);
				List<OperateArticle> list =  articleService.findWhereList(" categoryId="+a.getCategoryId()+" and isSpecial=1","sort asc");
				for (int i = 0; i < list.size(); i++) {
					OperateArticle article = articleService.findWhere("article_id="+list.get(i).getArticleId(),"" );
					article.setSort(i);
					articleService.updateByPrimaryKeySelective(article);
				}
			}			
		}
		return true;
	}
   
	/**
	 *设置发布
	 */
	@ResponseBody
	@RequestMapping(value = "/ArticlesetUseStatus.do", method = RequestMethod.POST)
	public boolean setUseStatus(@RequestParam(value = "ids[]") Integer[] ids,
			Integer value) {
		for (Integer id : ids) {
			OperateArticle a = articleService.selectByPrimaryKey(id);
			a.setPublishState(value);
			if(value==1){
				a.setPublishTime(new Timestamp(System.currentTimeMillis()));
			}			
			articleService.updateByPrimaryKeySelective(a);
		}
		return true;
	}
}
