package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.PiaojubaoBillDao;
import com.unbank.spider.mybatis.client.PiaojubaoBillMapper;
import com.unbank.spider.mybatis.vo.PiaojubaoBill;
import com.unbank.spider.mybatis.vo.PiaojubaoBillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class PiaojubaoBillDaoImpl implements PiaojubaoBillDao {

	PiaojubaoBillMapper piaojubaoBillMapper;

	public List<PiaojubaoBill> readPiaojubaoBills(
			SearchCondition searchCondition, int page, int limit) {
		PiaojubaoBillExample piaojubaoBillExample = new PiaojubaoBillExample();
		piaojubaoBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return piaojubaoBillMapper.selectByExample(piaojubaoBillExample);
	}

	public int countOfPiaojubaoBills(SearchCondition searchCondition) {
		PiaojubaoBillExample piaojubaoBillExample = new PiaojubaoBillExample();
		return piaojubaoBillMapper.countByExample(piaojubaoBillExample);
	}

	public List<PiaojubaoBill> readPiaojubaoBills(
			SearchCondition searchCondition) {
		PiaojubaoBillExample piaojubaoBillExample = new PiaojubaoBillExample();
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
		piaojubaoBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		piaojubaoBillExample.setOrderByClause("pro_date desc");
		return piaojubaoBillMapper.selectByExample(piaojubaoBillExample);
	}

	public PiaojubaoBillMapper getPiaojubaoBillMapper() {
		return piaojubaoBillMapper;
	}

	public void setPiaojubaoBillMapper(PiaojubaoBillMapper piaojubaoBillMapper) {
		this.piaojubaoBillMapper = piaojubaoBillMapper;
	}

}
