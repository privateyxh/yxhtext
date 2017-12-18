package com.googol.han.company.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Company;
import com.googol.han.entity.Depot;

@SuppressWarnings("all")
public interface CompanyService {

		//全查询
		public List<Map> findAll();
		//更新或删除
		public Integer update(Company company);
		//添加
		public Integer add(Company company);
		public List<Map> listpage(String pageno, String pagesize);
		public Company getOne(Company company);
	
	
}
