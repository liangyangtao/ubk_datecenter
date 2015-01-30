package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.PiaojuyiBillDao;
import com.unbank.spider.billquery.service.PiaojuyiBillService;
import com.unbank.spider.mybatis.vo.PiaojuyiBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class PiaojuyiBillServiceImpl implements PiaojuyiBillService {

	private PiaojuyiBillDao piaojuyiBillDao;

	public List<PiaojuyiBill> readPiaojuyiBills(
			SearchCondition searchCondition, int page, int limit) {
		return piaojuyiBillDao.readPiaojuyiBills(searchCondition, page, limit);
	}

	public int countOfPiaojuyiBills(SearchCondition searchCondition) {
		return piaojuyiBillDao.countOfPiaojuyiBills(searchCondition);
	}

	public List<PiaojuyiBill> readPiaojuyiBills(SearchCondition searchCondition) {
		return piaojuyiBillDao.readPiaojuyiBills(searchCondition);
	}

	public PiaojuyiBillDao getPiaojuyiBillDao() {
		return piaojuyiBillDao;
	}

	public void setPiaojuyiBillDao(PiaojuyiBillDao piaojuyiBillDao) {
		this.piaojuyiBillDao = piaojuyiBillDao;
	}

}
