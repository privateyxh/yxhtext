package com.googol.han.company.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.company.dao.CompanyDao;
import com.googol.han.company.service.CompanyService;
import com.googol.han.entity.Company;
@SuppressWarnings("all")
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	// 全查询
	@Override
	public List<Map> findAll() {
		// TODO Auto-generated method stub
		return companyDao.finallBuCompany();
	}

	// 更新
	@Override
	public Integer update(Company company) {
			return companyDao.updateCompany(company);
	}

	// 添加
	@Override
	public Integer add(Company company) {
		List<Map> list = companyDao.finBycompanyIdorcompanyName(company);
		Integer i = list.size();
		if (i == 0) {
			return companyDao.addCompany(company);
		} else {
			return null;
		}
	}

	@Override
	public List<Map> listpage(String pageno, String pagesize) {
		String tablename="GOOGOL_COMPANY";
		String sql="select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM "+tablename+" T  ) WHERE LIMITNUM BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize;
		System.out.println(sql);
		return companyDao.page(sql);
	}

	@Override
	public Company getOne(Company company) {
		return (Company) companyDao.finBycompanyIdorcompanyName(company).get(0);
	}

}
