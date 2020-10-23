package com.jiaoda.edu.controller.admin.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoda.edu.domain.LogOperation;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.service.ILogOperationService;
import com.jiaoda.edu.util.DataTablesParam;
import com.jiaoda.edu.util.DataTablesParamUtility;
import com.jiaoda.edu.util.PageData;



@Controller
@RequestMapping("/admin")
public class LogOperationController {
	/**
	 * 操作日志
	 */
	@Autowired
	private ILogOperationService operationService;
	
	@RequestMapping(value = "/logbilloperationlist.html", method = RequestMethod.GET)
	public String logList(ModelMap model) {
		model.put("size",operationService.findPagerList(0, 5, "", "").size());
		return "view/admin/sys/logoperationlist";
	}
	
	@RequestMapping(value = "/logoperation.html", method = RequestMethod.GET)
	public String logoperation(String logId,ModelMap map) {
		map.put("operation", operationService.selectByPrimaryKey(logId));
		return "view/admin/sys/logoperationdetail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/logoperationlist.json", method = RequestMethod.POST)
	public PageData<LogOperation> getLogList(Integer draw, Integer start, Integer length,
			String stime,String totime,HttpServletRequest request) {
		DataTablesParam param = DataTablesParamUtility.getParam(request);
		PageData<LogOperation> pageData = new PageData<LogOperation>();
		String  where =param.getDefaultFilter();
		String sql ="";
		if("".equals(stime)&&!"".equals(totime)){
			sql = " create_time <= '"+totime+"%'";
		}else if(!"".equals(stime)&&"".equals(totime)){
			sql = " create_time >= '"+stime+"%'";
		}else if(!"".equals(stime)&&!"".equals(totime)){
			sql = " create_time >= '"+stime+"%' and create_time <= '"+totime+"%'";
		}			
		if(where.equals("")){
			where = sql.equals("")?"":" and "+sql;			
		}else{
			sql = sql.equals("")?"":" and "+ sql;
			where ="("+where+") "+ sql;
		}
		Integer count = operationService.getCount(where);
		List<LogOperation> data = operationService.findPagerList(start, length, where, "create_time desc");
		pageData.setDraw(draw);
		pageData.setRecordsTotal(count);
		pageData.setRecordsFiltered(count);
		pageData.setData(data);
		return pageData;
	}
	
	/**
	 * 删除任意个
	 * @param id的list
	 * @return true 成功   false
	 */
	@ResponseBody
	@RequestMapping(value = "/delanyoneoperation.do", method = RequestMethod.POST)
	public boolean delbatchall(@RequestParam(value = "ids") Long[] ids){
		for(Long id :ids){
			operationService.deleteByPrimaryKey(id);
			
		}
		return  true;
	}
	/**
	 * 按钮删除
	 * @param method 1 删除30天前,2 保留最近100条, 3 清空
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dellogoperation.do", method = RequestMethod.POST)
	public boolean delall(Integer method){
		operationService.delLog(method);
		return true;
	}

}
