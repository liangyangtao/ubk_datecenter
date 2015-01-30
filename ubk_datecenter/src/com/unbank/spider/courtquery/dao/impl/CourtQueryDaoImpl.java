package com.unbank.spider.courtquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.courtquery.dao.CourtQueryDao;
import com.unbank.spider.mybatis.client.CourtInfoMapper;
import com.unbank.spider.mybatis.vo.CourtInfo;
import com.unbank.spider.mybatis.vo.CourtInfoExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class CourtQueryDaoImpl implements CourtQueryDao {

	CourtInfoMapper courtInfoMapper;

	public List<CourtInfo> readCourtInfos(SearchCondition searchCondition,
			int start, Integer rows) {
		CourtInfoExample courtInfoExample = new CourtInfoExample();
		courtInfoExample.setOrderByClause("bulletin_time desc limit " + start
				+ " , " + rows);
		return courtInfoMapper.selectByExampleWithBLOBs(courtInfoExample);
	}

	public Object countOfCourtInfos(SearchCondition searchCondition) {
		CourtInfoExample courtInfoExample = new CourtInfoExample();

		return courtInfoMapper.countByExample(courtInfoExample);
	}

	public List<CourtInfo> readCourtInfos(SearchCondition searchCondition) {

		Date startDate = searchCondition.getStartTime();
		Date endDate = searchCondition.getEndTime();
		if (startDate != null && endDate != null) {
		} else if (startDate == null && endDate == null) {
			startDate = SimpleTools.getMyDate(new Date(), -30);
			endDate = new Date();
		} else if (startDate == null && endDate != null) {
			startDate = SimpleTools.getMyDate(new Date(), -10);
		} else {
			endDate = new Date();
		}
		CourtInfoExample courtInfoExample = new CourtInfoExample();
		courtInfoExample.or().andBulletinTimeBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		courtInfoExample.setOrderByClause("bulletin_time desc");
		return courtInfoMapper.selectByExampleWithBLOBs(courtInfoExample);
	}

	public CourtInfoMapper getCourtInfoMapper() {
		return courtInfoMapper;
	}

	public void setCourtInfoMapper(CourtInfoMapper courtInfoMapper) {
		this.courtInfoMapper = courtInfoMapper;
	}

}
