package com.googol.han.sole.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.entity.Sole;
import com.googol.han.sole.dao.SoleDao;
import com.googol.han.sole.service.SoleService;
@SuppressWarnings("all")
@Service("soleService")
public class SoleServiceImpl implements SoleService {

	@Autowired
	private SoleDao soleDao;
	//��ѯ��λ
	@Override
	public List<Map> findByCompany() {
		// TODO Auto-generated method stub
		return soleDao.findByCompany();
	}

	//��ѯԱ��
	@Override
	public List<Map> findByUser() {
		// TODO Auto-generated method stub
		return soleDao.findByUser();
	}

	//��ѯ�ֿ�
	@Override
	public List<Map> findByDepot() {
		// TODO Auto-generated method stub
		return soleDao.findByDepot();
	}

	//��ѯ��Ʒ
	@Override
	public List<Map> findByGoods() {
		// TODO Auto-generated method stub
		return soleDao.findByGoods();
	}

	//������۵�
	@Override
	public Integer addBySole(Sole sole) {
		// TODO Auto-generated method stub
		return soleDao.addBySole(sole);
	}

	//��ѯ���۵�
	@Override
	public List<Map> findBySole() {
		// TODO Auto-generated method stub
		return soleDao.findBySole();
	}

	
	//��ҳ
	@Override
	public List listpage(String pageno, String pagesize) {
		String tablename="googol_sole";
		String sql="select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM "+tablename+" T  ) WHERE LIMITNUM BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize;
		System.out.println(sql);
		return soleDao.page(sql);
	}

}
