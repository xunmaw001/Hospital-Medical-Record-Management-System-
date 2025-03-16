package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiuzhenpingjiaEntity;
import com.entity.view.JiuzhenpingjiaView;

import com.service.JiuzhenpingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 就诊评价
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
@RestController
@RequestMapping("/jiuzhenpingjia")
public class JiuzhenpingjiaController {
    @Autowired
    private JiuzhenpingjiaService jiuzhenpingjiaService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiuzhenpingjiaEntity jiuzhenpingjia, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			jiuzhenpingjia.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			jiuzhenpingjia.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiuzhenpingjiaEntity> ew = new EntityWrapper<JiuzhenpingjiaEntity>();
    	PageUtils page = jiuzhenpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuzhenpingjia), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiuzhenpingjiaEntity jiuzhenpingjia, HttpServletRequest request){
        EntityWrapper<JiuzhenpingjiaEntity> ew = new EntityWrapper<JiuzhenpingjiaEntity>();
    	PageUtils page = jiuzhenpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuzhenpingjia), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiuzhenpingjiaEntity jiuzhenpingjia){
       	EntityWrapper<JiuzhenpingjiaEntity> ew = new EntityWrapper<JiuzhenpingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiuzhenpingjia, "jiuzhenpingjia")); 
        return R.ok().put("data", jiuzhenpingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiuzhenpingjiaEntity jiuzhenpingjia){
        EntityWrapper< JiuzhenpingjiaEntity> ew = new EntityWrapper< JiuzhenpingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiuzhenpingjia, "jiuzhenpingjia")); 
		JiuzhenpingjiaView jiuzhenpingjiaView =  jiuzhenpingjiaService.selectView(ew);
		return R.ok("查询就诊评价成功").put("data", jiuzhenpingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiuzhenpingjiaEntity jiuzhenpingjia = jiuzhenpingjiaService.selectById(id);
        return R.ok().put("data", jiuzhenpingjia);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiuzhenpingjiaEntity jiuzhenpingjia = jiuzhenpingjiaService.selectById(id);
        return R.ok().put("data", jiuzhenpingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiuzhenpingjiaEntity jiuzhenpingjia, HttpServletRequest request){
    	jiuzhenpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuzhenpingjia);

        jiuzhenpingjiaService.insert(jiuzhenpingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiuzhenpingjiaEntity jiuzhenpingjia, HttpServletRequest request){
    	jiuzhenpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuzhenpingjia);

        jiuzhenpingjiaService.insert(jiuzhenpingjia);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiuzhenpingjiaEntity jiuzhenpingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiuzhenpingjia);
        jiuzhenpingjiaService.updateById(jiuzhenpingjia);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiuzhenpingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiuzhenpingjiaEntity> wrapper = new EntityWrapper<JiuzhenpingjiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			wrapper.eq("yishenggonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = jiuzhenpingjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
