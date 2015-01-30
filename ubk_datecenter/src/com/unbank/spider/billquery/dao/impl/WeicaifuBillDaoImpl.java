package com.unbank.spider.billquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.billquery.dao.WeicaifuBillDao;
import com.unbank.spider.mybatis.client.WeicaifuBillMapper;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.WeicaifuBill;
import com.unbank.spider.mybatis.vo.WeicaifuBillExample;
import com.unbank.spider.tools.SimpleTools;

public class WeicaifuBillDaoImpl implements WeicaifuBillDao {

	WeicaifuBillMapper weicaifuBillMapper;

	public List<WeicaifuBill> readWeicaifuBills(
			SearchCondition searchCondition, int page, int limit) {
		WeicaifuBillExample weicaifuBillExample = new WeicaifuBillExample();
		weicaifuBillExample.setOrderByClause("pro_date desc limit " + page
				+ " , " + limit);
		return weicaifuBillMapper.selectByExample(weicaifuBillExample);
	}

	public int countOfWeicaifuBills(SearchCondition searchCondition) {
		WeicaifuBillExample weicaifuBillExample = new WeicaifuBillExample();
		return weicaifuBillMapper.countByExample(weicaifuBillExample);
	}

	public List<WeicaifuBill> readWeicaifuBills(SearchCondition searchCondition) {
		WeicaifuBillExample weicaifuBillExample = new WeicaifuBillExample();
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
		weicaifuBillExample.or().andProDateBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		weicaifuBillExample.setOrderByClause("pro_date desc");
		return weicaifuBillMapper.selectByExample(weicaifuBillExample);
	}

	public WeicaifuBillMapper getWeicaifuBillMapper() {
		return weicaifuBillMapper;
	}

	public void setWeicaifuBillMapper(WeicaifuBillMapper weicaifuBillMapper) {
		this.weicaifuBillMapper = weicaifuBillMapper;
	}

}
