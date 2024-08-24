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

import com.cl.entity.BiaoqianEntity;
import com.cl.entity.view.BiaoqianView;

import com.cl.service.BiaoqianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 标签
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@RestController
@RequestMapping("/biaoqian")
public class BiaoqianController {
    @Autowired
    private BiaoqianService biaoqianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BiaoqianEntity biaoqian,
		HttpServletRequest request){
        EntityWrapper<BiaoqianEntity> ew = new EntityWrapper<BiaoqianEntity>();

		PageUtils page = biaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biaoqian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BiaoqianEntity biaoqian, 
		HttpServletRequest request){
        EntityWrapper<BiaoqianEntity> ew = new EntityWrapper<BiaoqianEntity>();

		PageUtils page = biaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biaoqian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BiaoqianEntity biaoqian){
       	EntityWrapper<BiaoqianEntity> ew = new EntityWrapper<BiaoqianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( biaoqian, "biaoqian")); 
        return R.ok().put("data", biaoqianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BiaoqianEntity biaoqian){
        EntityWrapper< BiaoqianEntity> ew = new EntityWrapper< BiaoqianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( biaoqian, "biaoqian")); 
		BiaoqianView biaoqianView =  biaoqianService.selectView(ew);
		return R.ok("查询标签成功").put("data", biaoqianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BiaoqianEntity biaoqian = biaoqianService.selectById(id);
		biaoqian = biaoqianService.selectView(new EntityWrapper<BiaoqianEntity>().eq("id", id));
        return R.ok().put("data", biaoqian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BiaoqianEntity biaoqian = biaoqianService.selectById(id);
		biaoqian = biaoqianService.selectView(new EntityWrapper<BiaoqianEntity>().eq("id", id));
        return R.ok().put("data", biaoqian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BiaoqianEntity biaoqian, HttpServletRequest request){
        if(biaoqianService.selectCount(new EntityWrapper<BiaoqianEntity>().eq("biaoqian", biaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
    	biaoqian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(biaoqian);
        biaoqianService.insert(biaoqian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BiaoqianEntity biaoqian, HttpServletRequest request){
        if(biaoqianService.selectCount(new EntityWrapper<BiaoqianEntity>().eq("biaoqian", biaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
    	biaoqian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(biaoqian);
        biaoqianService.insert(biaoqian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BiaoqianEntity biaoqian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(biaoqian);
        biaoqianService.updateById(biaoqian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        biaoqianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
