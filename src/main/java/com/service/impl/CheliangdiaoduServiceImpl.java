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


import com.dao.CheliangdiaoduDao;
import com.entity.CheliangdiaoduEntity;
import com.service.CheliangdiaoduService;
import com.entity.vo.CheliangdiaoduVO;
import com.entity.view.CheliangdiaoduView;

@Service("cheliangdiaoduService")
public class CheliangdiaoduServiceImpl extends ServiceImpl<CheliangdiaoduDao, CheliangdiaoduEntity> implements CheliangdiaoduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangdiaoduEntity> page = this.selectPage(
                new Query<CheliangdiaoduEntity>(params).getPage(),
                new EntityWrapper<CheliangdiaoduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangdiaoduEntity> wrapper) {
		  Page<CheliangdiaoduView> page =new Query<CheliangdiaoduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CheliangdiaoduVO> selectListVO(Wrapper<CheliangdiaoduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheliangdiaoduVO selectVO(Wrapper<CheliangdiaoduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheliangdiaoduView> selectListView(Wrapper<CheliangdiaoduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangdiaoduView selectView(Wrapper<CheliangdiaoduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
