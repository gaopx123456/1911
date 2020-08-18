package com.jk.service;


import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "tb-provider-tow",fallback = UserServiceFallback.class)
public interface BookFeignService  extends UserService{




}
