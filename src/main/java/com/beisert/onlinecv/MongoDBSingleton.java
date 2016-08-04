package com.beisert.onlinecv;

import java.net.UnknownHostException;

import com.beisert.onlinecv.util.ShellExecute;
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
    	//local on mac
    	///usr/local/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log
        ShellExecute.run("/usr/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log");
    }


}
