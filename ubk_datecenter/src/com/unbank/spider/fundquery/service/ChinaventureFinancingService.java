package com.unbank.spider.fundquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.ChinaventureFinancing;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface ChinaventureFinancingService {

	List<ChinaventureFinancing> readChinaventureFinancingInfos(
			SearchCondition searchCondition, int start, Integer rows);

	Object countOfChinaventureFinancingInfos(SearchCondition searchCondition);

	List<ChinaventureFinancing> readChinaventureFinancingInfos(
			SearchCondition searchCondition);

}
