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


import com.cl.dao.WodegedanDao;
import com.cl.entity.WodegedanEntity;
import com.cl.service.WodegedanService;
import com.cl.entity.view.WodegedanView;

@Service("wodegedanService")
public class WodegedanServiceImpl extends ServiceImpl<WodegedanDao, WodegedanEntity> implements WodegedanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodegedanEntity> page = this.selectPage(
                new Query<WodegedanEntity>(params).getPage(),
                new EntityWrapper<WodegedanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodegedanEntity> wrapper) {
		  Page<WodegedanView> page =new Query<WodegedanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WodegedanView> selectListView(Wrapper<WodegedanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodegedanView selectView(Wrapper<WodegedanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
