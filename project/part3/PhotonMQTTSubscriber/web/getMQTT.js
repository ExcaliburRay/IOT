/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//local setting infomation
var loc = {'hostname' : 'localhost', 'port' : '9002' };

//build one new MQTT client and set localhost name and port into it 
client = new Paho.MQTT.Client(loc.hostname, Number(loc.port), 'photonSubscriber');
//when connect lost, invoke function onConnectionLost
client.onConnectionLost = onConnectionLost;
//when message arrived, invoke function onMessageArrived
client.onMessageArrived = onMessageArrived;

//when client connected, invoke function onConnect
client.connect({onSuccess:onConnect});

function onConnect() {
    //if connected succesfully,subscribe the info from coordinateTracker
    console.log("connection established, subscribing to photonTracker");
    client.subscribe("student/id", {qos: 1});
}

function onConnectionLost(responseObject) {
    //if connect failure,display error message
   if (responseObject.errorCode !== 0) {
        console.log("onConnectionLost:" + responseObject.errorMessage);
   }
}

function onMessageArrived(message) {
    //display the subscribe message 
    console.log(message);
    console.log("onMessageArrived:" + message.payloadString);
    //parse the info as JSON format
    var jsonString = JSON.parse(message.payloadString);
    var messageLine = document.getElementById('photon');
    //create one new node
    var newmsg = document.createElement("p");
    //select the info we need from JSON and set the content into the new node we created
    newmsg.innerHTML = "<b>My Name is </b>"+jsonString.name+"  <b>My URL is</b>  "+jsonString.URL;
    messageLine.append(newmsg);
 
    
}

