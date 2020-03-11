/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//local setting infomation
var loc = {'hostname' : 'localhost', 'port' : '9002' };

//build one new MQTT client and set localhost name and port into it 
client = new Paho.MQTT.Client(loc.hostname, Number(loc.port), 'coordinateSubscriber');
//when connect lost, invoke function onConnectionLost
client.onConnectionLost = onConnectionLost;
//when message arrived, invoke function onMessageArrived
client.onMessageArrived = onMessageArrived;

//when client connected, invoke function onConnect
client.connect({onSuccess:onConnect});

function onConnect() {
    //if connected succesfully,subscribe the info from coordinateTracker
    console.log("connection established, subscribing to coordinateTracker");
    client.subscribe("coordinateTracker", {qos: 1});
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
    var messageLine = document.getElementById('coordinate');
    //create one new node
    var newmsg = document.createElement("p");
    //select the info we need from JSON and set the content into the new node we created
    newmsg.innerHTML = "<b>Coordinate Received: Coordinate X is </b>"+jsonString.X+"  <b>Coordinate Y is</b>  "+jsonString.Y;
    messageLine.append(newmsg);
 
    
}

