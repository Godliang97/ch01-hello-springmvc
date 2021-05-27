package com.bjpowernode.controller;


import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyUserException;
import com.bjpowernode.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Name;


@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
        //处理some.do请求了。相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        //根据请求参数抛出异常
        if (!"zs".equals(name)) {
            throw new NameException("姓名不正确！！！");
        }

        if (age == null || age > 80) {
            throw new AgeException("年龄比较大！！！");
        }

        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

}