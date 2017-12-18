package com.googol.han.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googol.han.entity.User;
import com.googol.han.user.dao.UserDao;
import com.googol.han.user.service.UserService;

/**
 * @author 员工表的service曾的实现类
 * yuanxiaohan
 *
 */
@SuppressWarnings("all")
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	
	//全查询
	@Override
	public List<Map> findAll() {
	
		return userDao.findAll();
	}

	//login
	@Override
	public List<Map> findByUserIdAndUserName(User user) {
		return userDao.findByUserNameAndUserPassword(user);
	}

	//更新
	@Override
	public Integer update(User user) {
		return userDao.updateByUser(user);
	}

	//添加
	@Override
	public Integer add(User user) {
		List<?> list=userDao.findByUserId(user);
		Integer i=list.size();
		if(i==0) {
			return userDao.addByUser(user);
		}
		else {
			return null;	
		}
	}

	@Override
	public List listpage(String pageno, String pagesize) {
		// TODO Auto-generated method stub
		String tablename="googol_user";
		String sql="select * from ( SELECT ROWNUM AS LIMITNUM,T.*  FROM "+tablename+" T  ) WHERE LIMITNUM BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize;
		System.out.println(sql);
		return userDao.page(sql);
	}

	@Override
	public User getOne(User user) {
		return (User) userDao.findByUserId(user).get(0);
	}
	
}
