package com.entity.model;

import com.entity.CheliangdiaoduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车辆调度
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public class CheliangdiaoduModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车牌号码
	 */
	
	private String chepaihaoma;
		
	/**
	 * 车辆图片
	 */
	
	private String cheliangtupian;
		
	/**
	 * 载重类型
	 */
	
	private String zaizhongleixing;
		
	/**
	 * 调度时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date diaodushijian;
		
	/**
	 * 调度原因
	 */
	
	private String diaoduyuanyin;
		
	/**
	 * 司机账号
	 */
	
	private String sijizhanghao;
		
	/**
	 * 司机姓名
	 */
	
	private String sijixingming;
				
	
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
	 * 设置：车辆图片
	 */
	 
	public void setCheliangtupian(String cheliangtupian) {
		this.cheliangtupian = cheliangtupian;
	}
	
	/**
	 * 获取：车辆图片
	 */
	public String getCheliangtupian() {
		return cheliangtupian;
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
	 * 设置：调度时间
	 */
	 
	public void setDiaodushijian(Date diaodushijian) {
		this.diaodushijian = diaodushijian;
	}
	
	/**
	 * 获取：调度时间
	 */
	public Date getDiaodushijian() {
		return diaodushijian;
	}
				
	
	/**
	 * 设置：调度原因
	 */
	 
	public void setDiaoduyuanyin(String diaoduyuanyin) {
		this.diaoduyuanyin = diaoduyuanyin;
	}
	
	/**
	 * 获取：调度原因
	 */
	public String getDiaoduyuanyin() {
		return diaoduyuanyin;
	}
				
	
	/**
	 * 设置：司机账号
	 */
	 
	public void setSijizhanghao(String sijizhanghao) {
		this.sijizhanghao = sijizhanghao;
	}
	
	/**
	 * 获取：司机账号
	 */
	public String getSijizhanghao() {
		return sijizhanghao;
	}
				
	
	/**
	 * 设置：司机姓名
	 */
	 
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
			
}
