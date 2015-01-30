package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.Jr138Bill;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface Jr138BillService {

	List<Jr138Bill> readJr138Bills(SearchCondition searchCondition, int page,
			int limit);

	int countOfJr138Bills(SearchCondition searchCondition);

	List<Jr138Bill> readJr138Bills(SearchCondition searchCondition);

}
