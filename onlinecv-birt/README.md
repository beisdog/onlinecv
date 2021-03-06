# Online CV

The Online CV is a showcase to show the combination of different technologies like jersey rest, jaxb, mongo db, vaadin and jongo (http://jongo.org).

This application manages CVs.

This folder contains the BIRT Webviewer that generates the CV as Output document like word, pdf, html.

There is no custom coding inside except for the report design. It contains a copy of the BIRT Webviewer project from the BIRT runtime distribution. Unfortunately the BIRT project is not properly
in any maven repository. It got problems to get it to run from maven so the only solution I had was to copy all the jars and other files
to this project. This is BIRT 4.2.0, the newer versions had jar verify errors.

#Getting it to run

You can get the runtime to run by executing

```mvn clean install tomcat7:run````

and it will start on port 8090.

You need to run the onlinecv-rest project as well, so the report gets its xml data.

Then you can see a report by opening the URL under:

```
http://localhost:8090/run?__report=cv_report.rptdesign&__format=pdf&resturl=http://localhost:8888/rest/onlinecv/dbe?format=xml
```
The url has the following parameters:
* __report : the report design file
* __format : can be pdf, html or doc
* resturl: That is the url where it should fetch the data from, as you can here it must contain the user (here "dbe" and the format=xml)
