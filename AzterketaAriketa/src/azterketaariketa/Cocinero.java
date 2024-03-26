/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketaariketa;

import java.util.Date;

/**
 *
 * @author aimar
 */
public class Cocinero extends Thread {
    private final String type;
    private final Restaurante restaurant;
    private int id;

    public Cocinero(String type, Restaurante restaurant, int id) {
        this.type = type;
        this.restaurant = restaurant;
        this.id = id;
    }

    public int getIdd() {
        return id;
    }
    
 public String getType() {
        return this.type;
    }
 
    @Override
    public void run() {
        while (true) {
            try {
               Pedido pedido = restaurant.nextOrder(type);
               if(pedido!=null){
                   System.out.println(new Date().toString()+" "+"Cocinero "+this.getIdd()+" comienza pedido de Cliente "+pedido.getCliente().getIdu() +" de tipo "+pedido.getTipo());
                   synchronized (pedido) {
                       Thread.sleep(2000);
                    
                      pedido.notify();
                   }
                   
                      
               }
               
            
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}