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
import com.unbank.spider.billquery.service.YinpiaoBillService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YinpiaoBill;
import com.unbank.spider.tools.MD5;

public class YinpiaoBillAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchCondition searchCondition = new SearchCondition();
	private YinpiaoBillService yinpiaoBillService;
	private Integer rows;// 每页显示的记录数
	private Integer page;// 当前第几页
	private String fileName;
	private InputStream inputStream;
	private JSONObject result;

	public String readYinpiaoBills() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<YinpiaoBill> yinpiaoBills = yinpiaoBillService.readYinpiaoBills(
				searchCondition, start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total",
				yinpiaoBillService.countOfYinpiaoBills(searchCondition));// total键
		jsonMap.put("rows", yinpiaoBills);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportYinpaoExcel() {
		List<YinpiaoBill> jdBills = yinpiaoBillService
				.readYinpiaoBills(searchCondition);
		String rows[] = new String[] { "发布日期", "产品名称", "募集金额", "理财期限", "承兑银行",
				"产品期数", "发布时间", "预期年化收益率" };
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

	public File writerExcel(List<YinpiaoBill> list, String[] rows) {
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
				YinpiaoBill yinpiaoBill = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(yinpiaoBill.getProDate());
				cell = row.createCell(1);
				cell.setCellValue(yinpiaoBill.getProName());
				cell = row.createCell(2);
				cell.setCellValue(yinpiaoBill.getProMoney());
				cell = row.createCell(3);
				cell.setCellValue(yinpiaoBill.getProLimit());
				cell = row.createCell(4);
				cell.setCellValue(yinpiaoBill.getProBank());
				cell = row.createCell(5);
				cell.setCellValue(yinpiaoBill.getProNum());
				cell = row.createCell(6);
				cell.setCellValue(yinpiaoBill.getProTime());
				cell = row.createCell(7);
				cell.setCellValue(yinpiaoBill.getProRate());
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

	public YinpiaoBillService getYinpiaoBillService() {
		return yinpiaoBillService;
	}

	public void setYinpiaoBillService(YinpiaoBillService yinpiaoBillService) {
		this.yinpiaoBillService = yinpiaoBillService;
	}

}
