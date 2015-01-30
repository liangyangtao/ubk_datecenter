package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.ZgpjZhitieBillDao;
import com.unbank.spider.billquery.service.ZgpjZhitieBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhitieBill;

public class ZgpjZhitieBillServiceImpl implements ZgpjZhitieBillService {

	private ZgpjZhitieBillDao zgpjZhitieBillDao;

	public List<ZgpjZhitieBill> readZgpjZhitieBills(
			SearchCondition searchCondition, int page, int limit) {

		return zgpjZhitieBillDao.readZgpjZhitieBills(searchCondition, page,
				limit);
	}

	public int countOfZgpjZhitieBills(SearchCondition searchCondition) {
		return zgpjZhitieBillDao.countOfZgpjZhitieBills(searchCondition);
	}

	public List<ZgpjZhitieBill> readZgpjZhitieBills(
			SearchCondition searchCondition) {
		return zgpjZhitieBillDao.readZgpjZhitieBills(searchCondition);
	}

	public ZgpjZhitieBillDao getZgpjZhitieBillDao() {
		return zgpjZhitieBillDao;
	}

	public void setZgpjZhitieBillDao(ZgpjZhitieBillDao zgpjZhitieBillDao) {
		this.zgpjZhitieBillDao = zgpjZhitieBillDao;
	}

}
