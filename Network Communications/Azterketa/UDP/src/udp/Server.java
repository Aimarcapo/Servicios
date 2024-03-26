/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author aimar
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int port = 12345;
   
        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Server is listening on port " + port);
 InetAddress serverAddress = InetAddress.getByName("localhost");

    
            byte[] buffer = new byte[1024];
            while (true) {
                String zerbitzu="1.Kalkulagailua,2.Piscina,3.Ordenagailua,4.Pantaila,5.Xagua";
                
                  byte[] data = new byte[1024];
  data=zerbitzu.getBytes();
            DatagramPacket packeto = new DatagramPacket(data, data.length, serverAddress, 1);
            socket.send(packeto);
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivedPacket);
               
       
                String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
               int mensaje=Integer.parseInt(receivedMessage);
               int finala=mensaje+1;
              
                int puerto;
                String mensajeFinal="";
             switch(finala){
                 case 1:
                     serverAddress=InetAddress.getByName("192.168.72.1");
                     puerto=1234;
                  mensajeFinal="IP: "+serverAddress+" ,Puerto: "+puerto;
                   
                     
                     break;
                 case 2:
                     serverAddress=InetAddress.getByName("192.168.72.2");
                     puerto=1235;
                       mensajeFinal="IP: "+serverAddress+" ,Puerto: "+puerto;
                    
                    
                     break;
                 case 3:
                     serverAddress=InetAddress.getByName("192.168.72.3");
                     puerto=1236;
                     mensajeFinal="IP: "+serverAddress+" ,Puerto: "+puerto;
                     break;
                 case 4:
                     serverAddress=InetAddress.getByName("192.168.72.4");
                     puerto=1237;
                      mensajeFinal="IP: "+serverAddress+" ,Puerto: "+puerto;
                     break;
                 case 5:
                     serverAddress=InetAddress.getByName("192.168.72.4");
                     puerto=1237;
                      mensajeFinal="IP: "+serverAddress+" ,Puerto: "+puerto;
                     break;

                 default:
                      mensajeFinal="Errorea";
                     
             }
              buffer=mensajeFinal.getBytes();
                       DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receivedPacket.getAddress(), receivedPacket.getPort());
            socket.send(packet);
                
             
          
                //int received=Integer.parseInt(receivedMessage);

                // Process the received data, if needed
                // Respond to the client
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO code application logic here
        
    }
    
}
