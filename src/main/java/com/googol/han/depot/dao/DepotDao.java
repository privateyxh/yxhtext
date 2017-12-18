package com.googol.han.depot.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Depot;


/**
 * @author ԶЦ��
 *
 */
@SuppressWarnings("all")
public interface DepotDao {
	
	//ȫ��ѯ
	public List<Map> findAllByDepot();
	//�޸ĺ�ɾ��
	public Integer updateByDepot(Depot depot);
	//���
	public Integer addByDepot(Depot depot);
	//��ѯ��źͲֿ���
	public List<Map> findBydepotIdAnddepotName(Depot depot);
	//��ҳ
	public List<Map> page(String sql);

}
