package com.dao;

import com.entity.JiuzhenpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuzhenpingjiaVO;
import com.entity.view.JiuzhenpingjiaView;


/**
 * 就诊评价
 * 
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
public interface JiuzhenpingjiaDao extends BaseMapper<JiuzhenpingjiaEntity> {
	
	List<JiuzhenpingjiaVO> selectListVO(@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);
	
	JiuzhenpingjiaVO selectVO(@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);
	
	List<JiuzhenpingjiaView> selectListView(@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);

	List<JiuzhenpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);
	
	JiuzhenpingjiaView selectView(@Param("ew") Wrapper<JiuzhenpingjiaEntity> wrapper);
	
}
