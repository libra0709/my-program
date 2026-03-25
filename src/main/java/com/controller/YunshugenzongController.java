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

import com.entity.YunshugenzongEntity;
import com.entity.view.YunshugenzongView;

import com.service.YunshugenzongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 运输跟踪
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/yunshugenzong")
public class YunshugenzongController {
    @Autowired
    private YunshugenzongService yunshugenzongService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YunshugenzongEntity yunshugenzong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yunshugenzong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yunshugenzong.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YunshugenzongEntity> ew = new EntityWrapper<YunshugenzongEntity>();


        //查询结果
		PageUtils page = yunshugenzongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunshugenzong), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YunshugenzongEntity yunshugenzong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YunshugenzongEntity> ew = new EntityWrapper<YunshugenzongEntity>();

        //查询结果
		PageUtils page = yunshugenzongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunshugenzong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YunshugenzongEntity yunshugenzong){
       	EntityWrapper<YunshugenzongEntity> ew = new EntityWrapper<YunshugenzongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yunshugenzong, "yunshugenzong")); 
        return R.ok().put("data", yunshugenzongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YunshugenzongEntity yunshugenzong){
        EntityWrapper< YunshugenzongEntity> ew = new EntityWrapper< YunshugenzongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yunshugenzong, "yunshugenzong")); 
		YunshugenzongView yunshugenzongView =  yunshugenzongService.selectView(ew);
		return R.ok("查询运输跟踪成功").put("data", yunshugenzongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YunshugenzongEntity yunshugenzong = yunshugenzongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yunshugenzong,deSens);
        return R.ok().put("data", yunshugenzong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YunshugenzongEntity yunshugenzong = yunshugenzongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yunshugenzong,deSens);
        return R.ok().put("data", yunshugenzong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增运输跟踪") 
    public R save(@RequestBody YunshugenzongEntity yunshugenzong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshugenzong);
        yunshugenzongService.insert(yunshugenzong);
        return R.ok().put("data",yunshugenzong.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增运输跟踪")
    @RequestMapping("/add")
    public R add(@RequestBody YunshugenzongEntity yunshugenzong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshugenzong);
        yunshugenzongService.insert(yunshugenzong);
        return R.ok().put("data",yunshugenzong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改运输跟踪")
    public R update(@RequestBody YunshugenzongEntity yunshugenzong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshugenzong);
        //全部更新
        yunshugenzongService.updateById(yunshugenzong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除运输跟踪")
    public R delete(@RequestBody Long[] ids){
        yunshugenzongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
