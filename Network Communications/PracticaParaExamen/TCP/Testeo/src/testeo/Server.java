import java.io.*;
import java.net.*;
import java.util.Scanner;
import testeo.ClientHandler;

public class Server {
    public static void main(String[] args) throws IOException {
         int port = 12345;
        ServerSocket server = new ServerSocket(port);

        //Bezero kopuruaren limitea eskatu
        Scanner in = new Scanner(System.in);
        System.out.print("Bezeroen konexio limitea: ");
        int konexioKopurua = in.nextInt();
        int counter = 0;

        //Zerbitzaria bezeroen zain jarri eta bezeroen konexioak onartu. Konexio bakoitzeko, hari bat sortu
        while(counter < konexioKopurua) {
            Socket client = server.accept();
            ClientHandler thread = new ClientHandler(client);
            thread.start();
            counter++;
        }
    }
}
