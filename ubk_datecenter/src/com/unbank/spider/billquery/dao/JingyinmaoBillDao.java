package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.JingyinmaoBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface JingyinmaoBillDao {

	List<JingyinmaoBill> readJingyinmaoBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfJingyinmaoBills(SearchCondition searchCondition);

	List<JingyinmaoBill> readJingyinmaoBills(SearchCondition searchCondition);

}
