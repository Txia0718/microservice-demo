package com.demo.bookstock.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    @TableId
    private Long id;
    private String name;
    private Integer stock;
    @Version
    private Integer version;
}
