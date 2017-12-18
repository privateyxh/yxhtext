package com.googol.han.depot.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Depot;


/**
 * @author 远笑晗
 *
 */
@SuppressWarnings("all")
public interface DepotDao {
	
	//全查询
	public List<Map> findAllByDepot();
	//修改和删除
	public Integer updateByDepot(Depot depot);
	//添加
	public Integer addByDepot(Depot depot);
	//查询编号和仓库名
	public List<Map> findBydepotIdAnddepotName(Depot depot);
	//分页
	public List<Map> page(String sql);

}
