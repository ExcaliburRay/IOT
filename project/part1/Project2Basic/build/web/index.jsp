<%-- 
    Document   : index
    Created on : Jun 21, 2019, 2:55:03 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    
    <%-- construct one div to draw the triangle which display the cordinate--%>
div {
  width: 200px;
  height: 100px;
  border: 1px solid black;
}
</style>
</head>
<body>

    <%-- onmousemove means when this div detect the mouse moves, it implement the fuction muFunction--%>
    <%-- onmouseout means when the div detect the mouse is moved out of this div element, it implement clearCoor function --%>
    <div onmousemove="myFunction(event)" onmouseout="clearCoor()"></div>

<p>Mouse over the rectangle above, and get the coordinates of your mouse pointer.</p>

<p>When the mouse is moved over the div, the p element will display the horizontal and vertical coordinates of your mouse pointer, whose values are returned from the clientX and clientY properties on the 
MouseEvent object.</p>

<p id="demo"></p>

<%--e represent the event itself --%>
<%--e.clientX represent it obtains the horizontal coordinate within the application's client area at which the event occurred --%>
<%--e.clientY represent it obtains the vertical coordinate within the application's client area at which the event occurred --%>
<script>
function myFunction(e) {
  var x = e.clientX;
  var y = e.clientY;
  var coor = "Coordinates: (" + x + "," + y + ")";
  <%-- update the content in demo area --%>
  document.getElementById("demo").innerHTML = coor;
}
<%--clear the content in demo area--%>
function clearCoor() {
  document.getElementById("demo").innerHTML = "";
}
</script>

</body>
</html>
