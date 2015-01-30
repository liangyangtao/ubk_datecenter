package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.ChinaBillDao;
import com.unbank.spider.mybatis.client.ChinabillMapper;
import com.unbank.spider.mybatis.vo.Chinabill;
import com.unbank.spider.mybatis.vo.ChinabillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class ChinaBillDaoImpl implements ChinaBillDao {

	ChinabillMapper chinabillMapper;

	public List<Chinabill> readChinabills(SearchCondition searchCondition,
			int page, int limit) {
		ChinabillExample chinabillExample = new ChinabillExample();
		chinabillExample.setOrderByClause("issue_date desc limit " + page
				+ " , " + limit);
		return chinabillMapper.selectByExample(chinabillExample);
	}

	public int countOfChinabills(SearchCondition searchCondition) {
		ChinabillExample chinabillExample = new ChinabillExample();
		return chinabillMapper.countByExample(chinabillExample);
	}

	public List<Chinabill> readChinabills(SearchCondition searchCondition) {
		ChinabillExample chinabillExample = new ChinabillExample();
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
		chinabillExample.or().andIssueDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		chinabillExample.setOrderByClause("issue_date desc");
		return chinabillMapper.selectByExample(chinabillExample);
	}

	public ChinabillMapper getChinabillMapper() {
		return chinabillMapper;
	}

	public void setChinabillMapper(ChinabillMapper chinabillMapper) {
		this.chinabillMapper = chinabillMapper;
	}

}
