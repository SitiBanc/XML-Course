import java.util.*;

public class WorkerService {
  private Worker worker;

  public WorkerService() {
    worker = new Worker();
  }

  public Worker getWorker() {
    return worker;
  }

  public void setWorker(Worker w) {
    worker = w;
  }

  public Worker[] getArray() {
    Calendar c = Calendar.getInstance();
    c.set(1978, Calendar.MAY, 17);
    Worker w2 = new Worker("Dave Mentis", 60, c);
    Worker[] w = {new Worker(), w2};

    return w;
  }
}