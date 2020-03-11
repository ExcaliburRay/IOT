/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temperaturesensorproject;

import java.util.Random;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Ray
 */
public class TemperatureSensor {
    public static void main(String[] args) throws InterruptedException, MqttException{
        String topic = "";
        //define the local host address and clientID
        String broker = "tcp://localhost:1884";
        String clientId = "TemperatureSensor";
        //create one MQTTClient to send infomation 
        MqttClient client = new MqttClient(broker, clientId);
        //generate random number
        Random rd = new Random();
        double temperature;
        String label;
        //set cleanSession is ture, when user connect to client, it wil remove all old subscribers
        MqttConnectOptions mqtt = new MqttConnectOptions();
        mqtt.setCleanSession(true);
        //connect client with this session
        client.connect(mqtt);
        //generate one randome number and assign the value into topics respectively
        while(true){
            temperature = rd.nextDouble()*100;
            if(temperature>=0&&temperature<=45){
                topic = "pittsburgh/temperature/coldTemps";
            }else if(temperature>80){
                topic = "pittsburgh/temperature/hotTemps";
            }else{
                topic = "pittsburgh/temperature/niceTemps";
            }
            //transfer the temperature and time info to JSON
            String information = "{\"temperature\": \""+temperature+"\", \"time\": \""+System.currentTimeMillis()/1000+"\"}";
            System.out.println(information);
            //send message in qos 1
            MqttMessage message = new MqttMessage(information.getBytes());
            message.setQos(1);
            //publish the information into MQTT broker
            client.publish(topic, message);
            //send message 5 seconds per time
            Thread.sleep(5000);
        }
    }   
}

