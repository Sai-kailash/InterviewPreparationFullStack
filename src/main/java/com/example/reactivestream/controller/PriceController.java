package com.example.reactivestream.controller;

import com.example.reactivestream.model.Price;
import com.example.reactivestream.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping(value = "/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Price> getPriceStream(@PathVariable String symbol) {
        return priceService.streamPrices(symbol);
    }

    @GetMapping(value = "/symbols/{current_symbol}")
    public Price getCurrentSymbol(@PathVariable String current_symbol){
        return priceService.getOnePrice(current_symbol);
    }

    @PostMapping(value = "/symbols/{current_symbol}")
    public Price postCurrentSymbol(@PathVariable Price price){
        return price;
    }
}
