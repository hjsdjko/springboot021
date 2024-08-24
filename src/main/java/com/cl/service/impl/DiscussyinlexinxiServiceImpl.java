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


import com.cl.dao.DiscussyinlexinxiDao;
import com.cl.entity.DiscussyinlexinxiEntity;
import com.cl.service.DiscussyinlexinxiService;
import com.cl.entity.view.DiscussyinlexinxiView;

@Service("discussyinlexinxiService")
public class DiscussyinlexinxiServiceImpl extends ServiceImpl<DiscussyinlexinxiDao, DiscussyinlexinxiEntity> implements DiscussyinlexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinlexinxiEntity> page = this.selectPage(
                new Query<DiscussyinlexinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyinlexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinlexinxiEntity> wrapper) {
		  Page<DiscussyinlexinxiView> page =new Query<DiscussyinlexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyinlexinxiView> selectListView(Wrapper<DiscussyinlexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinlexinxiView selectView(Wrapper<DiscussyinlexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
