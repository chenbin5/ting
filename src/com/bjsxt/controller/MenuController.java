package com.bjsxt.controller;


import com.bjsxt.entity.Admin;
import com.bjsxt.service.IMenuService;
import com.bjsxt.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-06-11
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    //动态菜单查询
    @RequestMapping("/getMenusByParent")
    @ResponseBody
    public List<TreeNode> getMenusByParent(@RequestParam(value = "id",defaultValue = "0") int id, HttpSession session){
        //获取当前用户
        Admin admin = (Admin) session.getAttribute("admin");
        //查询
        List<TreeNode> nodes = menuService.listMenusByParent(id,admin.getAid());
        return nodes;
    }
}

