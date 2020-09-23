package com.sxhalo.lmb.service;


import com.sxhalo.lmb.domain.CoalSales;


public interface ICoalSalesService extends IBaseService<CoalSales> {
	public int getPackageNum(Long coalSalesId);
}
