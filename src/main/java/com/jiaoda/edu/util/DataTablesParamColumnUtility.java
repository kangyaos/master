package com.jiaoda.edu.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.jiaoda.edu.util.DataTablesColumnParam.DataTablesColumn;
import com.jiaoda.edu.util.DataTablesColumnParam.DataTablesOrder;

public class DataTablesParamColumnUtility {

	public static DataTablesColumnParam getParam(HttpServletRequest request) {

		DataTablesColumnParam param = new DataTablesColumnParam();
		
		List<DataTablesColumn> columns = new ArrayList<DataTablesColumn>();
		List<DataTablesOrder> orders = new ArrayList<DataTablesOrder>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (paramName.startsWith("columns")) {
				int begin = paramName.indexOf("[");
				int end = paramName.indexOf("]");
				String index = paramName.substring(begin + 1, end);
				if (columns.size() <= Integer.parseInt(index)) {
					columns.add(param.new DataTablesColumn());
				}
			}
			if (paramName.startsWith("order")) {
				int begin = paramName.indexOf("[");
				int end = paramName.indexOf("]");
				String index = paramName.substring(begin + 1, end);
				if (orders.size() <= Integer.parseInt(index)) {
					orders.add(param.new DataTablesOrder());
				}
			}
		}
		param.setColumns(columns);
		param.setOrders(orders);
		
		Map<String, String[]> paramMap = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
			String paramName = entry.getKey();
			String paramValue = "";
			String[] paramValueArr = entry.getValue();
			for (int i = 0; paramValueArr != null && i < paramValueArr.length; i++) {
				if (i == paramValueArr.length - 1) {
					paramValue += paramValueArr[i];
				} else {
					paramValue += paramValueArr[i] + ",";
				}
			}

			String regEx="[`~!@#$%^&*+=|{}':;',//[//]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
			paramValue = paramValue.replaceAll(regEx, "");

			if (paramName.equals("draw")) {
				param.setDraw(Integer.parseInt(paramValue));
			}
			if (paramName.equals("start")) {
				param.setStart(Integer.parseInt(paramValue));
			}
			if (paramName.equals("length")) {
				param.setLength(Integer.parseInt(paramValue));
			}
			if (paramName.equals("search[value]")) {
				param.setSearchValue(paramValue);
			}
			if (paramName.equals("search[regex]")) {
				param.setSearchRegex(Boolean.valueOf(paramValue));
			}

			for (int i = 0; i < columns.size(); i++) {

				DataTablesColumn col = columns.get(i);

				if (paramName.equals("columns[" + i + "][data]")) {
					col.setData(paramValue);
				}
				if (paramName.equals("columns[" + i + "][name]")) {
					col.setName(paramValue);
				}
				if (paramName.equals("columns[" + i + "][searchable]")) {
					col.setSearchable(Boolean.valueOf(paramValue));
				}
				if (paramName.equals("columns[" + i + "][orderable]")) {
					col.setOrderable(Boolean.valueOf(paramValue));
				}
				if (paramName.equals("columns[" + i + "][search][value]")) {
					col.setSearchValue(paramValue);
				}
				if (paramName.equals("columns[" + i + "][search][regex]")) {
					col.setSearchRegex(Boolean.valueOf(paramValue));
				}
			}
			
			for (int i = 0; i < orders.size(); i++) {
				DataTablesOrder order = orders.get(i);
				if (paramName.equals("order[" + i + "][column]")) {
					order.setCol(Integer.parseInt(paramValue));
				}
				if (paramName.equals("order[" + i + "][dir]")) {
					order.setDir(paramValue);
				}
			}
		}

		return param;
	}

}
