package com.entity.view;

import com.entity.MenzhenbingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 门诊病历
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-22 17:15:51
 */
@TableName("menzhenbingli")
public class MenzhenbingliView  extends MenzhenbingliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MenzhenbingliView(){
	}
 
 	public MenzhenbingliView(MenzhenbingliEntity menzhenbingliEntity){
 	try {
			BeanUtils.copyProperties(this, menzhenbingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
