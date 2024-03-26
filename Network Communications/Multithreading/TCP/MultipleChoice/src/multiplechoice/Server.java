package multiplechoice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

 

    public static void main(String[] args) throws IOException {
        //Portua definitu eta zerbitzariaren socketa sortu 
        int port = 12345;
        ServerSocket server = new ServerSocket(port);
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the maximum amount of client you want:");
        int maxConnect=in.nextInt();
        int counter=0;
        //Zerbitzaria bezeroen zain jarri eta bezeroen konexioak onartu. Konexio bakoitzeko, hari bat sortu
        while(maxConnect>=counter) {
            Socket client = server.accept();
            ClientHandler thread = new ClientHandler(client);
            thread.start();
            counter++;
        }
    }
}
