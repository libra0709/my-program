package com.dao;

import com.entity.CheliangdiaoduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangdiaoduVO;
import com.entity.view.CheliangdiaoduView;


/**
 * 车辆调度
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface CheliangdiaoduDao extends BaseMapper<CheliangdiaoduEntity> {
	
	List<CheliangdiaoduVO> selectListVO(@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);
	
	CheliangdiaoduVO selectVO(@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);
	
	List<CheliangdiaoduView> selectListView(@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);

	List<CheliangdiaoduView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);

	
	CheliangdiaoduView selectView(@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);
	

}
