import java.rmi.*;
import javax.xml.rpc.*;

import com.cdyne.ws.WeatherWS.*;

import javax.swing.*;

public class NetWeather {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    Weather service = new WeatherLocator();
    WeatherSoap call = service.getWeatherSoap();

    // 呼叫 GetCityWeatherByZIP()
    String input = JOptionPane.showInputDialog("請輸入 ZIP Code\neg. 94102, etc.");
    WeatherReturn w = call.getCityWeatherByZIP(input);

    if(w.isSuccess()) {
      System.out.println("州名：" + w.getState());
      System.out.println("城市：" + w.getCity());
      System.out.println("氣溫：" + w.getTemperature());
      System.out.println("濕度：" + w.getRelativeHumidity());
      System.out.println("其它：" + w.getRemarks());
    } else {
      System.out.println("錯誤訊息：" + w.getResponseText());
    }
  }
}