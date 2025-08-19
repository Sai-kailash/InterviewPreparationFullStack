package Java_Core;

public class WaitAndNotify {

    private boolean isReady;

    public synchronized void checkIsAvailable() throws InterruptedException {
        System.out.println("Checking if it is ready");
        while(!isReady){
            wait();
            System.out.println("Relased "+isReady);
        }
    }

    public synchronized void setReady(){
        isReady = true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify w = new WaitAndNotify();

        // Thread that waits
        Thread t1 = new Thread(() -> {
            try {
                w.checkIsAvailable();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();

        Thread.sleep(2000); // simulate delay

        // Thread that signals
        w.setReady();
    }
}
