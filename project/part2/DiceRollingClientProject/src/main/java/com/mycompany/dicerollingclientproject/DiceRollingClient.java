/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dicerollingclientproject;

/**
 *
 * @author Ray
 */
import java.util.Random;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
public class DiceRollingClient {
    public static void main(String[] args) throws InterruptedException, MqttException{
        String topic = "DiceRolling";
        //define the local host address and clientID
        String broker = "tcp://localhost:1884";
        String clientId = "DiceRoller";
        Random rd = new Random();
        int numberOne;
        int numberTwo;
        MqttClient client = new MqttClient(broker, clientId);
        //set cleanSession is ture, when user connect to client, it wil remove all old subscribers
        MqttConnectOptions mqtt = new MqttConnectOptions();
        mqtt.setCleanSession(true);
        //connect client with this session
        client.connect(mqtt);
        while(true){
            //generate random int number from 1 to 6
            numberOne = rd.nextInt(6)+1;
            numberTwo = rd.nextInt(6)+1;
            String information = "{\"Die1\": "+numberOne+", \"Die2\": "+numberTwo+"}";
            System.out.println(information);
            //send message in qos 1
            MqttMessage message = new MqttMessage(information.getBytes());
            message.setQos(1);
            //publish the information into MQTT broker
            client.publish(topic, message);
            //send message 1 seconds per time
            Thread.sleep(1000);
        }
        
    }
}
