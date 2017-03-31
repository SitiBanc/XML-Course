import java.rmi.*;
import javax.xml.rpc.*;

import com.cdyne.ws.WeatherWS.*;

import javax.swing.*;

public class NetWeather {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    Weather service = new WeatherLocator();
    WeatherSoap call = service.getWeatherSoap();

    // �I�s GetCityWeatherByZIP()
    String input = JOptionPane.showInputDialog("�п�J ZIP Code\neg. 94102, etc.");
    WeatherReturn w = call.getCityWeatherByZIP(input);

    if(w.isSuccess()) {
      System.out.println("�{�W�G" + w.getState());
      System.out.println("�����G" + w.getCity());
      System.out.println("��šG" + w.getTemperature());
      System.out.println("��סG" + w.getRelativeHumidity());
      System.out.println("�䥦�G" + w.getRemarks());
    } else {
      System.out.println("���~�T���G" + w.getResponseText());
    }
  }
}