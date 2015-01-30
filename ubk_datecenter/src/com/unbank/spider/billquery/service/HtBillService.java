package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.HtBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface HtBillService {

	List<HtBill> readHtBills(SearchCondition searchCondition, int page,
			int limit);

	int countOfHtBills(SearchCondition searchCondition);

	List<HtBill> readHtBills(SearchCondition searchCondition);

}
