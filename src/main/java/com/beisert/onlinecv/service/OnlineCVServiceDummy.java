package com.beisert.onlinecv.service;

import java.util.ArrayList;
import java.util.List;

import com.beisert.onlinecv.domain.OnlineCV;

/**
 * Implementation that uses a simple java list as storage.
 * @author dbe
 *
 */
public class OnlineCVServiceDummy implements OnlineCVService {

	private List<OnlineCV> cvs;

	public OnlineCVServiceDummy() {
		

	}

	public OnlineCV findCVByUser(final String user) {
		final String input = user == null ? "" : user;
		return cvs.stream().filter(e -> input.equals(e.getUser())).findFirst().get();
	}

	public List<OnlineCV> findall() {

		return cvs;
	}

	public OnlineCV save(OnlineCV cv) {
		OnlineCV existing = cvs.stream().filter(e -> cv.get_id().equals(e.get_id())).findFirst().get();

		if (existing != null) {
			cvs.remove(existing);
		}
		if (cv != null) {
			cvs.add(cv);
		}
		return cv;
	}

	@Override
	public long deleteAll() {
		int count = cvs.size();
		this.cvs.clear();
		return count;
	}

	@Override
	public int loadInitialCVsIntoDB() {
		this.cvs = new ArrayList<OnlineCV>();
		this.cvs.add(TestDataGenerator.generateNewOnlineCVFor("dbe", "Beisert", "David"));
		return cvs.size();
	}

}
