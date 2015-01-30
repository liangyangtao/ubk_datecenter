package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YinpiaoBill;

public interface YinpiaoBillDao {

	List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfYinpiaoBills(SearchCondition searchCondition);

	List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition);

}
