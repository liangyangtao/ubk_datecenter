package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.BillQueryBaseDao;
import com.unbank.spider.billquery.dao.JdBillDao;
import com.unbank.spider.mybatis.client.JdbillMapper;
import com.unbank.spider.mybatis.vo.Jdbill;
import com.unbank.spider.mybatis.vo.JdbillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class JdBillDaoImpl extends BillQueryBaseDao implements JdBillDao {

	private JdbillMapper jdbillMapper;

	public List<Jdbill> readJDBills(SearchCondition searchCondition, int page,
			int limit) {
		JdbillExample jdBillExample = new JdbillExample();
		// Date startDate = searchCondition.getStartTime();
		// Date endDate = searchCondition.getEndTime();
		// if (startDate != null && endDate != null) {
		// } else if (startDate == null && endDate == null) {
		// startDate = getMyDate(new Date(), -365);
		// endDate = new Date();
		// } else if (startDate == null && endDate != null) {
		// startDate = getMyDate(new Date(), -10);
		// } else {
		// endDate = new Date();
		// }
		// jdBillExample.or().andPublishDateBetween(dateToString(startDate),
		// dateToString(endDate));
		jdBillExample.setOrderByClause("publish_date desc limit " + page
				+ " , " + limit);
		return jdbillMapper.selectByExample(jdBillExample);
	}

	public JdbillMapper getJdbillMapper() {
		return jdbillMapper;
	}

	public void setJdbillMapper(JdbillMapper jdbillMapper) {
		this.jdbillMapper = jdbillMapper;
	}

	public int countOfbill(SearchCondition searchCondition) {
		JdbillExample jdBillExample = new JdbillExample();
		// Date startDate = searchCondition.getStartTime();
		// Date endDate = searchCondition.getEndTime();
		// if (startDate != null && endDate != null) {
		// } else if (startDate == null && endDate == null) {
		// startDate = getMyDate(new Date(), -365);
		// endDate = new Date();
		// } else if (startDate == null && endDate != null) {
		// startDate = getMyDate(new Date(), -10);
		// } else {
		// endDate = new Date();
		// }
		// jdBillExample.or().andPublishDateBetween(dateToString(startDate),
		// dateToString(endDate));
		return jdbillMapper.countByExample(jdBillExample);
	}

	public List<Jdbill> readJDBills(SearchCondition searchCondition) {
		JdbillExample jdBillExample = new JdbillExample();
		Date startDate = searchCondition.getStartTime();
		Date endDate = searchCondition.getEndTime();
		if (startDate != null && endDate != null) {
		} else if (startDate == null && endDate == null) {
			startDate = getMyDate(new Date(), -30);
			endDate = new Date();
		} else if (startDate == null && endDate != null) {
			startDate = getMyDate(new Date(), -10);
		} else {
			endDate = new Date();
		}
		jdBillExample.or().andPublishDateBetween(dateToString(startDate),
				dateToString(endDate));
		jdBillExample.setOrderByClause("publish_date desc");
		return jdbillMapper.selectByExample(jdBillExample);
	}

}
