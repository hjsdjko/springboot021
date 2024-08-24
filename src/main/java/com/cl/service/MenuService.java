package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MenuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenuView;


/**
 * 菜单
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:30
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenuView> selectListView(Wrapper<MenuEntity> wrapper);
   	
   	MenuView selectView(@Param("ew") Wrapper<MenuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenuEntity> wrapper);
   	

}

