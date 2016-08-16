<!doctype html>
<!-- The DOCTYPE declaration above will set the    -->
<!-- browser's rendering engine into               -->
<!-- "Standards Mode". Replacing this declaration  -->
<!-- with a "Quirks Mode" doctype may lead to some -->
<!-- differences in layout.                        -->

<%@page import="com.beisert.onlinecv.service.ServiceImpl"%>
<%@page import="com.beisert.onlinecv.service.MongoDBSingleton"%>
<%@page import="com.beisert.onlinecv.service.OnlineCVServiceMongo"%>
<%@page import="com.beisert.onlinecv.service.OnlineCVService"%>
<%@page import="com.beisert.onlinecv.rest.OnlineCVRestServiceImpl"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--                                                               -->
    <!-- Consider inlining CSS to reduce the number of requested files -->
    <!--                                                               -->
    <link type="text/css" rel="stylesheet" href="main.css">

    <link rel="shortcut icon" href="https://com.codenvy.com/site/images/favicon.ico">

    <!--                                           -->
    <!-- Any title is fine                         -->
    <!--                                           -->
    <title>Online CV Rest interface</title>

</head>

<!--                                           -->
<!-- The body can have arbitrary html, or      -->
<!-- you can leave the body empty if you want  -->
<!-- to create a completely dynamic UI.        -->
<!--                                           -->
<body>

<h1>Online CV Rest interface</h1>

<p>
Welcome to the Online CV sample project! <br>This project contains the restlayer to read and edit CVs. <br>The UI that uses this
service can be found here: <a href="http://localhost:8080" target="_newUI">Online CV Vaadin</a><br/>
<br>The code for the restlayer is hosted on github and can be found here: <a href="https://github.com/beisdog/onlinecv">https://github.com/beisdog/onlinecv</a>
<br/>
The code for the UI is also hosted on github and can be found here: <a href="https://github.com/beisdog/onlinecv-vaadin">https://github.com/beisdog/onlinecv-vaadin</a>

<br><br><h2>Status of Database</h2>
<ul>
<%
boolean mongoRunning = MongoDBSingleton.getInstance().isMongoRunning() ;
boolean usingDummyService = (OnlineCVRestServiceImpl.service == ServiceImpl.dummy );
 
 %>
<li><%=mongoRunning ? "<b><font color=green>Mongo DB is running!</font></b>" + (usingDummyService? "<font color=red><br/>Mongo is running but you use the Dummy Database. You can switch the rest layer to Mongo DB</font>":"") : "<b><font color=red>Mongo DB is not running</font></b>" %></li>
<% if(usingDummyService){ %>
   <li><b>Current backend uses dummy database</b></li>	
   <% 
    if (mongoRunning) {%>
   		<li><a href="rest/onlinecv/switchdb/mongo" target="right" onclick="javascript:window.top.frames['right'].location.href = 'rest/onlinecv/switchdb/mongo';window.top.frames['left'].location.reload()">Switch restlayer to use Mongo database</a></li>
   <%
    } 
   } else {
    //uses mongo layer
      
   %>
   <%if(mongoRunning) {%>
   		<li><b>Current backend uses Mongo database</b></li>
   		   <%
   	 }else{
   	 %>
   	 	<li><b><font color=red>ERROR: Current backend uses Mongo database layer but Mongo is not running!!!</font></b></li>
   	 <%
   	 }
   	 %>
   	 <li><a href="rest/onlinecv/switchdb/dummy" target="right" onclick="javascript:window.top.frames['right'].location.href = 'rest/onlinecv/switchdb/dummy';window.top.frames['left'].location.reload()">Switch restlayer to use dummy database (works in memory but does not persist)</a></li>
   	 <%   
   } %>
  

</ul>
</p>
<h2>Rest Methods to read CV Data</h2>
<ul>
	<li><a href="swagger-ui/index.html" target="newwindow">Show Swagger Rest Definition</a></li>
   <li><a href="rest/onlinecv?format=json" target="right">Show all CVs as json</a></li>
   <li><a href="rest/onlinecv/dbe?format=xml" target="_newXml">Show CV for user "dbe" as xml</a></li>
   <li><a href="rest/onlinecv/dbe?format=json" target="right">Show CV for user "dbe" as JSON</a></li>
   <li><a href="rest/onlinecv/xsd" target="_newXSD">Show definition of the Online CV  as XML Schema</a></li>
</ul>
<h3>Administrative Functions</h3>
 <ul>
   <% if(OnlineCVRestServiceImpl.service == ServiceImpl.dummy && mongoRunning){ %>
   <li><a href="rest/onlinecv/switchdb/mongo" target="right" onclick="javascript:location.reload()">Switch restlayer to use Mongo database</a></li>
   <% } else { %>
   <li><a href="rest/onlinecv/switchdb/dummy" target="right" onclick="javascript:location.reload()">Switch restlayer to use dummy database (works in memory but does not persist)</a></li>
   <%} %>
   <li><a href="rest/mongo/list/cvs/delete-all" target="right">Delete all CVS</a></li>
   <li><a href="rest/onlinecv/dataload" target="right">load data into the database (Also deletes all previous data)</a></li>
    
 </ul>
 <h3>Start Mongo Database (works only on prepared Environments)</h3>
 <ul>
 <li><a href="rest/mongo/start/CODENVY" target="right">Start &quot;mongodb&quot; in the codenvy environment (works only if your are running in codenvy)</a></li>
 <li><a href="rest/mongo/start/LOCAL" target="right">Start &quot;mongodb&quot; on your local MAC (works only if you have mongo db installed)</a></li>
  </ul>
</body>
</html>
