<%-- 
    Document   : index
    Created on : Jun 22, 2019, 4:05:39 PM
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
        <title>Temperature Subscriber</title>
    </head>
    <body>
        <h1>Temperature Subscriber</h1>
        <h2>Please choose your option:</h2>
        <%-- use one drop down menu bar to choose--%>
        <select id ="option">
            <option>pittsburgh/temperature/coldTemps</option>
            <option>pittsburgh/temperature/niceTemps</option>
            <option>pittsburgh/temperature/hotTemps</option>
            <option>pittsburgh/temperature/allTemps</option>
        </select>
        <button id ="click" onclick="submit()">submit</button>
        <div id="temperature"></div>
    </body>
</html>
