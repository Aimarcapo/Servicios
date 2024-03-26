package azterketa;

public class Cocinero extends Thread {
    private final String type;
    private final Restaurante restaurant;

    public Cocinero(String type, Restaurante restaurant) {
        this.type = type;
        this.restaurant = restaurant;
    }
 public String getType() {
        return this.type;
    }
 
    @Override
    public void run() {
        while (true) {
            try {
                restaurant.prepareDish(type);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
