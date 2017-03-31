import javax.xml.parsers.*;
import org.xml.sax.*;  
import java.io.*;
import org.w3c.dom.*;
public class test_remove_rename {
   static Document document; 
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

      System.out.println("建立的XML文件: ");
      printXML(root);
	  
	  //code改名為isbn
	  document.renameNode(node,node.getNamespaceURI(),"ISBN");
	  System.out.println("\n改名後的XML文件: ");
      printXML(root);
	  
	  //改code(isbn)內容
	  Text tnode = (Text) node.getFirstChild();
	  tnode.replaceWholeText("P787");
	  System.out.println("改text內容後的XML文件: ");
      printXML(root);
	  
	  //改code(isbn)屬性instock為stock
	  node.setAttribute("stock")

      // 刪除author元素
      root.removeChild((Element) root.getElementsByTagName("author").item(0));
      // 刪除code屬性instock
      Element del = (Element) root.getFirstChild();
      del.removeAttribute("instock");
      System.out.println("\n刪除後的XML文件: ");
      printXML(root);
   }
   // 顯示XML文件
   private static void printXML(Node root) {
      System.out.println("根元素: "+root.getNodeName());
      NodeList nodes = root.getChildNodes();
      // 取得所有的子節點
      for ( int i=0; i < nodes.getLength(); i++ ) {
        // 元素和文字節點
        System.out.print("元素: " + nodes.item(i).getNodeName());
        System.out.println("/"+nodes.item(i).getFirstChild().getNodeValue());
        // 顯示指定元素的屬性值
        if (nodes.item(i).hasAttributes()) {
          NamedNodeMap atts = nodes.item(i).getAttributes();
          for (int j = 0; j < atts.getLength(); j++) {
            Node att = atts.item(j);
            System.out.print(" +-- "+att.getNodeName()); 
            System.out.println("/"+att.getNodeValue());
          }        
        }
      }
   }
}
