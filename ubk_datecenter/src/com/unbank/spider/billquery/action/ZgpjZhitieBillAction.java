package com.unbank.spider.billquery.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unbank.spider.billquery.service.ZgpjPiaojuBillService;
import com.unbank.spider.billquery.service.ZgpjZhitieBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.ZgpjPiaojuBill;
import com.unbank.spider.mybatis.vo.ZgpjZhitieBill;
import com.unbank.spider.tools.MD5;

public class ZgpjZhitieBillAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchCondition searchCondition = new SearchCondition();
	private Integer rows;// 每页显示的记录数
	private Integer page;// 当前第几页
	private String fileName;
	private InputStream inputStream;
	private JSONObject result;
	private ZgpjZhitieBillService zgpjZhitieBillService;

	public String readZgpjZhitieBills() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<ZgpjZhitieBill> yinpiaoBills = zgpjZhitieBillService
				.readZgpjZhitieBills(searchCondition, start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total",
				zgpjZhitieBillService.countOfZgpjZhitieBills(searchCondition));// total键
		jsonMap.put("rows", yinpiaoBills);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportZgpjZhitieBillExcel() {
		List<ZgpjZhitieBill> jdBills = zgpjZhitieBillService
				.readZgpjZhitieBills(searchCondition);
		String rows[] = new String[] { "交易地点", "交易利率", "银行类型", "票据类型", "交易时间" };
		File file = writerExcel(jdBills, rows);
		ByteArrayOutputStream bout;
		try {
			byte[] buffer = new byte[1024];
			bout = new ByteArrayOutputStream();
			FileInputStream fis = new FileInputStream(file);
			int len;
			while ((len = fis.read(buffer)) > 0) {
				bout.write(buffer, 0, len);
			}
			fis.close();
			file.delete();
			inputStream = new ByteArrayInputStream(bout.toByteArray());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	public File writerExcel(List<ZgpjZhitieBill> list, String[] rows) {
		XSSFWorkbook xwb = new XSSFWorkbook();
		try {
			XSSFSheet sheet = xwb.createSheet();
			XSSFRow row;
			row = sheet.createRow(0);
			for (int i = 0; i < rows.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(rows[i]);
			}
			// "交易地点","交易利率","银行类型","票据类型","交易时间"
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				ZgpjZhitieBill zgpjZhitieBill = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(zgpjZhitieBill.getProPlace());
				cell = row.createCell(1);
				cell.setCellValue(zgpjZhitieBill.getProRate());
				cell = row.createCell(2);
				cell.setCellValue(zgpjZhitieBill.getProBank());
				cell = row.createCell(3);
				cell.setCellValue(zgpjZhitieBill.getBillType());
				cell = row.createCell(4);
				cell.setCellValue(zgpjZhitieBill.getProDate());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		fileName = getyyyyMMddTimeString(new Date(), 0) + "_"
				+ MD5.GetMD5Code(new Date().toString()) + ".xlsx";
		File file = new File(fileName);
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			xwb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			fileName = "";

		}
		return file;
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

	public SearchCondition getModel() {
		return searchCondition;
	}

	public SearchCondition getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ZgpjZhitieBillService getZgpjZhitieBillService() {
		return zgpjZhitieBillService;
	}

	public void setZgpjZhitieBillService(
			ZgpjZhitieBillService zgpjZhitieBillService) {
		this.zgpjZhitieBillService = zgpjZhitieBillService;
	}

}
