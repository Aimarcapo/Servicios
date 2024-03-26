package questions;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        final int port = 12345;
        Scanner in = new Scanner(System.in);
        InetAddress serverAddress = InetAddress.getLocalHost();

        Socket socket = new Socket(serverAddress, port);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(outputStream, true);

        int round = 0;

        while (true) {
            String mensaje=reader.readLine();
            String[]mensajes=mensaje.split(";");
            for(String message :mensajes ){
                System.out.println(message);
            }
            System.out.println("Enter the number for the option you want to choose");
            int guess = in.nextInt();
            writer.println(guess);
          
        }
    }
}
