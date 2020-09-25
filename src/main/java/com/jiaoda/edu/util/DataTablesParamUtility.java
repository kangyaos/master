package com.jiaoda.edu.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class DataTablesParamUtility {

	public static DataTablesParam getParam(HttpServletRequest request) {

		DataTablesParam param = new DataTablesParam();
		
		List<DataTablesColumn> columns = new ArrayList<DataTablesColumn>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (paramName.contains("columns")) {
				int begin = paramName.indexOf("[");
				int end = paramName.indexOf("]");
				String index = paramName.substring(begin + 1, end);
				if (columns.size() <= Integer.parseInt(index)) {
					columns.add(new DataTablesColumn());
				}
			}
		}
		param.setColumns(columns);
		
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

			String regEx="[`~!@#$%^&*()+=|{}';',?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			paramValue = paramValue.replaceAll(regEx, "").trim();

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
			if (paramName.equals("order[0][column]")) {
				param.setOrderColumn(Integer.parseInt(paramValue));
			}
			if (paramName.equals("order[0][dir]")) {
				param.setOrderDir(paramValue);
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
		}

		return param;
	}

}
