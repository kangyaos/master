package com.sxhalo.manage.controller.user;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxhalo.manage.dao.UserInfo;
import com.sxhalo.manage.service.IUserInfoService;
import com.sxhalo.manage.utils.DataTablesParam;
import com.sxhalo.manage.utils.DataTablesParamUtility;
import com.sxhalo.manage.utils.PageData;
import com.sxhalo.manage.utils.PasswordEncoder;

@Controller
@RequestMapping("/backend")
public class UserInfoController {
	/**
     * 角色管理
     */
	@RequestMapping(value = "/userlist.html", method = RequestMethod.GET)
	public String userinfoList(ModelMap model,HttpServletRequest request) {
		return "admin/user/userinfolist";
	}

	@RequestMapping(value = "/adduser.html", method = RequestMethod.GET)
	public String adduserinfo(ModelMap model,HttpServletRequest request) {
		String userName=request.getSession().getAttribute("userName").toString();
		UserInfo user = userinfosService.find("userName", userName);
		
        model.put("roles", null);
		model.put("user", new UserInfo());
		return "admin/user/userinfoform";
	}

	@RequestMapping(value = "/edituser.html", method = RequestMethod.GET)
	public String edituserinfo(Integer userId, ModelMap model,HttpServletRequest request) {
		UserInfo user = userinfosService.find("userId", userId);
		user = user != null ? user : new UserInfo();
		
        model.put("roles", null);
		model.put("user", user);	
		return "admin/user/userinfoform";
	}

	@RequestMapping(value = "/saveuser.do", method = RequestMethod.POST)
	public String saveRole(UserInfo user) {
		if (user.getUserId()==null) {
			user.setUserPwd(PasswordEncoder.MD5(user.getUserPwd()));
			user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			user.setCreateTime(new Timestamp(System.currentTimeMillis()));
			user.setDeleteFlag(0);
			userinfosService.save(user);
			
			userinfosService.update(user);
		} else {
			UserInfo entity = userinfosService.find("userId", user.getUserId());
			entity.setUserName(user.getUserName());
			entity.setRealName(user.getRealName());
			entity.setUserMobile(user.getUserMobile());
			
			entity.setRoleId(user.getRoleId());
			entity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			userinfosService.update(entity);
		}
		return "redirect:/backend/userlist.html";
	}


	
	
	@ResponseBody
	@RequestMapping(value = "/userlist.json", method = RequestMethod.POST)
	public PageData<UserInfo> getRoleList(Integer draw, Integer start, Integer length,
			HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<UserInfo> pageData = new PageData<UserInfo>();
		String where =param.getDefaultFilter();			
		Integer count = userinfosService.getCount(where);
		List<UserInfo> data = userinfosService.findPagerList(start, length, where, "createTime desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	/**
	 * 验证用户名
	 */
	@ResponseBody
	@RequestMapping(value = "/validUserName.json", method = RequestMethod.POST)
	public Boolean validUserName(String userId, String userName) {
		UserInfo user = userinfosService.find("userName", userName);
		if (user == null) {
			return true;
		} else {
			if (user.getUserId().toString().equals(userId)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 验证新密码
	 */
	@ResponseBody
	@RequestMapping(value = "/checkPass.json", method = RequestMethod.POST)
	public Boolean checkPassWord(String oldPwd, HttpServletRequest request) {
		String userName=request.getSession().getAttribute("userName").toString();
		UserInfo user = userinfosService.find("userName", userName);
		if (user != null) {
			if (user.getUserPwd().equals(PasswordEncoder.MD5(oldPwd))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/modifypwd.html", method = RequestMethod.GET)
	public String modifyPwd(ModelMap model) {
		return "admin/user/modifypwd";
	}
	
	/**
	 * 修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/modifypwd.do", method = RequestMethod.POST)
	public Boolean modifyPwd(String oldPwd, String newPwd, HttpServletRequest request) {
		String userName=request.getSession().getAttribute("userName").toString();
		UserInfo user = userinfosService.find("userName", userName);
		if (user != null) {
			if (user.getUserPwd().equals(PasswordEncoder.MD5(oldPwd))) {
				user.setUserPwd(PasswordEncoder.MD5(newPwd));
				userinfosService.update(user);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * 重置密码
	 */
	@ResponseBody
	@RequestMapping(value = "/passwordreset.do", method = RequestMethod.POST)
	public Boolean passwordreset(Integer userid){
		UserInfo user = userinfosService.find("userId", userid);
		user.setUserPwd(PasswordEncoder.MD5("111111"));
		userinfosService.update(user);
		return true;
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/deluser.do", method = RequestMethod.POST)
	public Boolean deluser(Integer userId){
		UserInfo field=userinfosService.findById(userId);
		field.setDeleteFlag(1);
		userinfosService.update(field);
		return true;		
	}
	
	
	/**
	 * 获取用户基本信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserBasicInfo.do", method = RequestMethod.POST)
	public UserInfo getUserBasicInfo(Integer userId) {
		UserInfo info = userinfosService.find("userId", userId);
		return info;
	}
	
	@Autowired
	private IUserInfoService userinfosService;
	
}
