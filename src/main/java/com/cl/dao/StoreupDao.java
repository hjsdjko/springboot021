package com.cl.dao;

import com.cl.entity.StoreupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.StoreupView;


/**
 * 我的收藏
 * 
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
public interface StoreupDao extends BaseMapper<StoreupEntity> {
	
	List<StoreupView> selectListView(@Param("ew") Wrapper<StoreupEntity> wrapper);

	List<StoreupView> selectListView(Pagination page,@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
	

}
