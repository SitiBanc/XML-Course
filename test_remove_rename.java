import javax.xml.parsers.*;
import org.xml.sax.*;  
import java.io.*;
import org.w3c.dom.*;
public class test_remove_rename {
   static Document document; 
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

      System.out.println("�إߪ�XML���: ");
      printXML(root);
	  
	  //code��W��isbn
	  document.renameNode(node,node.getNamespaceURI(),"ISBN");
	  System.out.println("\n��W�᪺XML���: ");
      printXML(root);
	  
	  //��code(isbn)���e
	  Text tnode = (Text) node.getFirstChild();
	  tnode.replaceWholeText("P787");
	  System.out.println("��text���e�᪺XML���: ");
      printXML(root);
	  
	  //��code(isbn)�ݩ�instock��stock
	  node.setAttribute("stock")

      // �R��author����
      root.removeChild((Element) root.getElementsByTagName("author").item(0));
      // �R��code�ݩ�instock
      Element del = (Element) root.getFirstChild();
      del.removeAttribute("instock");
      System.out.println("\n�R���᪺XML���: ");
      printXML(root);
   }
   // ���XML���
   private static void printXML(Node root) {
      System.out.println("�ڤ���: "+root.getNodeName());
      NodeList nodes = root.getChildNodes();
      // ���o�Ҧ����l�`�I
      for ( int i=0; i < nodes.getLength(); i++ ) {
        // �����M��r�`�I
        System.out.print("����: " + nodes.item(i).getNodeName());
        System.out.println("/"+nodes.item(i).getFirstChild().getNodeValue());
        // ��ܫ��w�������ݩʭ�
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
