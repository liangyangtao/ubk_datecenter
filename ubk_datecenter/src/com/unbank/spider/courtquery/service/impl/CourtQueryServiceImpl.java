package com.unbank.spider.courtquery.service.impl;

import java.util.List;

import com.unbank.spider.courtquery.dao.CourtQueryDao;
import com.unbank.spider.courtquery.service.CourtQueryService;
import com.unbank.spider.mybatis.vo.CourtInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class CourtQueryServiceImpl implements CourtQueryService {

	CourtQueryDao courtQueryDao;

	public List<CourtInfo> readCourtInfos(SearchCondition searchCondition,
			int start, Integer rows) {
		return courtQueryDao.readCourtInfos(searchCondition, start, rows);
	}

	public Object countOfCourtInfos(SearchCondition searchCondition) {

		return courtQueryDao.countOfCourtInfos(searchCondition);
	}

	public List<CourtInfo> readCourtInfos(SearchCondition searchCondition) {

		return courtQueryDao.readCourtInfos(searchCondition);
	}

	public CourtQueryDao getCourtQueryDao() {
		return courtQueryDao;
	}

	public void setCourtQueryDao(CourtQueryDao courtQueryDao) {
		this.courtQueryDao = courtQueryDao;
	}

}
