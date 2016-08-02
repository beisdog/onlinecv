package com.codenvy.example.gwt.server;

import com.beisert.onlinecv.gwt.server.MongoDBSingleton;
import com.codenvy.example.gwt.client.GreetingService;
import com.codenvy.example.gwt.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
                                                              GreetingService {

    public String greetServer(String input) throws IllegalArgumentException {
        // Verify that the input is valid.
        if (!FieldVerifier.isValidName(input)) {
            // If the input is not valid, throw an IllegalArgumentException back to
            // the client.
            throw new IllegalArgumentException(
                    "Name must be at least 4 characters long");
        }
		  System.out.println("Enter greetServer " + input);
        String serverInfo = getServletContext().getServerInfo();
        String userAgent = getThreadLocalRequest().getHeader("User-Agent");

        // Escape data from the client to avoid cross-site script vulnerabilities.
        input = escapeHtml(input);
        userAgent = escapeHtml(userAgent);
      
      	DB db = MongoDBSingleton.getInstance().getDB();
         
		  long count = 0;
        String greeting =  "Hello, " + input + "!<br><br>I am running " + serverInfo
               + ".<br><br>It looks like you are using:<br>" + userAgent;
      
      	try{
      		db.getCollection("greetings").insert(new BasicDBObject().append("input",input).append("serverInfo",serverInfo).append("userAgent",userAgent));
      	
      		count = db.getCollection("greetings").count();
        	}catch(Exception e){
           System.out.println(e.toString());
         }
      	
      	return greeting + " - inserted " + count + " into mongodb";
    }

    /**
     * Escape an html string. Escaping data received from the client helps to
     * prevent cross-site script vulnerabilities.
     *
     * @param html
     *         the html string to escape
     * @return the escaped string
     */
    private String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
                ">", "&gt;");
    }
}
