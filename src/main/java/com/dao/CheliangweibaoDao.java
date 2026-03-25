package com.dao;

import com.entity.CheliangweibaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangweibaoVO;
import com.entity.view.CheliangweibaoView;


/**
 * 车辆维保
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface CheliangweibaoDao extends BaseMapper<CheliangweibaoEntity> {
	
	List<CheliangweibaoVO> selectListVO(@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);
	
	CheliangweibaoVO selectVO(@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);
	
	List<CheliangweibaoView> selectListView(@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);

	List<CheliangweibaoView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);

	
	CheliangweibaoView selectView(@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);
	

}
