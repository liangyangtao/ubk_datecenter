package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhuantieBill;

public interface ZgpjZhuantieBillDao {

	List<ZgpjZhuantieBill> readZgpjZhuantieBills(
			SearchCondition searchCondition, int page, int limit);

	int countOfZgpjZhuantieBills(SearchCondition searchCondition);

	List<ZgpjZhuantieBill> readZgpjZhuantieBills(SearchCondition searchCondition);

}
