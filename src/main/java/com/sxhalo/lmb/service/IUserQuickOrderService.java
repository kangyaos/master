package com.sxhalo.lmb.service;


import com.sxhalo.lmb.domain.UserQuickOrder;


public interface IUserQuickOrderService extends IBaseService<UserQuickOrder> {
	
	public UserQuickOrder selectDetailByPrimaryKey(String orderNumber);
}
