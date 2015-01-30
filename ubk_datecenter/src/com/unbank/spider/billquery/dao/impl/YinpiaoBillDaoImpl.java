package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.YinpiaoBillDao;
import com.unbank.spider.mybatis.client.YinpiaoBillMapper;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YinpiaoBill;
import com.unbank.spider.mybatis.vo.YinpiaoBillExample;
import com.unbank.spider.tools.SimpleTools;

public class YinpiaoBillDaoImpl implements YinpiaoBillDao {

	YinpiaoBillMapper yinpiaoBillMapper;

	public List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition,
			int page, int limit) {
		YinpiaoBillExample yinpiaoBillExample = new YinpiaoBillExample();
		yinpiaoBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return yinpiaoBillMapper.selectByExample(yinpiaoBillExample);
	}

	public int countOfYinpiaoBills(SearchCondition searchCondition) {
		YinpiaoBillExample yinpiaoBillExample = new YinpiaoBillExample();
		return yinpiaoBillMapper.countByExample(yinpiaoBillExample);
	}

	public List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition) {
		YinpiaoBillExample yinpiaoBillExample = new YinpiaoBillExample();
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
		yinpiaoBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		yinpiaoBillExample.setOrderByClause("pro_date desc");
		return yinpiaoBillMapper.selectByExample(yinpiaoBillExample);
	}

	public YinpiaoBillMapper getYinpiaoBillMapper() {
		return yinpiaoBillMapper;
	}

	public void setYinpiaoBillMapper(YinpiaoBillMapper yinpiaoBillMapper) {
		this.yinpiaoBillMapper = yinpiaoBillMapper;
	}

}
