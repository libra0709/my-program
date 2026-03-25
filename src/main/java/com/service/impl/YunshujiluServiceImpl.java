package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YunshujiluDao;
import com.entity.YunshujiluEntity;
import com.service.YunshujiluService;
import com.entity.vo.YunshujiluVO;
import com.entity.view.YunshujiluView;

@Service("yunshujiluService")
public class YunshujiluServiceImpl extends ServiceImpl<YunshujiluDao, YunshujiluEntity> implements YunshujiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunshujiluEntity> page = this.selectPage(
                new Query<YunshujiluEntity>(params).getPage(),
                new EntityWrapper<YunshujiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunshujiluEntity> wrapper) {
		  Page<YunshujiluView> page =new Query<YunshujiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YunshujiluVO> selectListVO(Wrapper<YunshujiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunshujiluVO selectVO(Wrapper<YunshujiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunshujiluView> selectListView(Wrapper<YunshujiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunshujiluView selectView(Wrapper<YunshujiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YunshujiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YunshujiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YunshujiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
