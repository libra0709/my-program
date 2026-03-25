package com.dao;

import com.entity.YunshugenzongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YunshugenzongVO;
import com.entity.view.YunshugenzongView;


/**
 * 运输跟踪
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface YunshugenzongDao extends BaseMapper<YunshugenzongEntity> {
	
	List<YunshugenzongVO> selectListVO(@Param("ew") Wrapper<YunshugenzongEntity> wrapper);
	
	YunshugenzongVO selectVO(@Param("ew") Wrapper<YunshugenzongEntity> wrapper);
	
	List<YunshugenzongView> selectListView(@Param("ew") Wrapper<YunshugenzongEntity> wrapper);

	List<YunshugenzongView> selectListView(Pagination page,@Param("ew") Wrapper<YunshugenzongEntity> wrapper);

	
	YunshugenzongView selectView(@Param("ew") Wrapper<YunshugenzongEntity> wrapper);
	

}
