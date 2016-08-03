package com.beisert.onlinecv.rest;

import java.util.ArrayList;
import java.util.List;

import com.beisert.onlinecv.MongoDBSingleton;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mongo")
public class MongoRestServiceImpl {
  
  @GET
  @Path("/start")
  @Produces(MediaType.TEXT_HTML)
  public Response startMongo(){
    System.out.println("Enter startMongo");
    MongoDBSingleton.startMongo();
    System.out.println("Exit startMongo");
    return Response.ok().entity("Starting ... ").build();
  }
  
  @GET
  @Path("/list/{collection}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response listCollection(@PathParam("collection") String collection){
    System.out.println("Enter listCollectio " + collection);
    DBCursor cursor = MongoDBSingleton.getInstance().getDB().getCollection(collection).find();
    StringBuilder s = new StringBuilder("[");
    List<DBObject> result = new ArrayList<DBObject>();
    while(cursor.hasNext()){
      DBObject n = cursor.next();
      s.append(n.toString());
      result.add(n);
      if(cursor.hasNext()) s.append(",");
    }
    s.append("]");
    System.out.println("Exit listCollection: returning " + s);
    return Response.ok().entity(s.toString()).build();
  }
  
  
  
}
