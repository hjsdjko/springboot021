package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinlexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinlexinxiView;


/**
 * 音乐信息
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface YinlexinxiService extends IService<YinlexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlexinxiView> selectListView(Wrapper<YinlexinxiEntity> wrapper);
   	
   	YinlexinxiView selectView(@Param("ew") Wrapper<YinlexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlexinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YinlexinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YinlexinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YinlexinxiEntity> wrapper);



}

