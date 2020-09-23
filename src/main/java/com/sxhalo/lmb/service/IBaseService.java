package com.sxhalo.lmb.service;

import java.util.List;

public interface IBaseService<T> {
	/**
	 * 新增对象.
	 */
	public Integer insertSelective(T record);

	/**
	 * 修改对象.
	 */
	public Integer updateByPrimaryKeySelective(T record);

	/**
	 * 删除对象.
	 */
	public Integer deleteByPrimaryKey(Object key);

	/**
	 * 按id获取对象.
	 */
	public T selectByPrimaryKey(Object key);
	
	/**
	 * 按条件查找对象列表.
	 */
	public List<T> findWhereList(String where, String order);

	/**
	 * 按条件查找对象列表.
	 */
	public Integer getCount(String where);
	
	/**
	 * 分页查询.
	 */
	public List<T> findPagerList(Integer start, Integer length, String where, String order);

}
