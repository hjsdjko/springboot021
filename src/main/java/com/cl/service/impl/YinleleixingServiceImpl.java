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


import com.cl.dao.YinleleixingDao;
import com.cl.entity.YinleleixingEntity;
import com.cl.service.YinleleixingService;
import com.cl.entity.view.YinleleixingView;

@Service("yinleleixingService")
public class YinleleixingServiceImpl extends ServiceImpl<YinleleixingDao, YinleleixingEntity> implements YinleleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinleleixingEntity> page = this.selectPage(
                new Query<YinleleixingEntity>(params).getPage(),
                new EntityWrapper<YinleleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinleleixingEntity> wrapper) {
		  Page<YinleleixingView> page =new Query<YinleleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinleleixingView> selectListView(Wrapper<YinleleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinleleixingView selectView(Wrapper<YinleleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
