package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.ZgpjZhitieBillDao;
import com.unbank.spider.mybatis.client.ZgpjZhitieBillMapper;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhitieBill;
import com.unbank.spider.mybatis.vo.ZgpjZhitieBillExample;
import com.unbank.spider.tools.SimpleTools;

public class ZgpjZhitieBillDaoImpl implements ZgpjZhitieBillDao {
	private ZgpjZhitieBillMapper zgpjZhitieBillMapper;

	public List<ZgpjZhitieBill> readZgpjZhitieBills(
			SearchCondition searchCondition, int page, int limit) {
		ZgpjZhitieBillExample zgpjZhitieBillExample = new ZgpjZhitieBillExample();
		zgpjZhitieBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return zgpjZhitieBillMapper.selectByExample(zgpjZhitieBillExample);
	}

	public int countOfZgpjZhitieBills(SearchCondition searchCondition) {
		ZgpjZhitieBillExample zgpjZhitieBillExample = new ZgpjZhitieBillExample();
		return zgpjZhitieBillMapper.countByExample(zgpjZhitieBillExample);
	}

	public List<ZgpjZhitieBill> readZgpjZhitieBills(
			SearchCondition searchCondition) {
		ZgpjZhitieBillExample zgpjZhitieBillExample = new ZgpjZhitieBillExample();
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
		zgpjZhitieBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-M-d"),
				SimpleTools.dateToString(endDate, "yyyy-M-d"));
		zgpjZhitieBillExample.setOrderByClause("pro_date desc");
		return zgpjZhitieBillMapper.selectByExample(zgpjZhitieBillExample);
	}

	public ZgpjZhitieBillMapper getZgpjZhitieBillMapper() {
		return zgpjZhitieBillMapper;
	}

	public void setZgpjZhitieBillMapper(
			ZgpjZhitieBillMapper zgpjZhitieBillMapper) {
		this.zgpjZhitieBillMapper = zgpjZhitieBillMapper;
	}

}
