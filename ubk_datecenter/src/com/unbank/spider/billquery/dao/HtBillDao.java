package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.HtBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface HtBillDao {

	List<HtBill> readHtBills(SearchCondition searchCondition, int page,
			int limit);

	int countOfHtBills(SearchCondition searchCondition);

	List<HtBill> readHtBills(SearchCondition searchCondition);

}
