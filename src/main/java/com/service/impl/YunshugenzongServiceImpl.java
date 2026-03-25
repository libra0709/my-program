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


import com.dao.YunshugenzongDao;
import com.entity.YunshugenzongEntity;
import com.service.YunshugenzongService;
import com.entity.vo.YunshugenzongVO;
import com.entity.view.YunshugenzongView;

@Service("yunshugenzongService")
public class YunshugenzongServiceImpl extends ServiceImpl<YunshugenzongDao, YunshugenzongEntity> implements YunshugenzongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunshugenzongEntity> page = this.selectPage(
                new Query<YunshugenzongEntity>(params).getPage(),
                new EntityWrapper<YunshugenzongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunshugenzongEntity> wrapper) {
		  Page<YunshugenzongView> page =new Query<YunshugenzongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YunshugenzongVO> selectListVO(Wrapper<YunshugenzongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunshugenzongVO selectVO(Wrapper<YunshugenzongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunshugenzongView> selectListView(Wrapper<YunshugenzongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunshugenzongView selectView(Wrapper<YunshugenzongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
