package multiplechoice;

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

        int galderakopurua = 5;

        try {
            for (int i = 0; i < galderakopurua; i++) {
                String mensaje = reader.readLine();
                String[] mensajes = mensaje.split(";");
                for (String message : mensajes) {
                    System.out.println(message);
                }
                System.out.println("Zure erantzuna(a/b/c):");
                String guess = in.next();
                writer.println(guess);
                
            }
String erantzuna=reader.readLine();
            System.out.println(erantzuna);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
