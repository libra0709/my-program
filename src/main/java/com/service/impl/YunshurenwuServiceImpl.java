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


import com.dao.YunshurenwuDao;
import com.entity.YunshurenwuEntity;
import com.service.YunshurenwuService;
import com.entity.vo.YunshurenwuVO;
import com.entity.view.YunshurenwuView;

@Service("yunshurenwuService")
public class YunshurenwuServiceImpl extends ServiceImpl<YunshurenwuDao, YunshurenwuEntity> implements YunshurenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunshurenwuEntity> page = this.selectPage(
                new Query<YunshurenwuEntity>(params).getPage(),
                new EntityWrapper<YunshurenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunshurenwuEntity> wrapper) {
		  Page<YunshurenwuView> page =new Query<YunshurenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YunshurenwuVO> selectListVO(Wrapper<YunshurenwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunshurenwuVO selectVO(Wrapper<YunshurenwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunshurenwuView> selectListView(Wrapper<YunshurenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunshurenwuView selectView(Wrapper<YunshurenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
