package com.unbank.spider.bhiquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.BhiInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface BhiDao {

	List<BhiInfo> readBhiInfos(SearchCondition searchCondition, int start,
			Integer rows);

	Object countOfBhiInfos(SearchCondition searchCondition);

	List<BhiInfo> readBhiInfos(SearchCondition searchCondition);

}
