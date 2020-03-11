package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import developerworks.ajax.store.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"ajax1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"cart.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div style=\"float: left; width: 500px\">\n");
      out.write("<h2>Catalog</h2>\n");
      out.write("<table border=\"1\">\n");
      out.write("  <thead><th>Name</th><th>Description</th><th>Price</th><th></th></thead>\n");
      out.write("  <tbody>\n");
      out.write("  ");
      out.write(" \n");
      out.write("  ");

    for (Iterator<Item> I = new Catalog().getAllItems().iterator() ; I.hasNext() ; ) {
      Item item = I.next();
  
      out.write("\n");
      out.write("  ");
      out.write("\n");
      out.write("    <tr><td>");
      out.print( item.getName() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( item.getDescription() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( item.getFormattedPrice() );
      out.write("</td>\n");
      out.write("        <td><button onclick=\"addToCart('");
      out.print( item.getCode() );
      out.write("')\">Add to Cart</button></td>\n");
      out.write("    </tr>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("  </tbody>\n");
      out.write("</table>\n");
      out.write("<div style=\"position: absolute; top: 0px; right: 0px; width: 250px\">\n");
      out.write("<h2>Cart Contents</h2>\n");
      out.write("<ul id=\"contents\">\n");
      out.write("</ul>\n");
      out.write("Total cost: <span id=\"total\">$0.00</span>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
