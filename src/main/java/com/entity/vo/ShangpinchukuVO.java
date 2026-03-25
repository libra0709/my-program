package com.entity.vo;

import com.entity.ShangpinchukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 商品出库
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public class ShangpinchukuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品分类
	 */
	
	private String shangpinfenlei;
		
	/**
	 * 出库图片
	 */
	
	private String chukutupian;
		
	/**
	 * 出库数量
	 */
	
	private Integer kucunshuliang;
		
	/**
	 * 商品规格
	 */
	
	private String shangpinguige;
		
	/**
	 * 出库时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chukushijian;
		
	/**
	 * 出库备注
	 */
	
	private String chukubeizhu;
		
	/**
	 * 仓管账号
	 */
	
	private String cangguanzhanghao;
		
	/**
	 * 仓管姓名
	 */
	
	private String cangguanxingming;
				
	
	/**
	 * 设置：商品分类
	 */
	 
	public void setShangpinfenlei(String shangpinfenlei) {
		this.shangpinfenlei = shangpinfenlei;
	}
	
	/**
	 * 获取：商品分类
	 */
	public String getShangpinfenlei() {
		return shangpinfenlei;
	}
				
	
	/**
	 * 设置：出库图片
	 */
	 
	public void setChukutupian(String chukutupian) {
		this.chukutupian = chukutupian;
	}
	
	/**
	 * 获取：出库图片
	 */
	public String getChukutupian() {
		return chukutupian;
	}
				
	
	/**
	 * 设置：出库数量
	 */
	 
	public void setKucunshuliang(Integer kucunshuliang) {
		this.kucunshuliang = kucunshuliang;
	}
	
	/**
	 * 获取：出库数量
	 */
	public Integer getKucunshuliang() {
		return kucunshuliang;
	}
				
	
	/**
	 * 设置：商品规格
	 */
	 
	public void setShangpinguige(String shangpinguige) {
		this.shangpinguige = shangpinguige;
	}
	
	/**
	 * 获取：商品规格
	 */
	public String getShangpinguige() {
		return shangpinguige;
	}
				
	
	/**
	 * 设置：出库时间
	 */
	 
	public void setChukushijian(Date chukushijian) {
		this.chukushijian = chukushijian;
	}
	
	/**
	 * 获取：出库时间
	 */
	public Date getChukushijian() {
		return chukushijian;
	}
				
	
	/**
	 * 设置：出库备注
	 */
	 
	public void setChukubeizhu(String chukubeizhu) {
		this.chukubeizhu = chukubeizhu;
	}
	
	/**
	 * 获取：出库备注
	 */
	public String getChukubeizhu() {
		return chukubeizhu;
	}
				
	
	/**
	 * 设置：仓管账号
	 */
	 
	public void setCangguanzhanghao(String cangguanzhanghao) {
		this.cangguanzhanghao = cangguanzhanghao;
	}
	
	/**
	 * 获取：仓管账号
	 */
	public String getCangguanzhanghao() {
		return cangguanzhanghao;
	}
				
	
	/**
	 * 设置：仓管姓名
	 */
	 
	public void setCangguanxingming(String cangguanxingming) {
		this.cangguanxingming = cangguanxingming;
	}
	
	/**
	 * 获取：仓管姓名
	 */
	public String getCangguanxingming() {
		return cangguanxingming;
	}
			
}
