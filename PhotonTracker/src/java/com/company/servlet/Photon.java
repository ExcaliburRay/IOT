/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.servlet;

/**
 *
 * @author Ray
 */

//used to recorde object photon
public class Photon {
    private String id;
    private String time;
    private String lastHeartBeat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
   
    public String getLastHeartBeat() {
        return lastHeartBeat;
    }

    public void setLastHeartBeat(String lastHeartBeat) {
        this.lastHeartBeat = lastHeartBeat;
    }

    // parse the string info into xml format  
    public String toXML(){
        StringBuffer xml = new StringBuffer();
        xml.append("<photon>");
        xml.append("<id>");
        xml.append(this.getId());
        xml.append("</id>");
        xml.append("<time>");
        xml.append(this.getTime());
        xml.append("</time>");
        xml.append("<lastBeat>");
        xml.append(this.getLastHeartBeat());
        xml.append("</lastBeat>");
        xml.append("</photon>");
        return xml.toString();
    }
    
    
}

