package com.gtools.algorithm.jdk.wait.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/26 15:40
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/s1")
    public void say() {
        System.out.println("hello everybody.");
    }
}
