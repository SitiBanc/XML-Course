import java.util.*;

public class QueryTime {
  // �g�L���աA�ڭ̤]�i�H�� d.toString() ���ȥH XML ���榡�^�ǡA
  // �Ҧp�G return "<date>" + d.toString() + "</date>"
  public String getTime() {
    Date d = new Date();
    return "��a�ɶ� " + d.toString();
  }
}