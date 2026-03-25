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

import com.entity.YunshurenwuEntity;
import com.entity.view.YunshurenwuView;

import com.service.YunshurenwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 运输任务
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/yunshurenwu")
public class YunshurenwuController {
    @Autowired
    private YunshurenwuService yunshurenwuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YunshurenwuEntity yunshurenwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yunshurenwu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yunshurenwu.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YunshurenwuEntity> ew = new EntityWrapper<YunshurenwuEntity>();


        //查询结果
		PageUtils page = yunshurenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunshurenwu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YunshurenwuEntity yunshurenwu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YunshurenwuEntity> ew = new EntityWrapper<YunshurenwuEntity>();

        //查询结果
		PageUtils page = yunshurenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunshurenwu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YunshurenwuEntity yunshurenwu){
       	EntityWrapper<YunshurenwuEntity> ew = new EntityWrapper<YunshurenwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yunshurenwu, "yunshurenwu")); 
        return R.ok().put("data", yunshurenwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YunshurenwuEntity yunshurenwu){
        EntityWrapper< YunshurenwuEntity> ew = new EntityWrapper< YunshurenwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yunshurenwu, "yunshurenwu")); 
		YunshurenwuView yunshurenwuView =  yunshurenwuService.selectView(ew);
		return R.ok("查询运输任务成功").put("data", yunshurenwuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YunshurenwuEntity yunshurenwu = yunshurenwuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yunshurenwu,deSens);
        return R.ok().put("data", yunshurenwu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YunshurenwuEntity yunshurenwu = yunshurenwuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yunshurenwu,deSens);
        return R.ok().put("data", yunshurenwu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增运输任务") 
    public R save(@RequestBody YunshurenwuEntity yunshurenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshurenwu);
        yunshurenwuService.insert(yunshurenwu);
        return R.ok().put("data",yunshurenwu.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增运输任务")
    @RequestMapping("/add")
    public R add(@RequestBody YunshurenwuEntity yunshurenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshurenwu);
        yunshurenwuService.insert(yunshurenwu);
        return R.ok().put("data",yunshurenwu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改运输任务")
    public R update(@RequestBody YunshurenwuEntity yunshurenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshurenwu);
        //全部更新
        yunshurenwuService.updateById(yunshurenwu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除运输任务")
    public R delete(@RequestBody Long[] ids){
        yunshurenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
