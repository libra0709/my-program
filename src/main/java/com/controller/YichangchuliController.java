package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.YichangchuliEntity;
import com.entity.view.YichangchuliView;

import com.service.YichangchuliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 异常处理
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:23
 */
@RestController
@RequestMapping("/yichangchuli")
public class YichangchuliController {
    @Autowired
    private YichangchuliService yichangchuliService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YichangchuliEntity yichangchuli,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yichangchuli.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yichangchuli.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YichangchuliEntity> ew = new EntityWrapper<YichangchuliEntity>();


        //查询结果
		PageUtils page = yichangchuliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangchuli), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YichangchuliEntity yichangchuli, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YichangchuliEntity> ew = new EntityWrapper<YichangchuliEntity>();

        //查询结果
		PageUtils page = yichangchuliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yichangchuli), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YichangchuliEntity yichangchuli){
       	EntityWrapper<YichangchuliEntity> ew = new EntityWrapper<YichangchuliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yichangchuli, "yichangchuli")); 
        return R.ok().put("data", yichangchuliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YichangchuliEntity yichangchuli){
        EntityWrapper< YichangchuliEntity> ew = new EntityWrapper< YichangchuliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yichangchuli, "yichangchuli")); 
		YichangchuliView yichangchuliView =  yichangchuliService.selectView(ew);
		return R.ok("查询异常处理成功").put("data", yichangchuliView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YichangchuliEntity yichangchuli = yichangchuliService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangchuli,deSens);
        return R.ok().put("data", yichangchuli);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YichangchuliEntity yichangchuli = yichangchuliService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yichangchuli,deSens);
        return R.ok().put("data", yichangchuli);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增异常处理") 
    public R save(@RequestBody YichangchuliEntity yichangchuli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangchuli);
        yichangchuliService.insert(yichangchuli);
        return R.ok().put("data",yichangchuli.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增异常处理")
    @RequestMapping("/add")
    public R add(@RequestBody YichangchuliEntity yichangchuli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangchuli);
        yichangchuliService.insert(yichangchuli);
        return R.ok().put("data",yichangchuli.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改异常处理")
    public R update(@RequestBody YichangchuliEntity yichangchuli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yichangchuli);
        //全部更新
        yichangchuliService.updateById(yichangchuli);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除异常处理")
    public R delete(@RequestBody Long[] ids){
        yichangchuliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
