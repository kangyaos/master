package com.jiaoda.edu.controller.admin.user;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.SysRole;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.domain.UserLearnRecord;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.service.ISysRolesService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.service.IUserLearnRecordService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;
import com.jiaoda.edu.util.PasswordEncoder;
import com.jiaoda.edu.util.ExcelUtils;

@Controller
@RequestMapping("/admin")
public class UserLeanController {

   
	
    
	@RequestMapping(value = "/userleanlist.html", method = RequestMethod.GET)
	public String userinfoList(Integer courseId,ModelMap model,HttpServletRequest request) {
		model.put("courseId", courseId);
		return "view/admin/user/userleanlist";
	}



	
	
	@ResponseBody
	@RequestMapping(value = "/userleanlist.json", method = RequestMethod.POST)
	public PageData<UserLearnRecord> getRoleList(Integer courseId,Integer draw, Integer start, Integer length,
			HttpServletRequest request) {
  		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<UserLearnRecord> pageData = new PageData<UserLearnRecord>();
		String where =param.getDefaultFilter();	
		if("".equals(where)){
			where = courseId!=null?"  a.course_id="+courseId:"";
		}else if(!"".equals(where)){
			where = "(" +where+")  "+(courseId!=null?" and a.course_id="+courseId:"");
			
		}
		Integer count = leanrecordService.getCount(where);
		List<UserLearnRecord> data = leanrecordService.findPagerList(start, length, where, "create_time desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	
	
	@Autowired
	private IUserInfoService userinfosService;
	@Autowired
	private IUserLearnRecordService leanrecordService;
	
	
}
