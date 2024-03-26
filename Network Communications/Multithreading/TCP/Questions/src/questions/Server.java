package questions;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

    private static boolean haAcertado;

    public static void main(String[] args) throws IOException {
        //Portua definitu eta zerbitzariaren socketa sortu 
        int port = 12345;
        ServerSocket server = new ServerSocket(port);
        
        //Zerbitzaria bezeroen zain jarri eta bezeroen konexioak onartu. Konexio bakoitzeko, hari bat sortu
        while(true) {
            Socket client = server.accept();
            ClientHandler thread = new ClientHandler(client);
            thread.start();
        }
    }
}
