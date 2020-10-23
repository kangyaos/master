package com.jiaoda.edu.controller.admin.user;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jiaoda.edu.domain.SysRole;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.service.ISysRolesService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.PasswordEncoder;


@Controller
@RequestMapping("/admin")
public class TeacherController {

  
	
    
	@RequestMapping(value = "/teacherlist.html", method = RequestMethod.GET)
	public String UserInfoList(ModelMap model,HttpServletRequest request) {
		return "view/admin/user/teacherlist";
	}

	@RequestMapping(value = "/addteacher.html", method = RequestMethod.GET)
	public String addUserInfo(ModelMap model,HttpServletRequest request) {
		List<SysRole> roles=rolesService.findWhereList("", " role_sort asc");
		
        model.put("roles", roles);
		model.put("teacher", new UserInfo());
		return "view/admin/user/UserInfoform";
	}

	@RequestMapping(value = "/editteacher.html", method = RequestMethod.GET)
	public String editUserInfo(Integer teacherId, ModelMap model,HttpServletRequest request) {
		UserInfo teacher = userService.selectByPrimaryKey(teacherId);
		teacher = teacher != null ? teacher : new UserInfo();
		List<SysRole> roles=rolesService.findWhereList("", " role_sort asc");
        model.put("roles", roles);
		model.put("teacher", teacher);	
		return "view/admin/user/teacherform";
	}

	@RequestMapping(value = "/saveteacher.do", method = RequestMethod.POST)
	public String saveRole(UserInfo teacher) {
		if (teacher.getUserId()==null) {
			teacher.setUserPwd(PasswordEncoder.MD5(teacher.getUserPwd()));
			teacher.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			teacher.setCreateTime(new Timestamp(System.currentTimeMillis()));
			teacher.setDeleteFlag(0);
			userService.insertSelective(teacher);
			
//			userService.update(teacher);
		} else {
			UserInfo entity = userService.selectByPrimaryKey(teacher.getUserId()); 
			entity.setUserName(teacher.getUserName());
			entity.setRealName(teacher.getRealName());
			entity.setUserMobile(teacher.getUserMobile());
			
			entity.setRoleId(teacher.getRoleId());
			entity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			userService.updateByPrimaryKeySelective(entity);
		}
		return "redirect:/admin/teacherlist.html";
	}


	
	
	@ResponseBody
	@RequestMapping(value = "/teacherlist.json", method = RequestMethod.POST)
	public PageData<UserInfo> getRoleList(Integer draw, Integer start, Integer length,
			HttpServletRequest request) {
  		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		String where =param.getDefaultFilter();		
		if("".equals(where)){
			where = " delete_flag=0 and role_id=2";
		}else if(!"".equals(where)){
			where = "(" +where+") and  delete_flag=0 and role_id=2";
			
		}
		Integer count = userService.getCount(where);
		List<UserInfo> data = userService.findPagerList(start, length, where, "create_time desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@LogDesc(desc="移除老师")
	@RequestMapping(value = "/removeteacher.do", method = RequestMethod.POST)
	public Boolean deluser(Integer userId){
		UserInfo field=userService.selectByPrimaryKey(userId);
		field.setRoleId(3);
		field.setUpdateTime(new Date());
		userService.updateSelective(field);
		return true;		
	}
	
	@Autowired
	private IUserInfoService userService;
	@Autowired
	private ISysRolesService rolesService;
	
	
}
