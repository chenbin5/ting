package com.bjsxt.service.impl;

import com.bjsxt.entity.Menu;
import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjsxt.vo.TreeNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-02-24
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    /**
     * 方法实现： 根据父节点主键和登录管理员主键查询菜单集合
     * @param id 父节点主键
     * @param aid 登录管理员主键
     * @return
     */
    @Override
    public List<TreeNode> listMenusByParent(int id, Integer aid) {
        List<Menu> menus = baseMapper.selectByParent(id, aid);
        List<TreeNode> result = new ArrayList<>();
        for(Menu menu: menus){
            // 组织具体的树节点对象。
            TreeNode node = new TreeNode();
            node.setId(menu.getMid());
            node.setText(menu.getMname());
            node.setState(menu.getIsparent().equals("1") ? "closed" : "open");
            Map<String, String> attributes = new HashMap<>();
            attributes.put("url", menu.getUrl());
            node.setAttributes(attributes);

            result.add(node);
        }
        return result;
    }
}
