package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.ZgpjZhuantieBillDao;
import com.unbank.spider.mybatis.client.ZgpjZhuantieBillMapper;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhuantieBill;
import com.unbank.spider.mybatis.vo.ZgpjZhuantieBillExample;
import com.unbank.spider.tools.SimpleTools;

public class ZgpjZhuantieBillDaoImpl implements ZgpjZhuantieBillDao {
	private ZgpjZhuantieBillMapper zgpjZhuantieBillMapper;

	public List<ZgpjZhuantieBill> readZgpjZhuantieBills(
			SearchCondition searchCondition, int page, int limit) {
		ZgpjZhuantieBillExample zgpjZhuantieBillExample = new ZgpjZhuantieBillExample();
		zgpjZhuantieBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return zgpjZhuantieBillMapper.selectByExample(zgpjZhuantieBillExample);
	}

	public int countOfZgpjZhuantieBills(SearchCondition searchCondition) {
		ZgpjZhuantieBillExample zgpjZhuantieBillExample = new ZgpjZhuantieBillExample();
		return zgpjZhuantieBillMapper.countByExample(zgpjZhuantieBillExample);
	}

	public List<ZgpjZhuantieBill> readZgpjZhuantieBills(
			SearchCondition searchCondition) {
		ZgpjZhuantieBillExample zgpjZhuantieBillExample = new ZgpjZhuantieBillExample();
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
		zgpjZhuantieBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-M-d"),
				SimpleTools.dateToString(endDate, "yyyy-M-d"));
		zgpjZhuantieBillExample.setOrderByClause("pro_date desc");
		return zgpjZhuantieBillMapper.selectByExample(zgpjZhuantieBillExample);
	}

	public ZgpjZhuantieBillMapper getZgpjZhuantieBillMapper() {
		return zgpjZhuantieBillMapper;
	}

	public void setZgpjZhuantieBillMapper(
			ZgpjZhuantieBillMapper zgpjZhuantieBillMapper) {
		this.zgpjZhuantieBillMapper = zgpjZhuantieBillMapper;
	}

}
