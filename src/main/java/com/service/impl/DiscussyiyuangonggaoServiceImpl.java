package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyiyuangonggaoDao;
import com.entity.DiscussyiyuangonggaoEntity;
import com.service.DiscussyiyuangonggaoService;
import com.entity.vo.DiscussyiyuangonggaoVO;
import com.entity.view.DiscussyiyuangonggaoView;

@Service("discussyiyuangonggaoService")
public class DiscussyiyuangonggaoServiceImpl extends ServiceImpl<DiscussyiyuangonggaoDao, DiscussyiyuangonggaoEntity> implements DiscussyiyuangonggaoService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyiyuangonggaoEntity> page = this.selectPage(
                new Query<DiscussyiyuangonggaoEntity>(params).getPage(),
                new EntityWrapper<DiscussyiyuangonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyiyuangonggaoEntity> wrapper) {
		  Page<DiscussyiyuangonggaoView> page =new Query<DiscussyiyuangonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyiyuangonggaoVO> selectListVO(Wrapper<DiscussyiyuangonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyiyuangonggaoVO selectVO(Wrapper<DiscussyiyuangonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyiyuangonggaoView> selectListView(Wrapper<DiscussyiyuangonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyiyuangonggaoView selectView(Wrapper<DiscussyiyuangonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
