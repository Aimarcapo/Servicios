package unaizelaia.zugadi;

import java.util.concurrent.Semaphore;

public class Cook {
     private int specialization; // 1 will be sushi, 2 will be pasta and 3 marmitako.
    private Semaphore semaphore;

    public Cook(int spec) {
        specialization = spec;
        semaphore = new Semaphore(1, true); // true for fair semaphore
    }

    public void cook(int customer) {
        try {
            semaphore.acquire();
            switch (specialization) {
                case 1:
                    System.out.println("SUSHI CHEF is cooking now for customer " + customer);
                    Thread.sleep((long) (Math.random() * 4000));
                    System.out.println("SUSHI done cooking for customer " + customer);
                    break;
                case 2:
                    System.out.println("PASTA CHEF is cooking now for customer " + customer);
                    Thread.sleep((long) (Math.random() * 4000));
                    System.out.println("PASTA done cooking for customer " + customer);
                    break;
                case 3:
                    System.out.println("MARMITAKO CHEF is cooking now for customer " + customer);
                    Thread.sleep((long) (Math.random() * 4000));
                    System.out.println("MARMITAKO done cooking for customer " + customer);
                    break;
                default:
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
