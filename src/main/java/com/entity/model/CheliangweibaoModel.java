package com.entity.model;

import com.entity.CheliangweibaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车辆维保
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public class CheliangweibaoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date weibaoshijian;
		
	/**
	 * 维保详情
	 */
	
	private String weibaoxiangqing;
				
	
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
