package com.googol.han.depot.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Depot;
@SuppressWarnings("all")
public interface DepotService {

	//全查询
	public List<Map> findAll();
	//更新或删除
	public Integer update(Depot depot);
	//添加
	public Integer add(Depot depot);
	//分页
	public List listpage(String pageno,String pagesize);
	public Depot getOne(Depot depot);
}
