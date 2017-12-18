package com.googol.han.goods.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Goods;
@SuppressWarnings("all")
public interface GoodsDao {
	
		//全查询
		public List<Map> findAllByGoods();
		//修改和删除
		public Integer updateByGoods(Goods goods);
		//添加
		public Integer addByGoods(Goods goods);
		//查询编号和商品名
		public List<Map> findByGoodsIdAndGoodsName(Goods goods);
		//分页
		public List<Map> page(String sql);
}
