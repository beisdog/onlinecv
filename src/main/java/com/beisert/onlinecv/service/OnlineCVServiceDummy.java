package com.beisert.onlinecv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.beisert.onlinecv.domain.OnlineCV;

/**
 * Implementation that uses a simple java list as storage.
 * @author dbe
 *
 */
public class OnlineCVServiceDummy implements OnlineCVService {

	private List<OnlineCV> cvs = new ArrayList<>();

	public OnlineCVServiceDummy() {
		loadInitialCVsIntoDB();
	}

	public OnlineCV findCVByUser(final String user) {
		final String input = user == null ? "" : user;
		Optional<OnlineCV> cv = cvs.stream().filter(e -> input.equals(e.getUser())).findFirst();
		return cv.orElseGet(null);
	}

	public List<OnlineCV> findall() {

		return cvs;
	}

	public OnlineCV save(OnlineCV cv) {
		final String id = cv.get_id() == null?"":cv.get_id();
		Optional<OnlineCV> existing = cvs.stream().filter(e -> id.equals(e.get_id())).findFirst();

		if (existing.isPresent()) {
			cvs.remove(existing.get());
		}
		if (cv != null) {
			if(cv.get_id() == null){
				cv.set_id(System.currentTimeMillis()+"");
			}
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
		deleteAll();
		this.cvs = new ArrayList<OnlineCV>();
		OnlineCV cv = TestDataGenerator.generateNewOnlineCVFor("dbe", "Beisert", "David");
		cv.set_id(System.currentTimeMillis()+"");
		this.cvs.add(cv);
		return cvs.size();
	}

}
