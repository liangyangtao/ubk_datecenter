package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YinpiaoBill;

public interface YinpiaoBillService {

	List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfYinpiaoBills(SearchCondition searchCondition);

	List<YinpiaoBill> readYinpiaoBills(SearchCondition searchCondition);

}
