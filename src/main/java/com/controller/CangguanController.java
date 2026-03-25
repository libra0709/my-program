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

import com.entity.CangguanEntity;
import com.entity.view.CangguanView;

import com.service.CangguanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 员工
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-13 23:46:21
 */
@RestController
@RequestMapping("/cangguan")
public class CangguanController {
    @Autowired
    private CangguanService cangguanService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        CangguanEntity u = cangguanService.selectOne(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"cangguan",  "仓管" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody CangguanEntity cangguan){
    	//ValidatorUtils.validateEntity(cangguan);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	CangguanEntity u = cangguanService.selectOne(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", cangguan.getCangguanzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同仓管账号，否则返回错误信息
        if(cangguanService.selectCount(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", cangguan.getCangguanzhanghao()))>0) {
            return R.error("仓管账号已存在");
        }
		Long uId = new Date().getTime();
		cangguan.setId(uId);
        //保存用户
        cangguanService.insert(cangguan);
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
        CangguanEntity u = cangguanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        CangguanEntity u = cangguanService.selectOne(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        cangguanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CangguanEntity cangguan,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CangguanEntity> ew = new EntityWrapper<CangguanEntity>();


        //查询结果
		PageUtils page = cangguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangguan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CangguanEntity cangguan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CangguanEntity> ew = new EntityWrapper<CangguanEntity>();

        //查询结果
		PageUtils page = cangguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangguan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CangguanEntity cangguan){
       	EntityWrapper<CangguanEntity> ew = new EntityWrapper<CangguanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cangguan, "cangguan")); 
        return R.ok().put("data", cangguanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CangguanEntity cangguan){
        EntityWrapper< CangguanEntity> ew = new EntityWrapper< CangguanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cangguan, "cangguan")); 
		CangguanView cangguanView =  cangguanService.selectView(ew);
		return R.ok("查询员工成功").put("data", cangguanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CangguanEntity cangguan = cangguanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cangguan,deSens);
        return R.ok().put("data", cangguan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CangguanEntity cangguan = cangguanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(cangguan,deSens);
        return R.ok().put("data", cangguan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增员工") 
    public R save(@RequestBody CangguanEntity cangguan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(cangguanService.selectCount(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", cangguan.getCangguanzhanghao()))>0) {
            return R.error("仓管账号已存在");
        }
        //ValidatorUtils.validateEntity(cangguan);
        //验证账号唯一性，否则返回错误信息
        CangguanEntity u = cangguanService.selectOne(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", cangguan.getCangguanzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	cangguan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		cangguan.setId(new Date().getTime());
        cangguanService.insert(cangguan);
        return R.ok().put("data",cangguan.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增员工")
    @RequestMapping("/add")
    public R add(@RequestBody CangguanEntity cangguan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(cangguanService.selectCount(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", cangguan.getCangguanzhanghao()))>0) {
            return R.error("仓管账号已存在");
        }
        //ValidatorUtils.validateEntity(cangguan);
        //验证账号唯一性，否则返回错误信息
        CangguanEntity u = cangguanService.selectOne(new EntityWrapper<CangguanEntity>().eq("cangguanzhanghao", cangguan.getCangguanzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	cangguan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		cangguan.setId(new Date().getTime());
        cangguanService.insert(cangguan);
        return R.ok().put("data",cangguan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改员工")
    public R update(@RequestBody CangguanEntity cangguan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cangguan);
        //验证字段唯一性，否则返回错误信息
        if(cangguanService.selectCount(new EntityWrapper<CangguanEntity>().ne("id", cangguan.getId()).eq("cangguanzhanghao", cangguan.getCangguanzhanghao()))>0) {
            return R.error("仓管账号已存在");
        }
        //全部更新
        cangguanService.updateById(cangguan);
        if(null!=cangguan.getCangguanzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(cangguan.getCangguanzhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", cangguan.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除员工")
    public R delete(@RequestBody Long[] ids){
        cangguanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
