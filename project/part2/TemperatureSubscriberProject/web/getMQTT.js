/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//local setting infomation
function submit(){
    //clean all the info already displayed
    document.getElementById('temperature').innerHTML = "";
    var loc = {'hostname' : 'localhost', 'port' : '9002' };
    //build one new MQTT client and set localhost name and port into it 
    client = new Paho.MQTT.Client(loc.hostname, Number(loc.port), 'TemperatureSubscriber');
    //when connect lost, invoke function onConnectionLost
    client.onConnectionLost = onConnectionLost;
    //when message arrived, invoke function onMessageArrived
    client.onMessageArrived = onMessageArrived;
    //when client connected, invoke function onConnect
    client.connect({onSuccess:onConnect});
}

function onConnect() {
    //if connected succesfully,subscribe the info from TemperatureSensor
    console.log("connection established, subscribing to TemperatureSensor");
    //find the index of selected box
    var index = document.getElementById("option").selectedIndex;
    //obtain the value current display in the selected box
    var content = document.getElementById("option").options[index].text;
    //match the selected box with subscriber
    if(content === "pittsburgh/temperature/coldTemps"){
        client.subscribe("pittsburgh/temperature/coldTemps", {qos: 2});
    }else if(content === "pittsburgh/temperature/hotTemps"){
        client.subscribe("pittsburgh/temperature/hotTemps", {qos: 2});
    }else if(content === "pittsburgh/temperature/niceTemps"){
        client.subscribe("pittsburgh/temperature/niceTemps", {qos: 2});
    }else{
        client.subscribe("pittsburgh/temperature/#", {qos: 2});
    }
        
        
}

function onConnectionLost(responseObject) {
    //if connect failure,display error message
   if (responseObject.errorCode !== 0) {
        console.log("onConnectionLost:" + responseObject.errorMessage);
   }
}

function onMessageArrived(message) {
    //display the subscribe message 
    console.log("onMessageArrived:" + message.payloadString);
    //parse the info as JSON format
    var jsonString = JSON.parse(message.payloadString);
    var messageLine = document.getElementById('temperature');
    //create one new node
    var newmsg = document.createElement("p");
    //select the info we need from JSON and set the content into the new node we created
    newmsg.innerHTML = "<b>Temperature Information Received: temperature is </b>"+jsonString.temperature+"  <b>current timestamp is</b>  "+jsonString.time;
    messageLine.append(newmsg);
    
}

