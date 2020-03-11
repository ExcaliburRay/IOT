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
  public String toJson() {
   StringBuffer json = new StringBuffer();
   //json
   json.append("{\n");
   json.append("\"cart\": {\n");
   json.append("\"item\": [\n");
   for (Iterator<Item> I = contents.keySet().iterator() ; I.hasNext() ; ) {
      Item item = I.next();
      int itemQuantity = contents.get(item).intValue();
      json.append("{\n");
      json.append("\"name\":");
      json.append("\"");
      json.append(item.getName());
      json.append("\"");
      json.append(",\n");
      json.append("\"quantity\":");
      json.append("\"");
      json.append(itemQuantity);
      json.append("\"");
      json.append(",\n");
      json.append("\"__text\": ");
      json.append("\"");
      json.append(item.getCode());
      json.append("\"");
      json.append("\n");
      if(I.hasNext()){
        json.append("},\n");
      }else json.append("}\n");
   }
   json.append("],\n");
   json.append("\"generated\":");
   json.append("\"");
   json.append(System.currentTimeMillis());
   json.append("\"");
   json.append(",\n");
   json.append("\"total\":");
   json.append("\"");
   json.append(getCartTotal());
   json.append("\"");
   json.append("}\n");
   json.append("}");
   return json.toString();
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
