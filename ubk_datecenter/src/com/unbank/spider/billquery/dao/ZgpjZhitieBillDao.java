package com.unbank.spider.billquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjZhitieBill;

public interface ZgpjZhitieBillDao {

	List<ZgpjZhitieBill> readZgpjZhitieBills(SearchCondition searchCondition,
			int page, int limit);

	int countOfZgpjZhitieBills(SearchCondition searchCondition);

	List<ZgpjZhitieBill> readZgpjZhitieBills(SearchCondition searchCondition);

}
