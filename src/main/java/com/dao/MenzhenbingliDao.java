package com.dao;

import com.entity.MenzhenbingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MenzhenbingliVO;
import com.entity.view.MenzhenbingliView;


/**
 * 门诊病历
 * 
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
public interface MenzhenbingliDao extends BaseMapper<MenzhenbingliEntity> {
	
	List<MenzhenbingliVO> selectListVO(@Param("ew") Wrapper<MenzhenbingliEntity> wrapper);
	
	MenzhenbingliVO selectVO(@Param("ew") Wrapper<MenzhenbingliEntity> wrapper);
	
	List<MenzhenbingliView> selectListView(@Param("ew") Wrapper<MenzhenbingliEntity> wrapper);

	List<MenzhenbingliView> selectListView(Pagination page,@Param("ew") Wrapper<MenzhenbingliEntity> wrapper);
	
	MenzhenbingliView selectView(@Param("ew") Wrapper<MenzhenbingliEntity> wrapper);
	
}
