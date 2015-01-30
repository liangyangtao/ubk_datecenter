package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.YinpiaoBillDao;
import com.unbank.spider.billquery.service.YinpiaoBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YinpiaoBill;

public class YinpiaoBillServiceImpl implements YinpiaoBillService {

	YinpiaoBillDao yinpiaoBillDao;

	public List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition,
			int page, int limit) {
		return yinpiaoBillDao.readYinpiaoBills(searchCondition, page, limit);
	}

	public int countOfYinpiaoBills(SearchCondition searchCondition) {

		return yinpiaoBillDao.countOfYinpiaoBills(searchCondition);
	}

	public List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition) {
		return yinpiaoBillDao.readYinpiaoBills(searchCondition);
	}

	public YinpiaoBillDao getYinpiaoBillDao() {
		return yinpiaoBillDao;
	}

	public void setYinpiaoBillDao(YinpiaoBillDao yinpiaoBillDao) {
		this.yinpiaoBillDao = yinpiaoBillDao;
	}

}
