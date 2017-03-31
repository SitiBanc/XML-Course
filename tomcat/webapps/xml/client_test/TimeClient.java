import java.rmi.*;
import javax.xml.rpc.*;
import localhost.axis.services.TimeService.*;

public class TimeClient {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    // �I�s�A�Ȫ��覡�A�@�������ӨB�J�C�����A����l�Ƥ@�� Service Locator
    // ����A�A�ѳo�Ӫ��� get ��k�A���o�N���ݪA�Ȫ� stub�C
    QueryTimeService service = new QueryTimeServiceLocator();
    QueryTime call = service.getTimeService();
    
    // �ѩ� stub �b�����W�N���ݪA�Ȫ�����A�ҥH�N�i�H����
    // �ϥθӪ��� get ��k�Ӱ����k getTime()
    String result = call.getTime();

    System.out.println(result);
  }
}