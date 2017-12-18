package com.googol.han.echart.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googol.han.echart.service.EchartService;

@SuppressWarnings("all")
@Controller
@RequestMapping(value = "/echart")
public class EchartControl implements Serializable {
	private static final long serialVersionUID = -5214331034214587916L;
	@Autowired
	private EchartService echartService;

	@ResponseBody
	@RequestMapping(value = "/getInfo")
	public List<Map<String, Object>> getInfo() {
		List<Map<String, Object>> data = new ArrayList<>();
		List<Map<String, Object>> listdata = echartService.getInfo("googol_goods", "售卖中", "下架");
		if (listdata.size() > 0) {
			for (int i = 0; i < listdata.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", listdata.get(i).get("GOODSTATE"));
				map.put("value", listdata.get(i).get("GCOUNT"));
				data.add(map);
			}
		}
		return data;
	}

	@ResponseBody
	@RequestMapping(value = "/getInfo1")
	public List<Map<String, Object>> getInfo1() {
		List<Map<String, Object>> data = new ArrayList<>();
		List<Map<String, Object>> listdata = echartService.getInfo1("googol_depot", "运营中", "停止运营");
		if (listdata.size() > 0) {
			for (int i = 0; i < listdata.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", listdata.get(i).get("DEPOTSTATE"));
				map.put("value", listdata.get(i).get("GCOUNT"));
				data.add(map);
			}
		}
		return data;
	}

	@ResponseBody
	@RequestMapping(value = "/getInfo2")
	public List<Map<String, Object>> getInfo2() {
		List<Map<String, Object>> data = new ArrayList<>();
		List<Map<String, Object>> listdata = echartService.getInfo2("googol_company", "合作中", "合作终止");
		if (listdata.size() > 0) {
			for (int i = 0; i < listdata.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", listdata.get(i).get("COMPANYSTATE"));
				map.put("value", listdata.get(i).get("GCOUNT"));
				data.add(map);
			}
		}
		return data;
	}

	@ResponseBody
	@RequestMapping(value = "/getInfo3")
	public List<Map<String, Object>> getInfo3() {
		List<Map<String, Object>> data = new ArrayList<>();
		List<Map<String, Object>> listdata = echartService.getInfo3("googol_user", "在职", "离职");
		if (listdata.size() > 0) {
			for (int i = 0; i < listdata.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", listdata.get(i).get("USERSTATE"));
				map.put("value", listdata.get(i).get("GCOUNT"));
				data.add(map);
			}
		}
		return data;
	}
}
