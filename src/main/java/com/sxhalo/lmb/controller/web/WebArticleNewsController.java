package com.sxhalo.lmb.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxhalo.lmb.controller.BaseController;
import com.sxhalo.lmb.domain.OperateActivity;
import com.sxhalo.lmb.domain.OperateArticle;
import com.sxhalo.lmb.domain.OperateArticleCategory;
import com.sxhalo.lmb.service.IOperateActivityService;
import com.sxhalo.lmb.service.IOperateArticleCategoryService;
import com.sxhalo.lmb.service.IOperateArticleService;

@Controller
public class WebArticleNewsController extends BaseController {

	@Autowired
	private IOperateArticleService articleService;
	@Autowired
	private IOperateArticleCategoryService categoryService;
	
	/*
	 * 煤炭资讯列表
	 */
	@RequestMapping(value = "/articlelist.html", method = RequestMethod.GET)
	public String article( HttpServletRequest request,ModelMap map,Integer type) {
		if(type==null)type=3;
		//导航栏目
		List<OperateArticleCategory> categories = categoryService.findWhereList("category_id !=4 and category_id!=1 and category_id!=2", "category_id desc");
		map.put("categories", categories);
		//新闻头条
		List<OperateArticle> alist = articleService.findPagerList(0, 3, " a.is_special=1 and a.publish_state=1", "a.publish_time DESC");
	    map.put("alist", alist);		
	    //热点资讯
  		List<OperateArticle> olist = articleService.findPagerList(0, 10, "", "RAND()");
  	    map.put("olist", olist);
  	    map.put("picPath", UPLOAD_URL);
		return "/view/web/articlelist";
	}
	
	/**
	 * 新闻详情
	 * 
	 */
	@RequestMapping(value = "/articledetail/{articleId}.htm", method = RequestMethod.GET)
	public String articledetail(@PathVariable("articleId") Integer articleId,ModelMap map) {
		OperateArticle article = articleService.selectByPrimaryKey(articleId);
	    article.setClickNum(article.getClickNum()+1);
	    articleService.updateByPrimaryKeySelective(article);
	    map.put("article", article==null?new OperateArticle():article);
	    //获取上一篇文章和下一偏文章
	    OperateArticle art1 = articleService.findWhere("article_id<"+articleId, " article_id desc");
	    OperateArticle art2 = articleService.findWhere("article_id>"+articleId, " article_id asc");
		map.put("up", art1==null?new OperateArticle():art1);
		map.put("down", art2==null?new OperateArticle():art2);
		//截取 资讯路径
		if(art1!=null){
			String []o =art1.getPublishUrl().split("/");
			String upUrl=o[4]+"/"+o[5];
			map.put("upUrl", upUrl);
		}
		if(art2!=null){
			String []p =art2.getPublishUrl().split("/");
			String downUrl=p[4]+"/"+p[5];
			map.put("downUrl", downUrl);
		}
	    //热点资讯
		List<OperateArticle> olist = articleService.findPagerList(0, 10, "", "RAND()");
	    map.put("olist", olist);
	    //每日头条
	    List<OperateArticle> toplist = articleService.findPagerList(0, 5, " a.category_id=5", "a.publish_time DESC");
	    map.put("toplist", toplist);
		return "/view/web/articledetail";
	}
	
	
	/**
	 * 根据栏目获取相应的资讯列表
	 * 
	 */	
	@ResponseBody
	@RequestMapping(value = "/articleByType.do", method = RequestMethod.POST)
	public Map<String, Object> ArticleByType(Integer type,Integer p,HttpServletRequest request) {		
		Map<String,Object> map = new HashMap<String, Object>();
		int count = articleService.getCount(" a.category_id="+type);
	    int size = 10;
	    int pageCount=count/size;
		if(count%size!=0){
			 pageCount++;
		}		
		int pageIndex=0;		
		if(p !=null){
			pageIndex=p;
		}		
		if(pageIndex>pageCount-1) pageIndex=pageCount-1;
		if(pageIndex<0) pageIndex=0;
	    List<OperateArticle> olist = articleService.findPagerList(pageIndex*size, size, " a.category_id="+type, "a.publish_time DESC");
	    map.put("list", olist);
	    map.put("count", count);
	    map.put("type", type);
	    map.put("size", olist.size());
	    map.put("pageCount", pageCount);
	    map.put("pageIndex", pageIndex);		
		return map;
	}
	
	@Autowired
	private IOperateActivityService operateActivityService;
	
	/*
	 * 最新活动
	 */
	@RequestMapping(value = "/activitylist.html", method = RequestMethod.GET)
	public String activity( HttpServletRequest request,ModelMap map,Integer type) {
		return "/view/web/activitylist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/activitylist.do", method = RequestMethod.POST)
	public Map<String, Object> getActivityList( HttpServletRequest request,Integer page,Integer length) {
		Map<String,Object> map = new HashMap<String, Object>();
		String where=" delete_flag=0 and app_type = 0 ";
		Integer count = operateActivityService.getCount(where);
		List<OperateActivity> activityList = operateActivityService.findPagerList(page*length, length, where, "create_time desc");
		map.put("list", activityList);			   
		map.put("count", count);
		map.put("picUrl",UPLOAD_URL);
		return map;

	}
}
