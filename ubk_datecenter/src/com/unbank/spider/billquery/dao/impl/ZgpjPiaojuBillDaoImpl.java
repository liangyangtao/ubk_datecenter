package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.ZgpjPiaojuBillDao;
import com.unbank.spider.mybatis.client.ZgpjPiaojuBillMapper;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjPiaojuBill;
import com.unbank.spider.mybatis.vo.ZgpjPiaojuBillExample;
import com.unbank.spider.tools.SimpleTools;

public class ZgpjPiaojuBillDaoImpl implements ZgpjPiaojuBillDao {
	private ZgpjPiaojuBillMapper zgpjPiaojuBillMapper;

	public List<ZgpjPiaojuBill> readZgpjPiaojuBills(
			SearchCondition searchCondition, int page, int limit) {
		ZgpjPiaojuBillExample zgpjPiaojuBillExample = new ZgpjPiaojuBillExample();
		zgpjPiaojuBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return zgpjPiaojuBillMapper.selectByExample(zgpjPiaojuBillExample);
	}

	public int countOfZgpjPiaojuBills(SearchCondition searchCondition) {
		ZgpjPiaojuBillExample zgpjPiaojuBillExample = new ZgpjPiaojuBillExample();
		return zgpjPiaojuBillMapper.countByExample(zgpjPiaojuBillExample);
	}

	public List<ZgpjPiaojuBill> readZgpjPiaojuBills(
			SearchCondition searchCondition) {
		ZgpjPiaojuBillExample zgpjPiaojuBillExample = new ZgpjPiaojuBillExample();
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
		zgpjPiaojuBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		zgpjPiaojuBillExample.setOrderByClause("pro_date desc");
		return zgpjPiaojuBillMapper.selectByExample(zgpjPiaojuBillExample);
	}

	public ZgpjPiaojuBillMapper getZgpjPiaojuBillMapper() {
		return zgpjPiaojuBillMapper;
	}

	public void setZgpjPiaojuBillMapper(
			ZgpjPiaojuBillMapper zgpjPiaojuBillMapper) {
		this.zgpjPiaojuBillMapper = zgpjPiaojuBillMapper;
	}

}
