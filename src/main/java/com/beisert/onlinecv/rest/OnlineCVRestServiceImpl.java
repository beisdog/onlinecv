package com.beisert.onlinecv.rest;

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

import org.jongo.Jongo;
import org.jongo.MongoCursor;

import com.beisert.onlinecv.domain.OnlineCV;
import com.beisert.onlinecv.service.MongoDBSingleton;
import com.beisert.onlinecv.util.XMLUtils;


@Path("/onlinecv")
public class OnlineCVRestServiceImpl {

    @GET
    @Path("{user}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findCVByUser(@PathParam("user") String user, @QueryParam("format")String format, @Context HttpHeaders headers) {

        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
        OnlineCV cv = jongo.getCollection("cvs").findOne("{user: '"+user+"'}").as(OnlineCV.class);
        
        return Response
        		.ok(cv, getMediaTypeForFormat(headers,format))
        		.build();
    }

	private String getMediaTypeForFormat(HttpHeaders headers, String format) {
		if(format == null){
			List<MediaType> acceptableMediaTypes = headers.getAcceptableMediaTypes();
			if(acceptableMediaTypes != null && acceptableMediaTypes.size()>0){
				MediaType type = acceptableMediaTypes.get(0);
				return type.toString();
			}
		}
		return "xml".equals(format)?MediaType.APPLICATION_XML:MediaType.APPLICATION_JSON;
	}
    
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findall(@QueryParam("format")String format, @Context HttpHeaders headers) {

        Jongo jongo = MongoDBSingleton.getInstance().getJongo();
        MongoCursor<OnlineCV> cursor = jongo.getCollection("cvs").find("{}").as(OnlineCV.class);
        System.out.println("Found " + cursor.count());
        
        List<OnlineCV> cvs = new ArrayList<OnlineCV>();
        while(cursor.hasNext()){
        	cvs.add(cursor.next());
        }
        return Response
        		.ok(cvs, getMediaTypeForFormat(headers,format))
        		.build();
    }
    
    @GET
    @Path("/xsd")
    @Produces({MediaType.APPLICATION_XML})
    public Response getXSD() {

        String xsd = "<error/>";
        try {
			xsd = XMLUtils.generateXsd(OnlineCV.class);
			return Response
	        		.ok(xsd)
	        		.build();
		} catch (Exception e) {
			return Response
	        		.status(Status.INTERNAL_SERVER_ERROR).entity("<error>"+e+"</error>")
	        		.build();
		}
        
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
