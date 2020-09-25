package com.jiaoda.edu.controller.admin.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.domain.SysModules;
import com.jiaoda.edu.domain.SysRoleModules;
import com.jiaoda.edu.domain.SysRoleModulesKey;
import com.jiaoda.edu.service.ISysModulesService;
import com.jiaoda.edu.service.ISysRoleModulesService;


@Controller
public class SysRoleModulesController {

	@Autowired
	private ISysRoleModulesService roleModuleService;
	@Autowired
	private ISysModulesService modulesService;

	/** 角色分配平台模块 **/
	@RequestMapping(value = "/roleseto.html", method = RequestMethod.GET)
	public String roleSetModules(Integer roleId, Integer appId, ModelMap model) {
		model.put("roleId", roleId);
		model.put("appId", appId);
		return "sys/roleseto";
	}
	
	/** 角色分配App模块 **/
	@RequestMapping(value = "/rolesetm.html", method = RequestMethod.GET)
	public String roleSetAppModules(Integer roleId, Integer appId, ModelMap model) {
		model.put("roleId", roleId);
		model.put("appId", appId);
		List<SysModules> left = modulesService.findPagerList(0, -1, "appId="+appId, "moduleSort asc");
		List<SysRoleModules> roleModule = roleModuleService.findPagerList(0, -1, "id.roleId="+roleId, "moduleSort asc");
		List<SysModules> right = new ArrayList<SysModules>();
		for (SysRoleModules sysRole : roleModule) {
			SysModules o = modulesService.selectByPrimaryKey(sysRole.getModuleId());
			if(o!=null && o.getAppId()==appId){
				right.add(o);
			}
			if(left.contains(o)){
				left.remove(o);
			}
		}
		model.put("left", left);
		model.put("right", right);
		return "sys/rolesetm";
	}
	
	@RequestMapping(value = "/saveroleseto.do", method = RequestMethod.POST)
	public String saveRoleModules(Integer appId, Integer roleId, String modules, ModelMap model) {
		//删除角色已分配权限
		deleteRoleModule(appId, roleId);
		//插入已分配权限
		if (modules.length() > 0) {
			String[] lidt = modules.split(",");
			for (int i = 0; i < lidt.length; i++) {
				SysRoleModules rolemodule = new SysRoleModules();
				rolemodule.setRoleId(roleId);
				rolemodule.setModuleId(Integer.parseInt(lidt[i]));
				rolemodule.setModuleSort(i+1);
				roleModuleService.insertSelective(rolemodule);
			}
		}
		return "redirect:/rolelist.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/rolemodules.json")
	public List<Map<String, Object>> getRoleModules(Integer roleId, Integer appId) {
		List<SysModules> all = modulesService.findPagerList(0, -1, "appId="+appId, "moduleSort asc");
		List<SysRoleModules> roleModule = roleModuleService.findWhereList("id.roleId="+roleId, "");
		List<Map<String, Object>> list = getTreeData(0, all);
		setSelected(list, roleModule);
		return list;
	}

	private void setSelected(List<Map<String, Object>> list, List<SysRoleModules> roleModule){
		for (Map<String, Object> map : list) {
			if(map.containsKey("children")){
				List<Map<String, Object>> child = (List)map.get("children");
				setSelected(child,roleModule);
			}else{
				for (SysRoleModules t1RoleModule : roleModule) {
					String modid = t1RoleModule.getModuleId().toString();
					String nodeid = map.get("id").toString();
					if(modid.equals(nodeid)){
						Map<String, Object> state = (Map<String, Object>)map.get("state");
						state.put("selected", true);
					}
				}
			}
		}
	}
	
	private List<Map<String, Object>> getTreeData(Integer parentId, List<SysModules> list) {
		List<Map<String, Object>> tree = new ArrayList<Map<String, Object>>();
		for (SysModules mod : list) {
			if (parentId.equals(mod.getModuleParent())) {
				Map<String, Object> node = new HashMap<String, Object>();
				Map<String, Object> state = new HashMap<String, Object>();
				node.put("id", mod.getModuleId());
				node.put("text", mod.getModuleName().replace("<br/>", "").trim());
				node.put("state", state);
				List<Map<String, Object>> child = getTreeData(mod.getModuleId(), list);
				if (child.size() > 0) {
					state.put("opened", true);
					node.put("children", child);
				}
				tree.add(node);
			}
		}
		return tree;
	}
	
	private void deleteRoleModule(Integer appId, Integer roleId) {
		List<SysRoleModules> list = roleModuleService.findWhereList("id.roleId="+roleId, "");
		for (SysRoleModules roleModules : list) {
			SysModules mod = modulesService.selectByPrimaryKey(roleModules.getModuleId());
			if(mod.getAppId()==appId){
				//roleModuleService.delete(roleModules);
			}
		}
	}
	
}
