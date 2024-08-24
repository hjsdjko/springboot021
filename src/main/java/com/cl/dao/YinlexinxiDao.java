package com.cl.dao;

import com.cl.entity.YinlexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinlexinxiView;


/**
 * 音乐信息
 * 
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface YinlexinxiDao extends BaseMapper<YinlexinxiEntity> {
	
	List<YinlexinxiView> selectListView(@Param("ew") Wrapper<YinlexinxiEntity> wrapper);

	List<YinlexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YinlexinxiEntity> wrapper);
	
	YinlexinxiView selectView(@Param("ew") Wrapper<YinlexinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinlexinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinlexinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinlexinxiEntity> wrapper);



}
