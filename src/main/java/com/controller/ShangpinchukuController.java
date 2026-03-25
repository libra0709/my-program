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

import com.entity.ShangpinchukuEntity;
import com.entity.view.ShangpinchukuView;

import com.service.ShangpinchukuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 商品出库
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/shangpinchuku")
public class ShangpinchukuController {
    @Autowired
    private ShangpinchukuService shangpinchukuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinchukuEntity shangpinchuku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("cangguan")) {
			shangpinchuku.setCangguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShangpinchukuEntity> ew = new EntityWrapper<ShangpinchukuEntity>();


        //查询结果
		PageUtils page = shangpinchukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinchuku), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShangpinchukuEntity shangpinchuku, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShangpinchukuEntity> ew = new EntityWrapper<ShangpinchukuEntity>();

        //查询结果
		PageUtils page = shangpinchukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinchuku), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinchukuEntity shangpinchuku){
       	EntityWrapper<ShangpinchukuEntity> ew = new EntityWrapper<ShangpinchukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinchuku, "shangpinchuku")); 
        return R.ok().put("data", shangpinchukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinchukuEntity shangpinchuku){
        EntityWrapper< ShangpinchukuEntity> ew = new EntityWrapper< ShangpinchukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinchuku, "shangpinchuku")); 
		ShangpinchukuView shangpinchukuView =  shangpinchukuService.selectView(ew);
		return R.ok("查询商品出库成功").put("data", shangpinchukuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinchukuEntity shangpinchuku = shangpinchukuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shangpinchuku,deSens);
        return R.ok().put("data", shangpinchuku);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinchukuEntity shangpinchuku = shangpinchukuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shangpinchuku,deSens);
        return R.ok().put("data", shangpinchuku);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增商品出库") 
    public R save(@RequestBody ShangpinchukuEntity shangpinchuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinchuku);
        shangpinchukuService.insert(shangpinchuku);
        return R.ok().put("data",shangpinchuku.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增商品出库")
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinchukuEntity shangpinchuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinchuku);
        shangpinchukuService.insert(shangpinchuku);
        return R.ok().put("data",shangpinchuku.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改商品出库")
    public R update(@RequestBody ShangpinchukuEntity shangpinchuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinchuku);
        //全部更新
        shangpinchukuService.updateById(shangpinchuku);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除商品出库")
    public R delete(@RequestBody Long[] ids){
        shangpinchukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
