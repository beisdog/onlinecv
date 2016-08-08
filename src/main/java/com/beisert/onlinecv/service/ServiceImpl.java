package com.beisert.onlinecv.service;

public enum ServiceImpl{
	mongo(new OnlineCVServiceMongo()),dummy(new OnlineCVServiceDummy());
	
	public final OnlineCVService impl;
	private ServiceImpl(OnlineCVService impl){
		this.impl = impl;
	}
}