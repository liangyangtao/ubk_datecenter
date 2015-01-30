package com.unbank.spider.keyword.dao;

import java.util.List;

import com.unbank.spider.keyword.entity.KeywordInfo;
import com.unbank.spider.mybatis.vo.ArticleInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public interface KeywordDao {

	List<ArticleInfo> readInfo();

	KeywordInfo readKeywordInfo(SearchCondition searchCondition);

	void saveKeywordInfo(SearchCondition searchCondition);

}
