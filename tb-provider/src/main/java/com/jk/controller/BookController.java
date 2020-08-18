package com.jk.controller;

import com.jk.model.entity.BookBean;
import com.jk.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController implements BookFeignService {

    @Resource
    private BookService bookService;


    @Override
    @RequestMapping("/findBookList")
    public List<BookBean> findBookList() {
        List<BookBean> bookBeans= bookService.findBookList();
        return bookBeans;
    }





}
