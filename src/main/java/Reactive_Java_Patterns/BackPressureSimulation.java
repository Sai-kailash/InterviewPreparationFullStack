package Reactive_Java_Patterns;

import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import reactor.core.publisher.BufferOverflowStrategy;

public class BackPressureSimulation {

//    Flowable<T> onBackpressureBuffer(
//            int capacity,
//            Action onOverflow,
//            BufferOverflowStrategy overflowStrategy
//    )

        public static void main(String[] args) {
            Flowable<Integer> source = Flowable
                    .range(1, 100).onBackpressureDrop();

            source.subscribe(
                    integer -> {
                        System.out.println("Received: " + integer);
                        try {
                            Thread.sleep(1000); // Simulate slow consumer
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    },
                    Throwable::printStackTrace,
                    () -> System.out.println("Completed")
            );
        }

}
