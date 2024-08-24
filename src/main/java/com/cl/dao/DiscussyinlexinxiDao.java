package com.cl.dao;

import com.cl.entity.DiscussyinlexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinlexinxiView;


/**
 * 音乐信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-30 10:09:30
 */
public interface DiscussyinlexinxiDao extends BaseMapper<DiscussyinlexinxiEntity> {
	
	List<DiscussyinlexinxiView> selectListView(@Param("ew") Wrapper<DiscussyinlexinxiEntity> wrapper);

	List<DiscussyinlexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinlexinxiEntity> wrapper);
	
	DiscussyinlexinxiView selectView(@Param("ew") Wrapper<DiscussyinlexinxiEntity> wrapper);
	

}
