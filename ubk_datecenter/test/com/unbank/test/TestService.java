package com.unbank.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unbank.spider.fundquery.service.YangleeSilverLetterService;
import com.unbank.spider.keyword.service.KeywordService;
import com.unbank.spider.mybatis.vo.SearchCondition;

public class TestService {
	@Test
	public void testGetAllWebsite() {
		YangleeSilverLetterService websiteManageService = (YangleeSilverLetterService) new ClassPathXmlApplicationContext(
				"applicationContext.xml", "applicationContext-fundquery.xml")
				.getBean("yangleeSilverLetterService");

		SearchCondition searchCondition = new SearchCondition();
		searchCondition.setCrawlid(316);
		searchCondition.setKeyword("银行@@@小红@@@大米");

		websiteManageService.readYangleeSilverLetterInfos(searchCondition);
	}

}
