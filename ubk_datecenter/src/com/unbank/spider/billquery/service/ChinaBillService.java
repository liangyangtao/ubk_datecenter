package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.Chinabill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface ChinaBillService {

	List<Chinabill> readChinabills(SearchCondition searchCondition, int page,
			int limit);

	int countOfChinabills(SearchCondition searchCondition);

	List<Chinabill> readChinabills(SearchCondition searchCondition);

}
