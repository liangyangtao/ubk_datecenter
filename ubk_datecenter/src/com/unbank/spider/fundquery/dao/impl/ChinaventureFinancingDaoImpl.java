package com.unbank.spider.fundquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.fundquery.dao.ChinaventureFinancingDao;
import com.unbank.spider.mybatis.client.ChinaventureFinancingMapper;
import com.unbank.spider.mybatis.vo.ChinaventureFinancing;
import com.unbank.spider.mybatis.vo.ChinaventureFinancingExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class ChinaventureFinancingDaoImpl implements ChinaventureFinancingDao {

	ChinaventureFinancingMapper chinaventureFinancingMapper;

	public List<ChinaventureFinancing> readChinaventureFinancingInfos(
			SearchCondition searchCondition, int start, Integer rows) {
		ChinaventureFinancingExample chinaventureFinancingExample = new ChinaventureFinancingExample();
		chinaventureFinancingExample.setOrderByClause("pro_time desc limit "
				+ start + " , " + rows);
		return chinaventureFinancingMapper
				.selectByExample(chinaventureFinancingExample);
	}

	public Object countOfChinaventureFinancingInfos(
			SearchCondition searchCondition) {
		ChinaventureFinancingExample chinaventureFinancingExample = new ChinaventureFinancingExample();
		return chinaventureFinancingMapper
				.countByExample(chinaventureFinancingExample);
	}

	public List<ChinaventureFinancing> readChinaventureFinancingInfos(
			SearchCondition searchCondition) {
		ChinaventureFinancingExample chinaventureFinancingExample = new ChinaventureFinancingExample();
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
		chinaventureFinancingExample.or().andProTimeBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		chinaventureFinancingExample.setOrderByClause("pro_time desc");
		return chinaventureFinancingMapper
				.selectByExample(chinaventureFinancingExample);
	}

	public ChinaventureFinancingMapper getChinaventureFinancingMapper() {
		return chinaventureFinancingMapper;
	}

	public void setChinaventureFinancingMapper(
			ChinaventureFinancingMapper chinaventureFinancingMapper) {
		this.chinaventureFinancingMapper = chinaventureFinancingMapper;
	}

}
