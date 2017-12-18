package com.googol.han.user.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.User;

/**
 * @author ְԱ��Ϣdao
 *
 */
@SuppressWarnings("all")
public interface UserDao {
	//ͨ���û����������ѯ(login)
	List<Map> findByUserNameAndUserPassword(User user);
	//��ѯ���
	List<?> findByUserId(User user);
	//�޸ĺ�ɾ��
	Integer updateByUser(User user);
	//��ҳ
	Integer addByUser(User user);
	//��ҳ��ѯ
	List<Map> page(String sql);
	//ȫ��ѯ
	List<Map> findAll();

}
