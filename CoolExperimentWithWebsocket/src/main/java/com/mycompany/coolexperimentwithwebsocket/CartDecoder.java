/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coolexperimentwithwebsocket;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Ray
 */
public class CartDecoder implements Decoder.Text<Cart>{

    static Cart cart = new Cart();
    @Override
    public Cart decode(String json) throws DecodeException {
        System.out.println("decoding: "+json);      
        JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
        String action = jsonObject.getString("action");
        String item = jsonObject.getString("item"); 
        //make a judge statement and execuate operations respectively
        if ((action != null)&&(item != null)) {
          if ("addToCart".equals(action)) {
            cart.addItem(jsonObject);
          } else{
            cart.removeItems(jsonObject);
          }
        }    
        return cart;
    }

    @Override
    public boolean willDecode(String string) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
    
}
