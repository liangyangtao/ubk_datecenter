package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.PjtxBillDao;
import com.unbank.spider.billquery.service.PjtxBillService;
import com.unbank.spider.mybatis.vo.PjtxBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class PjtxBillServiceImpl implements PjtxBillService {

	private PjtxBillDao pjtxBillDao;

	public List<PjtxBill> readPjtxBills(SearchCondition searchCondition,
			int page, int limit) {
		return pjtxBillDao.readPjtxBills(searchCondition, page, limit);
	}

	public int countOfPjtxBills(SearchCondition searchCondition) {
		return pjtxBillDao.countOfPjtxBills(searchCondition);
	}

	public List<PjtxBill> readPjtxBills(SearchCondition searchCondition) {
		return pjtxBillDao.readPjtxBills(searchCondition);
	}

	public PjtxBillDao getPjtxBillDao() {
		return pjtxBillDao;
	}

	public void setPjtxBillDao(PjtxBillDao pjtxBillDao) {
		this.pjtxBillDao = pjtxBillDao;
	}

}
