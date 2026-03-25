package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CangguanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CangguanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CangguanView;


/**
 * 员工
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:21
 */
public interface CangguanService extends IService<CangguanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CangguanVO> selectListVO(Wrapper<CangguanEntity> wrapper);
   	
   	CangguanVO selectVO(@Param("ew") Wrapper<CangguanEntity> wrapper);
   	
   	List<CangguanView> selectListView(Wrapper<CangguanEntity> wrapper);
   	
   	CangguanView selectView(@Param("ew") Wrapper<CangguanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CangguanEntity> wrapper);

   	

}

