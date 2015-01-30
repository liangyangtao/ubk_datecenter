package com.unbank.spider.fundquery.dao;

import java.util.List;

import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YangleeSilverLetter;

public interface YangleeSilverLetterDao {

	List<YangleeSilverLetter> readYangleeSilverLetterInfos(
			SearchCondition searchCondition, int start, Integer rows);

	Object countOfYangleeSilverLetterInfos(SearchCondition searchCondition);

	List<YangleeSilverLetter> readYangleeSilverLetterInfos(
			SearchCondition searchCondition);

}
