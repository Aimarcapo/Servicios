package eus.alonso.aimar.exercise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringManipulatorB {
    public static void main(String[] args) {
        try {
            Process process;
            process = Runtime.getRuntime().exec("java StringManipulatorA");
            
            // Get the input and error streams of StringManipulatorA
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            
            // Pass a string to StringManipulatorA
            String inputString = "Input String for StringManipulatorA\n"; // Add a newline to indicate end of input
            process.getOutputStream().write(inputString.getBytes());
            process.getOutputStream().close();
            
            // Read the output of StringManipulatorA
            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println("Output from StringManipulatorA: " + line);
            }

            // Read any error messages
            while ((line = errorReader.readLine()) != null) {
                System.err.println("Error from StringManipulatorA: " + line);
            }
            
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
