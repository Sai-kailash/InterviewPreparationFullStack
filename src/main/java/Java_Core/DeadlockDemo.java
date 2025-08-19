package Java_Core;

public class DeadlockDemo {

    private static final String RESOURCE1 = "Resource 1";
    private static final String RESOURCE2 = "Resource 2";

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (RESOURCE1) {
                System.out.println("Thread 1: Locked resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (RESOURCE2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (RESOURCE2) {
                System.out.println("Thread 2: Locked resource 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (RESOURCE1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}