package com.googol.han.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.entity.Goods;
import com.googol.han.goods.dao.GoodsDao;
import com.googol.han.goods.service.GoodsService;

@SuppressWarnings("all")
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	public GoodsDao goodsDao;

	@Override
	public Integer update(Goods goods) {
		return goodsDao.updateByGoods(goods);
	}

	@Override
	public Integer add(Goods goods) {
		return goodsDao.addByGoods(goods);
	}

	@Override
	public List listpage(String pageno, String pagesize) {
		String tablename = "googol_goods";
		String sql = "select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM " + tablename
				+ " T  ) WHERE LIMITNUM BETWEEN (" + pageno + "-1)*" + pagesize + " AND " + pageno + "*" + pagesize;
		System.out.println(sql);
		return goodsDao.page(sql);
	}

	@Override
	public List findall() {
		// TODO Auto-generated method stub
		return goodsDao.findAllByGoods();
	}

	@Override
	public Goods getOne(Goods goods) {
		return (Goods) goodsDao.findByGoodsIdAndGoodsName(goods).get(0);

	}

}
