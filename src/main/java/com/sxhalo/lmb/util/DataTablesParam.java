package com.sxhalo.lmb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataTablesParam {
	private Integer draw;
	private Integer start;
	private Integer length;
	private String searchValue;
	private Boolean searchRegex;
	private Integer orderColumn;
	private String orderDir;

	private List<DataTablesColumn> columns;

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public Boolean getSearchRegex() {
		return searchRegex;
	}

	public void setSearchRegex(Boolean searchRegex) {
		this.searchRegex = searchRegex;
	}

	public List<DataTablesColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<DataTablesColumn> columns) {
		this.columns = columns;
	}

	public Integer getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(Integer orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	public String getDefaultFilter() {

		String filterColumn = "";
		for (int i = 0; i < columns.size(); i++) {
			DataTablesColumn col = columns.get(i);
			if(col.getSearchable() && !"".equals(col.getSearchValue())){
				if(col.getSearchRegex()){
					//正则表达式验证（错误写法）
					if(col.getSearchValue().contains("between")) {
						String value = col.getSearchValue().replace("between", "");
						value = value.split("and")[0].trim() + "' and '" + value.split("and")[1].trim();
						filterColumn += " and " + col.getData() + " between '" + value + "'";
					}else {
						filterColumn += " and " + col.getData() + " = '" + col.getSearchValue() + "'";
					}
				}else{
					filterColumn += " and " + col.getData() + " like '%" + col.getSearchValue() + "%'";
				}
			}
		}
		if(!"".equals(filterColumn)) filterColumn = filterColumn.substring(4);
		
		String filterGlobal = "";
		if (!"".equals(searchValue)) {
			for (int i = 0; i < columns.size(); i++) {
				DataTablesColumn col = columns.get(i);
				if(col.getSearchable()){
					String colName = col.getData();
					if(colName.toLowerCase().contains("time")
						||colName.toLowerCase().contains("date")
						||colName.toLowerCase().contains("birthday")){
						if(isValidDate(searchValue)){
							filterGlobal += " or " + col.getData() + " like '%" + searchValue + "%'";
						}
					}else{
						filterGlobal += " or " + col.getData() + " like '%" + searchValue + "%'";
					}
				}
			}
			filterGlobal = filterGlobal.substring(3);
		}
		
		String filter = "";
		if (!"".equals(filterColumn) && !"".equals(filterGlobal)) {
			filter = filterColumn + " and (" + filterGlobal + ")";
		} else {
			filter = filterColumn + filterGlobal;
		}
		return camelToUnderline(filter);
	}
	
	private boolean isValidDate(String str) {
		boolean convertSuccess=true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(str.length()<17){
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		}
		if(str.length()<11){
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
		if(str.length()<11){
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
		if(str.length()<8){
			format = new SimpleDateFormat("yyyy-MM");
		}
		if(str.length()<5){
			format = new SimpleDateFormat("yyyy");
		}
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess=false;
		} 
		return convertSuccess;
	}
	
	//驼峰转下划线
	private String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
            }
           sb.append(Character.toLowerCase(c));  //统一都转小写
        }
        return sb.toString();
    }
}
