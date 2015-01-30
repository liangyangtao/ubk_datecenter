package com.unbank.spider.bhiquery.service.impl;

import java.util.List;

import com.unbank.spider.bhiquery.dao.BhiDao;
import com.unbank.spider.bhiquery.service.BhiService;
import com.unbank.spider.mybatis.vo.BhiInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class BhiServiceImpl implements BhiService {

	BhiDao bhiDao;

	public List<BhiInfo> readBhiInfos(SearchCondition searchCondition,
			int start, Integer rows) {
		// TODO Auto-generated method stub
		return bhiDao.readBhiInfos(searchCondition, start, rows);
	}

	public Object countOfBhiInfos(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return bhiDao.countOfBhiInfos(searchCondition);
	}

	public List<BhiInfo> readBhiInfos(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return bhiDao.readBhiInfos(searchCondition);
	}

	public BhiDao getBhiDao() {
		return bhiDao;
	}

	public void setBhiDao(BhiDao bhiDao) {
		this.bhiDao = bhiDao;
	}

}
