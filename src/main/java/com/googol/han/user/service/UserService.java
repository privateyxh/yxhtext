package com.googol.han.user.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.User;

@SuppressWarnings("all")
public interface UserService {
	
	//全查询
	public List<Map> findAll();
	//通过id和name查询
	public List<Map> findByUserIdAndUserName(User user);
	//更新或删除
	public Integer update(User user);
	//添加
	public Integer add(User user);
	//分页
	public List listpage(String pageno,String pagesize);
	public User getOne(User user);
	
}
