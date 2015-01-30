package com.unbank.spider.fundquery.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
import com.unbank.spider.fundquery.service.ChinaventureFinancingService;
import com.unbank.spider.mybatis.vo.ChinaventureFinancing;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.MD5;
import com.unbank.spider.tools.SimpleTools;

public class ChinaventureFinancingAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	private static final long serialVersionUID = 1L;
	private SearchCondition searchCondition = new SearchCondition();
	private Integer rows;// 每页显示的记录数
	private Integer page;// 当前第几页
	private String fileName;
	private InputStream inputStream;
	private JSONObject result;
	private ChinaventureFinancingService chinaventureFinancingService;

	public String readChinaventureFinancingInfos() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;
		List<ChinaventureFinancing> courtInfos = chinaventureFinancingService
				.readChinaventureFinancingInfos(searchCondition, start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total", chinaventureFinancingService
				.countOfChinaventureFinancingInfos(searchCondition));// total键
		jsonMap.put("rows", courtInfos);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportChinaventureFinancingExcel() {
		List<ChinaventureFinancing> courtInfos = chinaventureFinancingService
				.readChinaventureFinancingInfos(searchCondition);
		String rows[] = new String[] { "产品名称 ", "时间", "地区", "企业性质", "融资性质",
				"融资金额", "股权", "企业估值", "行业分类", "融资方 ", "投资方", "投资银行", "律师事务所",
				"会计事务所", "交易描述" };
		File file = writerExcel(courtInfos, rows);
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

	public File writerExcel(List<ChinaventureFinancing> list, String[] rows) {
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
				ChinaventureFinancing chinaventureFinancing = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(chinaventureFinancing.getProName());
				cell = row.createCell(1);
				cell.setCellValue(chinaventureFinancing.getProTime());
				cell = row.createCell(2);
				cell.setCellValue(chinaventureFinancing.getProArea());
				cell = row.createCell(3);
				cell.setCellValue(chinaventureFinancing.getEnterpriseType());
				cell = row.createCell(4);
				cell.setCellValue(chinaventureFinancing.getFinancingType());
				cell = row.createCell(5);
				cell.setCellValue(chinaventureFinancing.getFinancingMoney());
				cell = row.createCell(6);
				cell.setCellValue(chinaventureFinancing.getEquity());
				cell = row.createCell(7);
				cell.setCellValue(chinaventureFinancing.getBusinessValuation());
				cell = row.createCell(8);
				cell.setCellValue(chinaventureFinancing.getIndustryCategory());
				cell = row.createCell(9);
				cell.setCellValue(chinaventureFinancing.getTargetEnterprise());
				cell = row.createCell(10);
				cell.setCellValue(chinaventureFinancing.getBuyerCompany());
				cell = row.createCell(11);
				cell.setCellValue(chinaventureFinancing.getInvestmentBank());
				cell = row.createCell(12);
				cell.setCellValue(chinaventureFinancing.getLawFirm());
				cell = row.createCell(13);
				cell.setCellValue(chinaventureFinancing.getAccountingFirm());
				cell = row.createCell(14);
				cell.setCellValue(chinaventureFinancing
						.getBusinessTransaction());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		fileName = SimpleTools.getyyyyMMddTimeString(new Date(), 0) + "_"
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

	public SearchCondition getModel() {
		return searchCondition;
	}

	public SearchCondition getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public ChinaventureFinancingService getChinaventureFinancingService() {
		return chinaventureFinancingService;
	}

	public void setChinaventureFinancingService(
			ChinaventureFinancingService chinaventureFinancingService) {
		this.chinaventureFinancingService = chinaventureFinancingService;
	}

}
