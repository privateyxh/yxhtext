package com.googol.han.goods.service;

import java.util.List;


import com.googol.han.entity.Goods;
@SuppressWarnings("all")
public interface GoodsService {

	
	//更新或删除
	public Integer update(Goods goods);
	//全查询
	public List findall();
	//添加
	public Integer add(Goods goods);
	//分页
	public List listpage(String pageno,String pagesize);
	
	public Goods getOne(Goods goods);

}
