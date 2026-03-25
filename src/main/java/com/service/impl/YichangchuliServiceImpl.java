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


import com.dao.YichangchuliDao;
import com.entity.YichangchuliEntity;
import com.service.YichangchuliService;
import com.entity.vo.YichangchuliVO;
import com.entity.view.YichangchuliView;

@Service("yichangchuliService")
public class YichangchuliServiceImpl extends ServiceImpl<YichangchuliDao, YichangchuliEntity> implements YichangchuliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YichangchuliEntity> page = this.selectPage(
                new Query<YichangchuliEntity>(params).getPage(),
                new EntityWrapper<YichangchuliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YichangchuliEntity> wrapper) {
		  Page<YichangchuliView> page =new Query<YichangchuliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YichangchuliVO> selectListVO(Wrapper<YichangchuliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YichangchuliVO selectVO(Wrapper<YichangchuliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YichangchuliView> selectListView(Wrapper<YichangchuliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YichangchuliView selectView(Wrapper<YichangchuliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
