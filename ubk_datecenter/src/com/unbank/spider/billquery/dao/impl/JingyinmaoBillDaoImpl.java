package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.JingyinmaoBillDao;
import com.unbank.spider.mybatis.client.JingyinmaoBillMapper;
import com.unbank.spider.mybatis.vo.JingyinmaoBill;
import com.unbank.spider.mybatis.vo.JingyinmaoBillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class JingyinmaoBillDaoImpl implements JingyinmaoBillDao {

	JingyinmaoBillMapper jingyinmaoBillMapper;

	public List<JingyinmaoBill> readJingyinmaoBills(
			SearchCondition searchCondition, int page, int limit) {
		JingyinmaoBillExample jingyinmaoBillExample = new JingyinmaoBillExample();
		jingyinmaoBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return jingyinmaoBillMapper.selectByExample(jingyinmaoBillExample);
	}

	public int countOfJingyinmaoBills(SearchCondition searchCondition) {
		JingyinmaoBillExample jingyinmaoBillExample = new JingyinmaoBillExample();
		return jingyinmaoBillMapper.countByExample(jingyinmaoBillExample);
	}

	public List<JingyinmaoBill> readJingyinmaoBills(
			SearchCondition searchCondition) {
		JingyinmaoBillExample jingyinmaoBillExample = new JingyinmaoBillExample();
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
		jingyinmaoBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		jingyinmaoBillExample.setOrderByClause("pro_date desc");
		return jingyinmaoBillMapper.selectByExample(jingyinmaoBillExample);
	}

	public JingyinmaoBillMapper getJingyinmaoBillMapper() {
		return jingyinmaoBillMapper;
	}

	public void setJingyinmaoBillMapper(
			JingyinmaoBillMapper jingyinmaoBillMapper) {
		this.jingyinmaoBillMapper = jingyinmaoBillMapper;
	}

}
