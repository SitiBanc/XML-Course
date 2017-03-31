/* �Ѧ� Ch10_3_1.java �ק� */
import javax.xml.parsers.*;
import org.xml.sax.*;  
import org.w3c.dom.*;
import java.io.*;
public class Ch10_3_1 {
   static Document document; // �ŧiXML���
   public static void main(String[] args) {
     String filename = "Books.xml";
     DocumentBuilderFactory dbf = 
               DocumentBuilderFactory.newInstance();
     //dbf.setIgnoringElementContentWhitespace(true); �|�ϳ�榨��text node�A�ܦ�mix content
     try {
       DocumentBuilder db = dbf.newDocumentBuilder();
       // Ū�JXML���
       document = db.parse(new File(filename));

       // Document �]�O Node ���@��
       System.out.println(getID(document));

       // ���o��󪺤l�`�I
       Node child = (Node)document.getFirstChild();
       // ���o�o�@�h���Ҧ��`�I
       for ( ; child != null; 
               child = child.getNextSibling() ) { 
         System.out.println(getID(child));
         pChild(child, 0);
       }
     } catch(SAXException se) {
       Exception  e = se; // ��R�L�{���~
       if ( se.getException() != null )
         e = se.getException();
       e.printStackTrace();
     } catch(ParserConfigurationException pe) {
       pe.printStackTrace();// ��R���]�w���~
     } catch(IOException ie) {
       ie.printStackTrace();// �ɮ׳B�z���~
     }
   }

   private static String getID(Node n) {
     int type = n.getNodeType();
     switch(type) {
       case 1: return "�����G" + n.getNodeName();
       case 3: return "���e�G" + n.getNodeValue().trim();
       case 4: return "CDATA Section�G" + n.getNodeValue();
       case 6: return "����W�١G" + n.getNodeName();
       case 8: return "���ѡG" + n.getNodeValue();
       case 9: return "Document�G" + n.getNodeName();
       case 10: return "DOCTYPE�G" + ((DocumentType) n).getSystemId();
       default: return "�|���w�q�G" + type;
     }
   }

   // ��ܤl�`�I�����j��k
   private static void pChild(Node temp,int pos) {
     if ( temp.hasChildNodes() ) {
       NodeList nodes = temp.getChildNodes();
       // ���o�Ҧ��l�`�I
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
   // ����Y�Ʃһݪ��r��
   private static void printIndent(int num) {
     System.out.print("  +");
     for (int i=0; i<=num; i++) System.out.print("-");
   }
}