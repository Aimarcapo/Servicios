/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author aimar
 */
public class ClientHandler extends Thread {

    private Socket clientSocket;
    private String izena;

    public ClientHandler(Socket clientSocket, String izena) {
        this.clientSocket = clientSocket;
        this.izena = izena;
    }

    @Override
    public void run() {
        //Erantzun zuzenak arraylist baten gorde

        //Erabiltzailearen erantzunak gordetzeko arraylista sortu
        ArrayList<String> erabiltzailearenErantzunak = new ArrayList<>();

        //Galderekin arraylist bat sortu
      ArrayList<String> galderak = new ArrayList<>();
      galderak.add("1.Espagetixx");
      galderak.add("2.Pizzaxx");
      galderak.add("3.Merluzaxx");
      galderak.add("4.Exit");
        String menua = "1.Espagetixx2.Pizzaxx3.Merluzaxx4.Exit";

        try {
            //TCPrako idazketa- eta irakurketa-kanalak sortu
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            
String[] erantzunak=menua.split("xx");
int precioa=0;
int i=0;
            //Ariketaren kodigoa
            while(true){
                writer.println(erantzunak[0]);
                writer.println(erantzunak[1]);
                  writer.println(erantzunak[2]);
                   writer.println(erantzunak[3]);
            //for(String galdera:galderak) {
                //Bezereoari galdera bidali
                
              
                
                
                //Bezeroaren mezua jaso eta gorde
                
           // }
String erantzuna = reader.readLine();
                erabiltzailearenErantzunak.add(erantzuna);
            String emaitzaTestua;
            int erantzunZuzenKopurua = 0;
        
                if (erabiltzailearenErantzunak.get(i).equals("espageti")){
                   precioa+=10;
                }
               if(erabiltzailearenErantzunak.get(i).equals("pizza")){
                     precioa+=8;
                }
                 if(erabiltzailearenErantzunak.get(i).equals("merluza")){
                     precioa+=15;
                }
                else if((erabiltzailearenErantzunak.get(i).equals("exit"))){
                     writer.println(precioa+"euro");
                    
                }
                 i++;
            //}
            //emaitzaTestua = "Asmatutako erantzunen kopurua: " + erantzunZuzenKopurua + "xx";
            //if(erantzunZuzenKopurua > erantzunZuzenak.size()/2){
                //emaitzaTestua += "GAINDITUTA!";
            //} else {
                //emaitzaTestua += "EZ GAINDITUTA!";
           // }
           // writer.println(emaitzaTestua);
            }

        } catch (Exception e) {
        }
    }

}
