package com.cl.entity.view;

import com.cl.entity.BiaoqianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 标签
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-30 10:09:29
 */
@TableName("biaoqian")
public class BiaoqianView  extends BiaoqianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BiaoqianView(){
	}
 
 	public BiaoqianView(BiaoqianEntity biaoqianEntity){
 	try {
			BeanUtils.copyProperties(this, biaoqianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
