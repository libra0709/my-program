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

import com.entity.ShangpinpandianEntity;
import com.entity.view.ShangpinpandianView;

import com.service.ShangpinpandianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 商品盘点
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:23
 */
@RestController
@RequestMapping("/shangpinpandian")
public class ShangpinpandianController {
    @Autowired
    private ShangpinpandianService shangpinpandianService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinpandianEntity shangpinpandian,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("cangguan")) {
			shangpinpandian.setCangguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShangpinpandianEntity> ew = new EntityWrapper<ShangpinpandianEntity>();


        //查询结果
		PageUtils page = shangpinpandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinpandian), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShangpinpandianEntity shangpinpandian, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShangpinpandianEntity> ew = new EntityWrapper<ShangpinpandianEntity>();

        //查询结果
		PageUtils page = shangpinpandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinpandian), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinpandianEntity shangpinpandian){
       	EntityWrapper<ShangpinpandianEntity> ew = new EntityWrapper<ShangpinpandianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinpandian, "shangpinpandian")); 
        return R.ok().put("data", shangpinpandianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinpandianEntity shangpinpandian){
        EntityWrapper< ShangpinpandianEntity> ew = new EntityWrapper< ShangpinpandianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinpandian, "shangpinpandian")); 
		ShangpinpandianView shangpinpandianView =  shangpinpandianService.selectView(ew);
		return R.ok("查询商品盘点成功").put("data", shangpinpandianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinpandianEntity shangpinpandian = shangpinpandianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shangpinpandian,deSens);
        return R.ok().put("data", shangpinpandian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinpandianEntity shangpinpandian = shangpinpandianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shangpinpandian,deSens);
        return R.ok().put("data", shangpinpandian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增商品盘点") 
    public R save(@RequestBody ShangpinpandianEntity shangpinpandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinpandian);
        shangpinpandianService.insert(shangpinpandian);
        return R.ok().put("data",shangpinpandian.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增商品盘点")
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinpandianEntity shangpinpandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinpandian);
        shangpinpandianService.insert(shangpinpandian);
        return R.ok().put("data",shangpinpandian.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改商品盘点")
    public R update(@RequestBody ShangpinpandianEntity shangpinpandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinpandian);
        //全部更新
        shangpinpandianService.updateById(shangpinpandian);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除商品盘点")
    public R delete(@RequestBody Long[] ids){
        shangpinpandianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
