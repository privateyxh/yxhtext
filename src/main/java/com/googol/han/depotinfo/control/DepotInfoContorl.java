package com.googol.han.depotinfo.control;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
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
import com.googol.han.depotinfo.service.DepotInfoService;
import com.googol.han.entity.Depot;
import com.googol.han.entity.DepotInfo;
import com.googol.han.entity.Goods;
import com.googol.han.entity.User;
import com.googol.han.goods.service.GoodsService;

import net.sf.json.JSONObject;

/**
 * @author Administrator 订单信息
 */
@Controller
@RequestMapping("/depotinfo")
@SuppressWarnings("all")
public class DepotInfoContorl {

	@Resource(name = "depotInfoService")
	private DepotInfoService depotInfoService;
	@Resource(name = "depotService")
	private DepotService depotService;
	@Resource(name = "goodsService")
	private GoodsService goodsService;

	// 查询所有订单
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
		Integer total = depotInfoService.findAll().size();
		int i;
		List<Map> list = new ArrayList<>();
		Map map1;
		list = depotInfoService.listpage(pageNumber.toString(), pageSize.toString());
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

	// 添加
	@RequestMapping(value = "/adddepotinfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView add(DepotInfo depotInfo,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取时间
		URL url = new URL("http://time.tianqi.com");
		URLConnection uc = url.openConnection();
		uc.connect();
		long ld = uc.getDate();
		Date date = new Date(ld);
		String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		depotInfo.setDepotDate(dateFormat);
		JSONObject jsonObject = new JSONObject();
		Depot depot = new Depot();
		depot.setDepotName(depotInfo.getDepotName());
		Depot depotres = depotService.getOne(depot);
		depotInfo.setDepotId(Integer.toString(depotres.getDepotId()));
		Goods goods = new Goods();
		goods.setGoodName(depotInfo.getGoodName());
		Goods goodsres = goodsService.getOne(goods);
		depotInfo.setGoodId(goodsres.getGoodId());
		depotInfo.setGoodBidPrice(goodsres.getGoodPrice());
		depotInfo.setGoodExplain(goodsres.getGoodExplain());
		depotInfo.setGoodNumber(goodsres.getGoodNumber());
		HttpSession httpSession = request.getSession();
		User user=(User) httpSession.getAttribute("user");
		depotInfo.setUserId(user.getUserId());
		Integer i = depotInfoService.addByDepotinfo(depotInfo);
		if (i == 1) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/page/depotinfo/depotinfoMain.jsp");
		return modelAndView;
	}

	// 查询员工
	@RequestMapping(value = "/finduser", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List finduser(HttpServletRequest request, HttpServletResponse response) {
		List userList = depotInfoService.findByUser();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("userList", userList);
		return userList;
	}

	// 查询物品
	@RequestMapping(value = "/findgoods", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List findgoods(HttpServletRequest request, HttpServletResponse response) {
		List goodsList = depotInfoService.findByGoods();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("goodsList", goodsList);
		return goodsList;
	}

	// 查询仓库
	@RequestMapping(value = "/finddepot", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List finddepot(HttpServletRequest request, HttpServletResponse response) {
		List depotList = depotInfoService.findByDepot();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("depotList", depotList);
		return depotList;
	}

	// 查询单位
	@RequestMapping(value = "/findcompany", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List findcompany(HttpServletRequest request, HttpServletResponse response) {
		List companyList = depotInfoService.findByCompany();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("companyList", companyList);
		return companyList;
	}
}
