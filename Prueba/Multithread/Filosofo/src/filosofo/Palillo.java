package filosofo;

public class Palillo {
    private final int id;
    private boolean usado;

    public Palillo(int id) {
        this.id = id;
        this.usado = false;
    }

    public synchronized void coge() throws InterruptedException  {
        while (usado) {
            wait();
        }
        usado = true;
    }

    public synchronized void deja() {
        usado = false;
        notify();
    }

  
  
    

  

}
