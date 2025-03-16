package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuzhenpingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiuzhenpingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuzhenpingjiaView;


/**
 * 就诊评价
 *
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
public interface JiuzhenpingjiaService extends IService<JiuzhenpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuzhenpingjiaVO> selectListVO(Wrapper<JiuzhenpingjiaEntity> wrapper);
   	
   	JiuzhenpingjiaVO selectVO(@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);
   	
   	List<JiuzhenpingjiaView> selectListView(Wrapper<JiuzhenpingjiaEntity> wrapper);
   	
   	JiuzhenpingjiaView selectView(@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuzhenpingjiaEntity> wrapper);
   	
}

