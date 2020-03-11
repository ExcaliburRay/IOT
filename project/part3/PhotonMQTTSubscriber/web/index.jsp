<%-- 
    Document   : index
    Created on : Jun 29, 2019, 3:48:58 PM
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
        <title>Photon Subscriber</title>
    </head>
    <body>
        <h1>Photon Subscriber</h1>
        <h2>Name/ID will shown below:</h2>
        <div id="photon"></div>
    </body>
</html>
