package com.unbank.spider.courtquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.CourtInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface CourtQueryService {

	List<CourtInfo> readCourtInfos(SearchCondition searchCondition, int start,
			Integer rows);

	Object countOfCourtInfos(SearchCondition searchCondition);

	List<CourtInfo> readCourtInfos(SearchCondition searchCondition);

}
