package com.cl.dao;

import com.cl.entity.WodegedanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WodegedanView;


/**
 * 我的歌单
 * 
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface WodegedanDao extends BaseMapper<WodegedanEntity> {
	
	List<WodegedanView> selectListView(@Param("ew") Wrapper<WodegedanEntity> wrapper);

	List<WodegedanView> selectListView(Pagination page,@Param("ew") Wrapper<WodegedanEntity> wrapper);
	
	WodegedanView selectView(@Param("ew") Wrapper<WodegedanEntity> wrapper);
	

}
