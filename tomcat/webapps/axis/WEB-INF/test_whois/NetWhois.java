import java.rmi.*;
import javax.xml.rpc.*;

import net.webservicex.www.*;

public class NetWhois {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    // 請注意之前使用的規則略有不同，比較好的方式是去看一下
    // proxy 類別的原始碼
    Whois service = new WhoisLocator();
    WhoisSoap call = service.getwhoisSoap();

    // 呼叫 whois()
    System.out.println(call.getWhoIS("www.nchu.edu.tw"));
  }
}