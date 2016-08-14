package com.beisert.onlinecv.service;

import java.util.List;

import com.beisert.onlinecv.domain.OnlineCV;

/**
 * Interface for reading and saving CVs.
 * @author dbe
 *
 */
public interface OnlineCVService {

	public OnlineCV findCVByUser(final String user) ;
	public List<OnlineCV> findall() ;
	public OnlineCV save(OnlineCV cv);
	
	public long deleteAll();
	
	public int loadInitialCVsIntoDB();

}