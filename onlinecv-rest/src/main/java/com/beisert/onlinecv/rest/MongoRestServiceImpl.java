package com.beisert.onlinecv.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.beisert.onlinecv.service.MongoDBSingleton;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import io.swagger.annotations.*;
/**
 * Simple rest interface to control and query mongo.
 * Just for troubleshooting.
 * @author dbe
 *
 */
@Path("/mongo")
@Api(value="/mongo", description = "Endpoint for testing Mongo DB")
public class MongoRestServiceImpl {

	@GET
//	@ApiOperation(
//		    value = "Start mongo DB for the specified environment", 
//		    notes = "environment can be: LOCAL or CODENVY"
//		    )
	@Path("/start/{env}")
	@Produces(MediaType.TEXT_HTML)
	public Response startMongo(@PathParam("env") String env) {
		System.out.println("Enter startMongo");
		MongoDBSingleton.startMongo(MongoDBSingleton.MongoEnv.valueOf(env));
		System.out.println("Exit startMongo");
		return Response.ok().entity("Starting " + env + " ...").build();
	}
	

	@GET
	@Path("/list/{collection}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCollection(@PathParam("collection") String collection) {
		System.out.println("Enter listCollectio " + collection);
		FindIterable<Document> iter = MongoDBSingleton.getInstance().getMongoDatabase().getCollection(collection)
				.find();

		final StringBuilder s = new StringBuilder("[");
		final List<Document> result = new ArrayList<Document>();
		
		s.append("[");
		iter.forEach(new Block<Document>() {

			public void apply(Document doc) {
				result.add(doc);
				s.append(doc.toString()).append(",");
			}
		});
		
		s.append("]");
		System.out.println("Exit listCollection: returning " + s);
		return Response.ok().entity(result).build();
	}
	
	@GET
	@Path("/list/{collection}/delete-all")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteAll(@PathParam("collection") String collection) {
		System.out.println("Enter listCollectio " + collection);
		long count = MongoDBSingleton.getInstance().getMongoDatabase().getCollection(collection)
				.deleteMany(new Document()).getDeletedCount();

		
		return Response.ok().entity("Deleted " + count).build();
	}
	
	
}
