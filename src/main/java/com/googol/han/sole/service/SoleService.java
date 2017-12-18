package com.googol.han.sole.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Sole;
@SuppressWarnings("all")
public interface SoleService {
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
	List listpage(String pageno,String pagesize);

}
