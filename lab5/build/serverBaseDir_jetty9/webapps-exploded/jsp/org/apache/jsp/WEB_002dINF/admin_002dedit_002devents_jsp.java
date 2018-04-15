package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002dedit_002devents_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("    <title>Incremental game framework - game information</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../app.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class =\"width-constraint\">\r\n");
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("\r\n");
      out.write("        <h1>Incremental game framework</h1>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t\t<div class=\"row-container\">\r\n");
      out.write("\r\n");
      out.write("            <form class=\"fill card\" method= \"POST\">\r\n");
      out.write("    \r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("    \r\n");
      out.write("                    <label for=\"name\">Event Name</label>\r\n");
      out.write("    \r\n");
      out.write("                    <input type=\"text\" id=\"names\" name =\"name\">\r\n");
      out.write("    \r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("    \r\n");
      out.write("                    <label for=\"description\">Event Description</label>\r\n");
      out.write("    \r\n");
      out.write("                    <textarea id=\"description\"name =\"descTextArea\" ></textarea>\r\n");
      out.write("    \r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("    \r\n");
      out.write("                    <label for=\"trigger_at\">Trigger at</label>\r\n");
      out.write("    \r\n");
      out.write("                    <input type=\"number\" id=\"trigger_at\" name =\"triggerInput\">\r\n");
      out.write("    \r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("                <div class=\"actions\">\r\n");
      out.write("    \r\n");
      out.write("                    <button>Save</button>\r\n");
      out.write("    \r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("            </form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</html>\r\n");
      out.write("\t\t");
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
