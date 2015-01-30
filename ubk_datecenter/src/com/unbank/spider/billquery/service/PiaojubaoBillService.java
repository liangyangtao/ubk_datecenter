package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.PiaojubaoBill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface PiaojubaoBillService {

	List<PiaojubaoBill> readPiaojubaoBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfPiaojubaoBills(SearchCondition searchCondition);

	List<PiaojubaoBill> readPiaojubaoBills(SearchCondition searchCondition);

}
