package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.Jdbill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface JdBillService {

	List<Jdbill> readJDBills(SearchCondition searchCondition, int page,
			int limit);

	int countOfbill(SearchCondition searchCondition);

	List<Jdbill> readJDBills(SearchCondition searchCondition);

}
