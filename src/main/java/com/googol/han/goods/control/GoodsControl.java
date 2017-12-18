package com.googol.han.goods.control;



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

import com.googol.han.entity.Goods;
import com.googol.han.goods.service.GoodsService;

import net.sf.json.JSONObject;
@SuppressWarnings("all")
@Controller
@RequestMapping("/goods")
public class GoodsControl {
	
	@Autowired
	private GoodsService goodsService;
	
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
		Integer total = goodsService.findall().size();
		int i;
		List<Map> list = new ArrayList<>();
		Map map1;
		list = goodsService.listpage(pageNumber.toString(), pageSize.toString());
		for (i = 0; i < list.size(); i++) {
			map1 = list.get(i);
			if(!map1.get("GOODSTATE").equals("售卖中")){
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
	//增加
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView add(Goods goods) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String status = goods.getGoodState();
		if (status.equals("0")) {
			status = "售卖中";
		} else {
			status = "下架";
		}
		goods.setGoodState(status);
		Integer i = goodsService.add(goods);
		if (i != null) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/page/goods/goodsMain.jsp");
		return modelAndView;
	}
	//更新
	@RequestMapping(value="/update",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String update(@RequestBody Goods goods) {
		JSONObject jsonObject = new JSONObject();
		Integer i=goodsService.update(goods);
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
		Goods goods =new Goods();
		if (ids.endsWith("=")) {
			String[] id = ids.split("=");
			for (int i = 0; i < id.length; i++) {
				String a = id[i];
				if (a.contains("%2C")) {
					String[] b = a.split("%2C");
					for (int j = 0; j < b.length; j++) {
						goods.setGoodId(b[j]);
						Goods obj1 = goodsService.getOne(goods);
						obj1.setGoodState("下架");;
						goodsService.update(obj1);
					}
				} else {
					goods.setGoodId(a);
					Goods obj = goodsService.getOne(goods);
					obj.setGoodState("下架");;
					goodsService.update(obj);
				}
			}
		}
		return null;
	}
}
