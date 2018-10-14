package org.java.web;

import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName TestController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/19 0019 11:10
 * @Version 1.0
 **/
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/initIndex")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam Map<String,Object> user, HttpSession ses)
    {
        user=userService.checkLogin(user);
        System.out.println(user);
        ses.setAttribute("user", user);
        return "redirect:/initIndex";
    }

    @RequestMapping("/initLogin")
    public String initLogin(){
        return "/login";
    }

}
