<%@page contentType="text/html" pageEncoding="Big5" import="java.lang.*,java.util.*,javax.xml.parsers.*,org.xml.sax.*,org.w3c.dom.*,java.io.*, javax.xml.transform.stream.*,javax.xml.transform.*" %>

<%
   String xsltData = "Books.xslt";
   String xmlFile = "Books.xml";
   File xml = new File(getServletContext().getRealPath("/")+"/"+xmlFile);
   File xslt = new File(getServletContext().getRealPath("/")+"/"+xsltData);
      // �إ�TransformerFactory����
      TransformerFactory tff = TransformerFactory.newInstance();
      // �إ�Transformer����
      Transformer tf = tff.newTransformer(new StreamSource(xsltData));
      // �ഫXML
	  tf.transform(new StreamSource(xmlFile),new StreamResult(out));
%>