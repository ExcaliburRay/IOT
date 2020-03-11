/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    var loc = {'hostname' : 'localhost', 'port' : '9002' };
    //build one new MQTT client and set localhost name and port into it 
    client = new Paho.MQTT.Client(loc.hostname, Number(loc.port), 'DrawChart');
    //when connect lost, invoke function onConnectionLost
    client.onConnectionLost = onConnectionLost;
    //when message arrived, invoke function onMessageArrived
    client.onMessageArrived = onMessageArrived;
    //when client connected, invoke function onConnect
    client.connect({onSuccess:onConnect});


function onConnect() {
    //if connected succesfully,subscribe the info from TemperatureSensor
    console.log("connection established, subscribing to TemperatureSensor");
    //find the index of selected box
    client.subscribe("DiceRolling", {qos: 2});               
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
    var dice1 = jsonString.Die1;
    var dice2 = jsonString.Die2;
    changeTemp(dice1,dice2);
    changeLineChart(dice1,dice2);
}

