package com.jk.service;

import com.jk.mapper.BookMapper;
import com.jk.model.entity.BookBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<BookBean> findBookList() {
        return bookMapper.findBookList();
    }


}
