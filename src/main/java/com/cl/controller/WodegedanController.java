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

import com.cl.entity.WodegedanEntity;
import com.cl.entity.view.WodegedanView;

import com.cl.service.WodegedanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 我的歌单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@RestController
@RequestMapping("/wodegedan")
public class WodegedanController {
    @Autowired
    private WodegedanService wodegedanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodegedanEntity wodegedan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodegedan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodegedanEntity> ew = new EntityWrapper<WodegedanEntity>();

		PageUtils page = wodegedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodegedan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodegedanEntity wodegedan, 
		HttpServletRequest request){
        EntityWrapper<WodegedanEntity> ew = new EntityWrapper<WodegedanEntity>();

		PageUtils page = wodegedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodegedan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodegedanEntity wodegedan){
       	EntityWrapper<WodegedanEntity> ew = new EntityWrapper<WodegedanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodegedan, "wodegedan")); 
        return R.ok().put("data", wodegedanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodegedanEntity wodegedan){
        EntityWrapper< WodegedanEntity> ew = new EntityWrapper< WodegedanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodegedan, "wodegedan")); 
		WodegedanView wodegedanView =  wodegedanService.selectView(ew);
		return R.ok("查询我的歌单成功").put("data", wodegedanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodegedanEntity wodegedan = wodegedanService.selectById(id);
		wodegedan = wodegedanService.selectView(new EntityWrapper<WodegedanEntity>().eq("id", id));
        return R.ok().put("data", wodegedan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodegedanEntity wodegedan = wodegedanService.selectById(id);
		wodegedan = wodegedanService.selectView(new EntityWrapper<WodegedanEntity>().eq("id", id));
        return R.ok().put("data", wodegedan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodegedanEntity wodegedan, HttpServletRequest request){
    	wodegedan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodegedan);
        wodegedanService.insert(wodegedan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodegedanEntity wodegedan, HttpServletRequest request){
    	wodegedan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodegedan);
        wodegedanService.insert(wodegedan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WodegedanEntity wodegedan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodegedan);
        wodegedanService.updateById(wodegedan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodegedanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
