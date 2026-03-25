package com.entity.view;

import com.entity.YunshugenzongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 运输跟踪
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@TableName("yunshugenzong")
public class YunshugenzongView  extends YunshugenzongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YunshugenzongView(){
	}
 
 	public YunshugenzongView(YunshugenzongEntity yunshugenzongEntity){
 	try {
			BeanUtils.copyProperties(this, yunshugenzongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
