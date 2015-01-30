package com.unbank.spider.fundquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.fundquery.dao.YangleeSilverLetterDao;
import com.unbank.spider.mybatis.client.YangleeSilverLetterMapper;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YangleeSilverLetter;
import com.unbank.spider.mybatis.vo.YangleeSilverLetterExample;
import com.unbank.spider.tools.SimpleTools;

public class YangleeSilverLetterDaoImpl implements YangleeSilverLetterDao {

	YangleeSilverLetterMapper yangleeSilverLetterMapper;

	public List<YangleeSilverLetter> readYangleeSilverLetterInfos(
			SearchCondition searchCondition, int start, Integer rows) {
		YangleeSilverLetterExample yangleeSilverLetterExample = new YangleeSilverLetterExample();
		yangleeSilverLetterExample
				.setOrderByClause("issue_date desc limit " + start
						+ " , " + rows);
		return yangleeSilverLetterMapper
				.selectByExample(yangleeSilverLetterExample);
	}

	public Object countOfYangleeSilverLetterInfos(
			SearchCondition searchCondition) {
		YangleeSilverLetterExample yangleeSilverLetterExample = new YangleeSilverLetterExample();
		return yangleeSilverLetterMapper
				.countByExample(yangleeSilverLetterExample);
	}

	public YangleeSilverLetterMapper getYangleeSilverLetterMapper() {
		return yangleeSilverLetterMapper;
	}

	public void setYangleeSilverLetterMapper(
			YangleeSilverLetterMapper yangleeSilverLetterMapper) {
		this.yangleeSilverLetterMapper = yangleeSilverLetterMapper;
	}

	public List<YangleeSilverLetter> readYangleeSilverLetterInfos(
			SearchCondition searchCondition) {
		YangleeSilverLetterExample yangleeSilverLetterExample = new YangleeSilverLetterExample();
		Date startDate = searchCondition.getStartTime();
		Date endDate = searchCondition.getEndTime();
		if (startDate != null && endDate != null) {
		} else if (startDate == null && endDate == null) {
			startDate = SimpleTools.getMyDate(new Date(), -30);
			endDate = new Date();
		} else if (startDate == null && endDate != null) {
			startDate = SimpleTools.getMyDate(new Date(), -10);
		} else {
			endDate = new Date();
		}
		yangleeSilverLetterExample.or().andEstablishedTimeBetween(
				SimpleTools.dateToString(startDate, "yyyy-MM-dd"),
				SimpleTools.dateToString(endDate, "yyyy-MM-dd"));
		yangleeSilverLetterExample.setOrderByClause("issue_date desc");
		return yangleeSilverLetterMapper
				.selectByExample(yangleeSilverLetterExample);
	}

}
