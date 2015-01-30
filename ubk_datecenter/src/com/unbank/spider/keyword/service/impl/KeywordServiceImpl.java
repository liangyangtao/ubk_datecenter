package com.unbank.spider.keyword.service.impl;

import java.util.List;

import com.unbank.spider.keyword.dao.KeywordDao;
import com.unbank.spider.keyword.entity.KeywordInfo;
import com.unbank.spider.keyword.service.KeywordService;
import com.unbank.spider.mybatis.vo.ArticleInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class KeywordServiceImpl implements KeywordService {

	private KeywordDao keywordDao;

	public List<ArticleInfo> readInfo() {
		return keywordDao.readInfo();
	}

	public KeywordDao getKeywordDao() {
		return keywordDao;
	}

	public void setKeywordDao(KeywordDao keywordDao) {
		this.keywordDao = keywordDao;
	}

	public KeywordInfo readKeywordInfo(SearchCondition searchCondition) {
		return keywordDao.readKeywordInfo(searchCondition);
	}

	public void saveKeywordInfo(SearchCondition searchCondition) {
		keywordDao.saveKeywordInfo(searchCondition);
	}

}
