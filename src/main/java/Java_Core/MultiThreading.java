package Java_Core;

public class MultiThreading implements Runnable {

    private int a;
    public MultiThreading(int a){
       this.a = a;
    }
    @Override

    public void run(){

        try {
            for (int i = 0; i < 10; i++) {
                if (a == 1) {
                    Thread.sleep(1000);
                    System.out.println(i+"a");
                }
                else{
                    Thread.sleep(2000);
                    System.out.println(i+"not a");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Interrupted Exception");
        }

    }

    public static void main(String args[]){

        System.out.println("Going ahead with multi threading");

        MultiThreading multiThreading = new MultiThreading(1);
        MultiThreading multiThreading1 = new MultiThreading(2);

        Thread thread1 = new Thread(multiThreading);
        Thread thread2 = new Thread(multiThreading1);

        thread1.start();
        thread2.start();
    }
}
