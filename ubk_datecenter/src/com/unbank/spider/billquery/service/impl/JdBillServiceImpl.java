package com.unbank.spider.billquery.service.impl;

import java.util.List;

import com.unbank.spider.billquery.dao.JdBillDao;
import com.unbank.spider.billquery.service.JdBillService;
import com.unbank.spider.mybatis.vo.Jdbill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class JdBillServiceImpl implements JdBillService {

	private JdBillDao jdBillDao;

	public List<Jdbill> readJDBills(SearchCondition searchCondition, int page,
			int limit) {
		return jdBillDao.readJDBills(searchCondition, page, limit);
	}

	public JdBillDao getJdBillDao() {
		return jdBillDao;
	}

	public void setJdBillDao(JdBillDao jdBillDao) {
		this.jdBillDao = jdBillDao;
	}

	public int countOfbill(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return jdBillDao.countOfbill(searchCondition);
	}

	public List<Jdbill> readJDBills(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return jdBillDao.readJDBills(searchCondition);
	}

}
