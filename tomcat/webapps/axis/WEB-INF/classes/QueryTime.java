import java.util.*;

public class QueryTime {
  // 經過測試，我們也可以把 d.toString() 的值以 XML 的格式回傳，
  // 例如： return "<date>" + d.toString() + "</date>"
  public String getTime() {
    Date d = new Date();
    return "當地時間 " + d.toString();
  }
}