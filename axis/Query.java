import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import javax.xml.rpc.ParameterMode;

public class Query {
  public static void main(String[] args) throws Exception {
    // �ڭ̥������D�n�s�������I�{������A�b�o�ӽd�Ҥ��A
    // URL: http://localhost:8080/axis/TimeService.jws �o�ӵ{��
    String host = "http://localhost:8080";
    String servicepath = "/axis/TimeService.jws";
    String endpoint = host + servicepath;

    String ret = null;

    // Service ����N��@�ӻ��ݪ��A�ȡA�Y web service
    Service service = new Service();

    // ���ݪA�Ȫ��I�s�O�g�Ѥ@�� Call ������A���󪺧Φ��覡
    // �N�O�� service ����Ӳ���
    Call call = (Call) service.createCall();

    // �}�l�I�s�H�e�A���]�w�s�����A�ȰT��
    call.setTargetEndpointAddress(new java.net.URL (endpoint));

    // �A�]�w TimeService.jws ���A�ڭ̩һݭn�I�s�� API�A�b�o��
    // �d�Ҥ��A�N�O getTime() �o�Ӥ�k
    call.setOperationName("getTime");

    // �w�q�^�Ǫ���ƫ��A�C���A���w�q�� XML Schema�A�b
    // �o�ӽd�ҡA�^�Ǫ���ƫ��A���r��
    call.setReturnType(XMLType.XSD_STRING);

    // �u�����I�s���ݪ��A�ȡC�ѩ�èS���ǻ��Ѽƨ컷�ݡA
    // �]���� null�C�^�Ǫ����G�A�|��� ret ���C
    ret = (String) call.invoke((Object[])null);

    System.out.println("Got result : " + ret);
  }
}