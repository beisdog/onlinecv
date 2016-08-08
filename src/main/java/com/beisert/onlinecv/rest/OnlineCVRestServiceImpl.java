package com.beisert.onlinecv.rest;

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

import com.beisert.onlinecv.domain.OnlineCV;
import com.beisert.onlinecv.service.OnlineCVService;
import com.beisert.onlinecv.util.XMLUtils;

/**
 * Rest facade for the online cv service that can read and save CVs.
 * @author dbe
 *
 */
@Path("/onlinecv")
public class OnlineCVRestServiceImpl {
	
	/**
	 * Stores the implementation of the online service. 
	 * Defaults to mongo backed service but can be switches to Dummy in memory implementation.
	 */
	private static OnlineCVService service = ServiceImpl.mongo.impl;

    @GET
    @Path("{user}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findCVByUser(@PathParam("user") String user, @QueryParam("format")String format, @Context HttpHeaders headers) {

        OnlineCV cv = service.findCVByUser(user);
        
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

        List<OnlineCV> cvs = service.findall();
        return Response
        		.ok(cvs, getMediaTypeForFormat(headers,format))
        		.build();
    }

    /**
     * Switch the service implementation. You can choose between mongo and dummy.
     * @param service: mongo or dummy
     * @return
     */
    @GET
    @Path("/switch/{service}")
    @Produces(value={MediaType.TEXT_PLAIN})
    public String switchService(@PathParam("service") String service) {
        ServiceImpl serviceEnum = ServiceImpl.valueOf(service);
        OnlineCVRestServiceImpl.service = serviceEnum.impl;
        System.out.println("Switches to " +  serviceEnum);
        return "Rest service now uses " + serviceEnum.toString() + " service";
    	
    }
    @GET
    @Path("/dataload")
    @Produces(value={MediaType.TEXT_PLAIN})
    public String dataload() {
       int count = service.loadInitialCVsIntoDB();
       return "loaded " + count + " cvs into the database";
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
        return service.save(cv);
    }
    
    
    
}
