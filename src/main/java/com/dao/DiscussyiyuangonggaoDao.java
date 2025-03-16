package com.dao;

import com.entity.DiscussyiyuangonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyiyuangonggaoVO;
import com.entity.view.DiscussyiyuangonggaoView;


/**
 * 医院公告评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
public interface DiscussyiyuangonggaoDao extends BaseMapper<DiscussyiyuangonggaoEntity> {
	
	List<DiscussyiyuangonggaoVO> selectListVO(@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);
	
	DiscussyiyuangonggaoVO selectVO(@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);
	
	List<DiscussyiyuangonggaoView> selectListView(@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);

	List<DiscussyiyuangonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);
	
	DiscussyiyuangonggaoView selectView(@Param("ew") Wrapper<DiscussyiyuangonggaoEntity> wrapper);
	
}
