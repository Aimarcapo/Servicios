/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketa2ariketa;

import java.util.concurrent.Semaphore;

/**
 *
 * @author aimar
 */
public class Client extends Thread {
 private Restaurant restaurant;
    private String dish;
    private int customerNumber;

    public Client(Restaurant restaurant, String dish, int customerNumber) {
        this.restaurant = restaurant;
        this.dish = dish;
        this.customerNumber = customerNumber;
    }

    public void run() {
        restaurant.order(dish, customerNumber);
    }
}