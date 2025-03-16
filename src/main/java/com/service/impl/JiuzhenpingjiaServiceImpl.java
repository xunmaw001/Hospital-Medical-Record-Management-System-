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


import com.dao.JiuzhenpingjiaDao;
import com.entity.JiuzhenpingjiaEntity;
import com.service.JiuzhenpingjiaService;
import com.entity.vo.JiuzhenpingjiaVO;
import com.entity.view.JiuzhenpingjiaView;

@Service("jiuzhenpingjiaService")
public class JiuzhenpingjiaServiceImpl extends ServiceImpl<JiuzhenpingjiaDao, JiuzhenpingjiaEntity> implements JiuzhenpingjiaService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhenpingjiaEntity> page = this.selectPage(
                new Query<JiuzhenpingjiaEntity>(params).getPage(),
                new EntityWrapper<JiuzhenpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhenpingjiaEntity> wrapper) {
		  Page<JiuzhenpingjiaView> page =new Query<JiuzhenpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiuzhenpingjiaVO> selectListVO(Wrapper<JiuzhenpingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuzhenpingjiaVO selectVO(Wrapper<JiuzhenpingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuzhenpingjiaView> selectListView(Wrapper<JiuzhenpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhenpingjiaView selectView(Wrapper<JiuzhenpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
