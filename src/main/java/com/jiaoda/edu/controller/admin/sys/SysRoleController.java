package com.jiaoda.edu.controller.admin.sys;

import java.sql.Timestamp;
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
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;



@Controller
@RequestMapping("/admin")
public class SysRoleController {
	
	@Autowired
	private ISysRolesService rolesService;
	
	/**
     * 角色管理
     */
	@RequestMapping(value = "/rolelist.html", method = RequestMethod.GET)
	public String roleList(ModelMap model) {
		return "view/admin/sys/rolelist";
	}

	@RequestMapping(value = "/addrole.html", method = RequestMethod.GET)
	public String addRole(ModelMap model) {
		model.put("role", new SysRole());
		return "view/admin/sys/roleform";
	}

	@RequestMapping(value = "/editrole.html", method = RequestMethod.GET)
	public String editRole(Integer roleId, ModelMap model) {
		SysRole role = rolesService.selectByPrimaryKey(roleId);
		role = role != null ? role : new SysRole();
		model.put("role", role);
		model.put("edit", "edit");
		return "view/admin/sys/roleform";
	}

	@RequestMapping(value = "/saverole.do", method = RequestMethod.POST)
	public String saveRole(SysRole role) {
		Timestamp date = new Timestamp(System.currentTimeMillis());

		if(role.getRoleId()==null){
			role.setCreateTime(date);
			role.setUpdateTime(date);
			rolesService.insertSelective(role);	
		}else{
			SysRole entity = rolesService.selectByPrimaryKey(role.getRoleId());
			entity.setRoleName(role.getRoleName());
			entity.setRemark(role.getRemark());
			entity.setStatus(role.getStatus());
			entity.setUpdateTime(date);
			rolesService.updateByPrimaryKeySelective(entity);
			
		}
	
		return "redirect:/admin/rolelist.html";
	}

	@ResponseBody
	@RequestMapping(value = "/rolelist.json", method = RequestMethod.POST)
	public PageData<SysRole> getRoleList(Integer draw, Integer start, Integer length,
			HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<SysRole> pageData = new PageData<SysRole>();
		String where= param.getDefaultFilter();
		List<SysRole> data = rolesService.findPagerList(start, length, where, "role_sort asc");
		Integer count=rolesService.getCount(where);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
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
	/**
	 * 验证角色名
	 */
	@ResponseBody
	@RequestMapping(value = "/validRoleName.json", method = RequestMethod.POST)
	public Boolean validRoleName(Integer roleId, String roleName,String edit) {
		SysRole roles = rolesService.findWhere("role_name='"+roleName+"'", "");
		
		if (roles == null&& roleId == null) {
			return true;
		} else if(edit==""){
			if(roles!=null&&roles.getRoleId()== roleId) return true;
		}else{
			SysRole roles2 = rolesService.selectByPrimaryKey(roleId);
			if(roles == null||roleName.equals(roles2.getRoleName())) return true;
		}
		return false;
	}
}
