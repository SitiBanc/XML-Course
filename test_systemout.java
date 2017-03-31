import javax.xml.parsers.*;
import org.xml.sax.*;  
import java.io.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

public class test_systemout {
   static Document document;
   // HTML 的結果由螢幕輸出
   public void buildHTML(String xmlData, String xsltFile) throws Exception {
      // 建立TransformerFactory物件
      TransformerFactory tff = TransformerFactory.newInstance();
      // 建立Transformer物件
      Transformer tf = tff.newTransformer();
	  //換行
	  tf.setOutputProperty(OutputKeys.INDENT,"yes");
      // 將Document物件印出在螢幕上
      tf.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(System.out)));
	  //tf.transform(new DOMSource(document), new StreanResult(new FileWriter()));
   }
   public static void main(String[] args) throws Exception {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      // 建立新XML文件
      document = db.newDocument();
      // 建立根元素
      Element root = document.createElement("book");
      document.appendChild(root);
      // 新增子元素code
      Element node = document.createElement("code");
      root.appendChild(node);
      node.appendChild(document.createTextNode("P761"));
      // 新增子元素title
      node = document.createElement("title");
      root.appendChild(node);
      node.appendChild(document.createTextNode("PHP 5網頁設計範例教本"));
      // 新增author元素
      Element newNode = document.createElement("author");
      root.insertBefore(newNode, root.getFirstChild());
      Node newText = document.createTextNode("陳會安");
      root.getFirstChild().appendChild(newText);
      // 新增屬性
      node=(Element)root.getFirstChild().getNextSibling();
      node.setAttribute("instock","Y");
	  
	  String xsltFile = "Books.xslt";
      String xmlFile = "Books.xml";
      test_systemout app = new test_systemout();
      BufferedReader br = new BufferedReader(new FileReader(xmlFile));
      String strLine;
      StringBuffer strBuffer = new StringBuffer();
      // 讀取XML文件的內容
      while ( (strLine = br.readLine()) != null ) {
         strBuffer.append(strLine+"\n");
      }
      // 呼叫方法建立轉換輸出的HTML文件        
      app.buildHTML(strBuffer.toString(), xsltFile);
	}
}