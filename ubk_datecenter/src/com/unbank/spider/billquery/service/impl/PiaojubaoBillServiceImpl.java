package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.PiaojubaoBillDao;
import com.unbank.spider.billquery.service.PiaojubaoBillService;
import com.unbank.spider.mybatis.vo.PiaojubaoBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class PiaojubaoBillServiceImpl implements PiaojubaoBillService {

	PiaojubaoBillDao piaojubaoBillDao;

	public List<PiaojubaoBill> readPiaojubaoBills(
			SearchCondition searchCondition, int page, int limit) {
		return piaojubaoBillDao
				.readPiaojubaoBills(searchCondition, page, limit);
	}

	public int countOfPiaojubaoBills(SearchCondition searchCondition) {

		return piaojubaoBillDao.countOfPiaojubaoBills(searchCondition);
	}

	public List<PiaojubaoBill> readPiaojubaoBills(
			SearchCondition searchCondition) {
		return piaojubaoBillDao.readPiaojubaoBills(searchCondition);
	}

	public PiaojubaoBillDao getPiaojubaoBillDao() {
		return piaojubaoBillDao;
	}

	public void setPiaojubaoBillDao(PiaojubaoBillDao piaojubaoBillDao) {
		this.piaojubaoBillDao = piaojubaoBillDao;
	}

}
