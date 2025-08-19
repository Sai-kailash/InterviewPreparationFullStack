package Reactive_Java_Patterns;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamExample {

    public static void main(String[] args) throws InterruptedException {
        // 1. Create a Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 2. Create a Subscriber
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("Subscribed!");
                subscription.request(1); // Ask for first item
            }

            @Override
            public void onNext(String item) {
                System.out.println("Received: " + item);
                subscription.request(1); // Ask for next item
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");
            }
        };

        // 3. Connect publisher to subscriber
        publisher.subscribe(subscriber);

        // 4. Publish items
        publisher.submit("One");
        publisher.submit("Two");
        publisher.submit("Three");

        // 5. Close publisher after some time
        publisher.close();

        // Prevent main from exiting early
        Thread.sleep(1000);
    }
}
