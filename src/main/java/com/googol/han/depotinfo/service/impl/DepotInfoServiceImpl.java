package com.googol.han.depotinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.depotinfo.dao.DepotInfoDao;
import com.googol.han.depotinfo.service.DepotInfoService;
import com.googol.han.entity.DepotInfo;

@SuppressWarnings("all")
@Service("depotInfoService")
public class DepotInfoServiceImpl implements DepotInfoService{

	@Autowired
	private DepotInfoDao depotInfoDao;
	
	
	//��ѯԱ��
	@Override
	public List<Map> findByUser() {
		// TODO Auto-generated method stub
		return depotInfoDao.findByUser();
	}

	
	//��ѯ�ֿ�
	@Override
	public List<Map> findByDepot() {
		// TODO Auto-generated method stub
		return depotInfoDao.findBuDepot();
	}

	
	//��ѯ��Ʒ��Ϣ
	@Override
	public List<Map> findByGoods() {
		// TODO Auto-generated method stub
		return depotInfoDao.findByGoods();
	}
	
	@Override
	public List<Map> listpage(String pageno, String pagesize) {
		String tablename="GOOGOL_DEPOTINFO";
		String sql="select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM "+tablename+" T  ) WHERE LIMITNUM BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize;
		System.out.println(sql);
		return depotInfoDao.page(sql);
	}
	// ȫ��ѯ
		@Override
		public List<Map> findAll() {
			return depotInfoDao.finByDepotInfo();
		}


		//��ѯ��λ
		@Override
		public List<Map> findByCompany() {
			return depotInfoDao.findByCompany();
		}


		@Override
		public Integer addByDepotinfo(DepotInfo depotInfo) {
			return depotInfoDao.addByDepotInfo(depotInfo);
		}

}
