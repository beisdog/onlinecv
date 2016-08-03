package com.beisert.onlinecv.gwt.shared.rest;



import org.json.simple.JSONObject;

import java.util.LinkedHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/onlinecv")
public class OnlineCVRestServiceImpl {
  
  @GET
  @Path("{user}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findCVByUser(@PathParam("user") String user) {
  
    JSONObject cv = new JSONObject();
    
    JSONObject personalData = new JSONObject(new LinkedHashMap<String,Object>());
    personalData.put("firstName","David");
    personalData.put("lastName","Beisert");
    personalData.put("birthDate", "04.07.1976");
    personalData.put("relationshipStatus", "married");
    personalData.put("numberOfChildren", 2);
    cv.put("personalData",personalData);
    
    return Response.status(200).entity(cv.toJSONString()).build();
    
  }
}
