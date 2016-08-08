package com.beisert.onlinecv.rest;

import com.beisert.onlinecv.service.OnlineCVService;
import com.beisert.onlinecv.service.OnlineCVServiceDummy;
import com.beisert.onlinecv.service.OnlineCVServiceMongo;

public enum ServiceImpl{
	mongo(new OnlineCVServiceMongo()),dummy(new OnlineCVServiceDummy());
	
	public final OnlineCVService impl;
	private ServiceImpl(OnlineCVService impl){
		this.impl = impl;
	}
}