package com.codenvy.example.gwt.server;

import org.bson.Document;

import com.beisert.onlinecv.service.MongoDBSingleton;
import com.codenvy.example.gwt.client.GreetingService;
import com.codenvy.example.gwt.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}
		System.out.println("Enter greetServer " + input);
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		System.out.println("Enter greetServer: serverInfo " + serverInfo);
		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		long count = 0;
		String greeting = "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;

		System.out.println("Enter greetServer: greeting " + greeting);

		try {
			MongoDatabase db = MongoDBSingleton.getInstance().getMongoDatabase();
			db.getCollection("greetings").insertOne(new Document().append("input", input)
					.append("serverInfo", serverInfo).append("userAgent", userAgent));
			count = db.getCollection("greetings").count();
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
		System.out.println("Enter greetServer: after mongo ");

		return greeting + " - inserted " + count + " into mongodb";
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 *
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
