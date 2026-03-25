package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YunshujiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YunshujiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YunshujiluView;


/**
 * 运输记录
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface YunshujiluService extends IService<YunshujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunshujiluVO> selectListVO(Wrapper<YunshujiluEntity> wrapper);
   	
   	YunshujiluVO selectVO(@Param("ew") Wrapper<YunshujiluEntity> wrapper);
   	
   	List<YunshujiluView> selectListView(Wrapper<YunshujiluEntity> wrapper);
   	
   	YunshujiluView selectView(@Param("ew") Wrapper<YunshujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunshujiluEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YunshujiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YunshujiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YunshujiluEntity> wrapper);



}

