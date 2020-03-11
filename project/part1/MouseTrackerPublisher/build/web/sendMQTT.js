//local setting infomation
var loc = {'hostname' : 'localhost', 'port' : '9002' };

//build one new MQTT client and set localhost name and port into it 
client = new Paho.MQTT.Client(loc.hostname, Number(loc.port), 'CoordinateTracker');

//when connect lost, invoke function onConnectionLost
client.onConnectionLost = onConnectionLost;

//when client connected, invoke function onConnect
client.connect({onSuccess:onConnect});

function onConnect() {
    //if connected, display connection established
    console.log("Connection established");
}


 function onConnectionLost(responseObject) {
     //if connect failure,display error message
    if (responseObject.errorCode !== 0) {
        console.log("onConnectionLost:" + responseObject.errorMessage);
    }
 }

function transmit(msg) {
     //create one new MQTT message object and assign topic value into this
     message = new Paho.MQTT.Message(msg);
     message.destinationName = "coordinateTracker";
     message.qos = 1;
     message.retained = true;
     //sent message into MQTT server
     client.send(message);
}

//e represent the event itself
//e.clientX represent it obtains the horizontal coordinate within the application's client area at which the event occurred
//e.clientY represent it obtains the vertical coordinate within the application's client area at which the event occurred

function mqtt(e) {
  var x = e.clientX;
  var y = e.clientY;
  var coor = "Coordinates: (" + x + "," + y + ")";
  //update the content in demo area
  document.getElementById("demo").innerHTML = coor;
  //sent the data as Json format to MQTT server as Publisher
  var jsonData = '{"X":"' + x + '","Y":"'+ y +'"}'
  transmit(jsonData);
}
//clear the content in demo area
function clearCoor() {
  document.getElementById("demo").innerHTML = "";
}