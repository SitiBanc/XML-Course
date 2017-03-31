import java.rmi.*;
import javax.xml.rpc.*;

import NET.webserviceX.www.*;

import javax.swing.*;

public class NetStock {
  public static void main(String[] args) throws RemoteException, 
                                                ServiceException {
    StockQuote service = new StockQuoteLocator();
    StockQuoteSoap call = service.getStockQuoteSoap();

    // �I�s getQuote()
    String input = JOptionPane.showInputDialog("�п�J�Ѳ��W��\neg. GOOG, IBM, etc.");
    System.out.println(call.getQuote(input));
  }
}