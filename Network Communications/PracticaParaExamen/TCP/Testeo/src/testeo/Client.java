package testeo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // Define the server address and por
        final String serverAddress = "192.168.1.132";
        final int port = 12345;
int galderaKopurua = 3;

        try (Socket socket = new Socket(serverAddress, port)) { //Konexioa sortu
            
            //TCPrako idazketa- eta irakurketa-kanalak sortu
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            //Ariketaren kodigoa
            for(int i = galderaKopurua; i >= 1; i--) {
                //Zerbitzariak bidaltzen duen mezua prozesatu
                String mezua = reader.readLine();
                String[] lerroak = mezua.split("xx");
                for (String lerroa : lerroak) {
                    System.out.println(lerroa);
                }

                //Erabiltzailearen datuak teklatu bidez hartu eta zerbitzariari bidali
                Scanner sc = new Scanner(System.in);
                System.out.print("Zure erantzuna (a/b/c): ");
                String aukera = sc.next().toLowerCase();
                writer.println(aukera);
            }
            
            String mezua = reader.readLine();
            String[] lerroak = mezua.split("xx");
            for (String lerroa : lerroak) {
                System.out.println(lerroa);
            }
        } catch (Exception e) {
        }
    }
}
