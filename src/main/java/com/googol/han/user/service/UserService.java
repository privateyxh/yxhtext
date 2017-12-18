package com.googol.han.user.service;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.User;

@SuppressWarnings("all")
public interface UserService {
	
	//ȫ��ѯ
	public List<Map> findAll();
	//ͨ��id��name��ѯ
	public List<Map> findByUserIdAndUserName(User user);
	//���»�ɾ��
	public Integer update(User user);
	//���
	public Integer add(User user);
	//��ҳ
	public List listpage(String pageno,String pagesize);
	public User getOne(User user);
	
}
