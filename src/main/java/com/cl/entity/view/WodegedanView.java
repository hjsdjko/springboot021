package com.cl.entity.view;

import com.cl.entity.WodegedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 我的歌单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@TableName("wodegedan")
public class WodegedanView  extends WodegedanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WodegedanView(){
	}
 
 	public WodegedanView(WodegedanEntity wodegedanEntity){
 	try {
			BeanUtils.copyProperties(this, wodegedanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
