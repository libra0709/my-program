package com.dao;

import com.entity.YunshurenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YunshurenwuVO;
import com.entity.view.YunshurenwuView;


/**
 * 运输任务
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface YunshurenwuDao extends BaseMapper<YunshurenwuEntity> {
	
	List<YunshurenwuVO> selectListVO(@Param("ew") Wrapper<YunshurenwuEntity> wrapper);
	
	YunshurenwuVO selectVO(@Param("ew") Wrapper<YunshurenwuEntity> wrapper);
	
	List<YunshurenwuView> selectListView(@Param("ew") Wrapper<YunshurenwuEntity> wrapper);

	List<YunshurenwuView> selectListView(Pagination page,@Param("ew") Wrapper<YunshurenwuEntity> wrapper);

	
	YunshurenwuView selectView(@Param("ew") Wrapper<YunshurenwuEntity> wrapper);
	

}
