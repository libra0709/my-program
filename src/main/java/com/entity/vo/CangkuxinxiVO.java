package com.entity.vo;

import com.entity.CangkuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 仓库信息
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public class CangkuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 仓库名称
	 */
	
	private String cangkumingcheng;
		
	/**
	 * 仓库图片
	 */
	
	private String cangkutupian;
		
	/**
	 * 货架号码
	 */
	
	private String huojiahaoma;
		
	/**
	 * 仓库位置
	 */
	
	private String cangkuweizhi;
		
	/**
	 * 仓库详情
	 */
	
	private String cangkuxiangqing;
				
	
	/**
	 * 设置：仓库名称
	 */
	 
	public void setCangkumingcheng(String cangkumingcheng) {
		this.cangkumingcheng = cangkumingcheng;
	}
	
	/**
	 * 获取：仓库名称
	 */
	public String getCangkumingcheng() {
		return cangkumingcheng;
	}
				
	
	/**
	 * 设置：仓库图片
	 */
	 
	public void setCangkutupian(String cangkutupian) {
		this.cangkutupian = cangkutupian;
	}
	
	/**
	 * 获取：仓库图片
	 */
	public String getCangkutupian() {
		return cangkutupian;
	}
				
	
	/**
	 * 设置：货架号码
	 */
	 
	public void setHuojiahaoma(String huojiahaoma) {
		this.huojiahaoma = huojiahaoma;
	}
	
	/**
	 * 获取：货架号码
	 */
	public String getHuojiahaoma() {
		return huojiahaoma;
	}
				
	
	/**
	 * 设置：仓库位置
	 */
	 
	public void setCangkuweizhi(String cangkuweizhi) {
		this.cangkuweizhi = cangkuweizhi;
	}
	
	/**
	 * 获取：仓库位置
	 */
	public String getCangkuweizhi() {
		return cangkuweizhi;
	}
				
	
	/**
	 * 设置：仓库详情
	 */
	 
	public void setCangkuxiangqing(String cangkuxiangqing) {
		this.cangkuxiangqing = cangkuxiangqing;
	}
	
	/**
	 * 获取：仓库详情
	 */
	public String getCangkuxiangqing() {
		return cangkuxiangqing;
	}
			
}
