package com.googol.han.depot.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.depot.dao.DepotDao;
import com.googol.han.depot.service.DepotService;
import com.googol.han.entity.Depot;

/**
 * @author ԶЦ��
 * �ֿ���Ϣ��serviceģ��
 * 		
 *
 */
@SuppressWarnings("all")		  
@Service("depotService")
public class DepotServiceImpl implements DepotService, Serializable {
	private static final long serialVersionUID = -5432009344247633240L;
	@Autowired
	private DepotDao depotDao;
	
	
	//ȫ��ѯ
	@Override
	public List<Map> findAll() {
		// TODO Auto-generated method stub
		return depotDao.findAllByDepot();
	}
	//��ȡһ����ѯ
	public Depot getOne(Depot depot) {
		return (Depot) depotDao.findBydepotIdAnddepotName(depot).get(0);
	}
	//����
	@Override
	public Integer update(Depot depot) {
			return depotDao.updateByDepot(depot);
	}
	
	//���
	@Override
	public Integer add(Depot depot) {
		List<Map> list=depotDao.findBydepotIdAnddepotName(depot);
		Integer i=depotDao.findBydepotIdAnddepotName(depot).size();
		if(i==0) {
			return depotDao.addByDepot(depot);
		}else {
			return null;	
		}
		
	}

	//��ҳ
	@Override
	public List listpage(String pageno, String pagesize) {
		String tablename="googol_depot";
		String sql="select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM "+tablename+" T  ) WHERE LIMITNUM BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize;
		System.out.println(sql);
		return depotDao.page(sql);
	}

}
