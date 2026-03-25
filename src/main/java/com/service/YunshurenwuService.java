package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YunshurenwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YunshurenwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YunshurenwuView;


/**
 * 运输任务
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface YunshurenwuService extends IService<YunshurenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunshurenwuVO> selectListVO(Wrapper<YunshurenwuEntity> wrapper);
   	
   	YunshurenwuVO selectVO(@Param("ew") Wrapper<YunshurenwuEntity> wrapper);
   	
   	List<YunshurenwuView> selectListView(Wrapper<YunshurenwuEntity> wrapper);
   	
   	YunshurenwuView selectView(@Param("ew") Wrapper<YunshurenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunshurenwuEntity> wrapper);

   	

}

