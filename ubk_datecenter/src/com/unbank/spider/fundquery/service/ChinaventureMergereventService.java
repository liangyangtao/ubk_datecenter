package com.unbank.spider.fundquery.service;

import java.util.List;

import com.unbank.spider.mybatis.vo.ChinaventureMergerevent;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface ChinaventureMergereventService {

	List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition, int start, Integer rows);

	Object countOfChinaventureMergereventInfos(SearchCondition searchCondition);

	List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition);

}
