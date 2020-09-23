package com.sxhalo.lmb.service;

import java.util.List;
import java.util.Map;

import com.sxhalo.lmb.domain.CoalGoods;

public interface ICoalGoodsService extends IBaseService<CoalGoods> {

	public void batchinsert(Integer userId,Integer coalSalesId,List<Map<String,Object>> list); 
}
