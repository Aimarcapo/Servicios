/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp;

/**
 *
 * @author aimar
 */
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCP {

    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 6006;//puerto remoto
        Socket socket = new Socket(Host, Puerto);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        // Ejemplo de BufferedReader y BufferedWriter
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line of text
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("Hello, server!");
            writer.newLine(); // Write a newline to indicate the end of the message
            writer.flush(); // Flush the buffer to send the data

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ejemplo de DataInputStream y DataOutputStream
        try {

            DataInputStream dataInput = new DataInputStream(inputStream);
            int intValue = dataInput.readInt();

            DataOutputStream dataOutput = new DataOutputStream(outputStream);
            dataOutput.writeInt(42);
            dataOutput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ejemplo de ObjectInputStream y ObjectOutputStream
        try {

            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            ExampleObject receivedObject = (ExampleObject) objectInput.readObject();

            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(receivedObject);
            objectOutput.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Ejemplo de PrintWriter
        try {
            PrintWriter printWriter = new PrintWriter(outputStream, true);
// The 'true' parameter enables auto-flushing
            printWriter.println("Hello server!! I'm Sainz");
            printWriter.print(55);
            printWriter.println();
            printWriter.close();
// Auto-flush is enabled, so you don't need to call printWriter.flush()
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ejemplo de Scanner
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                System.out.println("Scanner: " + scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ExampleObject implements Serializable {

    private String message;

    public ExampleObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
