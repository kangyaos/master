package com.jiaoda.edu.controller.admin.sys;

import java.sql.Timestamp;
import java.util.List;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.domain.SysRole;
import com.jiaoda.edu.domain.SysSettings;
import com.jiaoda.edu.service.ISysRolesService;
import com.jiaoda.edu.service.ISysSettingService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;


@Controller
@RequestMapping("/admin")
public class SysSettingController {
	@Autowired
	private ISysSettingService setService;
	
	/**
     * 角色管理
     */
	@RequestMapping(value = "/settinglist.html", method = RequestMethod.GET)
	public String Setting(ModelMap model) {
		return "view/admin/sys/settinglist";
	}

	@RequestMapping(value = "/addsetting.html", method = RequestMethod.GET)
	public String addRole(ModelMap model) {
		model.put("settings", new SysSettings());
		return "view/admin/sys/settingform";
	}

	@RequestMapping(value = "/editsetting.html", method = RequestMethod.GET)
	public String editRole(Integer roleId, ModelMap model) {
		SysSettings role = setService.selectByPrimaryKey(roleId);
		role = role != null ? role : new SysSettings();
		model.put("settings", role);
		model.put("edit", "edit");
		return "view/admin/sys/settingform";
	}
	
	@RequestMapping(value = "/savesetting.do", method = RequestMethod.POST)
	public String saveRole(SysSettings set) {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		SysSettings entity = setService.selectByPrimaryKey(set.getKeycode());
		if(entity==null){
			set.setCreateTime(date);
			set.setUpdateTime(date);
			setService.insertSelective(set);	
		}else{
			entity.setRemark(set.getRemark());
			entity.setValue(set.getValue());
			entity.setUpdateTime(date);
			setService.updateByPrimaryKeySelective(entity);
			
		}
	
		return "redirect:/admin/settinglist.html";
	}

	@ResponseBody
	@RequestMapping(value = "/settinglist.json", method = RequestMethod.POST)
	public PageData<SysSettings> getsettingList(Integer draw, Integer start, Integer length,
			HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<SysSettings> pageData = new PageData<SysSettings>();
		String where= param.getDefaultFilter();
		List<SysSettings> data = setService.findPagerList(start, length, where, "");
		Integer count=setService.getCount(where);
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	/**
	 * 验证是否已经存在编码
	 */
	@ResponseBody
	@RequestMapping(value = "/validCode.json", method = RequestMethod.POST)
	public Boolean validCode(String keycode,String key) {
		SysSettings settings = setService.findWhere(" keycode= '"+keycode.trim()+"'","");
		if (settings == null) {
			return true;
		} else {
			if("".equals(key)){
				return false;
			}else{
				return true;
			}
		}
	}
}
