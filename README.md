# onlinecv

The Online CV is a showcase to show the combination of different technologies.

Attention: This is work in progress! 

This project contains a rest layer to access Online CVs that are stored in a Mongo DB.

# Getting it to run
* Checkout the git repository
* install Mongo DB (on mac: $ brew install mongo)
* start mongo: $ /usr/bin/mongod --dbpath <path to db> --port 27017 --smallfiles --httpinterface --rest --fork --logpath <path to logfile>

* Run $ mvn clean install tomcat7:run

# Debugging
$ export MAVEN_OPTS -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n

Then in your eclipse create a new Remote Debugging configuration and connect to port 8000

# Technologies involved
The following technologies are shown:

* jersey rest 
* Mongo DB with Jongo lib
* Different output format generation xml and json
* JAXB datamapping.
* XSD on the fly generation
* Codeenvy as online code editor used
 * Docker image configured with Mongo DB.

# TODOs
* Clean up code
* Use real logging
* Add selenium test
* Add unit tests
* Add flat version of online cv for more efficient list display
* Add Swagger UI to see the Rest API


