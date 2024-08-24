package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.StoreupEntity;
import com.cl.entity.view.StoreupView;

import com.cl.service.StoreupService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 我的收藏
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@RestController
@RequestMapping("/storeup")
public class StoreupController {
    @Autowired
    private StoreupService storeupService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,StoreupEntity storeup,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		storeup.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();

		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StoreupEntity storeup, 
		HttpServletRequest request){
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();

		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( StoreupEntity storeup){
       	EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
      	ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
        return R.ok().put("data", storeupService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StoreupEntity storeup){
        EntityWrapper< StoreupEntity> ew = new EntityWrapper< StoreupEntity>();
 		ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
		StoreupView storeupView =  storeupService.selectView(ew);
		return R.ok("查询我的收藏成功").put("data", storeupView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
		storeup = storeupService.selectView(new EntityWrapper<StoreupEntity>().eq("id", id));
        return R.ok().put("data", storeup);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
		storeup = storeupService.selectView(new EntityWrapper<StoreupEntity>().eq("id", id));
        return R.ok().put("data", storeup);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(storeup);
    	storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(storeup);
        storeupService.insert(storeup);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        //ValidatorUtils.validateEntity(storeup);
        storeupService.updateById(storeup);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
