package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.PjtxBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface PjtxBillDao {

	List<PjtxBill> readPjtxBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfPjtxBills(SearchCondition searchCondition);

	List<PjtxBill> readPjtxBills(SearchCondition searchCondition);

}
