package com.unbank.spider.fundquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.ChinaventureMergerevent;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface ChinaventureMergereventDao {

	List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition, int start, Integer rows);

	Object countOfChinaventureMergereventInfos(SearchCondition searchCondition);

	List<ChinaventureMergerevent> readChinaventureMergereventInfos(
			SearchCondition searchCondition);

}
