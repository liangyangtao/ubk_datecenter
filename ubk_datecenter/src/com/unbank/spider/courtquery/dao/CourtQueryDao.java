package com.unbank.spider.courtquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.CourtInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface CourtQueryDao {

	List<CourtInfo> readCourtInfos(SearchCondition searchCondition, int start,
			Integer rows);

	Object countOfCourtInfos(SearchCondition searchCondition);

	List<CourtInfo> readCourtInfos(SearchCondition searchCondition);

}
