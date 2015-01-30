package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.Jr138BillDao;
import com.unbank.spider.billquery.service.Jr138BillService;
import com.unbank.spider.mybatis.vo.Jr138Bill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class Jr138BillServiceImpl implements Jr138BillService {

	private Jr138BillDao jr138BillDao;

	public List<Jr138Bill> readJr138Bills(SearchCondition searchCondition,
			int page, int limit) {
		return jr138BillDao.readJr138Bills(searchCondition, page, limit);
	}

	public int countOfJr138Bills(SearchCondition searchCondition) {
		return jr138BillDao.countOfJr138Bills(searchCondition);
	}

	public List<Jr138Bill> readJr138Bills(SearchCondition searchCondition) {
		return jr138BillDao.readJr138Bills(searchCondition);
	}

	public Jr138BillDao getJr138BillDao() {
		return jr138BillDao;
	}

	public void setJr138BillDao(Jr138BillDao jr138BillDao) {
		this.jr138BillDao = jr138BillDao;
	}

}
