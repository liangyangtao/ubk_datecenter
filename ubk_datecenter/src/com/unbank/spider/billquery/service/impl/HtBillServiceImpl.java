package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.HtBillDao;
import com.unbank.spider.billquery.service.HtBillService;
import com.unbank.spider.mybatis.vo.HtBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class HtBillServiceImpl implements HtBillService {

	private HtBillDao htBillDao;

	public List<HtBill> readHtBills(SearchCondition searchCondition, int page,
			int limit) {
		return htBillDao.readHtBills(searchCondition, page, limit);
	}

	public int countOfHtBills(SearchCondition searchCondition) {
		return htBillDao.countOfHtBills(searchCondition);
	}

	public List<HtBill> readHtBills(SearchCondition searchCondition) {
		return htBillDao.readHtBills(searchCondition);
	}

	public HtBillDao getHtBillDao() {
		return htBillDao;
	}

	public void setHtBillDao(HtBillDao htBillDao) {
		this.htBillDao = htBillDao;
	}

}
