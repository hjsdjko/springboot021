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


import com.cl.dao.YinlexinxiDao;
import com.cl.entity.YinlexinxiEntity;
import com.cl.service.YinlexinxiService;
import com.cl.entity.view.YinlexinxiView;

@Service("yinlexinxiService")
public class YinlexinxiServiceImpl extends ServiceImpl<YinlexinxiDao, YinlexinxiEntity> implements YinlexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlexinxiEntity> page = this.selectPage(
                new Query<YinlexinxiEntity>(params).getPage(),
                new EntityWrapper<YinlexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlexinxiEntity> wrapper) {
		  Page<YinlexinxiView> page =new Query<YinlexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinlexinxiView> selectListView(Wrapper<YinlexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlexinxiView selectView(Wrapper<YinlexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YinlexinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YinlexinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YinlexinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
