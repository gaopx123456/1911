package com.jk.service;

import com.jk.model.entity.BookBean;

import java.util.List;

public interface BookService {

    List<BookBean> findBookList();
}
