
package com.mycompany.coolexperimentwithwebsocket;

import java.math.BigDecimal;

public class Item {
  private String code;
  private String name;
  private String description;
  private int price;

  //contruct one item object 
  public Item(String code,String name,String description,int price) {
    this.code=code;
    this.name=name;
    this.description=description;
    this.price=price;
  }

  //get method
  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }

  public String getFormattedPrice() {
    return "$"+new BigDecimal(price).movePointLeft(2);
  }

  //rewrite the equal method for comparision
  public boolean equals(Object o) {
    if (this == o) return true;
    if (this == null) return false;
    if (!(o instanceof Item)) return false;
    return ((Item)o).getCode().equals(this.code);
  }
}

