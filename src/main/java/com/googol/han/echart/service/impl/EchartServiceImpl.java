package com.googol.han.echart.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.echart.dao.EchartDao;
import com.googol.han.echart.service.EchartService;
@SuppressWarnings("all")
@Service("echartService")
public class EchartServiceImpl implements EchartService{

	@Autowired
	public EchartDao echartDao;
	@Override
	public List<Map<String, Object>> getInfo(String tableName,String state1,String state2) {
		String sql="select case when goodState='"+state1+"' then '������' when goodState='"+state2+"' then '�¼�' end as goodState,count(goodState) as GCOUNT from "+tableName+" group by goodState";
		System.out.println(sql);
		return echartDao.getUserInfo(sql);
	}
	@Override
	public List<Map<String, Object>> getInfo1(String string, String string2, String string3) {
		String sql="select case when DEPOTSTATE='"+string2+"' then '��Ӫ��' when DEPOTSTATE='"+string3+"' then 'ֹͣ��Ӫ' end as DEPOTSTATE,count(DEPOTSTATE) as GCOUNT from "+string+" group by DEPOTSTATE";
		System.out.println(sql);
		return echartDao.getUserInfo1(sql);
	}
	@Override
	public List<Map<String, Object>> getInfo2(String string, String string2, String string3) {
		String sql="select case when COMPANYSTATE='"+string2+"' then '������' when COMPANYSTATE='"+string3+"' then '������ֹ' end as COMPANYSTATE,count(COMPANYSTATE) as GCOUNT from "+string+" group by COMPANYSTATE";
		System.out.println(sql);
		return echartDao.getUserInfo1(sql);
	}
	@Override
	public List<Map<String, Object>> getInfo3(String string, String string2, String string3) {
		String sql="select case when USERSTATE='"+string2+"' then '��ְ' when USERSTATE='"+string3+"' then '��ְ' end as USERSTATE,count(USERSTATE) as GCOUNT from "+string+" group by USERSTATE";
		System.out.println(sql);
		return echartDao.getUserInfo1(sql);
	}
}
