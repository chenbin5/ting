package com.bjsxt.service;

import com.bjsxt.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjsxt.vo.TreeNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-06-11
 */
public interface IMenuService extends IService<Menu> {

    List<TreeNode> listMenusByParent(int id, Integer aid);
}
