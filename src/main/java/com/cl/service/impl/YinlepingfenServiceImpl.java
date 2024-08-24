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


import com.cl.dao.YinlepingfenDao;
import com.cl.entity.YinlepingfenEntity;
import com.cl.service.YinlepingfenService;
import com.cl.entity.view.YinlepingfenView;

@Service("yinlepingfenService")
public class YinlepingfenServiceImpl extends ServiceImpl<YinlepingfenDao, YinlepingfenEntity> implements YinlepingfenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlepingfenEntity> page = this.selectPage(
                new Query<YinlepingfenEntity>(params).getPage(),
                new EntityWrapper<YinlepingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlepingfenEntity> wrapper) {
		  Page<YinlepingfenView> page =new Query<YinlepingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinlepingfenView> selectListView(Wrapper<YinlepingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlepingfenView selectView(Wrapper<YinlepingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
