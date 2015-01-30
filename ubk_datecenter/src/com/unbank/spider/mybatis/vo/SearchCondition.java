package com.unbank.spider.mybatis.vo;

import java.util.Date;

public class SearchCondition {
	private Integer crawlid;
	private String crawltitle;
	private String keyword;
	private Date startTime;
	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getCrawlid() {
		return crawlid;
	}

	public void setCrawlid(Integer crawlid) {
		this.crawlid = crawlid;
	}

	public String getCrawltitle() {
		return crawltitle;
	}

	public void setCrawltitle(String crawltitle) {
		this.crawltitle = crawltitle;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
