
package developerworks.ajax.servlet;

import developerworks.ajax.store.Cart;
import javax.servlet.http.*;

import java.util.Enumeration;

public class CartServlet extends HttpServlet {

  /**
   * Updates Cart, and outputs XML representation of contents
   */
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException {

//    obtain and print the last info of header
    Enumeration headers = req.getHeaderNames();
    while (headers.hasMoreElements()) {
      String header  =(String) headers.nextElement();
      System.out.println(header+": "+req.getHeader(header));
    }
    //obtain the request info in seession and action,item info in session
    Cart cart = getCartFromSession(req);

    String action = req.getParameter("action");
    String item = req.getParameter("item");
    
    //obtain the click action and execuate the operations respectively
    if ((action != null)&&(item != null)) {

      //execute the add and remove operations
      if ("add".equals(action)) {
        cart.addItem(item);

      } else if ("remove".equals(action)) {
        cart.removeItems(item);

      }
    }

    //set content to Json
    String cartJson = cart.toJson();
    res.setContentType("text/json");
    res.getWriter().write(cartJson);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException {
    // Bounce to post, for debugging use
    // Hit this servlet directly from the browser to see XML
    doPost(req,res);
  }

  private Cart getCartFromSession(HttpServletRequest req) {

    //Get information asynchronously
    HttpSession session = req.getSession(true);
    Cart cart = (Cart)session.getAttribute("cart");
    //add one empty cart if there is no products in the cart
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }

    return cart;
  }
}
