import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import javax.xml.rpc.ParameterMode;

public class Query {
  public static void main(String[] args) throws Exception {
    // 我們必須知道要連結的端點程式為何，在這個範例中，
    // URL: http://localhost:8080/axis/TimeService.jws 這個程式
    String host = "http://localhost:8080";
    String servicepath = "/axis/TimeService.jws";
    String endpoint = host + servicepath;

    String ret = null;

    // Service 物件代表一個遠端的服務，即 web service
    Service service = new Service();

    // 遠端服務的呼叫是經由一個 Call 的物件，物件的形成方式
    // 就是由 service 物件來產生
    Call call = (Call) service.createCall();

    // 開始呼叫以前，先設定連結的服務訊息
    call.setTargetEndpointAddress(new java.net.URL (endpoint));

    // 再設定 TimeService.jws 中，我們所需要呼叫的 API，在這個
    // 範例中，就是 getTime() 這個方法
    call.setOperationName("getTime");

    // 定義回傳的資料型態。型態的定義為 XML Schema，在
    // 這個範例，回傳的資料型態為字串
    call.setReturnType(XMLType.XSD_STRING);

    // 真正的呼叫遠端的服務。由於並沒有傳遞參數到遠端，
    // 因此為 null。回傳的結果，會放到 ret 中。
    ret = (String) call.invoke((Object[])null);

    System.out.println("Got result : " + ret);
  }
}