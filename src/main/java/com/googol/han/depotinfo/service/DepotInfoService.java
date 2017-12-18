package com.googol.han.depotinfo.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.DepotInfo;
@SuppressWarnings("all")
public interface DepotInfoService {

	
	//��ѯԱ��
	List<Map> findByUser();
	//��ѯ�ֿ�
	List<Map> findByDepot();
	//��ѯ��Ʒ
	List<Map> findByGoods();
	//��ѯ�ͻ�
	List<Map> findByCompany();
	//��Ӷ���
	Integer addByDepotinfo(DepotInfo depotInfo);
	//��ҳ��ѯ
	public List<Map> listpage(String pageno, String pagesize);
	//��ѯ���ж���
	public List<Map> findAll();
	
}
