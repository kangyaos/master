package com.sxhalo.lmb.service;


import java.util.List;

import com.sxhalo.lmb.domain.DiscoverView;


public interface IDiscoverViewService extends IBaseService<DiscoverView> {
	public List<DiscoverView> findPagerList(Integer start, Integer length, String where, String order,String lag);
}
