import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;
public class test_xslt_api {
   public test_xslt_api() {}

   // 建立HTML文件
   public void buildHTML(String xmlData,
     String htmlFile, String xsltFile) throws Exception {
      // 建立TransformerFactory物件
      TransformerFactory tff = TransformerFactory.newInstance();
      // 建立Transformer物件
      Transformer tf = tff.newTransformer(new StreamSource(xsltFile));
      // 轉換XML
      tf.transform(new StreamSource(new StringReader(xmlData)), 
                   new StreamResult(new FileOutputStream(htmlFile)));
      System.out.println("XSLT轉換成功:"+htmlFile);
   }
   // 主程式
   public static void main(String[] args) throws Exception {  
      String htmlFile = "test_jsp_xslt.html";
      String xsltFile = "Books.xslt";
      String xmlFile = "Books.xml";
      test_xslt_api app = new test_xslt_api();
      BufferedReader br = new BufferedReader(new FileReader(xmlFile));
      String strLine;
      StringBuffer strBuffer = new StringBuffer();

      // 讀取XML文件的內容
      while ( (strLine = br.readLine()) != null ) {
         strBuffer.append(strLine+"\n");
      }

      // 呼叫方法建立轉換輸出的HTML文件        
      app.buildHTML(strBuffer.toString(), htmlFile, xsltFile);
    }
}