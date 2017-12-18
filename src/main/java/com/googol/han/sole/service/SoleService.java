package com.googol.han.sole.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Sole;
@SuppressWarnings("all")
public interface SoleService {
	//��λ��ѯ
	List<Map> findByCompany();
	//Ա����ѯ
	List<Map> findByUser();
	//�ֿ��ѯ
	List<Map> findByDepot();
	//��Ʒ��ѯ
	List<Map> findByGoods();
	//������۵�
	Integer addBySole(Sole sole);
	//���۵���ѯ
	List<Map> findBySole();
	//��ҳ
	List listpage(String pageno,String pagesize);

}
