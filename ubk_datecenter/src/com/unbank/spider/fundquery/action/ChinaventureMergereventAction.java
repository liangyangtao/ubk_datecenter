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
import com.unbank.spider.fundquery.service.ChinaventureMergereventService;
import com.unbank.spider.mybatis.vo.ChinaventureMergerevent;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.MD5;
import com.unbank.spider.tools.SimpleTools;

public class ChinaventureMergereventAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	private static final long serialVersionUID = 1L;
	private SearchCondition searchCondition = new SearchCondition();
	private Integer rows;// 每页显示的记录数
	private Integer page;// 当前第几页
	private String fileName;
	private InputStream inputStream;
	private JSONObject result;
	private ChinaventureMergereventService chinaventureMergereventService;

	public String readChinaventureMergereventInfos() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;
		List<ChinaventureMergerevent> courtInfos = chinaventureMergereventService
				.readChinaventureMergereventInfos(searchCondition, start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total", chinaventureMergereventService
				.countOfChinaventureMergereventInfos(searchCondition));// total键
		jsonMap.put("rows", courtInfos);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportChinaventureMergereventExcel() {
		List<ChinaventureMergerevent> courtInfos = chinaventureMergereventService
				.readChinaventureMergereventInfos(searchCondition);
		String rows[] = new String[] { "产品名称 ", "产品类型", "交易方式", "是否跨境并购",
				"是否关联交易", "交易态度", "交易状态", "交易宣布时间", "交易结束时间", "交易金额", "企业估值",
				"支付方式", "行业分类 ", "标的企业", "买方企业", "投资银行", "律师事务所", "会计事务所",
				"资产评估公司", "交易描述" };
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

	public File writerExcel(List<ChinaventureMergerevent> list, String[] rows) {
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
				ChinaventureMergerevent chinaventureMergerevent = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(chinaventureMergerevent.getProName());
				cell = row.createCell(1);
				cell.setCellValue(chinaventureMergerevent.getTransactionType());
				cell = row.createCell(2);
				cell.setCellValue(chinaventureMergerevent.getTradingManner());
				cell = row.createCell(3);
				cell.setCellValue(chinaventureMergerevent
						.getWhetherCrossBorder());
				cell = row.createCell(4);
				cell.setCellValue(chinaventureMergerevent
						.getWhetherRelatedParty());
				cell = row.createCell(5);
				cell.setCellValue(chinaventureMergerevent.getTradingAttitude());
				cell = row.createCell(6);
				cell.setCellValue(chinaventureMergerevent
						.getTransactionStatus());
				cell = row.createCell(7);
				cell.setCellValue(chinaventureMergerevent
						.getDealAnnouncedTime());
				cell = row.createCell(8);
				cell.setCellValue(chinaventureMergerevent
						.getTransactionsOverTime());
				cell = row.createCell(9);
				cell.setCellValue(chinaventureMergerevent
						.getTransactionAmount());
				cell = row.createCell(10);
				cell.setCellValue(chinaventureMergerevent
						.getBusinessValuation());
				cell = row.createCell(11);
				cell.setCellValue(chinaventureMergerevent.getPatternPayment());
				cell = row.createCell(12);
				cell.setCellValue(chinaventureMergerevent.getIndustryCategory());
				cell = row.createCell(13);
				cell.setCellValue(chinaventureMergerevent.getTargetEnterprise());
				cell = row.createCell(14);
				cell.setCellValue(chinaventureMergerevent.getBuyerCompany());
				cell = row.createCell(15);
				cell.setCellValue(chinaventureMergerevent.getInvestmentBank());
				cell = row.createCell(16);
				cell.setCellValue(chinaventureMergerevent.getLawFirm());
				cell = row.createCell(17);
				cell.setCellValue(chinaventureMergerevent.getAccountingFirm());
				cell = row.createCell(18);
				cell.setCellValue(chinaventureMergerevent
						.getEvaluationCompany());
				cell = row.createCell(19);
				cell.setCellValue(chinaventureMergerevent
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

	public ChinaventureMergereventService getChinaventureMergereventService() {
		return chinaventureMergereventService;
	}

	public void setChinaventureMergereventService(
			ChinaventureMergereventService chinaventureMergereventService) {
		this.chinaventureMergereventService = chinaventureMergereventService;
	}

}
