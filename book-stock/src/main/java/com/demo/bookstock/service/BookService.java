package com.demo.bookstock.service;

import com.demo.bookstock.entity.Book;
import com.demo.bookstock.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public Book getBook(Long id) {
        return bookMapper.selectById(id);
    }

    public String buyBook(Long bookId, Integer quantity) {
        Book book = bookMapper.selectById(bookId);
        if (book == null) {
            return "图书不存在";
        }
        if (book.getStock() < quantity) {
            return "库存不足，当前剩余：" + book.getStock();
        }
        book.setStock(book.getStock() - quantity);
        int rows = bookMapper.updateById(book);
        if (rows == 0) {
            return "下单失败，库存已被抢光或数据已变动，请重试！";
        }
        return "下单成功，剩余库存：" + book.getStock();
    }
}
