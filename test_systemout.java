import javax.xml.parsers.*;
import org.xml.sax.*;  
import java.io.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

public class test_systemout {
   static Document document;
   // HTML �����G�ѿù���X
   public void buildHTML(String xmlData, String xsltFile) throws Exception {
      // �إ�TransformerFactory����
      TransformerFactory tff = TransformerFactory.newInstance();
      // �إ�Transformer����
      Transformer tf = tff.newTransformer();
	  //����
	  tf.setOutputProperty(OutputKeys.INDENT,"yes");
      // �NDocument����L�X�b�ù��W
      tf.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(System.out)));
	  //tf.transform(new DOMSource(document), new StreanResult(new FileWriter()));
   }
   public static void main(String[] args) throws Exception {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      // �إ߷sXML���
      document = db.newDocument();
      // �إ߮ڤ���
      Element root = document.createElement("book");
      document.appendChild(root);
      // �s�W�l����code
      Element node = document.createElement("code");
      root.appendChild(node);
      node.appendChild(document.createTextNode("P761"));
      // �s�W�l����title
      node = document.createElement("title");
      root.appendChild(node);
      node.appendChild(document.createTextNode("PHP 5�����]�p�d�ұХ�"));
      // �s�Wauthor����
      Element newNode = document.createElement("author");
      root.insertBefore(newNode, root.getFirstChild());
      Node newText = document.createTextNode("���|�w");
      root.getFirstChild().appendChild(newText);
      // �s�W�ݩ�
      node=(Element)root.getFirstChild().getNextSibling();
      node.setAttribute("instock","Y");
	  
	  String xsltFile = "Books.xslt";
      String xmlFile = "Books.xml";
      test_systemout app = new test_systemout();
      BufferedReader br = new BufferedReader(new FileReader(xmlFile));
      String strLine;
      StringBuffer strBuffer = new StringBuffer();
      // Ū��XML��󪺤��e
      while ( (strLine = br.readLine()) != null ) {
         strBuffer.append(strLine+"\n");
      }
      // �I�s��k�إ��ഫ��X��HTML���        
      app.buildHTML(strBuffer.toString(), xsltFile);
	}
}