package com.googol.han.echart.service;

import java.util.List;
import java.util.Map;
@SuppressWarnings("all")
public interface EchartService {
	public List<Map<String, Object>> getInfo(String tableName,String state1,String state2);

	public List<Map<String, Object>> getInfo1(String string, String string2, String string3);
	
	public List<Map<String, Object>> getInfo2(String string, String string2, String string3);
	
	public List<Map<String, Object>> getInfo3(String string, String string2, String string3);
}
