package com.googol.han.user.control;

import java.io.IOException;
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

import com.googol.han.entity.Depot;
import com.googol.han.entity.User;
import com.googol.han.user.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserControl {

	@Autowired
	private UserService userService;

	// ��½
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(User user, HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		List<Map> list = userService.findByUserIdAndUserName(user);
		// �ж�ͨ���˺������ѯ���˼�������
		if (list.size() == 1) {
			HttpSession session = request.getSession();// ����session
			session.setAttribute("user", list.get(0));// �û���Ϣ�ŵ�session��
			jsonObject.put("msg", true);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/page/main/root.jsp");
			return modelAndView;
		} else {
			jsonObject.put("msg", false);
			return null;
		}
		
	}

	// ��ҳ
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
		Integer total = userService.findAll().size();
		int i;
		List<Map> list = new ArrayList<>();
		Map map1;
		list = userService.listpage(pageNumber.toString(), pageSize.toString());
		for (i = 0; i < list.size(); i++) {
			map1 = list.get(i);
			if (!map1.get("USERSTATE").equals("��ְ")) {
				list.remove(i);
				i--;
			}
		}
		Map map = new HashMap();
		map.put("total", total);// ����Ŀ��
		map.put("rows", list);// ��ҳ����������
		JSONObject jsonArray = JSONObject.fromObject(map);
		System.out.println("JSONARRAY:" + jsonArray.toString());
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(jsonArray.toString());
	}

	// ����
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView add(User user) {
		JSONObject jsonObject = new JSONObject();
		String status =user.getUserState();
		if (status.equals("0")) {
			status = "��ְ";
		} else {
			status = "��ְ";
		}
		user.setUserState(status);
		Integer i = userService.add(user);
		if (i != null) {
			jsonObject.put("msg", true);

		} else {

			jsonObject.put("msg", false);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/page/user/userMain.jsp");
		return modelAndView;

	}

	// ����
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String update(@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		Integer i = userService.update(user);
		if (i != null) {
			jsonObject.put("msg", true);

		} else {

			jsonObject.put("msg", false);
		}

		return jsonObject.toString();

	}

	// ɾ��
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public String del(@RequestBody String ids) {
		User user= new User(); 
		if (ids.endsWith("=")) {
			String[] id = ids.split("=");
			for (int i = 0; i < id.length; i++) {
				String a = id[i];
				if (a.contains("%2C")) {
					String[] b = a.split("%2C");
					for (int j = 0; j < b.length; j++) {
						//depot.setDepotId(Integer.parseInt(b[j]));
						user.setUserId(b[j]);
						User obj1 = userService.getOne(user);
						obj1.setUserState("��ְ");
						userService.update(obj1);
					}
				} else {
					user.setUserId(a);
					User obj = userService.getOne(user);
					obj.setUserState("��ְ");
					userService.update(obj);
				}
			}
		}
		return null;
	}
}
