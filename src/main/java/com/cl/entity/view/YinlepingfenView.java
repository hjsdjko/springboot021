package com.cl.entity.view;

import com.cl.entity.YinlepingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 音乐评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@TableName("yinlepingfen")
public class YinlepingfenView  extends YinlepingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinlepingfenView(){
	}
 
 	public YinlepingfenView(YinlepingfenEntity yinlepingfenEntity){
 	try {
			BeanUtils.copyProperties(this, yinlepingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
