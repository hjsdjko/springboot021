package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinleleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinleleixingView;


/**
 * 音乐类型
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface YinleleixingService extends IService<YinleleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinleleixingView> selectListView(Wrapper<YinleleixingEntity> wrapper);
   	
   	YinleleixingView selectView(@Param("ew") Wrapper<YinleleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinleleixingEntity> wrapper);
   	

}

