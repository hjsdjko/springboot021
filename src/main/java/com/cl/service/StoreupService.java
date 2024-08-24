package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.StoreupEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.StoreupView;


/**
 * 我的收藏
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface StoreupService extends IService<StoreupEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<StoreupView> selectListView(Wrapper<StoreupEntity> wrapper);
   	
   	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<StoreupEntity> wrapper);
   	

}

