package com.googol.han.depot.control;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.googol.han.depot.service.DepotService;
import com.googol.han.entity.Depot;

import net.sf.json.JSONObject;

@SuppressWarnings("all")
@Controller
@RequestMapping(value = "/depot")
public class DepotControl implements Serializable {
	private static final long serialVersionUID = -5214331034214587916L;
	@Autowired
	private DepotService depotService;
	
	// 分页
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public void query(HttpServletRequest request, HttpServletResponse response, Integer pageSize, Integer pageNumber,
			String searchText) throws IOException {
		response.setCharacterEncoding("UTF-8");
		if (null != searchText) {
			try {
				searchText = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Integer total = depotService.findAll().size();
		int i;
		List<Map> list = new ArrayList<>();
		Map map1;
		list = depotService.listpage(pageNumber.toString(), pageSize.toString());
		for (i = 0; i < list.size(); i++) {
			map1 = list.get(i);
			if (!map1.get("DEPOTSTATE").equals("运营中")) {
				list.remove(i);
				i--;
			}
		}
		Map map = new HashMap();
		map.put("total", total);// 总条目数
		map.put("rows", list);// 该页多少行数据
		// 返回数据要求必须是JSONObject类型
		JSONObject jsonArray = JSONObject.fromObject(map);
		System.out.println("JSONARRAY:" + jsonArray.toString());
		// 输出流返回的数据
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(jsonArray.toString());
		// return jsonArray.toString();
	}

	// 查询所有
	@RequestMapping(value = "/findall", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String finAll(HttpServletRequest request, HttpServletResponse response) {
		List<Map> list = new ArrayList<>();
		list = depotService.findAll();
		int i;
		Map map;
		for (i = 0; i < list.size(); i++) {
			map = list.get(i);
			if (!map.get("DEPOTSTATE").equals("运营中")) {
				list.remove(i);
				i--;
			}
		}

		return list.toString();

	}

	// 增加
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView add(Depot depot) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String status = depot.getDepotState();
		if (status.equals("0")) {
			status = "运营中";
		} else {
			status = "停止运营";
		}
		depot.setDepotState(status);
		Integer i = depotService.add(depot);
		if (i != null) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/page/depot/depotMain.jsp");
		return modelAndView;
	}

	// 更新
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String update(@RequestBody Depot depot) {
		JSONObject jsonObject = new JSONObject();
		Integer i = depotService.update(depot);
		if (i != null) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		return jsonObject.toString();
	}
	// 删除
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public String del(@RequestBody String ids) {
		Depot depot = new Depot();
		if (ids.endsWith("=")) {
			String[] id = ids.split("=");
			for (int i = 0; i < id.length; i++) {
				String a = id[i];
				if (a.contains("%2C")) {
					String[] b = a.split("%2C");
					for (int j = 0; j < b.length; j++) {
						depot.setDepotId(Integer.parseInt(b[j]));
						Depot obj1 = depotService.getOne(depot);
						obj1.setDepotState("停止运营");
						depotService.update(obj1);
					}
				} else {
					depot.setDepotId(Integer.parseInt(a));
					Depot obj = depotService.getOne(depot);
					obj.setDepotState("停止运营");
					depotService.update(obj);
				}
			}
		}
		return null;
	}
}
