package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.JingyinmaoBillDao;
import com.unbank.spider.billquery.service.JingyinmaoBillService;
import com.unbank.spider.mybatis.vo.JingyinmaoBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class JingyinmaoBillServiceImpl implements JingyinmaoBillService {

	JingyinmaoBillDao jingyinmaoBillDao;

	public List<JingyinmaoBill> readJingyinmaoBills(
			SearchCondition searchCondition, int page, int limit) {
		return jingyinmaoBillDao.readJingyinmaoBills(searchCondition, page,
				limit);
	}

	public int countOfJingyinmaoBills(SearchCondition searchCondition) {

		return jingyinmaoBillDao.countOfJingyinmaoBills(searchCondition);
	}

	public List<JingyinmaoBill> readJingyinmaoBills(
			SearchCondition searchCondition) {
		return jingyinmaoBillDao.readJingyinmaoBills(searchCondition);
	}

	public JingyinmaoBillDao getJingyinmaoBillDao() {
		return jingyinmaoBillDao;
	}

	public void setJingyinmaoBillDao(JingyinmaoBillDao jingyinmaoBillDao) {
		this.jingyinmaoBillDao = jingyinmaoBillDao;
	}

}
