package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.SijiEntity;
import com.entity.view.SijiView;

import com.service.SijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 司机
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
@RestController
@RequestMapping("/siji")
public class SijiController {
    @Autowired
    private SijiService sijiService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"siji",  "司机" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody SijiEntity siji){
    	//ValidatorUtils.validateEntity(siji);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同司机账号，否则返回错误信息
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
		Long uId = new Date().getTime();
		siji.setId(uId);
        //保存用户
        sijiService.insert(siji);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        SijiEntity u = sijiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        sijiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SijiEntity siji,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();


        //查询结果
		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
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
    public R list(@RequestParam Map<String, Object> params,SijiEntity siji, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();

        //查询结果
		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SijiEntity siji){
       	EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( siji, "siji")); 
        return R.ok().put("data", sijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SijiEntity siji){
        EntityWrapper< SijiEntity> ew = new EntityWrapper< SijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( siji, "siji")); 
		SijiView sijiView =  sijiService.selectView(ew);
		return R.ok("查询司机成功").put("data", sijiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(siji,deSens);
        return R.ok().put("data", siji);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(siji,deSens);
        return R.ok().put("data", siji);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增司机") 
    public R save(@RequestBody SijiEntity siji, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        //ValidatorUtils.validateEntity(siji);
        //验证账号唯一性，否则返回错误信息
        SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	siji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		siji.setId(new Date().getTime());
        sijiService.insert(siji);
        return R.ok().put("data",siji.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增司机")
    @RequestMapping("/add")
    public R add(@RequestBody SijiEntity siji, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        //ValidatorUtils.validateEntity(siji);
        //验证账号唯一性，否则返回错误信息
        SijiEntity u = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	siji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		siji.setId(new Date().getTime());
        sijiService.insert(siji);
        return R.ok().put("data",siji.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改司机")
    public R update(@RequestBody SijiEntity siji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(siji);
        //验证字段唯一性，否则返回错误信息
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().ne("id", siji.getId()).eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        //全部更新
        sijiService.updateById(siji);
        if(null!=siji.getSijizhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(siji.getSijizhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", siji.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除司机")
    public R delete(@RequestBody Long[] ids){
        sijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
