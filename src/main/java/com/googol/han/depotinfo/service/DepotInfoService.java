package com.googol.han.depotinfo.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.DepotInfo;
@SuppressWarnings("all")
public interface DepotInfoService {

	
	//查询员工
	List<Map> findByUser();
	//查询仓库
	List<Map> findByDepot();
	//查询物品
	List<Map> findByGoods();
	//查询客户
	List<Map> findByCompany();
	//添加订单
	Integer addByDepotinfo(DepotInfo depotInfo);
	//分页查询
	public List<Map> listpage(String pageno, String pagesize);
	//查询所有订单
	public List<Map> findAll();
	
}
