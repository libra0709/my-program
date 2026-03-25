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

import com.entity.CheliangdiaoduEntity;
import com.entity.view.CheliangdiaoduView;

import com.service.CheliangdiaoduService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 车辆调度
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/cheliangdiaodu")
public class CheliangdiaoduController {
    @Autowired
    private CheliangdiaoduService cheliangdiaoduService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangdiaoduEntity cheliangdiaodu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("siji")) {
			cheliangdiaodu.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<CheliangdiaoduEntity> ew = new EntityWrapper<CheliangdiaoduEntity>();


        //查询结果
		PageUtils page = cheliangdiaoduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangdiaodu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CheliangdiaoduEntity cheliangdiaodu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CheliangdiaoduEntity> ew = new EntityWrapper<CheliangdiaoduEntity>();

        //查询结果
		PageUtils page = cheliangdiaoduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangdiaodu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangdiaoduEntity cheliangdiaodu){
       	EntityWrapper<CheliangdiaoduEntity> ew = new EntityWrapper<CheliangdiaoduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangdiaodu, "cheliangdiaodu")); 
        return R.ok().put("data", cheliangdiaoduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangdiaoduEntity cheliangdiaodu){
        EntityWrapper< CheliangdiaoduEntity> ew = new EntityWrapper< CheliangdiaoduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangdiaodu, "cheliangdiaodu")); 
		CheliangdiaoduView cheliangdiaoduView =  cheliangdiaoduService.selectView(ew);
		return R.ok("查询车辆调度成功").put("data", cheliangdiaoduView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangdiaoduEntity cheliangdiaodu = cheliangdiaoduService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cheliangdiaodu,deSens);
        return R.ok().put("data", cheliangdiaodu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangdiaoduEntity cheliangdiaodu = cheliangdiaoduService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cheliangdiaodu,deSens);
        return R.ok().put("data", cheliangdiaodu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增车辆调度") 
    public R save(@RequestBody CheliangdiaoduEntity cheliangdiaodu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangdiaodu);
        cheliangdiaoduService.insert(cheliangdiaodu);
        return R.ok().put("data",cheliangdiaodu.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增车辆调度")
    @RequestMapping("/add")
    public R add(@RequestBody CheliangdiaoduEntity cheliangdiaodu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangdiaodu);
        cheliangdiaoduService.insert(cheliangdiaodu);
        return R.ok().put("data",cheliangdiaodu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改车辆调度")
    public R update(@RequestBody CheliangdiaoduEntity cheliangdiaodu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangdiaodu);
        //全部更新
        cheliangdiaoduService.updateById(cheliangdiaodu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除车辆调度")
    public R delete(@RequestBody Long[] ids){
        cheliangdiaoduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
