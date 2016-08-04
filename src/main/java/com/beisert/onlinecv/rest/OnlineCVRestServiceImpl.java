package com.beisert.onlinecv.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jongo.Jongo;

import com.beisert.onlinecv.MongoDBSingleton;
import com.beisert.onlinecv.gwt.shared.domain.OnlineCV;


@Path("/onlinecv")
public class OnlineCVRestServiceImpl {

    @GET
    @Path("{user}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findCVByUser(@PathParam("user") String user, @QueryParam("format")String format) {

        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
        OnlineCV cv = jongo.getCollection("cvs").findOne("{user: '"+user+"'}").as(OnlineCV.class);
        System.out.println("Found " + cv);
        System.out.println("Try to marshal to xml ...");
        
        return Response
        		.ok(cv, "xml".equals(format)?MediaType.APPLICATION_XML:MediaType.APPLICATION_JSON)
        		.build();
    }
    
    @POST
    @Path("/save")
    @Produces(value={MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public OnlineCV save(OnlineCV cv) {

        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
        jongo.getCollection("cvs").save(cv);
        
        
        return cv;
    }
    
    
}
