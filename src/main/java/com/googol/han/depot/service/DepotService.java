package com.googol.han.depot.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Depot;
@SuppressWarnings("all")
public interface DepotService {

	//ȫ��ѯ
	public List<Map> findAll();
	//���»�ɾ��
	public Integer update(Depot depot);
	//���
	public Integer add(Depot depot);
	//��ҳ
	public List listpage(String pageno,String pagesize);
	public Depot getOne(Depot depot);
}
