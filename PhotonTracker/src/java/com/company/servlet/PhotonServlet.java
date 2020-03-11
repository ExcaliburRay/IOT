package com.company.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ray
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.*;

public class PhotonServlet extends HttpServlet {

  static Photon photon = new Photon();
  //define the format of date
  SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd h:m:s");
  Date datePhoton;
  Date dateWeb;
  String timePhoton;
  String timeWeb;
  Calendar calendarWeb;
  Calendar calendarPhoton;
  String timeStamp;
  long photonTime;
  long webTime;
  long timeDiff = 0;
  String[] week = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
  String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException {
    
    String action = req.getParameter("action");
    String photonid = req.getParameter("Photon_ID");
    String photonState = "";
    //determine where the signal come from
    if(action == null){
        //signal comes from photon
        datePhoton = new Date();
        photon.setId(photonid);
        timePhoton = timeFormat.format(datePhoton);
        calendarPhoton = Calendar.getInstance();
        calendarPhoton.setTime(datePhoton);
        photonTime = calendarPhoton.getTimeInMillis();
        //construct the format of time in need
        timeStamp = week[calendarPhoton.get(Calendar.DAY_OF_WEEK)-1]+" "+
                    month[calendarPhoton.get(Calendar.MONTH)]+" "+
                    calendarPhoton.get(Calendar.DAY_OF_MONTH)+" "+
                    calendarPhoton.get(Calendar.HOUR_OF_DAY)+":"+
                    calendarPhoton.get(Calendar.MINUTE)+":"+
                    calendarPhoton.get(Calendar.SECOND)+" EDT "+
                    calendarPhoton.get(Calendar.YEAR);
    }else{
        //signal comes from web
        dateWeb = new Date();
        timeWeb = timeFormat.format(dateWeb);
        calendarWeb = Calendar.getInstance();
        calendarWeb.setTime(dateWeb);
        webTime = calendarWeb.getTimeInMillis();
    }
        //calculate the time differences
        timeDiff = (webTime-photonTime)/1000;
        if(timeDiff>20){
            photonState = timeDiff+" seconds ago, suspected failure";
        }else{
            photonState = timeDiff+" seconds ago";
        }     
        //sent info as req
        photon.setTime(photonState);
        photon.setLastHeartBeat(timeStamp);
        String photonXML = photon.toXML();
        res.setContentType("text/xml");
        res.getWriter().write(photonXML); 
        System.out.println(photonXML);   
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException {
    // Bounce to post, for debugging use
    // Hit this servlet directly from the browser to see XML
    doPost(req,res);
  }


}
