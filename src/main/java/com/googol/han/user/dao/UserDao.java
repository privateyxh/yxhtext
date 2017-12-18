package com.googol.han.user.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.User;

/**
 * @author 职员信息dao
 *
 */
@SuppressWarnings("all")
public interface UserDao {
	//通过用户名和密码查询(login)
	List<Map> findByUserNameAndUserPassword(User user);
	//查询编号
	List<?> findByUserId(User user);
	//修改和删除
	Integer updateByUser(User user);
	//分页
	Integer addByUser(User user);
	//分页查询
	List<Map> page(String sql);
	//全查询
	List<Map> findAll();

}
