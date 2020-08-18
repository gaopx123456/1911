package com.jk.service;

import com.jk.model.entity.BookBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNameUserService
 * @Description
 * @Author 高鹏翔
 * @Date2020/8/16 19:41
 * @Version V1.0
 **/
@RestController
public interface UserService  {
    @RequestMapping("/findBookList")
    List<BookBean> findBookList();

    @RequestMapping("/hello")
    String hello(@RequestParam String name);

    @RequestMapping("/saveOrder")
    Object saveOrder(@RequestParam  String name,@RequestParam  Integer price,@RequestParam  Integer typeId);
}
