package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinlepingfenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinlepingfenView;


/**
 * 音乐评分
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface YinlepingfenService extends IService<YinlepingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlepingfenView> selectListView(Wrapper<YinlepingfenEntity> wrapper);
   	
   	YinlepingfenView selectView(@Param("ew") Wrapper<YinlepingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlepingfenEntity> wrapper);
   	

}

