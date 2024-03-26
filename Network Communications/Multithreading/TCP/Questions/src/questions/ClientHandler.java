package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    private Socket clientSocket;
    

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        
    }

   

    public void run() {
        String galderak="How to reset my account password?;" +
"How can I connect my device to a Wi-Fi network?;" +
"How to troubleshoot printing issues on my printer?;" +
"What steps should I follow to update my operating system software?;" +
"How can I back up my important files?;" +
"Exit;";
            ArrayList<String>erantzunak=new ArrayList<>();
            erantzunak.add("Zure pasahitza berrezarri dezakezu, saioa hasteko orriko berreskuratze-urratsak jarraituz.");
        erantzunak.add("Jo ezazu Wi-Fi konfiguraziora zure gailuan, aukeratu erabilgarri dagoen sarea eta sartu pasahitza, beharrezkoa bada.");
        erantzunak.add("Egiaztatu inprimagailuaren konexioa, tinta-mailak/papera, eta berrabiarazi inprimagailua eta ordenagailua, beharrezkoa bada.");
        erantzunak.add("Bisitatu sistema eragilearen konfigurazioa, bilatu 'Eguneratzeak' eta jarraitu eskuragarri dauden eguneratzeak bilatzeko eta aplikatzeko jarraibideak.");
        erantzunak.add("Zure fitxategi garrantzitsuak babestu ditzakezu hodeiko biltegiratze-zerbitzuak edo kanpoko biltegiratze-gailuak (USB) erabiliz.");
        try {
            
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            while (true) {
              writer.println(galderak);
              String erantzuna=reader.readLine();
              switch(erantzuna){
                  case("1"):
                      writer.println(erantzunak.get(0));
                      break;
                       case("2"):
                      writer.println(erantzunak.get(1));
                      break;
                       case("3"):
                      writer.println(erantzunak.get(2));
                      break;
                      case("4"):
                          writer.println(erantzunak.get(3));
                          break;
                      case("5"):
                           writer.println(erantzunak.get(4));
                          break;
                      case("6"):
                          clientSocket.close();
                          break;
              }
              
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
