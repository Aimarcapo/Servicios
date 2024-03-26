package exercise2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException {
       // Define the server address and por
        InetAddress serverAddress = InetAddress.getLocalHost();
        final int port = 12345;

        // Try to connect to the server
        try (Socket socket = new Socket(serverAddress, port)) {
            // Create input and output streams for the server
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
Scanner in=new Scanner(System.in);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            System.out.println("Numero");
            // Send a random number to the server
            int numero=in.nextInt();
            int number = (int)(Math.random()*100);
            dataOutputStream.writeInt(numero);
            //dataOutputStream.flush();
              int respuesta = dataInputStream.readInt();
              System.out.println(respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
