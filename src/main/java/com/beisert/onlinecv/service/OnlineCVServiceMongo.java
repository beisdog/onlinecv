package com.beisert.onlinecv.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCursor;

import com.beisert.onlinecv.domain.OnlineCV;
import com.beisert.onlinecv.util.XMLUtils;

/**
 * Implementation that uses Mongo as Database.
 * @author dbe
 *
 */
public class OnlineCVServiceMongo implements OnlineCVService {
	
	  public OnlineCV findCVByUser(String user) {

	        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
	        OnlineCV cv = jongo.getCollection("cvs").findOne("{user: '"+user+"'}").as(OnlineCV.class);
	        
	        return cv;
	    }

		
	    public List<OnlineCV> findall() {

	        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
	        MongoCursor<OnlineCV> cursor = jongo.getCollection("cvs").find("{}").as(OnlineCV.class);
	        System.out.println("Found " + cursor.count());
	        
	        List<OnlineCV> cvs = new ArrayList<OnlineCV>();
	        while(cursor.hasNext()){
	        	cvs.add(cursor.next());
	        }
	        return cvs;
	    }
	    
	    	    
	    public OnlineCV save(OnlineCV cv) {
	        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
	        jongo.getCollection("cvs").save(cv);
	        return cv;
	    }


		@Override
		public long deleteAll() {
			long count = MongoDBSingleton.getInstance().getMongoDatabase().getCollection("cvs")
					.deleteMany(new Document()).getDeletedCount();
			return count;
		}


		@Override
		public int loadInitialCVsIntoDB() {
			Jongo jongo = MongoDBSingleton.getInstance().getJongo();
			OnlineCV cv = TestDataGenerator.generateNewOnlineCVFor("dbe","Beisert","David");
	        jongo.getCollection("cvs").insert(cv);
	        return 1;
		}

}
