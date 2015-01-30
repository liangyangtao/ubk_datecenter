package com.unbank.spider.fundquery.service.impl;

import java.util.List;

import com.unbank.spider.fundquery.dao.YangleeSilverLetterDao;
import com.unbank.spider.fundquery.service.YangleeSilverLetterService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YangleeSilverLetter;

public class YangleeSilverLetterServiceImpl implements
		YangleeSilverLetterService {

	YangleeSilverLetterDao yangleeSilverLetterDao;

	public List<YangleeSilverLetter> readYangleeSilverLetterInfos(
			SearchCondition searchCondition, int start, Integer rows) {
		return yangleeSilverLetterDao.readYangleeSilverLetterInfos(
				searchCondition, start, rows);
	}

	public Object countOfYangleeSilverLetterInfos(
			SearchCondition searchCondition) {

		return yangleeSilverLetterDao
				.countOfYangleeSilverLetterInfos(searchCondition);
	}

	public YangleeSilverLetterDao getYangleeSilverLetterDao() {
		return yangleeSilverLetterDao;
	}

	public void setYangleeSilverLetterDao(
			YangleeSilverLetterDao yangleeSilverLetterDao) {
		this.yangleeSilverLetterDao = yangleeSilverLetterDao;
	}

	public List<YangleeSilverLetter> readYangleeSilverLetterInfos(
			SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return yangleeSilverLetterDao.readYangleeSilverLetterInfos(searchCondition);
	}

}
