package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YunshugenzongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YunshugenzongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YunshugenzongView;


/**
 * 运输跟踪
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface YunshugenzongService extends IService<YunshugenzongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunshugenzongVO> selectListVO(Wrapper<YunshugenzongEntity> wrapper);
   	
   	YunshugenzongVO selectVO(@Param("ew") Wrapper<YunshugenzongEntity> wrapper);
   	
   	List<YunshugenzongView> selectListView(Wrapper<YunshugenzongEntity> wrapper);
   	
   	YunshugenzongView selectView(@Param("ew") Wrapper<YunshugenzongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunshugenzongEntity> wrapper);

   	

}

