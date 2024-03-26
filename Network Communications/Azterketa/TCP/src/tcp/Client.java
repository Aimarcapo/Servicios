/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author aimar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here

        //final String serverAddress = "localhost";
        final int port = 12345;
        InetAddress serverAddress = InetAddress.getLocalHost();
        try (Socket socket = new Socket(serverAddress, port)) { //Konexioa sortu

            //TCPrako idazketa- eta irakurketa-kanalak sortu
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            Scanner in = new Scanner(System.in);
            System.out.println("Zure izena?");
            String nombre=in.next();
            writer.println(nombre);
            //Ariketaren kodigoa
            boolean bukatu=false;
            int j=0;
           
            while(true){
             Scanner sc = new Scanner(System.in);
          
                //Zerbitzariak bidaltzen duen mezua prozesatu
                for(int i=0;i<=3;i++){
                       String mezua = reader.readLine();

                System.out.println(mezua);
                } 
                //Erabiltzailearen datuak teklatu bidez hartu eta zerbitzariari bidali
               do{
                   System.out.print("Zure aukera (Espageti/Pizza/Merluza/Exit): ");
                String aukera = sc.nextLine().toLowerCase();
                if(aukera.contains("exit")){
                   bukatu=true; 
                }
                writer.println(aukera);
               }while(bukatu=false);
                
                String erreakzioa=reader.readLine();
                System.out.println(erreakzioa);
                if(erreakzioa.contains("euro")){
                   //socket.close();
                }
            }
               
                  
          
      
            
            
           
          
        } catch (Exception e) {
        }

    }

}
