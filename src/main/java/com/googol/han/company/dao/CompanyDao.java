package com.googol.han.company.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Company;


/**
 * @author ԶЦ��
 *��λ���DAO
 */
@SuppressWarnings("all")
public interface CompanyDao {
	//��ѯȫ��
	List<Map> finallBuCompany();
	//����id�͵�λ����ѯ
	List<Map> finBycompanyIdorcompanyName(Company company);
	//����
	Integer updateCompany(Company company);
	//���
	Integer addCompany(Company company);
	List<Map> page(String sql);
}
