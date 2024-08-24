package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WodegedanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WodegedanView;


/**
 * 我的歌单
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface WodegedanService extends IService<WodegedanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodegedanView> selectListView(Wrapper<WodegedanEntity> wrapper);
   	
   	WodegedanView selectView(@Param("ew") Wrapper<WodegedanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodegedanEntity> wrapper);
   	

}

