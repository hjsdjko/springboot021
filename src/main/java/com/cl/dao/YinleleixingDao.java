package com.cl.dao;

import com.cl.entity.YinleleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinleleixingView;


/**
 * 音乐类型
 * 
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface YinleleixingDao extends BaseMapper<YinleleixingEntity> {
	
	List<YinleleixingView> selectListView(@Param("ew") Wrapper<YinleleixingEntity> wrapper);

	List<YinleleixingView> selectListView(Pagination page,@Param("ew") Wrapper<YinleleixingEntity> wrapper);
	
	YinleleixingView selectView(@Param("ew") Wrapper<YinleleixingEntity> wrapper);
	

}
