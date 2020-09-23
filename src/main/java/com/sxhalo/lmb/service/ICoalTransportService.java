package com.sxhalo.lmb.service;


import com.sxhalo.lmb.domain.CoalTransport;


public interface ICoalTransportService extends IBaseService<CoalTransport> {
	public CoalTransport findByIdDetail(String transportId);
}
