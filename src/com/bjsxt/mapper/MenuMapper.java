package com.bjsxt.mapper;

import com.bjsxt.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-06-11
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectByParent(@Param("id") int id, @Param("aid") Integer aid);

}
