package developerworks.ajax.store;

import java.math.BigDecimal;
import java.util.*;

/**
 * A very simple shopping Cart
 */
public class Cart {

  private HashMap<Item,Integer> contents;

  /**
   * Creates a new Cart instance
   */
  public Cart() {
    contents = new HashMap<Item,Integer>();
  }

  /**
   * Adds a named item to the cart
   * @param itemName The name of the item to add to the cart
   */
  public void addItem(String itemCode) {

    Catalog catalog = new Catalog();

    if (catalog.containsItem(itemCode)) {
      Item item = catalog.getItem(itemCode);

    // check the cart whether have this product, if it already has
    // increase the quantity of it
    //if not,create one new product in this cart
      int newQuantity = 1;
      if (contents.containsKey(item)) {
        Integer currentQuantity = contents.get(item);
        newQuantity += currentQuantity.intValue();
      }

      contents.put(item, new Integer(newQuantity));
    }
  }

  /**
   * Removes the named item from the cart
   * @param itemName Name of item to remove
   */
  public void removeItems(String itemCode) {

    Catalog catalog = new Catalog();

    //check the cart whether it has item
    //if it has, decrease its quantity
    //if quantity equal to 0, remove it
    if (catalog.containsItem(itemCode)) {
      Item item = catalog.getItem(itemCode);

      int newQuantity = 0;
      if (contents.containsKey(item)) {
        Integer currentQuantity = contents.get(item);
        newQuantity = currentQuantity-1;
      }
      
      if (newQuantity >0)
        contents.put(item, new Integer(newQuantity));
      else contents.remove(item);
    }
  }

  /**
   * @return XML representation of cart contents
   */
  public String toXml() {
    StringBuffer xml = new StringBuffer();
    xml.append("<?xml version=\"1.0\"?>\n");
    xml.append("<cart generated=\""+System.currentTimeMillis()+"\" total=\""+getCartTotal()+"\">\n");
    //build one iterator to add the item info into item object,add child node into father node
    for (Iterator<Item> I = contents.keySet().iterator() ; I.hasNext() ; ) {
      Item item = I.next();
      int itemQuantity = contents.get(item).intValue();

      xml.append("<item code=\""+item.getCode()+"\">\n");
      xml.append("<name>");
      xml.append(item.getName());
      xml.append("</name>\n");
      xml.append("<quantity>");
      xml.append(itemQuantity);
      xml.append("</quantity>\n");
      xml.append("</item>\n");
    }
    
    xml.append("</cart>\n");
    return xml.toString();
  }

  private String getCartTotal() {
    int total = 0;
    //obtain the total price of cart by calculating the product of price and quantity
    for (Iterator<Item> I = contents.keySet().iterator() ; I.hasNext() ; ) {
      Item item = I.next();
      int itemQuantity = contents.get(item).intValue();

      total += (item.getPrice() * itemQuantity);
    }

    return "$"+new BigDecimal(total).movePointLeft(2);
  }
}
