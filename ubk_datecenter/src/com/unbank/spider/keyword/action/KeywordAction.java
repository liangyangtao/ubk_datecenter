package com.unbank.spider.keyword.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unbank.spider.keyword.entity.KeywordInfo;
import com.unbank.spider.keyword.service.KeywordService;
import com.unbank.spider.mybatis.vo.ArticleInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class KeywordAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	private SearchCondition searchCondition = new SearchCondition();
	private KeywordService keywordService;
	private List<ArticleInfo> articleInfos;
	private KeywordInfo keywordInfo;

	public String readInfo() {
		articleInfos = keywordService.readInfo();
		return SUCCESS;

	}

	public String readKeywordInfo() {
		keywordInfo = keywordService.readKeywordInfo(searchCondition);
		return SUCCESS;

	}

	public String saveKeywordInfo() {
		keywordService.saveKeywordInfo(searchCondition);

		return SUCCESS;

	}

	public SearchCondition getModel() {
		return searchCondition;
	}

	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public List<ArticleInfo> getArticleInfos() {
		return articleInfos;
	}

	public void setArticleInfos(List<ArticleInfo> articleInfos) {
		this.articleInfos = articleInfos;
	}

	public KeywordInfo getKeywordInfo() {
		return keywordInfo;
	}

	public void setKeywordInfo(KeywordInfo keywordInfo) {
		this.keywordInfo = keywordInfo;
	}

}
