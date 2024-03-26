package unaizelaia.zugadi;

public class Customer extends Thread {
    Cook sushiCook;
    Cook pastaCook;
    Cook marmiCook;
    int id;

    public Customer(Cook sushi, Cook pasta, Cook marmi, int id){
        sushiCook = sushi;
        pastaCook = pasta;
        marmiCook = marmi;
        this.id = id;
    }

   @Override
    public void run() {
        try {
            String selection;
            double cookSelect;

            while (true) {
                synchronized (this) {
                    cookSelect = Math.random();
                    if (cookSelect < 0.3) {
                        selection = "sushi";
                    } else if (cookSelect >= 0.3 && cookSelect <= 0.6) {
                        selection = "pasta";
                    } else {
                        selection = "marmitako";
                    }

                    switch (selection) {
                        case "sushi":
                            System.out.println("Customer " + id + " asking for SUSHI. It is waiting");
                            sushiCook.cook(id);
                            System.out.println("Order of SUSHI for customer " + id + " is ready.");
                            break;
                        case "pasta":
                            System.out.println("Customer " + id + " asking for PASTA. It is waiting");
                            pastaCook.cook(id);
                            System.out.println("Order of PASTA for customer " + id + " is ready.");
                            break;
                        case "marmitako":
                            System.out.println("Customer " + id + " asking for MARMITAKO. It is waiting");
                            marmiCook.cook(id);
                            System.out.println("Order of MARMITAKO for customer " + id + " is ready.");
                            break;
                        default:
                            break;
                    }
                }
                Thread.sleep((long) (Math.random() * 2000)); // Wait before placing another order
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
