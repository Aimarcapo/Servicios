package eus.alonso.aimar.exercise;


import java.util.Scanner;


public class StringManipulatorA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        
        // Add the programmer-selected string
        String programmerString = " Programmer-Selected String";
        String resultString = inputString + programmerString;
        
        // Print the result to the standard output
        System.out.println("Result: " + resultString);
    }
}
