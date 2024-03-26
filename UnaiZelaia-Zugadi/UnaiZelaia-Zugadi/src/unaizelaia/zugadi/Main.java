/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unaizelaia.zugadi;

import java.util.Scanner;

/**
 *
 * @author unai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cook sushiCook = new Cook(1);
        Cook pastaCook = new Cook(2);
        Cook marmiCook = new Cook(3);

        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of customers: ");
        int customers = s.nextInt();
        s.close();
        
        if (customers < 9) {
            customers = 9;
        }

        for(int i = 0; i < customers; i++){
            Customer c = new Customer(sushiCook, pastaCook, marmiCook, (i + 1));
            c.start();
        }
    }
    
}
