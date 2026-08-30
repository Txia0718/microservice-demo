package com.demo.orderservice.service;

import com.demo.orderservice.client.BookStockClient;
import com.demo.orderservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private BookStockClient bookStockClient;

    public String createOrder(Long bookId, Integer quantity) {
        return bookStockClient.buyBookById(bookId, quantity);
    }

    public String isAlive() {
        return bookStockClient.hi();
    }

    public Book searchBook(Long id) {
        return bookStockClient.getBookById(id);
    }
}
