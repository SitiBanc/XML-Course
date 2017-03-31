/* 參考 Ch10_3_1.java 修改 */
import javax.xml.parsers.*;
import org.xml.sax.*;  
import org.w3c.dom.*;
import java.io.*;
public class Ch10_3_1 {
   static Document document; // 宣告XML文件
   public static void main(String[] args) {
     String filename = "Books.xml";
     DocumentBuilderFactory dbf = 
               DocumentBuilderFactory.newInstance();
     //dbf.setIgnoringElementContentWhitespace(true); 會使喚行成為text node，變成mix content
     try {
       DocumentBuilder db = dbf.newDocumentBuilder();
       // 讀入XML文件
       document = db.parse(new File(filename));

       // Document 也是 Node 的一種
       System.out.println(getID(document));

       // 取得文件的子節點
       Node child = (Node)document.getFirstChild();
       // 取得這一層的所有節點
       for ( ; child != null; 
               child = child.getNextSibling() ) { 
         System.out.println(getID(child));
         pChild(child, 0);
       }
     } catch(SAXException se) {
       Exception  e = se; // 剖析過程錯誤
       if ( se.getException() != null )
         e = se.getException();
       e.printStackTrace();
     } catch(ParserConfigurationException pe) {
       pe.printStackTrace();// 剖析器設定錯誤
     } catch(IOException ie) {
       ie.printStackTrace();// 檔案處理錯誤
     }
   }

   private static String getID(Node n) {
     int type = n.getNodeType();
     switch(type) {
       case 1: return "元素：" + n.getNodeName();
       case 3: return "內容：" + n.getNodeValue().trim();
       case 4: return "CDATA Section：" + n.getNodeValue();
       case 6: return "實體名稱：" + n.getNodeName();
       case 8: return "註解：" + n.getNodeValue();
       case 9: return "Document：" + n.getNodeName();
       case 10: return "DOCTYPE：" + ((DocumentType) n).getSystemId();
       default: return "尚未定義：" + type;
     }
   }

   // 顯示子節點的遞迴方法
   private static void pChild(Node temp,int pos) {
     if ( temp.hasChildNodes() ) {
       NodeList nodes = temp.getChildNodes();
       // 取得所有子節點
       for (int i=0; i < nodes.getLength(); i++) {
         int type = nodes.item(i).getNodeType();
         printIndent(pos);
         System.out.println(getID(nodes.item(i)));
         if(type == Node.ELEMENT_NODE) {
           pChild(nodes.item(i), pos+1);
         } 
       }       
     }
   } 
   // 顯示縮排所需的字元
   private static void printIndent(int num) {
     System.out.print("  +");
     for (int i=0; i<=num; i++) System.out.print("-");
   }
}