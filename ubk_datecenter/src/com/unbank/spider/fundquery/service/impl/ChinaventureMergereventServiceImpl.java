package com.unbank.spider.fundquery.service.impl;

import java.util.List;

import com.unbank.spider.fundquery.dao.ChinaventureMergereventDao;
import com.unbank.spider.fundquery.service.ChinaventureMergereventService;
import com.unbank.spider.mybatis.vo.ChinaventureMergerevent;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class ChinaventureMergereventServiceImpl implements
		ChinaventureMergereventService {

	ChinaventureMergereventDao chinaventureMergereventDao;

	public List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition, int start, Integer rows) {
		return chinaventureMergereventDao.readChinaventureMergereventInfos(
				searchCondition, start, rows);
	}

	public Object countOfChinaventureMergereventInfos(
			SearchCondition searchCondition) {

		return chinaventureMergereventDao
				.countOfChinaventureMergereventInfos(searchCondition);
	}

	public List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition) {
		return chinaventureMergereventDao
				.readChinaventureMergereventInfos(searchCondition);
	}

	public ChinaventureMergereventDao getChinaventureMergereventDao() {
		return chinaventureMergereventDao;
	}

	public void setChinaventureMergereventDao(
			ChinaventureMergereventDao chinaventureMergereventDao) {
		this.chinaventureMergereventDao = chinaventureMergereventDao;
	}

}
