package com.jiaoda.edu.controller.admin.sys;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import com.jiaoda.edu.domain.SysModules;
import com.jiaoda.edu.service.ISysModulesService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;



@Controller
public class SysModulesController {
	
	@Autowired
	private ISysModulesService modulesService;
	
	/**
	 * 模块管理
	 */
	@RequestMapping(value = "/modulelist.html", method = RequestMethod.GET)
	public String moduleList(ModelMap model) {
		return "sys/modulelist";
	}
	
	@RequestMapping(value = "/appmodulelist.html", method = RequestMethod.GET)
	public String appmodulelist(ModelMap model) {
		return "sys/appmodulelist";
	}
	
	@RequestMapping(value = "/addmodule.html", method = RequestMethod.GET)
	public String addModule(ModelMap model,Integer parentId) {
		model.put("module", new SysModules());
		model.put("appId", parentId);
		model.put("mlist", modulesService.findPagerList(0, -1, "appId="+parentId, "moduleSort asc"));
		return "sys/moduleform";
	}
	
	@RequestMapping(value = "/addappmodule.html", method = RequestMethod.GET)
	public String addappmodule(ModelMap model,Integer parentId) {
		model.put("module", new SysModules());
		return "sys/appmoduleform";
	}

	@RequestMapping(value = "/editmodule.html", method = RequestMethod.GET)
	public String editModule(Integer moduleId,Integer appId, ModelMap model) {
		SysModules module = modulesService.selectByPrimaryKey(moduleId);
		module = module != null ? module : new SysModules();
		model.put("module", module);
		model.put("appId", appId);
		model.put("mlist", modulesService.findPagerList(0, -1, "appId="+appId, "moduleSort asc"));
		return "sys/moduleform";
	}
	
	@RequestMapping(value = "/editappmodule.html", method = RequestMethod.GET)
	public String editappmodule(Integer moduleId, ModelMap model) {
		SysModules module = modulesService.selectByPrimaryKey(moduleId);
		module = module != null ? module : new SysModules();
		model.put("module", module);
		return "sys/appmoduleform";
	}

	@RequestMapping(value = "/savemodule.do", method = RequestMethod.POST)
	public String saveModule(SysModules module,Integer appId) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		if (module.getModuleId() == null) {
			module.setCreateTime(nowTime);
			module.setUpdateTime(nowTime);
			module.setAppId(appId);
			module.setDeleteFlag(0);
			modulesService.insertSelective(module);
		} else {
			SysModules entity = modulesService.selectByPrimaryKey(module.getModuleId());
			entity.setAppId(appId);
			entity.setModuleName(module.getModuleName());
			entity.setModuleCode(module.getModuleCode());
			entity.setModulePath(module.getModulePath());
			entity.setModuleClass(module.getModuleClass());
			entity.setModuleDescription(module.getModuleDescription());
			entity.setModuleSort(module.getModuleSort());
			entity.setModuleParent(module.getModuleParent());
			entity.setModuleIsdisable(module.getModuleIsdisable());
			modulesService.updateByPrimaryKeySelective(entity);
		}
		if(module.getAppId()==1||module.getAppId()==4){
			return "redirect:/modulelist.html";
		}else{
			return "redirect:/appmodulelist.html";
		}
		
	}

	
	@ResponseBody
	@RequestMapping(value = "/modulelist.json", method = RequestMethod.POST)
	public PageData<SysModules> getModuleList(Integer appId, Integer draw,Integer mId,
			Integer start, Integer length, HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<SysModules> pageData = new PageData<SysModules>();
		String where = param.getDefaultFilter();
		String parent = mId==null?"":" and ( moduleId=" + mId +" or moduleParent ="+mId+" )";
		if ("".equals(where)) {
			where = "appId=" + (appId == null ? 1 : appId)+parent;
		} else {
			where = "(" + where + ") and appId=" + (appId == null ? 1 : appId)+parent;
		}
		int count = modulesService.getCount(where);
		List<SysModules> data = modulesService.findPagerList(start, length, where, "moduleSort asc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modules.json")
	public List<Map<String, Object>> getModules(Integer appId) {
		appId = (appId == null ? 1 : appId);
		return getTreeData(modulesService.findPagerList(0, -1, "appId="+appId+" and moduleParent=0", ""));
	}

	private List<Map<String, Object>> getTreeData(List<SysModules> list) {

		Collections.sort(list,new Comparator<SysModules>(){
			public int compare(SysModules arg0, SysModules arg1){
				return arg0.getModuleSort().compareTo(arg1.getModuleSort());
			}
		});

		List<Map<String, Object>> tree = new ArrayList<Map<String, Object>>();
		for (SysModules mod : list) {
			Map<String, Object> node = new HashMap<String, Object>();
			Map<String, Object> state = new HashMap<String, Object>();
			node.put("id", mod.getModuleId());
			node.put("text", mod.getModuleName().replace("<br/>", "").trim());
			node.put("state", state);
			List<Map<String, Object>> child = getTreeData(modulesService.findWhereList("moduleParent="+mod.getModuleId(),""));
			if (child.size() > 0) {
				state.put("opened", true);
				node.put("children", child);
			}
			tree.add(node);
		}
		return tree;
	}
	
	@RequestMapping(value = "/modulelistcha.do", method = RequestMethod.POST)
	public String getmodulelistcha(Integer id, Integer parent, Integer position,
			HttpServletRequest request) {
		SysModules module=modulesService.selectByPrimaryKey(id);
		int i=0;
		int j=position+1;
		if(module.getModuleParent()==parent) {
	    	List<SysModules> l=modulesService.findWhereList("moduleParent="+parent,"" );
	    	for(SysModules m:l){
	    		if(m.getModuleId()!=id)i++;
	    		if(position>=module.getModuleSort()&&m.getModuleSort()>module.getModuleSort()&&
	    				m.getModuleSort()<=(position+1)&&m.getModuleId()!=id) {
	    			     m.setModuleSort(i);
	    			    modulesService.updateByPrimaryKeySelective(m);
	    			
	    		}
	    		if(position+1<module.getModuleSort()&&m.getModuleSort()<module.getModuleSort()&&
	    				m.getModuleSort()>position&&m.getModuleId()!=id) {
	    			    j++;
	    			    m.setModuleSort(j);
	    			    modulesService.updateByPrimaryKeySelective(m);
	    		}
	    	}
	     } else{
	    	List<SysModules> o=modulesService.findWhereList("moduleParent="+ module.getModuleParent(),"" );
	    	List<SysModules> n=modulesService.findWhereList("moduleParent="+parent,"" );
	        for(SysModules m:o){
	        	if(m.getModuleId()!=id)i++;
	        	if(m.getModuleSort()>module.getModuleSort()){
	        		 m.setModuleSort(i);
	    			    modulesService.updateByPrimaryKeySelective(m);
	        	}
	        }
	        for(SysModules m:n){
	        	if(m.getModuleSort()>position&&m.getModuleId()!=id) {
	        		 j++;
	        		 m.setModuleSort(j);
	    			    modulesService.updateByPrimaryKeySelective(m);
	        	}
	        }
	    }
		module.setModuleParent(parent);
		module.setModuleSort(position+1);
	    modulesService.updateByPrimaryKeySelective(module);
		return "redirect:/modules.json";
	}
}
