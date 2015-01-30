package com.unbank.spider.billquery.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BillQueryBaseDao {
	public String dateToString(Date time) {
		if (time == null) {
			time = new Date();
		}
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		String ctime = formatter.format(time);
		return ctime;
	}

	public String getyyyyMMddTimeString(Date date, int num) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DATE, num);
		date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = simpleDateFormat.format(date);
		return dateString;
	}

	public Date getMyDate(Date date, int num) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DATE, num);
		date = calendar.getTime();
		return date;
	}

}
