package com.beisert.onlinecv.gwt.server;

import java.net.UnknownHostException;

import com.beisert.onlinecv.gwt.util.ShellExecute;
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Singleton to access Mongo DB.

 */
public class MongoDBSingleton {

    private static MongoDBSingleton instance;

    private MongoClient             mongoClient;

    private static DB               db;

    private final String            dbHost = "localhost";
    private final int               dbPort = 27017;
    private final String            dbName = "testdb";

    public static MongoDBSingleton getInstance() {
        if (instance == null) {
            instance = new MongoDBSingleton();
            startMongo();

        }
        return instance;
    }

    public DB getDB() {


        if (mongoClient == null) {
            try {
                mongoClient = new MongoClient(dbHost, dbPort);
            } catch (UnknownHostException e) {
                return null;
            }
        }
        if (db == null)
            db = mongoClient.getDB(dbName);

        return db;

    }

    private static void startMongo() {
        ShellExecute.run("/usr/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log");

    }


}
