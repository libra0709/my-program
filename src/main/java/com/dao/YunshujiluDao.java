package com.dao;

import com.entity.YunshujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YunshujiluVO;
import com.entity.view.YunshujiluView;


/**
 * 运输记录
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface YunshujiluDao extends BaseMapper<YunshujiluEntity> {
	
	List<YunshujiluVO> selectListVO(@Param("ew") Wrapper<YunshujiluEntity> wrapper);
	
	YunshujiluVO selectVO(@Param("ew") Wrapper<YunshujiluEntity> wrapper);
	
	List<YunshujiluView> selectListView(@Param("ew") Wrapper<YunshujiluEntity> wrapper);

	List<YunshujiluView> selectListView(Pagination page,@Param("ew") Wrapper<YunshujiluEntity> wrapper);

	
	YunshujiluView selectView(@Param("ew") Wrapper<YunshujiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YunshujiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YunshujiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YunshujiluEntity> wrapper);



}
