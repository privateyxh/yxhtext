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
	//查询单位
	@Override
	public List<Map> findByCompany() {
		// TODO Auto-generated method stub
		return soleDao.findByCompany();
	}

	//查询员工
	@Override
	public List<Map> findByUser() {
		// TODO Auto-generated method stub
		return soleDao.findByUser();
	}

	//查询仓库
	@Override
	public List<Map> findByDepot() {
		// TODO Auto-generated method stub
		return soleDao.findByDepot();
	}

	//查询物品
	@Override
	public List<Map> findByGoods() {
		// TODO Auto-generated method stub
		return soleDao.findByGoods();
	}

	//添加销售单
	@Override
	public Integer addBySole(Sole sole) {
		// TODO Auto-generated method stub
		return soleDao.addBySole(sole);
	}

	//查询销售单
	@Override
	public List<Map> findBySole() {
		// TODO Auto-generated method stub
		return soleDao.findBySole();
	}

	
	//分页
	@Override
	public List listpage(String pageno, String pagesize) {
		String tablename="googol_sole";
		String sql="select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM "+tablename+" T  ) WHERE LIMITNUM BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize;
		System.out.println(sql);
		return soleDao.page(sql);
	}

}
