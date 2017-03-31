import java.util.*;

public class Worker {
  private String name;
  private int hours;
  private Calendar birthday;

  public Worker() {
    name = "Eric Lu";
    hours = 40;
    birthday = Calendar.getInstance();
    birthday.set(1988, Calendar.JULY, 15);
  }

  public Worker(String n, int h, Calendar c) {
    setName(n);
    setHours(h);
    setBirthday(c);
  }

  public String getName() {
    return name;
  }

  public int getHours() {
    return hours;
  }

  public Calendar getBirthday() {
    return birthday;
  }

  public void setName(String n) {
    name = n;
  }

  public void setHours(int h) {
    hours = h;
  }

  public void setBirthday(Calendar d) {
    birthday = d;
  }
}