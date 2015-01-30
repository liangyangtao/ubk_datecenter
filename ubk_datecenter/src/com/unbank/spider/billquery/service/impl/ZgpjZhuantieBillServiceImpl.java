package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.ZgpjZhuantieBillDao;
import com.unbank.spider.billquery.service.ZgpjZhuantieBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhuantieBill;

public class ZgpjZhuantieBillServiceImpl implements ZgpjZhuantieBillService {

	private ZgpjZhuantieBillDao zgpjZhuantieBillDao;

	public List<ZgpjZhuantieBill> readZgpjZhuantieBills(
			SearchCondition searchCondition, int page, int limit) {

		return zgpjZhuantieBillDao.readZgpjZhuantieBills(searchCondition, page,
				limit);
	}

	public int countOfZgpjZhuantieBills(SearchCondition searchCondition) {
		return zgpjZhuantieBillDao.countOfZgpjZhuantieBills(searchCondition);
	}

	public List<ZgpjZhuantieBill> readZgpjZhuantieBills(
			SearchCondition searchCondition) {
		return zgpjZhuantieBillDao.readZgpjZhuantieBills(searchCondition);
	}

	public ZgpjZhuantieBillDao getZgpjZhuantieBillDao() {
		return zgpjZhuantieBillDao;
	}

	public void setZgpjZhuantieBillDao(ZgpjZhuantieBillDao zgpjZhuantieBillDao) {
		this.zgpjZhuantieBillDao = zgpjZhuantieBillDao;
	}

}
