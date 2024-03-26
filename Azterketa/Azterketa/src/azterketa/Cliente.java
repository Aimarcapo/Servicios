package azterketa;

import java.util.Random;

public class Cliente extends Thread {
    private final Restaurante restaurant;

    public Cliente(Restaurante restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (true) {
            String tipo = generateTipoComida();
            restaurant.makeOrder(tipo);
            try {
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
        int high = 3;
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
