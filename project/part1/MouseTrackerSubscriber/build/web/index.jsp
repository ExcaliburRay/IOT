<%-- 
    Document   : index
    Created on : Jun 21, 2019, 3:53:59 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- connect with js by using script--%>
        <script type="text/JavaScript" src="mqttws31.js"></script>
        <script type="text/JavaScript" src="getMQTT.js"></script> 
        <title>Mouse Tracker Subscriber</title>
    </head>
    <body>
        <h1>Mouse Tracker Subscriber</h1>
        <h2>Coordinate will shown below:</h2>
        <div id="coordinate"></div>
    </body>
</html>
