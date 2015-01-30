package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.WeicaifuBillDao;
import com.unbank.spider.billquery.service.WeicaifuBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.WeicaifuBill;

public class WeicaifuBillServiceImpl implements WeicaifuBillService {

	WeicaifuBillDao weicaifuBillDao;

	public List<WeicaifuBill> readWeicaifuBills(
			SearchCondition searchCondition, int page, int limit) {
		return weicaifuBillDao.readWeicaifuBills(searchCondition, page, limit);
	}

	public int countOfWeicaifuBills(SearchCondition searchCondition) {

		return weicaifuBillDao.countOfWeicaifuBills(searchCondition);
	}

	public List<WeicaifuBill> readWeicaifuBills(SearchCondition searchCondition) {
		return weicaifuBillDao.readWeicaifuBills(searchCondition);
	}

	public WeicaifuBillDao getWeicaifuBillDao() {
		return weicaifuBillDao;
	}

	public void setWeicaifuBillDao(WeicaifuBillDao weicaifuBillDao) {
		this.weicaifuBillDao = weicaifuBillDao;
	}

}
