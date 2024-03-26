package multiplechoice;

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
        String galderak="Which of the following is a connection-oriented transport protocol? a) TCP b) UDP c) IP;" +
"What type of applications benefit most from the UDP protocol? a) File transfer b) Video conferencing and voice transmission c) Web browsing;" +
"What is the function of the \"Acknowledgment\" (ACK) field in the TCP header? a) Confirming data delivery b) Establishing the initial connection c) Managing routing;" +
"Which of the following is a connectionless transport protocol? a) TCP b) UDP c) FTP;" +
"What type of service does TCP offer compared to UDP? a) Unreliable service b) Reliable and connection-oriented service c) Broadcast-oriented service;";
            ArrayList<String>erantzunak=new ArrayList<>();
            erantzunak.add("a");
        erantzunak.add("b");
        erantzunak.add("a");
        erantzunak.add("b");
        erantzunak.add("b");
        try {
            
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
ArrayList<String> erantzunTotalak=new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
String []separado=galderak.split(";");

            for(String mensaje:separado){
                writer.println(mensaje);
               String respuesta=reader.readLine();
               erantzunTotalak.add(respuesta);
            }
              int puntos=0;
            for(int i=0;i<5;i++){
                if(erantzunak.get(i).equals(erantzunTotalak.get(i))){
                    puntos++;
                }
            }
          String   emaitzaTestua = "Asmatutako erantzunen kopurua: " + puntos + " ";
            if(puntos > erantzunak.size()/2){
                emaitzaTestua += "GAINDITUTA!";
            } else {
                emaitzaTestua += "EZ GAINDITUTA!";
            }
            writer.println(emaitzaTestua);


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
