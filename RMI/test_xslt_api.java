import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;
public class test_xslt_api {
   public test_xslt_api() {}

   // �إ�HTML���
   public void buildHTML(String xmlData,
     String htmlFile, String xsltFile) throws Exception {
      // �إ�TransformerFactory����
      TransformerFactory tff = TransformerFactory.newInstance();
      // �إ�Transformer����
      Transformer tf = tff.newTransformer(new StreamSource(xsltFile));
      // �ഫXML
      tf.transform(new StreamSource(new StringReader(xmlData)), 
                   new StreamResult(new FileOutputStream(htmlFile)));
      System.out.println("XSLT�ഫ���\:"+htmlFile);
   }
   // �D�{��
   public static void main(String[] args) throws Exception {  
      String htmlFile = "test_jsp_xslt.html";
      String xsltFile = "Books.xslt";
      String xmlFile = "Books.xml";
      test_xslt_api app = new test_xslt_api();
      BufferedReader br = new BufferedReader(new FileReader(xmlFile));
      String strLine;
      StringBuffer strBuffer = new StringBuffer();

      // Ū��XML��󪺤��e
      while ( (strLine = br.readLine()) != null ) {
         strBuffer.append(strLine+"\n");
      }

      // �I�s��k�إ��ഫ��X��HTML���        
      app.buildHTML(strBuffer.toString(), htmlFile, xsltFile);
    }
}