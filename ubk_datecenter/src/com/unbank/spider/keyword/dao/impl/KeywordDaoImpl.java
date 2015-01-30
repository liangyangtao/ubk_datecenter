package com.unbank.spider.keyword.dao.impl;

import java.util.List;

import com.unbank.spider.keyword.dao.KeywordDao;
import com.unbank.spider.keyword.entity.KeywordInfo;
import com.unbank.spider.mybatis.client.ArticleContentMapper;
import com.unbank.spider.mybatis.client.ArticleInfoMapper;
import com.unbank.spider.mybatis.client.ArticleKeywordMapper;
import com.unbank.spider.mybatis.vo.ArticleContent;
import com.unbank.spider.mybatis.vo.ArticleInfo;
import com.unbank.spider.mybatis.vo.ArticleInfoExample;
import com.unbank.spider.mybatis.vo.ArticleKeyword;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class KeywordDaoImpl implements KeywordDao {
	private ArticleInfoMapper articleInfoMapper;

	private ArticleContentMapper articleContentMapper;

	private ArticleKeywordMapper articleKeywordMapper;

	public List<ArticleInfo> readInfo() {
		ArticleInfoExample example = new ArticleInfoExample();
		return articleInfoMapper.selectByExample(example);
	}

	public ArticleInfoMapper getArticleInfoMapper() {
		return articleInfoMapper;
	}

	public void setArticleInfoMapper(ArticleInfoMapper articleInfoMapper) {
		this.articleInfoMapper = articleInfoMapper;
	}

	public KeywordInfo readKeywordInfo(SearchCondition searchCondition) {
		Integer crawl_id = searchCondition.getCrawlid();
		if (crawl_id != 0) {
			KeywordInfo keywordInfo = new KeywordInfo();
			ArticleContent articleContent = articleContentMapper
					.selectByPrimaryKey(crawl_id);

			keywordInfo.setCrawlId(crawl_id);
			keywordInfo.setContent(articleContent.getText());
			return keywordInfo;
		}
		return null;
	}

	public ArticleContentMapper getArticleContentMapper() {
		return articleContentMapper;
	}

	public void setArticleContentMapper(
			ArticleContentMapper articleContentMapper) {
		this.articleContentMapper = articleContentMapper;
	}

	public ArticleKeywordMapper getArticleKeywordMapper() {
		return articleKeywordMapper;
	}

	public void setArticleKeywordMapper(
			ArticleKeywordMapper articleKeywordMapper) {
		this.articleKeywordMapper = articleKeywordMapper;
	}

	public void saveKeywordInfo(SearchCondition searchCondition) {
		Integer crawlid = searchCondition.getCrawlid();
		String keyword = searchCondition.getKeyword();
		ArticleKeyword record = new ArticleKeyword();
		record.setCrawlId(crawlid);
		record.setKeyword(keyword);
		articleKeywordMapper.insertSelective(record);
	}

}
