package com.dao;

import com.entity.CangguanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CangguanVO;
import com.entity.view.CangguanView;


/**
 * 员工
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:21
 */
public interface CangguanDao extends BaseMapper<CangguanEntity> {
	
	List<CangguanVO> selectListVO(@Param("ew") Wrapper<CangguanEntity> wrapper);
	
	CangguanVO selectVO(@Param("ew") Wrapper<CangguanEntity> wrapper);
	
	List<CangguanView> selectListView(@Param("ew") Wrapper<CangguanEntity> wrapper);

	List<CangguanView> selectListView(Pagination page,@Param("ew") Wrapper<CangguanEntity> wrapper);

	
	CangguanView selectView(@Param("ew") Wrapper<CangguanEntity> wrapper);
	

}
