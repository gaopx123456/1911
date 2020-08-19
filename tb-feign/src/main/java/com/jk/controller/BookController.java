package com.jk.controller;

import com.jk.model.entity.BookBean;
import com.jk.model.utils.Constant;
import com.jk.model.utils.RedisUtil;
import com.jk.service.BookFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookFeignService bookFeignService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/saveOrder")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    @ResponseBody
    public  Object saveOrder(String name,Integer price,Integer typeId,HttpServletRequest request){
       return   bookFeignService.saveOrder(name,price,typeId);
    }


    //降级处理

    public Object saveOrderFail(String name,Integer price,Integer typeId, HttpServletRequest request){

        System.out.println("controller 保存降级处理");

        String ipAddr = request.getRemoteAddr();

        //新启动一个线程进行业务逻辑处理
        // 开启一个独立线程，进行发送警报，给开发人员，处理问题
        new Thread( ()->{
            System.out.println(ipAddr);
        }).start();

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("message", "抢购排队人数过多，请您稍后重试。");
        return map;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String name){

        return bookFeignService.hello(name);

    }
    @RequestMapping("/hello666")
    @ResponseBody
    public String hello666(String name){

        return name;

    }
    @RequestMapping("/toBookPage")
    public String toBookPage(){
        return "book";
    }

    @RequestMapping("/findBookList")
    @ResponseBody
    public List<BookBean> findBookList(){

     List<BookBean> bookBeans= (List<BookBean>) redisUtil.get(Constant.SELECT_USER_LIST);

   if(bookBeans==null || bookBeans.size()<0 || bookBeans.isEmpty()){
       bookBeans=  bookFeignService.findBookList();
       redisUtil.set(Constant.SELECT_USER_LIST,bookBeans,30);
   }
      return bookBeans;
     }
  }
