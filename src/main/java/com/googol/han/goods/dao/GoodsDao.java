package com.googol.han.goods.dao;

import java.util.List;
import java.util.Map;

import com.googol.han.entity.Goods;
@SuppressWarnings("all")
public interface GoodsDao {
	
		//ȫ��ѯ
		public List<Map> findAllByGoods();
		//�޸ĺ�ɾ��
		public Integer updateByGoods(Goods goods);
		//���
		public Integer addByGoods(Goods goods);
		//��ѯ��ź���Ʒ��
		public List<Map> findByGoodsIdAndGoodsName(Goods goods);
		//��ҳ
		public List<Map> page(String sql);
}
