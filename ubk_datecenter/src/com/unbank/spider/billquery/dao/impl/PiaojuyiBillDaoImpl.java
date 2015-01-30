package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.PiaojuyiBillDao;
import com.unbank.spider.mybatis.client.PiaojuyiBillMapper;
import com.unbank.spider.mybatis.vo.PiaojuyiBill;
import com.unbank.spider.mybatis.vo.PiaojuyiBillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class PiaojuyiBillDaoImpl implements PiaojuyiBillDao {
	private PiaojuyiBillMapper piaojuyiBillMapper;

	public List<PiaojuyiBill> readPiaojuyiBills(
			SearchCondition searchCondition, int page, int limit) {
		PiaojuyiBillExample piaojuyiBillExample = new PiaojuyiBillExample();
		piaojuyiBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return piaojuyiBillMapper.selectByExample(piaojuyiBillExample);
	}

	public int countOfPiaojuyiBills(SearchCondition searchCondition) {
		PiaojuyiBillExample piaojuyiBillExample = new PiaojuyiBillExample();
		return piaojuyiBillMapper.countByExample(piaojuyiBillExample);
	}

	public List<PiaojuyiBill> readPiaojuyiBills(SearchCondition searchCondition) {
		PiaojuyiBillExample piaojuyiBillExample = new PiaojuyiBillExample();
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
		piaojuyiBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-M-d"),
				SimpleTools.dateToString(endDate, "yyyy-M-d"));
		piaojuyiBillExample.setOrderByClause("pro_date desc");
		return piaojuyiBillMapper.selectByExample(piaojuyiBillExample);
	}

	public PiaojuyiBillMapper getPiaojuyiBillMapper() {
		return piaojuyiBillMapper;
	}

	public void setPiaojuyiBillMapper(PiaojuyiBillMapper piaojuyiBillMapper) {
		this.piaojuyiBillMapper = piaojuyiBillMapper;
	}

}
