/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketaariketa;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author aimar
 */
public class Cliente extends Thread {
    private Restaurante restaurant;
    private int id;
    public Cliente(Restaurante restaurant,int id) {
        this.restaurant = restaurant;
        this.id=id;
    }

    public Restaurante getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurante restaurant) {
        this.restaurant = restaurant;
    }


    public int getIdu() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    @Override
    public void run() {
        while (true) {
            String tipo = generateTipoComida();
           Pedido pedido=new Pedido(tipo,this);
            
            try {
                 
                 synchronized (pedido) {
                     restaurant.makeOrder(pedido);
                     System.out.println(new Date().toString()+" Cliente "+this.getIdu()+" a la espera de realizar pedido");
                     
                    pedido.wait();
                     System.out.println(new Date().toString()+" Pedido de cliente "+this.getIdu()+" realizado");
                }
                
                Thread.sleep(1000); // Simulating time between orders
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static String generateTipoComida(){
        Random r = new Random();
       String tipo=null;
        int low = 1;
        int high = 4;
        int result = r.nextInt(high - low) + low;
        switch (result) {
            case 1 -> tipo = "sushi";
            case 2 -> tipo = "pasta";
            case 3 -> tipo = "marmitako";
            default -> {
            }
        }
        return tipo;
    }
}
