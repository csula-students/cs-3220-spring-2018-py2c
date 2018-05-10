package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class authentication_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\t\t<html lang=\"en\">\r\n");
      out.write("\t\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>Incremental game framework Login</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../app.css\">\r\n");
      out.write("\t\t</head>\r\n");
      out.write("\r\n");
      out.write("\t\t<body class=\"width-constraint\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t<h1>Incremental game framework login</h1>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<main>\r\n");
      out.write("\t\t<form class=\"card\" method=\"POST\">\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t<label for=\"name\">Username:</label>\r\n");
      out.write("\t\t<input type=\"text\" name = \"username\" id=\"name\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t<label for=\"password\">Password: </label><br>\r\n");
      out.write("\t\t<input type=\"password\" name=\"password\" id=\"pins\"><br>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"actions\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Log in\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</main>\r\n");
      out.write("\t\t</body>\r\n");
      out.write("\t\t</html>");
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
