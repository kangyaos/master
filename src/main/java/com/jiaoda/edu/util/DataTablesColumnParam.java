package com.jiaoda.edu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataTablesColumnParam {
	private Integer draw;
	private Integer start;
	private Integer length;
	private String searchValue;
	private Boolean searchRegex;

	private List<DataTablesColumn> columns;

	private List<DataTablesOrder> orders;

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

	public List<DataTablesOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<DataTablesOrder> orders) {
		this.orders = orders;
	}

	public String getOrderBy() {
		String order = "";
		for (int i = 0; i < orders.size(); i++) {
			DataTablesOrder or = orders.get(i);
			DataTablesColumn col = columns.get(or.getCol());
			if (col != null && col.getOrderable() && !"".equals(col.getData())) {
				order = order + "," + col.getData() + " " + or.getDir();
			}
		}
		return order.length() > 0 ? order.substring(1) : "";
	}

	public String getDefaultFilter() {

		String filterColumn = "";
		for (int i = 0; i < columns.size(); i++) {
			DataTablesColumn col = columns.get(i);
			if (col.getSearchable() && !"".equals(col.getSearchValue())) {
				if (col.getSearchRegex()) {
					// 正则表达式验证（错误写法）
					filterColumn += " and " + col.getName() + " = '"
							+ col.getSearchValue() + "'";
				} else {
					filterColumn += " and " + col.getName() + " like '"
							+ col.getSearchValue() + "%'";
				}
			}
		}
		if (!"".equals(filterColumn))
			filterColumn = filterColumn.substring(4);

		String filterGlobal = "";
		if (!"".equals(searchValue)) {
			for (int i = 0; i < columns.size(); i++) {
				DataTablesColumn col = columns.get(i);
				if (col.getSearchable()) {
					String colName = col.getData();
					if (colName.toLowerCase().contains("time")
							|| colName.toLowerCase().contains("date")
							|| colName.toLowerCase().contains("birthday")) {
						if (isValidDate(searchValue)) {
							filterGlobal += " or " + col.getName() + " like '"
									+ searchValue + "%'";
						}
					} else {
						filterGlobal += " or " + col.getName() + " like '"
								+ searchValue + "%'";
					}
				}
			}
			if (!"".equals(filterGlobal))
			filterGlobal = filterGlobal.substring(3);
		}

		String filter = "";
		if (!"".equals(filterColumn) && !"".equals(filterGlobal)) {
			filter = filterColumn + " and (" + filterGlobal + ")";
		} else {
			filter = filterColumn + filterGlobal;
		}
		return filter;
	}

	private boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (str.length() < 17) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		}
		if (str.length() < 11) {
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
		if (str.length() < 11) {
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
		if (str.length() < 8) {
			format = new SimpleDateFormat("yyyy-MM");
		}
		if (str.length() < 5) {
			format = new SimpleDateFormat("yyyy");
		}
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}
	
	public class DataTablesColumn {

		private String data;
		private String name;
		private Boolean searchable;
		private Boolean orderable;
		private String searchValue;
		private Boolean searchRegex;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Boolean getSearchable() {
			return searchable;
		}

		public void setSearchable(Boolean searchable) {
			this.searchable = searchable;
		}

		public Boolean getOrderable() {
			return orderable;
		}

		public void setOrderable(Boolean orderable) {
			this.orderable = orderable;
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
	}
	
	public class DataTablesOrder {
		
		private Integer col;
		private String dir;
		
		public Integer getCol() {
			return col;
		}
		public void setCol(Integer col) {
			this.col = col;
		}
		public String getDir() {
			return dir;
		}
		public void setDir(String dir) {
			this.dir = dir;
		}
	}
}
