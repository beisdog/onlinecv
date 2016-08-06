package com.beisert.onlinecv.service;

import java.util.ArrayList;

import org.jongo.Jongo;

import com.beisert.onlinecv.domain.AddressData;
import com.beisert.onlinecv.domain.CommunicationData;
import com.beisert.onlinecv.domain.GenericContainer;
import com.beisert.onlinecv.domain.I18NText;
import com.beisert.onlinecv.domain.OnlineCV;
import com.beisert.onlinecv.domain.PersonalData;
import com.beisert.onlinecv.domain.ProjectData;
import com.beisert.onlinecv.domain.SimpleDate;
import com.beisert.onlinecv.domain.UserSkill;
import com.beisert.onlinecv.domain.CommunicationData.CommunicationType;
import com.beisert.onlinecv.util.DateUtil;
import com.beisert.onlinecv.util.ShellExecute;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Singleton to access Mongo DB. Because Mongo does connection pooling itself
 * no special datasource is needed.
 */
public class MongoDBSingleton {

    private static MongoDBSingleton instance;

    private MongoClient             mongoClient;
    private MongoDatabase           db;
    private String                  dbHost = "localhost";
    private int                     dbPort = 27017;
    private String                  dbName = "testdb";

	private Jongo jongo;

    public static MongoDBSingleton getInstance() {
        if (instance == null) {
            instance = new MongoDBSingleton();
        }
        return instance;
    }
    
    public boolean isMongoRunning(){
    	try {
			if( getMongoDatabase() != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
    }

    /**
     * New API
     * @return
     */
    public MongoDatabase getMongoDatabase() {
        if (mongoClient == null) {
          mongoClient = new MongoClient(dbHost, dbPort);
          
        }
        if (db == null)
            db = mongoClient.getDatabase(dbName);

        return db;
    }
    
    /**
     * OR Mapper jongo for the db.
     * @return
     */
    public Jongo getJongo(){
    	if(this.jongo == null) {
    		this.jongo =new Jongo(getDB());
    	}
    	return this.jongo;
    }
    
    /**
     * Use the deprecated API but compatible with other mappers.
     * @return
     */
    public DB getDB() {
        if (mongoClient == null) {
          mongoClient = new MongoClient(dbHost, dbPort);
          
        }
        return mongoClient.getDB(dbName);

    }

    public static enum MongoEnv {
    	LOCAL("/usr/local/bin/mongod",27017,"/Users/dbe/Development/tools/mongodb/db","/Users/dbe/Development/workspaces/gwt/onlinecv/mongo.log"),
    	CODENVY("/usr/bin/mongod",27017,"/home/user/mongodb/db","/home/user/mongo.log")
    	;
    	
    	private final String mongodPath;
    	private final int port;
    	private final String dbpath;
    	private final String logpath;
    	
		private MongoEnv(String mongodPath, int port, String dbpath, String logpath) {
			this.mongodPath = mongodPath;
			this.port = port;
			this.dbpath = dbpath;
			this.logpath = logpath;
		}
		
		public String getCmdLine(){
			return mongodPath + " --dbpath " + dbpath + " --port " + port + " --smallfiles --httpinterface --rest --fork --logpath " + logpath; 
		}
    	
    	
    }
    
    public static void startMongo(MongoEnv env) {
    	
    	//local on mac
    	///usr/local/bin/mongod --dbpath /Users/dbe/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log
        ShellExecute.run(env.getCmdLine());
    }
    
    public void dataload(){
    	OnlineCV cv = new OnlineCV();
    	
    	cv.setUser("dbe");

        PersonalData pd = new PersonalData();
        pd.setFirstname("David");
        pd.setLastname("Beisert");
        pd.setBirthday(new SimpleDate(1976, 7, 4));
        pd.setNumberOfChildren(2);


        UserSkill java = new UserSkill("java", 18d, 2016);
        cv.getUserSkills().add(java);
        UserSkill j2ee = new UserSkill("j2ee", 18d, 2016);
        cv.getUserSkills().add(j2ee);
        UserSkill hibernate = new UserSkill("hibernate", 18d, 2016);
        cv.getUserSkills().add(hibernate);

        ProjectData project1 =
                               new ProjectData(new I18NText("Tolles project", "Great Project"), new I18NText("schön", "beautiful"), "BAYER",
                            		  new SimpleDate(2016, 1, 1), new SimpleDate(2016, 8, 1), java, j2ee,
                                               hibernate);
        project1.getAdditionalInfos().add(new GenericContainer(new I18NText("Rolle", "Role"), new I18NText("Architekt", "Architect")));
        cv.getProjects().add(project1);
        cv.setPersonalData(pd);

        AddressData ad = new AddressData("Farnsburgerstrasse", "54", "", "4052", "Basel", "Switzerland");
        pd.setAddress(ad);
        pd.setCommunicationData(new ArrayList<CommunicationData>());
        pd.getCommunicationData().add(new CommunicationData(CommunicationType.EMAIL, "david.beisert@beisert-btc.de", ""));
        pd.getCommunicationData().add(new CommunicationData(CommunicationType.MOBILE, "+49 151 58771341", ""));
        
        
        getJongo().getCollection("cvs").insert(cv);
        //getJongo().getCollection("cvs").getDBCollection().createIndex(new BasicDBObject("user",1),new BasicDBObject("unique",true));
        
    }


}
