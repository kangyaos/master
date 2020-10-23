package com.jiaoda.edu.controller.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaoda.edu.controller.BaseController;
import com.jiaoda.edu.controller.admin.UploadController;
import com.jiaoda.edu.controller.admin.operate.CourseInfoController;
import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.Questionnaire;
import com.jiaoda.edu.domain.UserAnswerRecord;
import com.jiaoda.edu.domain.UserAnswerRecordKey;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.domain.UserLearnRecord;
import com.jiaoda.edu.domain.UserLearnRecordKey;
import com.jiaoda.edu.service.ICertificateService;
import com.jiaoda.edu.service.ICourseInfoService;
import com.jiaoda.edu.service.IOperateArticleService;
import com.jiaoda.edu.service.IQuestionnaireService;
import com.jiaoda.edu.service.IUserAnswerRecordService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.service.IUserLearnRecordService;
import com.jiaoda.edu.util.DateUtil;
import com.jiaoda.edu.util.PrintImage;



@Controller
public class WebIndexController extends BaseController {
	
	@Autowired
	private IOperateArticleService articleService;
	
	@Autowired
	private ICourseInfoService infoService;
	
	@Autowired
	private IUserInfoService userService;
	
	@Autowired
	private ICertificateService certService;
	@Autowired
	private IUserLearnRecordService leanService;
	@Autowired
	private IUserAnswerRecordService answerService;
	@Autowired
	private IQuestionnaireService naireService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/index.html";
	}

	// 网站首页
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap map) throws Exception {
		List<CourseInfo> infos= infoService.findPagerList(0, 6, " delete_flag=0 and pic!='' and pic is not null", "");
		List<OperateArticle> articles= articleService.findPagerList(0, 4, " a.category_id=1", "");
		List<Certificate> certs= certService.findPagerList(0,3, "", " a.create_time desc");
		List<UserInfo> users= userService.findPagerList(0, 5, " delete_flag=0 and role_id=2", "");
		map.put("infos", infos);
		map.put("users", users);
		map.put("certs", certs);
		map.put("articles", articles);
		return "view/web/index";
	}
	
	// 网站首页
	@RequestMapping(value = "/trainingcourse.html", method = RequestMethod.GET)
	public String trainingcourse(Integer  pgid,HttpServletRequest request, ModelMap map) throws Exception {
		pgid=pgid==null?0:pgid;
		Integer count=infoService.getCount(" delete_flag=0 and course_type="+pgid);
		map.put("pgid", pgid==null?0:pgid);
		map.put("count", count%6==0?count/6:(count/6+1));
		return "view/web/trainingcourse";
	}
	
	// 网站首页
	@ResponseBody
	@RequestMapping(value = "/course.json", method = RequestMethod.POST)
	public Map<String,Object > course(Integer  pgid,Integer page,Integer type,HttpServletRequest request) throws Exception {
		pgid=pgid==null?0:pgid;
		page=page==null?1:page;
		if(type!=null) {
			page=page+type;
		}
		List<CourseInfo> infos= infoService.findPagerList((page-1)*6, 6, " delete_flag=0 and course_type="+pgid, "");
		Integer count=infoService.getCount(" delete_flag=0 and course_type="+pgid);
		HashMap map=new HashMap();
		map.put("infos", infos);
		map.put("count", count%6==0?count/6:(count/6+1));
		map.put("page", page);
		return map;
	}
	
	// 网站首页
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public String contact(HttpServletRequest request, ModelMap map) throws Exception {
		
		return "view/web/contact";
	}
	// 网站首页
	@RequestMapping(value = "/teacher.html", method = RequestMethod.GET)
	public String teacher(HttpServletRequest request, ModelMap map) throws Exception {
		
		return "view/web/teacher";
	}
	
	// 网站首页
	@ResponseBody
	@RequestMapping(value = "/teacher.json", method = RequestMethod.POST)
	public Map<String,Object > teacherdata(Integer page,Integer ptype,HttpServletRequest request) throws Exception {
		 Map<String, String[]> maps= request.getParameterMap();
		page=page==null?1:page;
		if(ptype!=null) {
			page=page+ptype;
		}
		List<UserInfo> infos= userService.findPagerList((page-1)*6, 6, " delete_flag=0 and role_id=2", "");
		Integer count=userService.getCount(" delete_flag=0 and role_id=2");
		HashMap map=new HashMap();
		map.put("infos", infos);
		map.put("count", count%6==0?count/6:(count/6+1));
		map.put("page", page);
		return map;
	}
	
	// 网站首页
	@RequestMapping(value = "/news.html", method = RequestMethod.GET)
	public String news(Integer gid,Integer page,Integer type,HttpServletRequest request, ModelMap map) throws Exception {
		
		gid=gid==null?1:gid;
		page=page==null?1:page;
		if(type!=null) {
			page=page+type;
		}
		
		List<OperateArticle> articles= articleService.findPagerList((page-1)*5, 5, " a.category_id="+gid, "");
		Integer count=articleService.getCount("");
		map.put("articles", articles);
		map.put("count", count%3==0?count/3:(count/3+1));
		map.put("gid", gid==null?1:gid);
		map.put("page", page);
		return "view/web/news";
	}
	
	
	
	//证书
	@RequestMapping(value = "/certificate.html", method = RequestMethod.GET)
	public String certificate(HttpServletRequest request, ModelMap map) throws Exception {
		return "view/web/certificate";
	}
	// 网站首页
	@ResponseBody
	@RequestMapping(value = "/certificate.json", method = RequestMethod.POST)
	public Map<String,Object > certificatedata(Integer page,Integer type,HttpServletRequest request) throws Exception {
		
		page=page==null?1:page;
		if(type!=null) {
			page=page+type;
		}
		List<Certificate> infos= certService.findPagerList((page-1)*6, 6, "", " a.create_time desc");
		Integer count=certService.getCount("");
		HashMap map=new HashMap();
		map.put("infos", infos);
		map.put("count", count%6==0?count/6:(count/6+1));
		map.put("page", page);
		return map;
	}
	
	//新闻详情
	@RequestMapping(value = "/newsdetail.html", method = RequestMethod.GET)
	public String newsdetail(String newsid,HttpServletRequest request, ModelMap map) throws Exception {
		OperateArticle article= articleService.selectByPrimaryKey(newsid.replaceAll(",", ""));
		article.setClickNum(article.getClickNum()==null?0:article.getClickNum()+1);
		articleService.updateByPrimaryKeySelective(article);
		   //获取上一篇文章和下一偏文章
		OperateArticle art1 = articleService.findWhere(" article_id<"+article.getArticleId(), " article_id desc");
		OperateArticle art2 = articleService.findWhere(" article_id>"+article.getArticleId(), " article_id asc");
		map.put("up", art1==null?new OperateArticle():art1);
		map.put("down", art2==null?new OperateArticle():art2);
		map.put("article", article);
		return "view/web/newsdetail";
	}
	//课程详情
	@RequestMapping(value = "/coursedetail.html", method = RequestMethod.GET)
	public String coursedetail(Integer pid,HttpServletRequest request, ModelMap map) throws Exception {
		CourseInfo info= infoService.selectByPrimaryKey(pid);
		map.put("info", info);
		return "view/web/coursedetail";
	}
	
	//课程详情
	@RequestMapping(value = "/learncoursedetail.html", method = RequestMethod.GET)
	public String learncoursedetail(Integer cid,Integer keshi,HttpSession session,HttpServletRequest request, ModelMap map) throws Exception {
		keshi=keshi==null?1:keshi;
		CourseInfo info= infoService.selectByPrimaryKey(cid);
		map.put("info", info);
		map.put("keshi", keshi);
		UserLearnRecordKey userleankey=new UserLearnRecordKey();
		userleankey.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
	
		userleankey.setKeshi(keshi);
		userleankey.setCourseId(cid);
		UserLearnRecord userlean =leanService.selectByPrimaryKey(userleankey);
		if(userlean==null){
			userlean=new UserLearnRecord();
			userlean.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
			userlean.setKeshi(keshi);
			userlean.setCourseId(cid);
			userlean.setCreateTime(new Date());
			leanService.insertSelective(userlean);
		}
	
		return "view/web/learncoursedetail";
	}
	
	//课程详情
	@ResponseBody
	@RequestMapping(value = "/createlearnrecod.do", method = RequestMethod.POST)
	public Boolean createlearnrecod(Integer cid,Integer keshi,Integer time,HttpSession session,HttpServletRequest request, ModelMap map) throws Exception {
	   Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
	   String userName=session.getAttribute("userName").toString();
		UserLearnRecordKey userleankey=new UserLearnRecordKey();
		userleankey.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
		userleankey.setKeshi(keshi);
		userleankey.setCourseId(cid);
		UserLearnRecord userlean =leanService.selectByPrimaryKey(userleankey);
		userlean.setCompleteState(1);
		userlean.setLearnTime(time);
		leanService.updateByPrimaryKeySelective(userlean);
		CourseInfo info= infoService.selectByPrimaryKey(cid);
		if(info.getSource().split(",").length==keshi){
			loadImageLocal(userId,keshi,cid,request);
		}
		return true;
	}
	
	//课程详情
	@RequestMapping(value = "/teacherdetail.html", method = RequestMethod.GET)
	public String teacherdetail(Integer pid,HttpServletRequest request, ModelMap map) throws Exception {
		UserInfo info= userService.selectByPrimaryKey(pid);
		map.put("info", info);
		return "view/web/teacherdetail";
	}
	//课程详情
	@RequestMapping(value = "/web/login.html", method = RequestMethod.GET)
	public String login(String url,Integer cid,HttpServletRequest request, ModelMap map) throws Exception {
		map.put("cid", cid);
		map.put("url", url);
		return "view/web/login";
	}
	
	//问卷调查
	@RequestMapping(value = "/questionnaire.html", method = RequestMethod.GET)
	public String questionnaire(HttpServletRequest request, HttpSession session,ModelMap map) throws Exception {
		 ObjectMapper oMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL);
		
		Object userId=session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/web/login.html";
		}else {
			Questionnaire naire=naireService.selectDetailByWhere(null);
			Integer uId=Integer.parseInt(session.getAttribute("userId").toString());
			UserAnswerRecordKey key=new UserAnswerRecordKey();
			key.setNaireId(naire.getId());
			key.setUserId(uId);
			UserAnswerRecord record=answerService.selectByPrimaryKey(key);
			map.put("naire", naire);
			if(record!=null) {
				Map m=new HashMap();
				m= oMapper.readValue(record.getContent(), Map.class);
				map.put("answer", m);
			}
		}
	
		
		return "view/web/questionnaire";
	}		

	
	//提交问卷
	@ResponseBody
	@RequestMapping(value = "/submitAnswerRecord.do", method = RequestMethod.POST)
	public Boolean submitAnswerRecord(Integer id,String questions,HttpSession session,HttpServletRequest request, ModelMap map) throws Exception {
	   Date now=new Date();
	   Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
	   UserAnswerRecord record=new UserAnswerRecord();
	   record.setUserId(userId);
	   record.setNaireId(id);
	   record.setCreateTime(now);
	   record.setSubmitTime(now);
	   record.setUpdateTime(now);
	   record.setContent(questions);
	   answerService.insertSelective(record);
		return true;
	}
	

	@RequestMapping(value = "/download/temp", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws Exception {
		String path = ResourceUtils.getURL("classpath:").getPath() + "static/assets/web/企业加入审批表.docx";
		downloadFile(response, path, "企业加入审批表.docx");
		return;

	}
	
	public void downloadFile(HttpServletResponse response, String path, String fileName) throws IOException {
		
		File file = new File(path);
		if (file.exists()) {
			/** 将文件名称进行编码 */
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("content-type:octet-stream");
			/** 读取服务器端模板文件 */
			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			/** 将流中内容写出去 . */
			OutputStream outputStream = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			inputStream.close();
			outputStream.close();
		}else {
			System.out.println("路径有误，文件不存在！");
		}
	}

	
	
}
