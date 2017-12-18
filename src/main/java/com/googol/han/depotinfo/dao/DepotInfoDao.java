package com.googol.han.depotinfo.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.DepotInfo;
@SuppressWarnings("all")
public interface DepotInfoDao {
	
	//��Ӷ���
	Integer addByDepotInfo(DepotInfo depotInfo);
	//��ѯ��Ʒ
	List<Map> findByGoods();
	//��ѯԱ��
	List<Map> findByUser();
	//��ѯ�ֿ�
	List<Map> findBuDepot();
	//��ҳ
	List<Map> page(String sql);
	//��ѯ���ж���
	List<Map> finByDepotInfo();
	//��ѯ��λ
	List<Map> findByCompany();

}
