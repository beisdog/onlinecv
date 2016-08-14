# Online CV

The Online CV is a showcase to show the combination of different technologies like jersey rest, jaxb, mongo db, vaadin and jongo (http://jongo.org).

This application manages CVs. 

This folder contains the BIRT Webviewer that generates the CV as Output document like word, pdf, html.

There is no custom coding inside but just a copy of the BIRT Webviewer project. Unfortunately the BIRT project is not properly
in any maven project. It got problems to get it to run so the only solution I had was to copy all the jars and other files 
to this project. This is BIRT 4.2.0, the other versions had jar verify errors.

#Getting it to run

You can get the runtime to run by executing

```mvn clean install tomcat7:run````

and it will start on port 8090.

You need to run the onlinecv-rest project as well, so the report gets its xml data.

Then you can see a report by opening the URL under:

```http://localhost:8090/run?__report=cv_report.rptdesign&__format=pdf&resturl=http://localhost:8888/rest/onlinecv/dbe?format=xml```

The url has the following partameters:
* __report : the report design file
* __format : can be pdf, html or doc
* resturl: That is the url where it should fetch the data from, as you can here it mus contain the user (here "dbe" and the format=xml)




