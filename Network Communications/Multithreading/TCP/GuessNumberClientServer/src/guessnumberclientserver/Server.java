package guessnumberclientserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

    private static boolean haAcertado;

    public static void main(String[] args) throws IOException {
        final int port = 12345;
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("Server is waiting for a connection on " + localHost.getHostAddress() + ":" + port);
        ServerSocket serverSocket = new ServerSocket(port, 4);
        Random rand = new Random();

        while (true) {
            int rand_int = rand.nextInt(1, 10);
            System.out.println("Target number: " + rand_int);

            ClientHandler[] workers = new ClientHandler[4];
            for (int i = 0; i < 4; i++) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, rand_int);
                clientHandler.start();
                workers[i] = clientHandler;
            }

            int round = 0;
            boolean todosResponden = false;

            while (true) {
                round++;
                for (int i = 0; i < workers.length; i++) {
                    workers[i].setRound(round);
                    todosResponden = false;  // Reset flag for each client
                }

                // Wait for responses from all clients
                while (!todosResponden) {
                    todosResponden = true;

                    for (int i = 0; i < workers.length; i++) {
                        if (!workers[i].haRespondido()) {
                            todosResponden = false;
                            break;
                        }
                    }
                }

                // Check if someone has guessed correctly
                if (haAcertado) {
                    break;
                }
            }

            // Notify clients that someone has guessed correctly
            for (int i = 0; i < workers.length; i++) {
                workers[i].setAlguienHaAcertado(true);
            }
        }
    }
}
