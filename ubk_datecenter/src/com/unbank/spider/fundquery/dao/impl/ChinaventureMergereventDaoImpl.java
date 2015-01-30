package com.unbank.spider.fundquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.fundquery.dao.ChinaventureMergereventDao;
import com.unbank.spider.mybatis.client.ChinaventureMergereventMapper;
import com.unbank.spider.mybatis.vo.ChinaventureMergerevent;
import com.unbank.spider.mybatis.vo.ChinaventureMergereventExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class ChinaventureMergereventDaoImpl implements
		ChinaventureMergereventDao {

	ChinaventureMergereventMapper chinaventureMergereventMapper;

	public List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition, int start, Integer rows) {
		ChinaventureMergereventExample chinaventureMergereventExample = new ChinaventureMergereventExample();
		chinaventureMergereventExample
				.setOrderByClause("deal_announced_time desc limit " + start
						+ " , " + rows);
		return chinaventureMergereventMapper
				.selectByExample(chinaventureMergereventExample);
	}

	public Object countOfChinaventureMergereventInfos(
			SearchCondition searchCondition) {
		ChinaventureMergereventExample chinaventureMergereventExample = new ChinaventureMergereventExample();
		return chinaventureMergereventMapper
				.countByExample(chinaventureMergereventExample);
	}

	public List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition) {
		ChinaventureMergereventExample chinaventureMergereventExample = new ChinaventureMergereventExample();
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
		chinaventureMergereventExample.or().andDealAnnouncedTimeBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		chinaventureMergereventExample
				.setOrderByClause("deal_announced_time desc");
		return chinaventureMergereventMapper
				.selectByExample(chinaventureMergereventExample);
	}

	public ChinaventureMergereventMapper getChinaventureMergereventMapper() {
		return chinaventureMergereventMapper;
	}

	public void setChinaventureMergereventMapper(
			ChinaventureMergereventMapper chinaventureMergereventMapper) {
		this.chinaventureMergereventMapper = chinaventureMergereventMapper;
	}

}
