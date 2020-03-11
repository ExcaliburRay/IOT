<%-- 
    Document   : index
    Created on : Jun 22, 2019, 7:58:40 PM
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
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/JavaScript" src="googleChart.js"></script> 
        <script type="text/JavaScript" src="googleLineChart.js"></script> 
        <title>Google Chart</title>
    </head>
    <body>
        <%-- area of drawing google chart--%>
        <h1>Google Chart</h1>
        <div id="gauge_div" style="width:280px; height: 140px;"></div>
        <div id="gauge_div_plus" style="width:280px; height: 140px;"></div>
        <div id="lineChart_div" style="width:900px; height: 500px;"></div>
        <div id ="result"></div>
    </body>
</html>
