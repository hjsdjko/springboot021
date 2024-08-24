package com.cl.service.impl;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.dao.ConfigDao;
import com.cl.entity.ConfigEntity;
import com.cl.service.ConfigService;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


/**
 * 系统用户
 */
@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {
	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper) {
		Page<ConfigEntity> page = this.selectPage(
                new Query<ConfigEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
	}
}
