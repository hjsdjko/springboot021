package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.BiaoqianDao;
import com.cl.entity.BiaoqianEntity;
import com.cl.service.BiaoqianService;
import com.cl.entity.view.BiaoqianView;

@Service("biaoqianService")
public class BiaoqianServiceImpl extends ServiceImpl<BiaoqianDao, BiaoqianEntity> implements BiaoqianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BiaoqianEntity> page = this.selectPage(
                new Query<BiaoqianEntity>(params).getPage(),
                new EntityWrapper<BiaoqianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BiaoqianEntity> wrapper) {
		  Page<BiaoqianView> page =new Query<BiaoqianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BiaoqianView> selectListView(Wrapper<BiaoqianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BiaoqianView selectView(Wrapper<BiaoqianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
