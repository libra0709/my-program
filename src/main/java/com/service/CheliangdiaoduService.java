package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangdiaoduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangdiaoduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangdiaoduView;


/**
 * 车辆调度
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface CheliangdiaoduService extends IService<CheliangdiaoduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangdiaoduVO> selectListVO(Wrapper<CheliangdiaoduEntity> wrapper);
   	
   	CheliangdiaoduVO selectVO(@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);
   	
   	List<CheliangdiaoduView> selectListView(Wrapper<CheliangdiaoduEntity> wrapper);
   	
   	CheliangdiaoduView selectView(@Param("ew") Wrapper<CheliangdiaoduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangdiaoduEntity> wrapper);

   	

}

