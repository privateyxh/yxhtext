package com.googol.han.company.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Company;
import com.googol.han.entity.Depot;

@SuppressWarnings("all")
public interface CompanyService {

		//ȫ��ѯ
		public List<Map> findAll();
		//���»�ɾ��
		public Integer update(Company company);
		//���
		public Integer add(Company company);
		public List<Map> listpage(String pageno, String pagesize);
		public Company getOne(Company company);
	
	
}
