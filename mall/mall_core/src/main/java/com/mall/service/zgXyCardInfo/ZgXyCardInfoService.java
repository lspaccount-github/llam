package com.mall.service.zgXyCardInfo;

import java.util.List;

import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfoCriteria;



/**
 * 
 * @ClassName: ZgXyCardInfoService
 * @Description: 医院sqlserver数据库 卡信息表
 * @author ShenWei 
 * @date 2017年12月14日 上午12:36:26
 *
 */
public interface ZgXyCardInfoService {

	/**
	 * 根据查询条件查询卡信息表
	 * @Title: selectByExample 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param zgXyCardInfoCriteria
	 * @param @return    设定文件 
	 * @return List<ZgXyCardInfo>    返回类型 
	 * @throws
	 */
	public List<ZgXyCardInfo> selectByExample(ZgXyCardInfoCriteria zgXyCardInfoCriteria);
}
