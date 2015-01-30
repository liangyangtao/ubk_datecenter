package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.PjtxBillDao;
import com.unbank.spider.mybatis.client.PjtxBillMapper;
import com.unbank.spider.mybatis.vo.PjtxBill;
import com.unbank.spider.mybatis.vo.PjtxBillExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class PjtxBillDaoImpl implements PjtxBillDao {

	private PjtxBillMapper pjtxBillMapper;

	public List<PjtxBill> readPjtxBills(SearchCondition searchCondition,
			int page, int limit) {

		PjtxBillExample pjtxBillExample = new PjtxBillExample();
		pjtxBillExample.setOrderByClause("pro_date desc limit " + page + " , "
				+ limit);
		return pjtxBillMapper.selectByExample(pjtxBillExample);
	}

	public int countOfPjtxBills(SearchCondition searchCondition) {
		PjtxBillExample pjtxBillExample = new PjtxBillExample();
		return pjtxBillMapper.countByExample(pjtxBillExample);
	}

	public List<PjtxBill> readPjtxBills(SearchCondition searchCondition) {
		PjtxBillExample pjtxBillExample = new PjtxBillExample();
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
		pjtxBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		pjtxBillExample.setOrderByClause("pro_date desc");
		return pjtxBillMapper.selectByExample(pjtxBillExample);
	}

	public PjtxBillMapper getPjtxBillMapper() {
		return pjtxBillMapper;
	}

	public void setPjtxBillMapper(PjtxBillMapper pjtxBillMapper) {
		this.pjtxBillMapper = pjtxBillMapper;
	}

}
