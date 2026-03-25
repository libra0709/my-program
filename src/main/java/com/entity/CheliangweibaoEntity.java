package com.entity;

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
 * 车辆维保
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@TableName("cheliangweibao")
public class CheliangweibaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CheliangweibaoEntity() {
		
	}
	
	public CheliangweibaoEntity(T t) {
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
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 车辆名称
	 */
					
	private String cheliangmingcheng;
	
	/**
	 * 车牌号码
	 */
					
	private String chepaihaoma;
	
	/**
	 * 维保图片
	 */
					
	private String weibaotupian;
	
	/**
	 * 载重类型
	 */
					
	private String zaizhongleixing;
	
	/**
	 * 荷载重量
	 */
					
	private String hezaizhongliang;
	
	/**
	 * 维保进度
	 */
					
	private String weibaojindu;
	
	/**
	 * 维保时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date weibaoshijian;
	
	/**
	 * 维保详情
	 */
					
	private String weibaoxiangqing;
	
	
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
	 * 设置：车辆名称
	 */
	public void setCheliangmingcheng(String cheliangmingcheng) {
		this.cheliangmingcheng = cheliangmingcheng;
	}
	/**
	 * 获取：车辆名称
	 */
	public String getCheliangmingcheng() {
		return cheliangmingcheng;
	}
	/**
	 * 设置：车牌号码
	 */
	public void setChepaihaoma(String chepaihaoma) {
		this.chepaihaoma = chepaihaoma;
	}
	/**
	 * 获取：车牌号码
	 */
	public String getChepaihaoma() {
		return chepaihaoma;
	}
	/**
	 * 设置：维保图片
	 */
	public void setWeibaotupian(String weibaotupian) {
		this.weibaotupian = weibaotupian;
	}
	/**
	 * 获取：维保图片
	 */
	public String getWeibaotupian() {
		return weibaotupian;
	}
	/**
	 * 设置：载重类型
	 */
	public void setZaizhongleixing(String zaizhongleixing) {
		this.zaizhongleixing = zaizhongleixing;
	}
	/**
	 * 获取：载重类型
	 */
	public String getZaizhongleixing() {
		return zaizhongleixing;
	}
	/**
	 * 设置：荷载重量
	 */
	public void setHezaizhongliang(String hezaizhongliang) {
		this.hezaizhongliang = hezaizhongliang;
	}
	/**
	 * 获取：荷载重量
	 */
	public String getHezaizhongliang() {
		return hezaizhongliang;
	}
	/**
	 * 设置：维保进度
	 */
	public void setWeibaojindu(String weibaojindu) {
		this.weibaojindu = weibaojindu;
	}
	/**
	 * 获取：维保进度
	 */
	public String getWeibaojindu() {
		return weibaojindu;
	}
	/**
	 * 设置：维保时间
	 */
	public void setWeibaoshijian(Date weibaoshijian) {
		this.weibaoshijian = weibaoshijian;
	}
	/**
	 * 获取：维保时间
	 */
	public Date getWeibaoshijian() {
		return weibaoshijian;
	}
	/**
	 * 设置：维保详情
	 */
	public void setWeibaoxiangqing(String weibaoxiangqing) {
		this.weibaoxiangqing = weibaoxiangqing;
	}
	/**
	 * 获取：维保详情
	 */
	public String getWeibaoxiangqing() {
		return weibaoxiangqing;
	}

}
