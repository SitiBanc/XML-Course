import java.rmi.*;
import javax.xml.rpc.*;

import net.webservicex.www.*;

public class NetWhois {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    // �Ъ`�N���e�ϥΪ��W�h�������P�A����n���覡�O�h�ݤ@�U
    // proxy ���O����l�X
    Whois service = new WhoisLocator();
    WhoisSoap call = service.getwhoisSoap();

    // �I�s whois()
    System.out.println(call.getWhoIS("www.nchu.edu.tw"));
  }
}