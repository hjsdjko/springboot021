package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BiaoqianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BiaoqianView;


/**
 * 标签
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface BiaoqianService extends IService<BiaoqianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BiaoqianView> selectListView(Wrapper<BiaoqianEntity> wrapper);
   	
   	BiaoqianView selectView(@Param("ew") Wrapper<BiaoqianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BiaoqianEntity> wrapper);
   	

}

