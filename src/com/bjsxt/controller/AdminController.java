package com.bjsxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjsxt.entity.Admin;
import com.bjsxt.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-06-11
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String adminLogin(String aname,String apwd,HttpSession httpSession){
        QueryWrapper<Admin> query = new QueryWrapper<>();
        query.eq("aname",aname);
        query.eq("apwd",apwd);

        Admin admin = adminService.getOne(query);
        //判断用户是否登录成功
        if (null == admin){
            //如果登录失败
            httpSession.setAttribute("flag","1");
            return "redirect:/index.jsp";
        }else{
            //登陆成功
            httpSession.setAttribute("admin",admin);
            return "redirect:/main.jsp";
        }
    }

}

