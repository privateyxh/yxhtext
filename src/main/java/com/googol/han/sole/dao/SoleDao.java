package com.googol.han.sole.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Sole;


/**
 * @author Administrator
 *	销售单
 */
@SuppressWarnings("all")
public interface SoleDao {
	//单位查询
	List<Map> findByCompany();
	//员工查询
	List<Map> findByUser();
	//仓库查询
	List<Map> findByDepot();
	//物品查询
	List<Map> findByGoods();
	
	
	
	//添加销售单
	Integer addBySole(Sole sole);
	//销售单查询
	List<Map> findBySole();
	//分页
	List<Map> page(String sql);
	

}
