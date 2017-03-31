import java.rmi.*;
import javax.xml.rpc.*;

import localhost.axis.services.ObjectService.*;
import DefaultNamespace.*;
import java.util.*;

public class WorkerClient {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    WorkerServiceService service = new WorkerServiceServiceLocator();
    WorkerService call = service.getObjectService();

    // 先利用 service 設定一個 Worker 物件
    Calendar c = Calendar.getInstance();
    c.set(1970, Calendar.JUNE, 22);
    Worker s = new Worker(c, 55, "John Cena"); 
    call.setWorker(s);
    
    // 再取回剛剛的 Worker 物件(???) 
    Worker w = call.getWorker();
    System.out.print(w.getName() + "\t");
    System.out.print(w.getHours() + "\t");
    c = w.getBirthday();
    System.out.println(c.get(Calendar.YEAR) + "/" +
                       (c.get(Calendar.MONTH) + 1) + "/" +
                       c.get(Calendar.DATE) + "\n");

    // 取得一個預設的 Worker[] 陣列
    Worker[] ww = call.getArray();
    for(int i=0; i < ww.length; i++) {
      System.out.print(ww[i].getName() + "\t");
      System.out.print(ww[i].getHours() + "\t");
      c = ww[i].getBirthday();
      System.out.println(c.get(Calendar.YEAR) + "/" +
                         (c.get(Calendar.MONTH) + 1) + "/" +
                         c.get(Calendar.DATE));
    }
  }
}