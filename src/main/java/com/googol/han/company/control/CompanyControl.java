package com.googol.han.company.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.googol.han.company.service.CompanyService;
import com.googol.han.entity.Company;
import com.googol.han.entity.Depot;

import net.sf.json.JSONObject;
@SuppressWarnings("all")
@Controller
@RequestMapping("/company")
public class CompanyControl {
	
	@Autowired
	private CompanyService companyService;
	
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
		Integer total = companyService.findAll().size();
		int i;
		List<Map> list = new ArrayList<>();
		Map map1;
		list = companyService.listpage(pageNumber.toString(),pageSize.toString());
		for (i = 0; i < list.size(); i++) {
			map1 = list.get(i);
			if(!map1.get("COMPANYSTATE").equals("合作中")){
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
	@RequestMapping(value="/findall",produces="application/json;charset=utf-8")
	@ResponseBody
	public String finAll(HttpServletRequest request,HttpServletResponse response) {
		List<Map> list=new ArrayList<>();
		list=companyService.findAll();	
		int i;
		Map map;
		for(i = 0;i < list.size();i++){
			map = list.get(i);
            if(!map.get("DEPOTSTATE").equals("合作中")){
                list.remove(i);
                i--;
            }
        }
		return list.toString();
	}
	//增加
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView add(Company company) throws Exception {
		
		
		//在这遍历了非空
		
		JSONObject jsonObject = new JSONObject();
		String status = company.getCompanyState();
		if (status.equals("0")) {
			status = "合作中";
		} else {
			status = "合作终止";
		}
		company.setCompanyState(status);
		Integer i = companyService.add(company);
		if (i != null) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/page/company/companyMain.jsp");
		return modelAndView;
	}
	//更新
	@RequestMapping(value="/update",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String update(@RequestBody Company company) {
		JSONObject jsonObject = new JSONObject();
		Integer i=companyService.update(company);
		if(i!=null) {
			jsonObject.put("msg", true);
			
		}else {
			
			jsonObject.put("msg", false);
		}
		return jsonObject.toString();
		
	}
	
	//删除
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public String del(@RequestBody String ids) {
		Company company =new Company();
		if (ids.endsWith("=")) {
			String[] id = ids.split("=");
			for (int i = 0; i < id.length; i++) {
				String a = id[i];
				if (a.contains("%2C")) {
					String[] b = a.split("%2C");
					for (int j = 0; j < b.length; j++) {
						company.setCompanyId(b[j]);
						Company obj1 = companyService.getOne(company);
						obj1.setCompanyState("合作终止");;
						companyService.update(obj1);
					}
				} else {
					company.setCompanyId(a);
					Company obj = companyService.getOne(company);
					obj.setCompanyState("合作终止");;
					companyService.update(obj);
				}
			}
		}
		return null;
	}
}
