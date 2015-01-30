package com.unbank.spider.billquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhitieBill;

public interface ZgpjZhitieBillService {

	List<ZgpjZhitieBill> readZgpjZhitieBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfZgpjZhitieBills(SearchCondition searchCondition);

	List<ZgpjZhitieBill> readZgpjZhitieBills(SearchCondition searchCondition);

}
