package com.cl.dao;

import com.cl.entity.YinlepingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinlepingfenView;


/**
 * 音乐评分
 * 
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface YinlepingfenDao extends BaseMapper<YinlepingfenEntity> {
	
	List<YinlepingfenView> selectListView(@Param("ew") Wrapper<YinlepingfenEntity> wrapper);

	List<YinlepingfenView> selectListView(Pagination page,@Param("ew") Wrapper<YinlepingfenEntity> wrapper);
	
	YinlepingfenView selectView(@Param("ew") Wrapper<YinlepingfenEntity> wrapper);
	

}
