# Online CV

The Online CV is a showcase to show the combination of different technologies like jersey rest, jaxb, mongo db, vaadin, BIRT reporting and jongo (http://jongo.org).

This application manages CVs. 

It consists of different sub projects. 

The folder 
* onlinecv-rest: contains the service layer and exposes them as rest services.
* onlinecv-vaadin: contains a vaadin user interface to edit and display the CV data. It is implemented in a very generic fashion so that data structure changes are immediately visible in the UI.
* onlinecv-birt: contains the BIRT webviewer and a design file to display the CV in a sendable output format like word or pdf.

# Getting it to run
* checkout the git repository into a local directory on your machine:
 * `git clone https://github.com/beisdog/onlinecv.git`

* Then you have to run the 3 projects
 * `cd onlinecv/onlinecv-rest`
 * `mvn clean install tomcat7:run`
 * `cd ../onlinecv-vaadin`
 * `mvn clean install jetty:run`
 * `cd ../onlinecv-birt`
 * `mvn clean install tomcat7:run`
 
* Here are the URLs: 
 * Rest Admin: http://localhost:8888/
 * Vaadin edit CV: http://localhost:8080
 * BIRT CV generation to PDF etc: http://localhost:8090/run?__report=cv_report.rptdesign&__format=pdf&resturl=http://localhost:8888/rest/onlinecv/dbe?format=xml


# Roadmap
* REST: use real logging, system.out is still used.
* REST: add Swagger UI to see the Rest API
* add selenium test
* add unit tests
* Add a pom.xml here in the root folder that can run all 3 services at once.


