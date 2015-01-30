package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.Chinabill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface ChinaBillDao {

	List<Chinabill> readChinabills(SearchCondition searchCondition, int page,
			int limit);

	int countOfChinabills(SearchCondition searchCondition);

	List<Chinabill> readChinabills(SearchCondition searchCondition);

}
