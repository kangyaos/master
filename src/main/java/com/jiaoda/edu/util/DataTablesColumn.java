package com.jiaoda.edu.util;

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
