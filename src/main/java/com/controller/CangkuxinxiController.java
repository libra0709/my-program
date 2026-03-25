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

import com.entity.CangkuxinxiEntity;
import com.entity.view.CangkuxinxiView;

import com.service.CangkuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 仓库信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/cangkuxinxi")
public class CangkuxinxiController {
    @Autowired
    private CangkuxinxiService cangkuxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CangkuxinxiEntity cangkuxinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CangkuxinxiEntity> ew = new EntityWrapper<CangkuxinxiEntity>();


        //查询结果
		PageUtils page = cangkuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangkuxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CangkuxinxiEntity cangkuxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CangkuxinxiEntity> ew = new EntityWrapper<CangkuxinxiEntity>();

        //查询结果
		PageUtils page = cangkuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangkuxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CangkuxinxiEntity cangkuxinxi){
       	EntityWrapper<CangkuxinxiEntity> ew = new EntityWrapper<CangkuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cangkuxinxi, "cangkuxinxi")); 
        return R.ok().put("data", cangkuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CangkuxinxiEntity cangkuxinxi){
        EntityWrapper< CangkuxinxiEntity> ew = new EntityWrapper< CangkuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cangkuxinxi, "cangkuxinxi")); 
		CangkuxinxiView cangkuxinxiView =  cangkuxinxiService.selectView(ew);
		return R.ok("查询仓库信息成功").put("data", cangkuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CangkuxinxiEntity cangkuxinxi = cangkuxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cangkuxinxi,deSens);
        return R.ok().put("data", cangkuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CangkuxinxiEntity cangkuxinxi = cangkuxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cangkuxinxi,deSens);
        return R.ok().put("data", cangkuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增仓库信息") 
    public R save(@RequestBody CangkuxinxiEntity cangkuxinxi, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(cangkuxinxiService.selectCount(new EntityWrapper<CangkuxinxiEntity>().eq("cangkubianhao", cangkuxinxi.getCangkubianhao()))>0) {
            return R.error("仓库编号已存在");
        }
        //ValidatorUtils.validateEntity(cangkuxinxi);
        cangkuxinxiService.insert(cangkuxinxi);
        return R.ok().put("data",cangkuxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增仓库信息")
    @RequestMapping("/add")
    public R add(@RequestBody CangkuxinxiEntity cangkuxinxi, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(cangkuxinxiService.selectCount(new EntityWrapper<CangkuxinxiEntity>().eq("cangkubianhao", cangkuxinxi.getCangkubianhao()))>0) {
            return R.error("仓库编号已存在");
        }
        //ValidatorUtils.validateEntity(cangkuxinxi);
        cangkuxinxiService.insert(cangkuxinxi);
        return R.ok().put("data",cangkuxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改仓库信息")
    public R update(@RequestBody CangkuxinxiEntity cangkuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cangkuxinxi);
        //验证字段唯一性，否则返回错误信息
        if(cangkuxinxiService.selectCount(new EntityWrapper<CangkuxinxiEntity>().ne("id", cangkuxinxi.getId()).eq("cangkubianhao", cangkuxinxi.getCangkubianhao()))>0) {
            return R.error("仓库编号已存在");
        }
        //全部更新
        cangkuxinxiService.updateById(cangkuxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除仓库信息")
    public R delete(@RequestBody Long[] ids){
        cangkuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
