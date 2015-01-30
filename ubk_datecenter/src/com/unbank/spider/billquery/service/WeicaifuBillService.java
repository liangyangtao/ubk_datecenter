package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.WeicaifuBill;

public interface WeicaifuBillService {

	List<WeicaifuBill> readWeicaifuBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfWeicaifuBills(SearchCondition searchCondition);

	List<WeicaifuBill> readWeicaifuBills(SearchCondition searchCondition);
}
