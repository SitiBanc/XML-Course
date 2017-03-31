import org.apache.axis.client.AdminClient;

public class ListWSDD {
  public static void main(String[] args) throws Exception {
    String host = "http://localhost:8080";
    String servicepath = "/axis/services";
    String endpoint = host + servicepath;

    AdminClient ac = new AdminClient();
    ac.setTargetEndpointAddress(new java.net.URL (endpoint));
    System.out.println(ac.list());
  }
}