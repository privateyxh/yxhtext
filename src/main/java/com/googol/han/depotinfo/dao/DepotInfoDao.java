package com.googol.han.depotinfo.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.DepotInfo;
@SuppressWarnings("all")
public interface DepotInfoDao {
	
	//添加订单
	Integer addByDepotInfo(DepotInfo depotInfo);
	//查询物品
	List<Map> findByGoods();
	//查询员工
	List<Map> findByUser();
	//查询仓库
	List<Map> findBuDepot();
	//分页
	List<Map> page(String sql);
	//查询所有订单
	List<Map> finByDepotInfo();
	//查询单位
	List<Map> findByCompany();

}
