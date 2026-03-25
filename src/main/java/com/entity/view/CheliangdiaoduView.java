package com.entity.view;

import com.entity.CheliangdiaoduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 车辆调度
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@TableName("cheliangdiaodu")
public class CheliangdiaoduView  extends CheliangdiaoduEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheliangdiaoduView(){
	}
 
 	public CheliangdiaoduView(CheliangdiaoduEntity cheliangdiaoduEntity){
 	try {
			BeanUtils.copyProperties(this, cheliangdiaoduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
