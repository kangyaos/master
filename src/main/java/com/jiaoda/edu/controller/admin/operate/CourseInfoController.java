package com.jiaoda.edu.controller.admin.operate;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.jiaoda.edu.controller.BaseController;
import com.jiaoda.edu.controller.admin.UploadController;
import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.log.SysControllerLog;
import com.jiaoda.edu.service.ICertificateService;
import com.jiaoda.edu.service.ICourseInfoHistoryService;
import com.jiaoda.edu.service.ICourseInfoService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.DateUtil;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.PrintImage;



@Controller
@RequestMapping("/admin")
public class CourseInfoController extends BaseController {
	
	@Autowired
	private ICourseInfoService infoService;
	@Autowired
	private ICourseInfoHistoryService historyService;
	
	@Autowired
	private IUserInfoService userService;
	
	@Autowired
	private ICertificateService ccService;


	/**
	 煤炭资讯*/
	@RequestMapping(value = "/courselist.html", method = RequestMethod.GET)
	public String courselist(HttpSession session,ModelMap model) {
		Object userId=session.getAttribute("userId");
		if(userId!=null) {
			UserInfo user=userService.selectByPrimaryKey(userId);
			model.put("roleName", user.getRoleName());
		}
		
		return "view/admin/operate/courselist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/courselist.json", method = RequestMethod.POST)
	public PageData<CourseInfo> getCourselist(HttpSession session,Integer draw, Integer start,
			Integer length, HttpServletRequest request) {
		Object userId=session.getAttribute("userId");
		UserInfo user=userService.selectByPrimaryKey(userId);
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		String where = param.getDefaultFilter();
		String order="publish_time desc";
		if("".equals(where)){
			where = "delete_flag=0 "+(!user.getRoleName().contains("管理员")?" and lecturer_id="+userId:"");
		}else if(!"".equals(where)){
			where = "(" +where+") and delete_flag=0 "+(!user.getRoleName().contains("管理员")?" and lecturer_id="+userId:"");
			order ="sort desc,publish_time desc";
		}
		PageData<CourseInfo> pageData = new PageData<CourseInfo>();
		Integer count = infoService.getCount(where);
		List<CourseInfo> data = infoService.findPagerList(start, length, where,order);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@RequestMapping(value = "/addcourse.html", method = RequestMethod.GET)
	public String addcourse(HttpSession session,ModelMap model) {
		CourseInfo course = new CourseInfo();
		Object userId=session.getAttribute("userId");
		UserInfo user=userService.selectByPrimaryKey(userId);
		model.put("roleName", user.getRoleName());
		if(user.getRoleName().contains("管理员")) {
			List<UserInfo> infos=userService.findWhereList(" delete_flag=0 and role_id=2","");
			model.put("infos", infos);
		}else {
			course.setLecturerId(user.getUserId());
			course.setLecturer(user.getRealName());
		}
		
	
		//煤炭资讯1//货运资讯2数据从快煤宝读取
		model.put("course", course);
		
		return "view/admin/operate/courseform";
	}
	
	@RequestMapping(value = "/editcourse.html", method = RequestMethod.GET)
	public String editcourse(Integer courseId, ModelMap model) {
		CourseInfo info = infoService.selectByPrimaryKey(courseId);
		info = info != null ? info : new CourseInfo();
	
		model.put("course", info);		
		List<UserInfo> infos=userService.findWhereList(" delete_flag=0 and role_id=2","");
		model.put("infos", infos);
		return "view/admin/operate/courseform";
	}

	
	@RequestMapping(value = "/savecourse.do", method = RequestMethod.POST)
	public String savecourse(HttpSession session,CourseInfo info,HttpServletRequest request) throws ParseException {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		
		Object userId=session.getAttribute("userId");
		UserInfo user=userService.selectByPrimaryKey(userId);
		
		String url = getServerUrl(request);
		if (info.getCourseId() == null) {
			info.setCreateTime(date);
			info.setUpdateTime(date);
			if(user.getRoleName().contains("管理员")) {
				info.setPublishState(1);
				info.setPublishTime(date);
			}else {
				info.setPublishState(0);
			}
			info.setDeleteFlag(0);			
			info.setSort(null);
			infoService.insertSelective(info);
			//生成证书
			loadImageLocal(info.getLecturerId(),info.getLecturer(),request);
			//默认排序
			getAddChangeSort(info);
		} else {
			CourseInfo entity = infoService.selectByPrimaryKey(info.getCourseId());
			entity.setCourseName(info.getCourseName());
			entity.setCourseType(info.getCourseType());
			entity.setCoursewareType(info.getCoursewareType());
			entity.setPic(info.getPic().equals("")?null:info.getPic());
			entity.setSummary(info.getSummary());
			entity.setSource(info.getSource());
			entity.setLecturer(info.getLecturer());
			
			if(entity.getPublishState()==0&&info.getPublishState()!=null&&info.getPublishState()==1) {
				entity.setPublishTime(date);
			}
			entity.setPublishState(info.getPublishState());
			entity.setContent(info.getContent());
			entity.setUpdateTime(date);
			infoService.updateByPrimaryKeySelective(entity);
		
		}
		return "redirect:/admin/courselist.html";
	}
	
	/**
	 * 新增时判断是不是头条或者幻灯片，进行默认排序
	 * @param entity
	 */
	private void getAddChangeSort(CourseInfo entity) {		
		CourseInfo info =new CourseInfo();
		
 			if(entity.getSort()==null){
 				info = infoService.findWhere(" course_type="+entity.getCourseType(),"sort desc");
				int num =0;
				if(info !=null){
					if(info.getSort()!=null){
						num = info.getSort()+1;
					}					
				}
				entity.setSort(num);
			}
 			if(entity.getPublishState()==1) {
 				entity.setCourseReleaseNum(""+info.getCourseId()+info.getCourseType()+System.currentTimeMillis());
 				historyService.insertSelective(entity);
 			}
		
 			infoService.updateByPrimaryKeySelective(entity);
	}
	


	//上移  下移
	@ResponseBody
	@RequestMapping(value = "/courseUpAndDown.do", method = RequestMethod.POST)
	@LogDesc(desc="排序幻灯头条")
	public String GetCourseUpAndDown(Integer courseId,Integer otherId,String typeId, ModelMap model) {
	
	
		CourseInfo sort = infoService.findWhere(" course_id="+courseId+" and course_type="+typeId, "");
		CourseInfo sort2 = infoService.findWhere(" course_id="+otherId+" and course_type="+typeId, "");
		Integer num = sort.getSort();
		Integer num2 = sort2.getSort();	
		sort.setSort(num2);
		sort2.setSort(num);
		infoService.updateByPrimaryKeySelective(sort);			
		infoService.updateByPrimaryKeySelective(sort2);
		return null;
	}
	

	@LogDesc(desc="删除课程")
	@ResponseBody
	@RequestMapping(value = "/courseedel.do", method = RequestMethod.POST)
	public boolean coursedel(ModelMap model, @RequestParam(value = "ids[]") Integer[] ids) {		
		for (Integer id : ids) {
			CourseInfo a = infoService.selectByPrimaryKey(id);
			a.setDeleteFlag(1);
			a.setSort(null);
			a.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			infoService.updateByPrimaryKeySelective(a);
		}		
		return true;
	}


	/**
	 *设置发布
	 */
	@ResponseBody
	@RequestMapping(value = "/coursesetUseStatus.do", method = RequestMethod.POST)
	public boolean setUseStatus(@RequestParam(value = "ids[]") Integer[] ids,
			Integer value) {
		for (Integer id : ids) {
			CourseInfo a = infoService.selectByPrimaryKey(id);
			a.setPublishState(value);
			if(value==1){
				a.setPublishTime(new Timestamp(System.currentTimeMillis()));
			}			
			infoService.updateByPrimaryKeySelective(a);
		}
		return true;
	}

	//提交审核
	@LogDesc(desc="审核课程")
	@ResponseBody
	@RequestMapping(value = "/courseAuth.do", method = RequestMethod.POST)
	public String courseAuth(HttpSession session,Integer verifyState,String verifyMemo,Integer courseId,HttpServletRequest request) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Object userId=session.getAttribute("userId");
		CourseInfo info = infoService.selectByPrimaryKey(courseId);
		info.setVerifier(Integer.parseInt(userId.toString()));
		info.setVerifyMemo(verifyMemo);
		info.setPublishState(verifyState);
		info.setPublishTime(nowTime);
		infoService.updateByPrimaryKeySelective(info);
		if(info.getPublishState()==1) {
			info.setCourseReleaseNum(""+info.getCourseId()+info.getCourseType()+System.currentTimeMillis());
			historyService.insertSelective(info);
		}
		return "true";
	}
	
	
		//提交审核
		@LogDesc(desc="批量审核课程")
		@ResponseBody
		@RequestMapping(value = "/batchcourseAuth.do", method = RequestMethod.POST)
		public String batchcourseAuth(HttpSession session,Integer verifyState,String verifyMemo,@RequestParam(value = "courseIds[]") Integer[] courseIds,HttpServletRequest request) {
			Timestamp nowTime = new Timestamp(System.currentTimeMillis());	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Object userId=session.getAttribute("userId");
			for (Integer courseId : courseIds) {
				CourseInfo info = infoService.selectByPrimaryKey(courseId);
				if(info.getPublishState()==0) {
					info.setVerifier(Integer.parseInt(userId.toString()));
					info.setVerifyMemo(verifyMemo);
					info.setPublishState(verifyState);
					info.setPublishTime(nowTime);
					infoService.updateByPrimaryKeySelective(info);
					if(info.getPublishState()==1) {
						info.setCourseReleaseNum(""+info.getCourseId()+info.getCourseType()+System.currentTimeMillis());
						historyService.insertSelective(info);
					}
				}
				
			}
			return "true";
		}	
		
	@ResponseBody
	@LogDesc(desc="批量删除课程")
	@RequestMapping(value = "/couserdel.do", method = RequestMethod.POST)
	public boolean couserdel(ModelMap model, @RequestParam(value = "ids[]") Integer[] ids) {
		infoService.batchdelete(ids);
		return true;
	}
	
	@ResponseBody
	@LogDesc(desc="批量下架课程")
	@RequestMapping(value = "/batchUpdateState.do", method = RequestMethod.POST)
	public boolean courseUseStatus(ModelMap model, @RequestParam(value = "ids[]") Integer[] ids) {
		infoService.batchUpdateState(ids);
		return true;
	}
	
	
	@ResponseBody
	@LogDesc(desc="生成证书")
	@RequestMapping(value = "/createcertificate.do", method = RequestMethod.POST)
	public boolean createcertificate(Integer uId,HttpServletRequest request) {
		UserInfo user=	userService.selectByPrimaryKey(uId);
		loadImageLocal(uId,user.getRealName(),request);
		return true;
	}
	@ResponseBody
	@LogDesc(desc="生成证书")
	@RequestMapping(value = "/createcertificate1.do", method = RequestMethod.POST)
	public boolean createcertificate(Integer uId,@RequestParam(value = "ids[]") Integer[] ids,HttpServletRequest request) {
		for (Integer id : ids) {
			loadImageLocal(uId,1,id,request);
		}
		return true;
	}

}
