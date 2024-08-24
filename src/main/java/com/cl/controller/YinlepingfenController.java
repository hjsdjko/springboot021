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

import com.cl.entity.YinlepingfenEntity;
import com.cl.entity.view.YinlepingfenView;

import com.cl.service.YinlepingfenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 音乐评分
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@RestController
@RequestMapping("/yinlepingfen")
public class YinlepingfenController {
    @Autowired
    private YinlepingfenService yinlepingfenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlepingfenEntity yinlepingfen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinlepingfen.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YinlepingfenEntity> ew = new EntityWrapper<YinlepingfenEntity>();

		PageUtils page = yinlepingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlepingfen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlepingfenEntity yinlepingfen, 
		HttpServletRequest request){
        EntityWrapper<YinlepingfenEntity> ew = new EntityWrapper<YinlepingfenEntity>();

		PageUtils page = yinlepingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlepingfen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlepingfenEntity yinlepingfen){
       	EntityWrapper<YinlepingfenEntity> ew = new EntityWrapper<YinlepingfenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlepingfen, "yinlepingfen")); 
        return R.ok().put("data", yinlepingfenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinlepingfenEntity yinlepingfen){
        EntityWrapper< YinlepingfenEntity> ew = new EntityWrapper< YinlepingfenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlepingfen, "yinlepingfen")); 
		YinlepingfenView yinlepingfenView =  yinlepingfenService.selectView(ew);
		return R.ok("查询音乐评分成功").put("data", yinlepingfenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlepingfenEntity yinlepingfen = yinlepingfenService.selectById(id);
		yinlepingfen = yinlepingfenService.selectView(new EntityWrapper<YinlepingfenEntity>().eq("id", id));
        return R.ok().put("data", yinlepingfen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlepingfenEntity yinlepingfen = yinlepingfenService.selectById(id);
		yinlepingfen = yinlepingfenService.selectView(new EntityWrapper<YinlepingfenEntity>().eq("id", id));
        return R.ok().put("data", yinlepingfen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlepingfenEntity yinlepingfen, HttpServletRequest request){
    	yinlepingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlepingfen);
        yinlepingfenService.insert(yinlepingfen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlepingfenEntity yinlepingfen, HttpServletRequest request){
    	yinlepingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlepingfen);
        yinlepingfenService.insert(yinlepingfen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlepingfenEntity yinlepingfen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlepingfen);
        yinlepingfenService.updateById(yinlepingfen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlepingfenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
