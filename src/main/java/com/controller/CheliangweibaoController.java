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

import com.entity.CheliangweibaoEntity;
import com.entity.view.CheliangweibaoView;

import com.service.CheliangweibaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 车辆维保
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/cheliangweibao")
public class CheliangweibaoController {
    @Autowired
    private CheliangweibaoService cheliangweibaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangweibaoEntity cheliangweibao,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CheliangweibaoEntity> ew = new EntityWrapper<CheliangweibaoEntity>();


        //查询结果
		PageUtils page = cheliangweibaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangweibao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CheliangweibaoEntity cheliangweibao, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CheliangweibaoEntity> ew = new EntityWrapper<CheliangweibaoEntity>();

        //查询结果
		PageUtils page = cheliangweibaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangweibao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangweibaoEntity cheliangweibao){
       	EntityWrapper<CheliangweibaoEntity> ew = new EntityWrapper<CheliangweibaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangweibao, "cheliangweibao")); 
        return R.ok().put("data", cheliangweibaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangweibaoEntity cheliangweibao){
        EntityWrapper< CheliangweibaoEntity> ew = new EntityWrapper< CheliangweibaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangweibao, "cheliangweibao")); 
		CheliangweibaoView cheliangweibaoView =  cheliangweibaoService.selectView(ew);
		return R.ok("查询车辆维保成功").put("data", cheliangweibaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangweibaoEntity cheliangweibao = cheliangweibaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cheliangweibao,deSens);
        return R.ok().put("data", cheliangweibao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangweibaoEntity cheliangweibao = cheliangweibaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cheliangweibao,deSens);
        return R.ok().put("data", cheliangweibao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增车辆维保") 
    public R save(@RequestBody CheliangweibaoEntity cheliangweibao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangweibao);
        cheliangweibaoService.insert(cheliangweibao);
        return R.ok().put("data",cheliangweibao.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增车辆维保")
    @RequestMapping("/add")
    public R add(@RequestBody CheliangweibaoEntity cheliangweibao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangweibao);
        cheliangweibaoService.insert(cheliangweibao);
        return R.ok().put("data",cheliangweibao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改车辆维保")
    public R update(@RequestBody CheliangweibaoEntity cheliangweibao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangweibao);
        //全部更新
        cheliangweibaoService.updateById(cheliangweibao);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除车辆维保")
    public R delete(@RequestBody Long[] ids){
        cheliangweibaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
