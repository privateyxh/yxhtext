package com.googol.han.sole.control;

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

import com.googol.han.company.service.CompanyService;
import com.googol.han.depot.service.DepotService;
import com.googol.han.entity.Company;
import com.googol.han.entity.Goods;
import com.googol.han.entity.Sole;
import com.googol.han.entity.User;
import com.googol.han.goods.service.GoodsService;
import com.googol.han.sole.service.SoleService;

import net.sf.json.JSONObject;

@SuppressWarnings("all")
@Controller
@RequestMapping("/sole")
public class SoleControl {

	@Resource(name = "soleService")
	private SoleService soleService;
	@Resource(name = "companyService")
	private CompanyService companyService;
	@Resource(name = "goodsService")
	private GoodsService goodsService;

	// 查询单位
	@RequestMapping(value = "/findbycompany", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List findbycompany(HttpServletRequest request, HttpServletResponse response) {
		List CompanyList = soleService.findByCompany();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("CompanyList", CompanyList);
		return CompanyList;
	}

	// 查询物品
	@RequestMapping(value = "/findbygoods", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List findbygoods(HttpServletRequest request, HttpServletResponse response) {
		List GoodsList = soleService.findByGoods();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("GoodsList", GoodsList);
		return GoodsList;
	}

	// 查询订单
	@RequestMapping(value = "/findbysole", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findbysole() {
		return soleService.findBySole().toString();
	}

	// 添加订单
	@RequestMapping("/addbysole")
	@ResponseBody
	public ModelAndView addbysole(Sole sole, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取时间
		URL url = new URL("http://time.tianqi.com");
		URLConnection uc = url.openConnection();
		uc.connect();
		long ld = uc.getDate();
		Date date = new Date(ld);
		String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		// 添加时间
		sole.setSoleDate(dateFormat);
		Company company = new Company();
		company.setCompanyId(sole.getCompanyId());
		Company companyres=companyService.getOne(company);
		sole.setCompanyId(companyres.getCompanyId());
		Goods goods= new Goods();
		goods.setGoodName(sole.getGoodName());
		Goods goodsres=goodsService.getOne(goods);
		sole.setGoodId(goodsres.getGoodId());
		sole.setGoodNumber(goodsres.getGoodNumber());
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		sole.setUserId(user.getUserId());
		soleService.addBySole(sole);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/page/sole/soleMain.jsp");
		return modelAndView;
	}

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
		Integer total = soleService.findBySole().size();
		int i;
		List<Map> list = new ArrayList<>();
		Map map1;
		list = soleService.listpage(pageNumber.toString(), pageSize.toString());
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

}
