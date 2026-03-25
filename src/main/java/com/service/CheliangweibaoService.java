package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangweibaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangweibaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangweibaoView;


/**
 * 车辆维保
 *
 * @author 
 * @email 
 * @date 2025-04-13 23:46:22
 */
public interface CheliangweibaoService extends IService<CheliangweibaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangweibaoVO> selectListVO(Wrapper<CheliangweibaoEntity> wrapper);
   	
   	CheliangweibaoVO selectVO(@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);
   	
   	List<CheliangweibaoView> selectListView(Wrapper<CheliangweibaoEntity> wrapper);
   	
   	CheliangweibaoView selectView(@Param("ew") Wrapper<CheliangweibaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangweibaoEntity> wrapper);

   	

}

