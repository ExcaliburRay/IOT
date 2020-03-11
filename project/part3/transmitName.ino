#include "MQTT.h"

void callback(char* topic, byte* payload, unsigned int length);

/**
 * if want to use IP address,
 * byte server[] = { XXX,XXX,XXX,XXX };
 * MQTT client(server, 1883, callback);
 * want to use domain name,
 * exp) iot.eclipse.org is Eclipse Open MQTT Broker: https://iot.eclipse.org/getting-started
 * MQTT client("iot.eclipse.org", 1884, callback);
 **/
 // localhost IP
byte serverIP[] = {172, 29, 80, 173};
// port number
MQTT client(serverIP, 1884, callback);

// recieve message
void callback(char* topic, byte* payload, unsigned int length) {
}


void setup() {
	//start RGB controller function
    RGB.control(true);

    // connect to the server
    client.connect("sparkclient");
}

void loop() {
    if (client.isConnected()){
        // change the color into gold when the client publish info into mqtt
        client.publish("student/id","{\"name\":\"Ruixin Huang\",\"URL\":\"http://www.andrew.cmu.edu/user/ruixinh\"}");
        RGB.color(255, 215, 0);
        delay(1000);
        // turn light off after 1 sec
        RGB.color(0,0,0);
		// sleep this thread for 4 sec
        delay(4000);
		//revoke this loop function again
        client.loop();
    }else{
        // change the color into red when disconnected
        RGB.color(255, 0, 0);
    }
}
