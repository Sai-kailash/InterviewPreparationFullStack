package Java_Core;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) {
        // Create an ExecutorService using a factory method
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // Submit tasks for execution
        pool.submit(() -> System.out.println("Task 1 executed on: " + Thread.currentThread().getName()));
        pool.submit(() -> System.out.println("Task 2 executed on: " + Thread.currentThread().getName()));
        pool.submit(() -> System.out.println("Task 3 executed on: " + Thread.currentThread().getName()));

        // Shutdown the pool to stop accepting new tasks and initiate a graceful shutdown
        pool.shutdown();
    }
}