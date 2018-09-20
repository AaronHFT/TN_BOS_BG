package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName tn_bos_background
 * @ClassName TestController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/19 0019 11:10
 * @Version 1.0
 **/
@Controller
public class TestController {

    @RequestMapping("/index")
    public String test(){
        return "/index";
    }

    @RequestMapping("/login")
    public String test1(){
        return "/login";
    }
}
