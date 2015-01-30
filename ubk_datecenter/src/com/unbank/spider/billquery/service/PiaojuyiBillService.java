package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.PiaojuyiBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface PiaojuyiBillService {

	List<PiaojuyiBill> readPiaojuyiBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfPiaojuyiBills(SearchCondition searchCondition);

	List<PiaojuyiBill> readPiaojuyiBills(SearchCondition searchCondition);

}
