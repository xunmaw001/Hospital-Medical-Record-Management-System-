package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyiyuangonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyiyuangonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyiyuangonggaoView;


/**
 * 医院公告评论表
 *
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
public interface DiscussyiyuangonggaoService extends IService<DiscussyiyuangonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyiyuangonggaoVO> selectListVO(Wrapper<DiscussyiyuangonggaoEntity> wrapper);
   	
   	DiscussyiyuangonggaoVO selectVO(@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);
   	
   	List<DiscussyiyuangonggaoView> selectListView(Wrapper<DiscussyiyuangonggaoEntity> wrapper);
   	
   	DiscussyiyuangonggaoView selectView(@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyiyuangonggaoEntity> wrapper);
   	
}

