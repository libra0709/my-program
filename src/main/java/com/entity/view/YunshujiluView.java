package com.entity.view;

import com.entity.YunshujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 运输记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@TableName("yunshujilu")
public class YunshujiluView  extends YunshujiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YunshujiluView(){
	}
 
 	public YunshujiluView(YunshujiluEntity yunshujiluEntity){
 	try {
			BeanUtils.copyProperties(this, yunshujiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
