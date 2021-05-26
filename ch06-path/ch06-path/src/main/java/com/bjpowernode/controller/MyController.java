package com.bjpowernode.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MyController {

    //指定some.do是get请求方式
    @RequestMapping(value = "/user/some.do")
    public ModelAndView doSome() {  //doGet()--service请求处理
        //处理some.do请求了。相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是doSome方法");
        mv.setViewName("/index.jsp");
        return mv;
    }

}
