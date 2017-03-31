import java.rmi.*;
import javax.xml.rpc.*;

import NET.webserviceX.www.*;

import javax.swing.*;

public class NetStock {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    StockQuote service = new StockQuoteLocator();
    StockQuoteSoap call = service.getStockQuoteSoap();

    // 呼叫 getQuote()
    String input = JOptionPane.showInputDialog("請輸入股票名稱\neg. GOOG, IBM, etc.");
    System.out.println(call.getQuote(input));
  }
}