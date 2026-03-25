package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YichangchuliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YichangchuliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YichangchuliView;


/**
 * 异常处理
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:23
 */
public interface YichangchuliService extends IService<YichangchuliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YichangchuliVO> selectListVO(Wrapper<YichangchuliEntity> wrapper);
   	
   	YichangchuliVO selectVO(@Param("ew") Wrapper<YichangchuliEntity> wrapper);
   	
   	List<YichangchuliView> selectListView(Wrapper<YichangchuliEntity> wrapper);
   	
   	YichangchuliView selectView(@Param("ew") Wrapper<YichangchuliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YichangchuliEntity> wrapper);

   	

}

