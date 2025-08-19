package Reactive_Java_Patterns;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BasicRxJavaExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(1, 2, 3, 4, 5);
        //Observable.range(1, 10);
        //Observable.create()
        //Observable.defer()
         //Observable.interval(1, TimeUnit.SECONDS);
        //Observable.fromArray(new int[]{1,2,3,4,5});
//        PublishSubject<String> subject = PublishSubject.create();
//        subject.subscribe(item -> System.out.println(item));
//
//        subject.onNext("a");
//        subject.onComplete();
        source.filter(integer -> integer%2 == 0)
                        .map(integer -> integer * 1)
                                .take(1).
                subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Subscribed");
            }
            @Override
            public void onNext(Integer integer) {
                System.out.println("Got: " + integer);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("Oops: " + e.getMessage());
            }
            @Override
            public void onComplete() {
                System.out.println("Received all!");
            }
        });

        Observable<Integer> source2 = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onError(new Exception("Something went wrong!"));
            // These will NOT be emitted because the stream ends on error
            emitter.onNext(4);
            emitter.onComplete();
        });

        source2.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Subscribed to source2");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Got element " + integer);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");

            }
        });

        Observable<Integer> source3 = Observable.create(emitter ->{
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(6);
            emitter.onNext(4);
        });
        source3.subscribe(new Observer<Integer>() {

            private Disposable d;
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Subscribed to source3");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Got element " + integer);
                try {
                    if(integer == 6){
                        System.out.println("Since 6 is present I shall unsubscribe");
                        d.dispose();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");

            }
        });

        Observable.range(1, 10)
                .subscribeOn(Schedulers.io())       // Emits on IO thread
                .filter(n -> n % 2 == 0)
                .observeOn(Schedulers.computation()) // Map and subscribe run on computation thread
                .map(n -> n * 2)
                .subscribe(n -> {
                    System.out.println("Received: " + n + " on " + Thread.currentThread().getName());
                });


    }
}