package com.jiaoda.edu.controller.admin.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.domain.SysRole;
import com.jiaoda.edu.service.ISysRolesService;



@Controller
public class SysRoleController {
	
	@Autowired
	private ISysRolesService rolesService;
	
	/**
     * 角色管理
     */
	@RequestMapping(value = "/rolelist.html", method = RequestMethod.GET)
	public String roleList(ModelMap model) {
		return "sys/rolelist";
	}
//
//	@RequestMapping(value = "/addrole.html", method = RequestMethod.GET)
//	public String addRole(ModelMap model) {
//		model.put("role", new SysRole());
//		return "sys/roleform";
//	}
//
//	@RequestMapping(value = "/editrole.html", method = RequestMethod.GET)
//	public String editRole(Integer roleId, ModelMap model) {
//		SysRole role = rolesService.findById(roleId);
//		role = role != null ? role : new SysRole();
//		model.put("role", role);
//		model.put("edit", "edit");
//		return "sys/roleform";
//	}
//
//	@RequestMapping(value = "/saverole.do", method = RequestMethod.POST)
//	public String saveRole(SysRole role) {
//		List<SysRole> list = rolesService.findAll();
//		Integer level = role.getRoleLevel() >= list.size() ? list.size()-1: role.getRoleLevel();
//		level = level < 0 ? 0 : level;		
//		SysRole entity = rolesService.findById(role.getRoleId());
//		entity = entity==null? new SysRole() : entity;
//		entity.setRoleId(role.getRoleId());
//		entity.setRoleName(role.getRoleName());
//		entity.setRoleDescription(role.getRoleDescription());
//		entity.setRoleIsdisable(role.getRoleIsdisable());
//		entity.setRoleLevel(level);
//		rolesService.update(entity);			
//		SysRole roles = rolesService.find("roleName", "系统管理员");
//		roles.setRoleLevel(list.size());
//		rolesService.update(roles);
//		return "redirect:/rolelist.html";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/rolelist.json", method = RequestMethod.POST)
//	public PageData<SysRole> getRoleList(Integer draw, Integer start, Integer length,
//			HttpServletRequest request) {
//		DataTablesParam param = DataTablesParamUtility.getParam(request);
//		PageData<SysRole> pageData = new PageData<SysRole>();
//		List<SysRole> all = rolesService.findAll();
//		List<SysRole> data = rolesService.findPagerList(start, length, param.getDefaultFilter(), "roleLevel desc");
//		pageData.setDraw(draw);
//		pageData.setRecordsTotal(all.size());
//		pageData.setRecordsFiltered(all.size());
//		pageData.setData(data);
//		return pageData;
//	}
//	
//	/*
//	 * 修改用户级别，级别最高为角色数量
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/getRoleSort.do", method = RequestMethod.POST)
//	public Boolean getRoleSort(Integer sort,Integer roleId,HttpServletRequest request) {
//		List<SysRole> list = rolesService.findAll();
//		sort = sort >= list.size() ? list.size()-1: sort;
//		sort = sort < 0 ? 0 : sort;
//		SysRole entity = rolesService.findById(roleId);
//		entity.setRoleLevel(sort);
//		rolesService.update(entity);
//		return true;
//	}
//	
//	
//	/**
//	 * 验证角色名
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/validRoleName.json", method = RequestMethod.POST)
//	public Boolean validRoleName(Long roleId, String roleName,String edit) {
//		SysRole roles = rolesService.find("roleName", roleName);
//		SysRole roles2 = rolesService.findById(roleId);
//		if (roles == null&& roles2 == null) {
//			return true;
//		} else if(edit==""){
//			if(roles!=null&&roles.getRoleId()== roleId) return true;
//		}else{
//			if(roles == null||roleName.equals(roles2.getRoleName())) return true;
//		}
//		return false;
//	}
}
