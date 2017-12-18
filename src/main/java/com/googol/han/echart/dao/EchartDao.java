package com.googol.han.echart.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Goods;
@SuppressWarnings("all")
public interface EchartDao {
	public List<Map<String, Object>> getUserInfo(String sql);
	public List<Map<String, Object>> getUserInfo1(String sql);
	public List<Map<String, Object>> getUserInfo2(String sql);
	public List<Map<String, Object>> getUserInfo3(String sql);
}
