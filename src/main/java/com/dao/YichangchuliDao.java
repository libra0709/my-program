package com.dao;

import com.entity.YichangchuliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YichangchuliVO;
import com.entity.view.YichangchuliView;


/**
 * 异常处理
 * 
 * @author 
 * @email 
 * @date 2025-04-13 23:46:23
 */
public interface YichangchuliDao extends BaseMapper<YichangchuliEntity> {
	
	List<YichangchuliVO> selectListVO(@Param("ew") Wrapper<YichangchuliEntity> wrapper);
	
	YichangchuliVO selectVO(@Param("ew") Wrapper<YichangchuliEntity> wrapper);
	
	List<YichangchuliView> selectListView(@Param("ew") Wrapper<YichangchuliEntity> wrapper);

	List<YichangchuliView> selectListView(Pagination page,@Param("ew") Wrapper<YichangchuliEntity> wrapper);

	
	YichangchuliView selectView(@Param("ew") Wrapper<YichangchuliEntity> wrapper);
	

}
