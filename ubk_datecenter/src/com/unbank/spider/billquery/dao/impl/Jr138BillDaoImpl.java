package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.Jr138BillDao;
import com.unbank.spider.mybatis.client.Jr138BillMapper;
import com.unbank.spider.mybatis.vo.Jr138Bill;
import com.unbank.spider.mybatis.vo.Jr138BillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class Jr138BillDaoImpl implements Jr138BillDao {
	private Jr138BillMapper jr138BillMapper;

	public List<Jr138Bill> readJr138Bills(SearchCondition searchCondition,
			int page, int limit) {
		Jr138BillExample jr138BillExample = new Jr138BillExample();
		jr138BillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return jr138BillMapper.selectByExample(jr138BillExample);
	}

	public int countOfJr138Bills(SearchCondition searchCondition) {
		Jr138BillExample jr138BillExample = new Jr138BillExample();
		return jr138BillMapper.countByExample(jr138BillExample);
	}

	public List<Jr138Bill> readJr138Bills(SearchCondition searchCondition) {
		Jr138BillExample jr138BillExample = new Jr138BillExample();
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
		jr138BillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-M-d"),
				SimpleTools.dateToString(endDate, "yyyy-M-d"));
		jr138BillExample.setOrderByClause("pro_date desc");
		return jr138BillMapper.selectByExample(jr138BillExample);
	}

	public Jr138BillMapper getJr138BillMapper() {
		return jr138BillMapper;
	}

	public void setJr138BillMapper(Jr138BillMapper jr138BillMapper) {
		this.jr138BillMapper = jr138BillMapper;
	}

}
