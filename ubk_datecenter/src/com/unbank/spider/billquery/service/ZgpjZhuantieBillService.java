package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhuantieBill;

public interface ZgpjZhuantieBillService {

	List<ZgpjZhuantieBill> readZgpjZhuantieBills(
			SearchCondition searchCondition, int page, int limit);

	int countOfZgpjZhuantieBills(SearchCondition searchCondition);

	List<ZgpjZhuantieBill> readZgpjZhuantieBills(SearchCondition searchCondition);

}
