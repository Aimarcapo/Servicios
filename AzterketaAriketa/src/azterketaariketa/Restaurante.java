/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketaariketa;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author aimar
 */
public class Restaurante {
      
    private final Cocinero[] chefs;
  
    private ArrayList<Pedido> pedidosSushi=new ArrayList<Pedido>();
    private ArrayList<Pedido> pedidosPasta=new ArrayList<Pedido>();
    private ArrayList<Pedido> pedidosMarmitako=new ArrayList<Pedido>();
    public Restaurante(int numberOfChefs) {
        
        chefs = new Cocinero[numberOfChefs];

        //for (int i = 0; i < numberOfChefs; i++) {
           // chefSemaphores[i] = new Semaphore(0, true); // Fairness enabled
       // }
         // Creating chefs
        String[] chefTypes = {"sushi", "pasta", "marmitako"};
        for (int i = 0; i < numberOfChefs; i++) {
            Cocinero chef = new Cocinero(chefTypes[i], this,i+1);
            chef.setName("Chef " + (i) + " - " + chefTypes[i]);
            //this.assignChef(i, chef);
            chef.start();
        }
        
    }

    public  void makeOrder(Pedido pedido) throws InterruptedException {
        System.out.println(new Date().toString()+" nuevo pedido de "+pedido.getTipo()+" del Cliente "+pedido.getCliente().getIdu());
        //orderSemaphore.acquire();
        if(pedido.getTipo().equals("sushi")){
            synchronized (pedidosSushi) {
                pedidosSushi.add(pedido);
            }
        }
        else if(pedido.getTipo().equals("pasta")){
            synchronized (pedidosPasta) {
                pedidosPasta.add(pedido);
            }
        }
        else if(pedido.getTipo().equals("marmitako")){
            synchronized (pedidosMarmitako) {
                pedidosMarmitako.add(pedido);
            }
        }
        
        //orderSemaphore.release();
    }
    public Pedido nextOrder(String tipo){
        if(tipo.equals("sushi")){
            synchronized (pedidosSushi) {
                if(!pedidosSushi.isEmpty()){
                    return pedidosSushi.remove(0);
                }
                else{
                    return null;
                }
             
            }
        }
        else if(tipo.equals("pasta")){
            synchronized (pedidosPasta) {
               if(!pedidosPasta.isEmpty()){
                    return pedidosPasta.remove(0);
                }
                else{
                    return null;
                }
            }
        }
        else{
            synchronized (pedidosMarmitako) {
               if(!pedidosMarmitako.isEmpty()){
                    return pedidosMarmitako.remove(0);
                }
                else{
                    return null;
                }
            }
        }
    }

    public void prepareDish(String type) throws InterruptedException {
        //orderSemaphore.acquire();

        for (Cocinero chef : chefs) {
            if (chef.getType().equals(type)) {
                System.out.println("Chef " + chef.getName() + " is preparing " + type);

                // Simulating cooking time
                Thread.sleep(2000);

                System.out.println("Chef " + chef.getName() + " has prepared " + type);

                //chefSemaphores[chef.hashCode() % chefSemaphores.length].release();
                break;
            }
        }
          //orderSemaphore.release();
    }

    public void assignChef(int index, Cocinero chef) {
        chefs[index] = chef;
    }
}
