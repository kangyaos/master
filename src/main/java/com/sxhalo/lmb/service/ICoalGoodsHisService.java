package com.sxhalo.lmb.service;

import java.util.List;
import java.util.Map;

import com.sxhalo.lmb.domain.CoalGoodsHis;

public interface ICoalGoodsHisService extends IBaseService<CoalGoodsHis> {
	public List<Map<String,Object>> getChartData(String goodsId, String day);
}
