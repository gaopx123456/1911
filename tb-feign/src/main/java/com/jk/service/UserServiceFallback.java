package com.jk.service;

import com.jk.model.entity.BookBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassNameUserServiceFallback
 * @Description
 * @Author 高鹏翔
 * @Date2020/8/16 19:39
 * @Version V1.0
 **/
@RequestMapping("/error")
@Component
public class UserServiceFallback  implements  BookFeignService  {
    @Override
    public List<BookBean> findBookList() {
        System.out.println("进熔断器giao");
        return null;
    }

    @Override
    public String hello(String name) {
        System.out.println("进入了 hello 方法 熔断器");
        return "请求失败，请检查电脑手机网络";
    }

    @Override
    public Object saveOrder(String name, Integer price, Integer typeId) {
        System.out.println("进入了 saveOrder 熔断器");
        return null;
    }
}
