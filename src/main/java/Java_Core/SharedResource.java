package Java_Core;

public class SharedResource {
    private boolean isReady = false;

    public synchronized void waitForData() {
        while (!isReady) {
            try {
                wait();  // Releases the monitor and waits.
            } catch (InterruptedException e) {
                // Handle the exception.
            }
        }
    }

    public synchronized void provideData() {
        // Code to set 'isReady' to true.
        notify();  // Wakes up one waiting thread.
    }
}