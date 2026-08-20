package com.demo.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public String createOrder(@RequestParam Long bookId, @RequestParam Integer quantity) {
        String url = "http://book-stock/order/buy?bookId=" + bookId + "&quantity=" + quantity;
        return restTemplate.postForObject(url, null, String.class);
    }
}
