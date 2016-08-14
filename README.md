# Online CV

The Online CV is a showcase to show the combination of different technologies like jersey rest, jaxb, mongo db, vaadin and jongo (http://jongo.org).

This application manages CVs. 

It consists of different sub projects. The folder onlinecv-rest contains the service layer and exposes them as rest services.
A sample UI is implemented in the folder onlinecv-vaadin and the generation of the PDF,Word is done through birt in 
the folder onlinecv-birt.

The CVs are stored either in a dummy implementation or a Mongo DB. 
You can switch the behaviour at runtime from the Admin page of this application: [http://localhost:8888](http://localhost:8888). 

## Noteworthy Architecture Design Decisions of the Rest Project

### XML Schema File Generation
The domain objects are annotated with jaxb annotations so a schema file can be generated.

The rest client then can use this xsd to generate javaclasses from this definition. 

This approach is actually used in the onlinecv-vaadin project

You can get the xsd by calling the rest service:  [http://localhost:8888/rest/onlinecv/xsd](http://localhost:8888/rest/onlinecv/xsd).

### The CV is multilingual
In the data object the type I18NText is used for all fields that contain free text. Through this the CV can
be provided in multiple languages. This will be to use when the PDF generation is implemented.  

# Getting it to run
* checkout the git repository into a local directory on your machine:
 * `git clone https://github.com/beisdog/onlinecv.git`

* to run the application:
 * `cd onlinecv`
 * `mvn clean install tomcat7:run`
* open the admin page for the rest service: http://localhost:8888/
* after that start the Rest client by following the instructions here: https://github.com/beisdog/onlinecv-vaadin.git)

## Using Mongo DB as Backend
* if you want to play with Mongo DB: 
 * install Mongo DB on mac: 
  * `brew install mongo`
 * start mongo: 
  * `/usr/bin/mongod --dbpath "path to db" --port 27017 --smallfiles --httpinterface --rest --fork --logpath "path to logfile"`
 * switch the database implementation to mongo by clicking this link once the application is running
  * http://localhost:8888/rest/onlinecv/switch/mongo
  * press the link to create some example cv in the database: http://localhost:8888/rest/onlinecv/dataload

# Using the Admin UI
Initially the application is running with a dummy backend implementation. If you have a running mongo installation on the default port
you can switch to the mongo db through the Admin UI located [http://localhost:8888](http://localhost:8888)

From the Admin UI you can do the following:
* see the status of the application
* switch between dummy database and mongo
* test the rest services
* load and delete data in the database
* start mongo (if installed)

# Debugging
To debug set these MAVEN_OPTS in your console:

* `export MAVEN_OPTS -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n` 

Then in your eclipse create a new Remote Debugging configuration and connect to port 8000 .

# Technologies involved
The following technologies are shown:

* jersey rest 
* Mongo DB with Jongo lib
* different output format generation xml and json
* JAXB datamapping.
* XSD on the fly generation

# Roadmap
* use real logging, system.out is still used.
* add selenium test
* add unit tests
* add flat version of online cv for more efficient list display
* add Swagger UI to see the Rest API
* add PDF Generation


