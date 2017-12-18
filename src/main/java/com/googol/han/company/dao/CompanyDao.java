package com.googol.han.company.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Company;


/**
 * @author 远笑晗
 *单位表的DAO
 */
@SuppressWarnings("all")
public interface CompanyDao {
	//查询全部
	List<Map> finallBuCompany();
	//根据id和单位名查询
	List<Map> finBycompanyIdorcompanyName(Company company);
	//更新
	Integer updateCompany(Company company);
	//添加
	Integer addCompany(Company company);
	List<Map> page(String sql);
}
