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
import com.unbank.spider.billquery.service.Jr138BillService;
import com.unbank.spider.mybatis.vo.Jr138Bill;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.MD5;

public class Jr138BillAction extends ActionSupport implements
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
	private Jr138BillService jr138BillService;

	public String readJr138Bills() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<Jr138Bill> yinpiaoBills = jr138BillService.readJr138Bills(
				searchCondition, start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total",
				jr138BillService.countOfJr138Bills(searchCondition));// total键
		jsonMap.put("rows", yinpiaoBills);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportJr138BillExcel() {
		List<Jr138Bill> jdBills = jr138BillService
				.readJr138Bills(searchCondition);
		String rows[] = new String[] { "期限", "金额", "交易地点", "交易类型", "交易利率",
				"查看类型", "交易时间", "银行类型" };
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

	public File writerExcel(List<Jr138Bill> list, String[] rows) {
		XSSFWorkbook xwb = new XSSFWorkbook();
		try {
			XSSFSheet sheet = xwb.createSheet();
			XSSFRow row;
			row = sheet.createRow(0);
			for (int i = 0; i < rows.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(rows[i]);
			}
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				Jr138Bill jr138Bill = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(jr138Bill.getProLimit());
				cell = row.createCell(1);
				cell.setCellValue(jr138Bill.getProMoney());
				cell = row.createCell(2);
				cell.setCellValue(jr138Bill.getProPlace());
				cell = row.createCell(3);
				cell.setCellValue(jr138Bill.getProType());
				cell = row.createCell(4);
				cell.setCellValue(jr138Bill.getProRate());
				cell = row.createCell(5);
				cell.setCellValue(jr138Bill.getLookType());
				cell = row.createCell(6);
				cell.setCellValue(jr138Bill.getProDate());
				cell = row.createCell(7);
				cell.setCellValue(jr138Bill.getProBank());
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

	public Jr138BillService getJr138BillService() {
		return jr138BillService;
	}

	public void setJr138BillService(Jr138BillService jr138BillService) {
		this.jr138BillService = jr138BillService;
	}

}
