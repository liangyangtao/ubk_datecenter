package com.unbank.spider.fundquery.service.impl;

import java.util.List;

import com.unbank.spider.fundquery.dao.ChinaventureFinancingDao;
import com.unbank.spider.fundquery.service.ChinaventureFinancingService;
import com.unbank.spider.mybatis.vo.ChinaventureFinancing;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class ChinaventureFinancingServiceImpl implements
		ChinaventureFinancingService {

	ChinaventureFinancingDao chinaventureFinancingDao;

	public List<ChinaventureFinancing> readChinaventureFinancingInfos(
			SearchCondition searchCondition, int start, Integer rows) {
		return chinaventureFinancingDao.readChinaventureFinancingInfos(
				searchCondition, start, rows);
	}

	public Object countOfChinaventureFinancingInfos(
			SearchCondition searchCondition) {

		return chinaventureFinancingDao
				.countOfChinaventureFinancingInfos(searchCondition);
	}

	public List<ChinaventureFinancing> readChinaventureFinancingInfos(
			SearchCondition searchCondition) {
		return chinaventureFinancingDao
				.readChinaventureFinancingInfos(searchCondition);
	}

	public ChinaventureFinancingDao getChinaventureFinancingDao() {
		return chinaventureFinancingDao;
	}

	public void setChinaventureFinancingDao(
			ChinaventureFinancingDao chinaventureFinancingDao) {
		this.chinaventureFinancingDao = chinaventureFinancingDao;
	}

}
