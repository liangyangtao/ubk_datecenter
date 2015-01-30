package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.Jdbill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface JdBillDao {

	List<Jdbill> readJDBills(SearchCondition searchCondition, int page,
			int limit);

	int countOfbill(SearchCondition searchCondition);

	List<Jdbill> readJDBills(SearchCondition searchCondition);

}
