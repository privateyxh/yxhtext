package com.googol.han.goods.service;

import java.util.List;


import com.googol.han.entity.Goods;
@SuppressWarnings("all")
public interface GoodsService {

	
	//���»�ɾ��
	public Integer update(Goods goods);
	//ȫ��ѯ
	public List findall();
	//���
	public Integer add(Goods goods);
	//��ҳ
	public List listpage(String pageno,String pagesize);
	
	public Goods getOne(Goods goods);

}
