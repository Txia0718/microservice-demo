package com.demo.orderservice.client;

import com.demo.orderservice.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "book-stock")
public interface BookStockClient {
    @GetMapping("/book/{id}")
    Book getBookById(@PathVariable("id") Long id);

    @PostMapping("/order/buy")
    String buyBookById(@RequestParam("bookId") Long bookId, @RequestParam("quantity") Integer quantity);

    @GetMapping("/hello")
    String hi();
}
