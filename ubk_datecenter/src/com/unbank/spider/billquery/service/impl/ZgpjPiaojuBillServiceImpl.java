package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.ZgpjPiaojuBillDao;
import com.unbank.spider.billquery.service.ZgpjPiaojuBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjPiaojuBill;

public class ZgpjPiaojuBillServiceImpl implements ZgpjPiaojuBillService {

	private ZgpjPiaojuBillDao zgpjPiaojuBillDao;

	public List<ZgpjPiaojuBill> readZgpjPiaojuBills(
			SearchCondition searchCondition, int page, int limit) {

		return zgpjPiaojuBillDao.readZgpjPiaojuBills(searchCondition, page,
				limit);
	}

	public int countOfZgpjPiaojuBills(SearchCondition searchCondition) {
		return zgpjPiaojuBillDao.countOfZgpjPiaojuBills(searchCondition);
	}

	public List<ZgpjPiaojuBill> readZgpjPiaojuBills(
			SearchCondition searchCondition) {
		return zgpjPiaojuBillDao.readZgpjPiaojuBills(searchCondition);
	}

	public ZgpjPiaojuBillDao getZgpjPiaojuBillDao() {
		return zgpjPiaojuBillDao;
	}

	public void setZgpjPiaojuBillDao(ZgpjPiaojuBillDao zgpjPiaojuBillDao) {
		this.zgpjPiaojuBillDao = zgpjPiaojuBillDao;
	}

}
