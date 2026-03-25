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


import com.dao.CheliangweibaoDao;
import com.entity.CheliangweibaoEntity;
import com.service.CheliangweibaoService;
import com.entity.vo.CheliangweibaoVO;
import com.entity.view.CheliangweibaoView;

@Service("cheliangweibaoService")
public class CheliangweibaoServiceImpl extends ServiceImpl<CheliangweibaoDao, CheliangweibaoEntity> implements CheliangweibaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangweibaoEntity> page = this.selectPage(
                new Query<CheliangweibaoEntity>(params).getPage(),
                new EntityWrapper<CheliangweibaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangweibaoEntity> wrapper) {
		  Page<CheliangweibaoView> page =new Query<CheliangweibaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CheliangweibaoVO> selectListVO(Wrapper<CheliangweibaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheliangweibaoVO selectVO(Wrapper<CheliangweibaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheliangweibaoView> selectListView(Wrapper<CheliangweibaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangweibaoView selectView(Wrapper<CheliangweibaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
