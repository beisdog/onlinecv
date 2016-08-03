package com.beisert.onlinecv;

import java.net.UnknownHostException;

<<<<<<< HEAD
import com.beisert.onlinecv.gwt.server.util.ShellExecute;
=======
import com.beisert.onlinecv.util.ShellExecute;
>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Singleton to access Mongo DB. Because Mongo does connection pooling itself
 * no special datasource is needed.
 */
public class MongoDBSingleton {

    private static MongoDBSingleton instance;

    private MongoClient             mongoClient;
    private DB                      db;
    private String                  dbHost = "localhost";
    private int                     dbPort = 27017;
    private String                  dbName = "testdb";

    public static MongoDBSingleton getInstance() {
        if (instance == null) {
            instance = new MongoDBSingleton();
<<<<<<< HEAD
            startMongo();
=======
            //startMongo();
>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2

        }
        return instance;
    }

    public DB getDB() {


        if (mongoClient == null) {
          try{
            mongoClient = new MongoClient(dbHost, dbPort);
          }catch(UnknownHostException e){
            throw new RuntimeException(e);
          }
        }
        if (db == null)
            db = mongoClient.getDB(dbName);

        return db;

    }

    public static void startMongo() {
<<<<<<< HEAD
=======
    	//local on mac
    	///usr/local/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log
>>>>>>> 5b7e992de2754950669724678236ad1a13c68da2
        ShellExecute.run("/usr/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log");
    }


}
