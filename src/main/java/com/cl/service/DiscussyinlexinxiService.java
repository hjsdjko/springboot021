package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyinlexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinlexinxiView;


/**
 * 音乐信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-30 10:09:30
 */
public interface DiscussyinlexinxiService extends IService<DiscussyinlexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinlexinxiView> selectListView(Wrapper<DiscussyinlexinxiEntity> wrapper);
   	
   	DiscussyinlexinxiView selectView(@Param("ew") Wrapper<DiscussyinlexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinlexinxiEntity> wrapper);
   	

}

