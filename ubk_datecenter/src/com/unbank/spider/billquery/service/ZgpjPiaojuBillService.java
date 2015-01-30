package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjPiaojuBill;

public interface ZgpjPiaojuBillService {

	List<ZgpjPiaojuBill> readZgpjPiaojuBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfZgpjPiaojuBills(SearchCondition searchCondition);

	List<ZgpjPiaojuBill> readZgpjPiaojuBills(SearchCondition searchCondition);

}
