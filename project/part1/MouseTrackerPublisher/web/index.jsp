<%-- 
    Document   : index
    Created on : Jun 21, 2019, 2:57:06 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%-- connect with js by using script--%>
        <script type="text/JavaScript" src="mqttws31.js"></script>
        <script type="text/JavaScript" src="sendMQTT.js"></script> 
<style>
    
    <%-- construct one div to draw the triangle which display the cordinate--%>
div {
  <%-- define the specific width,height,border of this div--%>
  width: 200px;
  height: 100px;
  border: 1px solid black;
}
</style>
</head>
<body>

    <%-- onmousemove means when this div detect the mouse moves, it implement the fuction muFunction--%>
    <%-- onmouseout means when the div detect the mouse is moved out of this div element, it implement clearCoor function --%>
    <div onmousemove="mqtt(event)" onmouseout="clearCoor()"></div>
<p>Mouse over the rectangle above, and get the coordinates of your mouse pointer.</p>

<p>When the mouse is moved over the div, the p element will display the horizontal and vertical coordinates of your mouse pointer, whose values are returned from the clientX and clientY properties on the 
MouseEvent object.</p>

<p id="demo"></p>

</body>
</html>

