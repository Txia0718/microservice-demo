package com.demo.bookstock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.bookstock.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    // 这里一行都不用写，MyBatis-Plus 已经内置了增删改查
}
