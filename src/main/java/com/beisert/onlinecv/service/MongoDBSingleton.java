package com.beisert.onlinecv.service;

import java.util.ArrayList;

import org.jongo.Jongo;

import com.beisert.onlinecv.domain.AddressData;
import com.beisert.onlinecv.domain.Certification;
import com.beisert.onlinecv.domain.CommunicationData;
import com.beisert.onlinecv.domain.Education;
import com.beisert.onlinecv.domain.GenericContainer;
import com.beisert.onlinecv.domain.I18NText;
import com.beisert.onlinecv.domain.Job;
import com.beisert.onlinecv.domain.LanguageSkill;
import com.beisert.onlinecv.domain.OnlineCV;
import com.beisert.onlinecv.domain.PersonalData;
import com.beisert.onlinecv.domain.Project;
import com.beisert.onlinecv.domain.SimpleDate;
import com.beisert.onlinecv.domain.UserSkill;
import com.beisert.onlinecv.domain.UserSkill.Category;
import com.beisert.onlinecv.domain.UserSkill.SkillLevel;
import com.beisert.onlinecv.domain.CommunicationData.CommunicationType;
import com.beisert.onlinecv.domain.LanguageSkill.LanguageSkillLevel;
import com.beisert.onlinecv.domain.LanguageText.Locale;
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
        ShellExecute.run(env.getCmdLine());
    }
    
    

	

}
