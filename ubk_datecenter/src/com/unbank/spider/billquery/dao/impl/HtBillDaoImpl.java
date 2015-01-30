package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.HtBillDao;
import com.unbank.spider.mybatis.client.HtBillMapper;
import com.unbank.spider.mybatis.vo.HtBill;
import com.unbank.spider.mybatis.vo.HtBillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class HtBillDaoImpl implements HtBillDao {

	private HtBillMapper htBillMapper;

	public List<HtBill> readHtBills(SearchCondition searchCondition, int page,
			int limit) {
		HtBillExample htBillExample = new HtBillExample();
		htBillExample.setOrderByClause("pro_date desc limit " + page + " , "
				+ limit);
		return htBillMapper.selectByExample(htBillExample);
	}

	public int countOfHtBills(SearchCondition searchCondition) {
		HtBillExample htBillExample = new HtBillExample();
		return htBillMapper.countByExample(htBillExample);
	}

	public List<HtBill> readHtBills(SearchCondition searchCondition) {
		HtBillExample htBillExample = new HtBillExample();
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
		htBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		htBillExample.setOrderByClause("pro_date desc");
		return htBillMapper.selectByExample(htBillExample);
	}

	public HtBillMapper getHtBillMapper() {
		return htBillMapper;
	}

	public void setHtBillMapper(HtBillMapper htBillMapper) {
		this.htBillMapper = htBillMapper;
	}

}
