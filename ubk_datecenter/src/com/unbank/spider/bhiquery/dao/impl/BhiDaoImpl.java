package com.unbank.spider.bhiquery.dao.impl;

import java.util.Date;
import java.util.List;

import com.unbank.spider.bhiquery.dao.BhiDao;
import com.unbank.spider.mybatis.client.BhiInfoMapper;
import com.unbank.spider.mybatis.vo.BhiInfo;
import com.unbank.spider.mybatis.vo.BhiInfoExample;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.SimpleTools;

public class BhiDaoImpl implements BhiDao {

	BhiInfoMapper bhiInfoMapper;

	public List<BhiInfo> readBhiInfos(SearchCondition searchCondition,
			int start, Integer rows) {
		BhiInfoExample bhiInfoExample = new BhiInfoExample();
		bhiInfoExample.setOrderByClause("pro_time desc limit " + start + " , "
				+ rows);

		return bhiInfoMapper.selectByExample(bhiInfoExample);
	}

	public Object countOfBhiInfos(SearchCondition searchCondition) {

		BhiInfoExample bhiInfoExample = new BhiInfoExample();
		return bhiInfoMapper.countByExample(bhiInfoExample);
	}

	public List<BhiInfo> readBhiInfos(SearchCondition searchCondition) {
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
		BhiInfoExample bhiInfoExample = new BhiInfoExample();
		bhiInfoExample.or().andProTimeBetween(startDate, endDate);
		bhiInfoExample.setOrderByClause("pro_time desc");
		return bhiInfoMapper.selectByExample(bhiInfoExample);
	}

	public BhiInfoMapper getBhiInfoMapper() {
		return bhiInfoMapper;
	}

	public void setBhiInfoMapper(BhiInfoMapper bhiInfoMapper) {
		this.bhiInfoMapper = bhiInfoMapper;
	}

}
