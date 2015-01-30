package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.PiaojuyiBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface PiaojuyiBillDao {

	List<PiaojuyiBill> readPiaojuyiBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfPiaojuyiBills(SearchCondition searchCondition);

	List<PiaojuyiBill> readPiaojuyiBills(SearchCondition searchCondition);

}
