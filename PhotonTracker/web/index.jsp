<%-- 
    Document   : index
    Created on : Jun 10, 2019, 2:46:56 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" language="javascript" src="ajax1.js"></script>
        <script type="text/javascript" language="javascript" src="photon.js"></script>
        
        <script type="text/javascript">
            function invoke(){
                var req = newXMLHttpRequest();
                req.onreadystatechange = getReadyStateHandler(req, invokeTime);
                req.open("POST", "PhotonServlet", true);
                req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                req.send("action=initial");
            }
            function invokeTime(photonXML){
                var photonId = photonXML.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                var lastTime = photonXML.getElementsByTagName("lastBeat")[0].childNodes[0].nodeValue;
                document.getElementById("PhotonId").innerHTML = photonId;  
                document.getElementById("lastTime").innerHTML = lastTime;
            }
            window.onload=invoke;
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photon HeartBeat</title>
    </head>
    <body>
        <table border="1">
            <thread>
                <th>
                    Photon Name
                </th>
                <th>
                    ID
                </th>
                <th>
                    Last HeartBeat
                </th>
                <th>
                    Fetch Update
                </th>
            </thread>
            <tr>
                <td>Photon</td>
                <td id = "PhotonId"></td>
                <td id = "lastTime"></td>
                <td><button onclick="updateTime()">Update Time</button></td>
            </tr>
        </table>
    </body>
</html>
