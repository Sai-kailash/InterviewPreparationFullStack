package com.example.reactivestream.service;

import com.example.reactivestream.model.Price;
import java.util.function.Function;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class PriceService {

    public Flux<Price> streamPrices(String symbol) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new Price(symbol, getRandomPrice()))
                .take(10);

//        return Flux.interval(Duration.ofSeconds(1))
//                .map(i -> new Price(symbol, getRandomPrice()))
//                .take(Duration.ofSeconds(10));
    }

    private double getRandomPrice() {
        Flux<String> users = Flux.just("Alice", "Sai");
        users.transform(commonTransform()).subscribe();
        return Math.round(100 + Math.random() * 900 * 100.0) / 100.0; // 100.00 - 1000.00
    }

    private static Function<Flux<String>, Flux<String>> commonTransform(){
        return flux -> flux.map(user -> user.toUpperCase()).filter(s -> s.startsWith("s"));
    }

    public Price getOnePrice(String symbol){
        return new Price(symbol, getRandomPrice());
    }
}
