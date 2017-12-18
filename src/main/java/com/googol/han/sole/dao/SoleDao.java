package com.googol.han.sole.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Sole;


/**
 * @author Administrator
 *	���۵�
 */
@SuppressWarnings("all")
public interface SoleDao {
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
	List<Map> page(String sql);
	

}
