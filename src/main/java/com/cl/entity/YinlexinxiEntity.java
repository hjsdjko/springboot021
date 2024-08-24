package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 音乐信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@TableName("yinlexinxi")
public class YinlexinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YinlexinxiEntity() {
		
	}
	
	public YinlexinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 音乐类型
	 */
					
	private String yinleleixing;
	
	/**
	 * 标签
	 */
					
	private String biaoqian;
	
	/**
	 * 歌曲封面
	 */
					
	private String gequfengmian;
	
	/**
	 * 语言类别
	 */
					
	private String yuyanleibie;
	
	/**
	 * 上架时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shangjiashijian;
	
	/**
	 * 歌名
	 */
					
	private String songname;
	
	/**
	 * 音乐文件
	 */
					
	private String songfile;
	
	/**
	 * 歌手
	 */
					
	private String singer;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	/**
	 * 作词
	 */
					
	private String zuoci;
	
	/**
	 * 作曲
	 */
					
	private String zuoqu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：音乐类型
	 */
	public void setYinleleixing(String yinleleixing) {
		this.yinleleixing = yinleleixing;
	}
	/**
	 * 获取：音乐类型
	 */
	public String getYinleleixing() {
		return yinleleixing;
	}
	/**
	 * 设置：标签
	 */
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	/**
	 * 获取：标签
	 */
	public String getBiaoqian() {
		return biaoqian;
	}
	/**
	 * 设置：歌曲封面
	 */
	public void setGequfengmian(String gequfengmian) {
		this.gequfengmian = gequfengmian;
	}
	/**
	 * 获取：歌曲封面
	 */
	public String getGequfengmian() {
		return gequfengmian;
	}
	/**
	 * 设置：语言类别
	 */
	public void setYuyanleibie(String yuyanleibie) {
		this.yuyanleibie = yuyanleibie;
	}
	/**
	 * 获取：语言类别
	 */
	public String getYuyanleibie() {
		return yuyanleibie;
	}
	/**
	 * 设置：上架时间
	 */
	public void setShangjiashijian(Date shangjiashijian) {
		this.shangjiashijian = shangjiashijian;
	}
	/**
	 * 获取：上架时间
	 */
	public Date getShangjiashijian() {
		return shangjiashijian;
	}
	/**
	 * 设置：歌名
	 */
	public void setSongname(String songname) {
		this.songname = songname;
	}
	/**
	 * 获取：歌名
	 */
	public String getSongname() {
		return songname;
	}
	/**
	 * 设置：音乐文件
	 */
	public void setSongfile(String songfile) {
		this.songfile = songfile;
	}
	/**
	 * 获取：音乐文件
	 */
	public String getSongfile() {
		return songfile;
	}
	/**
	 * 设置：歌手
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}
	/**
	 * 获取：歌手
	 */
	public String getSinger() {
		return singer;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
	/**
	 * 设置：作词
	 */
	public void setZuoci(String zuoci) {
		this.zuoci = zuoci;
	}
	/**
	 * 获取：作词
	 */
	public String getZuoci() {
		return zuoci;
	}
	/**
	 * 设置：作曲
	 */
	public void setZuoqu(String zuoqu) {
		this.zuoqu = zuoqu;
	}
	/**
	 * 获取：作曲
	 */
	public String getZuoqu() {
		return zuoqu;
	}

}
