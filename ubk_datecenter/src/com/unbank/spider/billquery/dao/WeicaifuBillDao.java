package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.WeicaifuBill;

public interface WeicaifuBillDao {

	List<WeicaifuBill> readWeicaifuBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfWeicaifuBills(SearchCondition searchCondition);

	List<WeicaifuBill> readWeicaifuBills(SearchCondition searchCondition);

}
