/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
            
function updateTime(){
    var req = newXMLHttpRequest();
    
    //revoke updatePhoton function to update
    req.onreadystatechange = getReadyStateHandler(req, updatePhoton);
    req.open("POST", "PhotonServlet", true);
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send("action=update");
    
}

//obtain photon's xml info to update info into jsp site.
function updatePhoton(photonXML) {

    //update the timeSlot in jsp
    var photonId = photonXML.getElementsByTagName("id")[0].childNodes[0].nodeValue;
    var photonTime = photonXML.getElementsByTagName("time")[0].childNodes[0].nodeValue;
    document.getElementById("PhotonId").innerHTML = photonId;  
    document.getElementById("lastTime").innerHTML = photonTime;
}




//



