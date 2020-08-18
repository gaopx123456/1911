package com.jk.tbprovidertow.service;

import com.jk.model.entity.BookBean;
import com.jk.service.UserService;
import com.jk.tbprovidertow.mapper.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNameUserServiceImpl
 * @Description
 * @Author 高鹏翔
 * @Date2020/8/16 19:18
 * @Version V1.0
 **/
@RestController
public class UserServiceImpl implements UserService {

    @Resource
    private BookMapper bookMapper;

    @Override
    @RequestMapping("/findBookList")
    public List<BookBean> findBookList() {
        return bookMapper.findBookList();
    }

    @Override
    @RequestMapping("/hello")
    public String hello(String name) {
        return "hi 我是"+name;
    }

    @Override
    @RequestMapping("/saveOrder")
    public Object saveOrder(@RequestParam String name,@RequestParam  Integer price,@RequestParam  Integer typeId) {
        Map<String, Object> orderMap = new HashMap<String, Object>();
        orderMap.put("typeId",typeId);
        orderMap.put("name",name);
        orderMap.put("price", price);
        orderMap.put("orderNo", "20200815103622123");
        orderMap.put("orderName", "一架辽宁舰");
        orderMap.put("orderPrice", 100000);
        orderMap.put("createTime", "2020-08-15 10:37");
        return orderMap;
    }
}
