package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.ChinaBillDao;
import com.unbank.spider.billquery.service.ChinaBillService;
import com.unbank.spider.mybatis.vo.Chinabill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class ChinaBillServiceImpl implements ChinaBillService {

	ChinaBillDao chinaBillDao;

	public List<Chinabill> readChinabills(SearchCondition searchCondition,
			int page, int limit) {
		return chinaBillDao.readChinabills(searchCondition, page, limit);
	}

	public int countOfChinabills(SearchCondition searchCondition) {
		return chinaBillDao.countOfChinabills(searchCondition);
	}

	public List<Chinabill> readChinabills(SearchCondition searchCondition) {
		return chinaBillDao.readChinabills(searchCondition);
	}

	public ChinaBillDao getChinaBillDao() {
		return chinaBillDao;
	}

	public void setChinaBillDao(ChinaBillDao chinaBillDao) {
		this.chinaBillDao = chinaBillDao;
	}

}
