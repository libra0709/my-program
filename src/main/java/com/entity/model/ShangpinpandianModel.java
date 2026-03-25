package com.entity.model;

import com.entity.ShangpinpandianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 商品盘点
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-13 23:46:23
 */
public class ShangpinpandianModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品分类
	 */
	
	private String shangpinfenlei;
		
	/**
	 * 盘点图片
	 */
	
	private String pandiantupian;
		
	/**
	 * 库存数量
	 */
	
	private Integer kucunshuliang;
		
	/**
	 * 盘点数量
	 */
	
	private Integer pandianshuliang;
		
	/**
	 * 商品规格
	 */
	
	private String shangpinguige;
		
	/**
	 * 仓管账号
	 */
	
	private String cangguanzhanghao;
		
	/**
	 * 仓管姓名
	 */
	
	private String cangguanxingming;
		
	/**
	 * 盘点备注
	 */
	
	private String pandianbeizhu;
		
	/**
	 * 盘点时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pandianshijian;
				
	
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
	 * 设置：盘点图片
	 */
	 
	public void setPandiantupian(String pandiantupian) {
		this.pandiantupian = pandiantupian;
	}
	
	/**
	 * 获取：盘点图片
	 */
	public String getPandiantupian() {
		return pandiantupian;
	}
				
	
	/**
	 * 设置：库存数量
	 */
	 
	public void setKucunshuliang(Integer kucunshuliang) {
		this.kucunshuliang = kucunshuliang;
	}
	
	/**
	 * 获取：库存数量
	 */
	public Integer getKucunshuliang() {
		return kucunshuliang;
	}
				
	
	/**
	 * 设置：盘点数量
	 */
	 
	public void setPandianshuliang(Integer pandianshuliang) {
		this.pandianshuliang = pandianshuliang;
	}
	
	/**
	 * 获取：盘点数量
	 */
	public Integer getPandianshuliang() {
		return pandianshuliang;
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
				
	
	/**
	 * 设置：盘点备注
	 */
	 
	public void setPandianbeizhu(String pandianbeizhu) {
		this.pandianbeizhu = pandianbeizhu;
	}
	
	/**
	 * 获取：盘点备注
	 */
	public String getPandianbeizhu() {
		return pandianbeizhu;
	}
				
	
	/**
	 * 设置：盘点时间
	 */
	 
	public void setPandianshijian(Date pandianshijian) {
		this.pandianshijian = pandianshijian;
	}
	
	/**
	 * 获取：盘点时间
	 */
	public Date getPandianshijian() {
		return pandianshijian;
	}
			
}
