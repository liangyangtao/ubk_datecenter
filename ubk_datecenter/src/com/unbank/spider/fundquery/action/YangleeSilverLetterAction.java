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
import com.unbank.spider.fundquery.service.YangleeSilverLetterService;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.mybatis.vo.YangleeSilverLetter;
import com.unbank.spider.tools.MD5;
import com.unbank.spider.tools.SimpleTools;

public class YangleeSilverLetterAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	private static final long serialVersionUID = 1L;
	private SearchCondition searchCondition = new SearchCondition();
	private Integer rows;// 每页显示的记录数
	private Integer page;// 当前第几页
	private String fileName;
	private InputStream inputStream;
	private JSONObject result;
	private YangleeSilverLetterService yangleeSilverLetterService;

	public String readYangleeSilverLetterInfos() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;
		List<YangleeSilverLetter> courtInfos = yangleeSilverLetterService
				.readYangleeSilverLetterInfos(searchCondition, start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total", yangleeSilverLetterService
				.countOfYangleeSilverLetterInfos(searchCondition));// total键
		jsonMap.put("rows", courtInfos);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportYangleeSilverLetterExcel() {
		List<YangleeSilverLetter> courtInfos = yangleeSilverLetterService
				.readYangleeSilverLetterInfos(searchCondition);
		String rows[] = new String[] { "产品名称 ", "产品类型", "产品状态", "发行机构", "项目经理",
				"理财币种", "投资门槛", "发售对象", "发行地", "发行时间", "发行规模", "成立时间", "成立规模 ",
				"产品期限", "预计收益", "收益类型", "投资方式", "投资领域", "投资管理类型", "投资管理人",
				"资金托管行", "资金托管费率", "收益分配方式", "申购赎回费率", "到期清算日", "实际收益率",
				"交易结构", "信用增级措施", "产品特点 ", "其他相关信息", "原始链接" };
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

	public File writerExcel(List<YangleeSilverLetter> list, String[] rows) {
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
				YangleeSilverLetter yangleeSilverLetter = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(yangleeSilverLetter.getProName());
				cell = row.createCell(1);
				cell.setCellValue(yangleeSilverLetter.getProType());
				cell = row.createCell(2);
				cell.setCellValue(yangleeSilverLetter.getProState());
				cell = row.createCell(3);
				cell.setCellValue(yangleeSilverLetter.getPubHouse());
				cell = row.createCell(4);
				cell.setCellValue(yangleeSilverLetter.getProManage());
				cell = row.createCell(5);
				cell.setCellValue(yangleeSilverLetter.getFinancialCurrency());
				cell = row.createCell(6);
				cell.setCellValue(yangleeSilverLetter.getInvestmentThreshold());
				cell = row.createCell(7);
				cell.setCellValue(yangleeSilverLetter.getReleaseObject());
				cell = row.createCell(8);
				cell.setCellValue(yangleeSilverLetter.getIssuePlace());
				cell = row.createCell(9);
				cell.setCellValue(yangleeSilverLetter.getIssueDate());
				cell = row.createCell(10);
				cell.setCellValue(yangleeSilverLetter.getIssuingScale());
				cell = row.createCell(11);
				cell.setCellValue(yangleeSilverLetter.getEstablishedTime());
				cell = row.createCell(12);
				cell.setCellValue(yangleeSilverLetter.getSetupScale());
				cell = row.createCell(13);
				cell.setCellValue(yangleeSilverLetter.getLifetimeExtension());
				cell = row.createCell(14);
				cell.setCellValue(yangleeSilverLetter.getAnticipatedIncome());
				cell = row.createCell(15);
				cell.setCellValue(yangleeSilverLetter.getReturnsType());
				cell = row.createCell(16);
				cell.setCellValue(yangleeSilverLetter.getInvestmentWay());
				cell = row.createCell(17);
				cell.setCellValue(yangleeSilverLetter.getInvestmentField());
				cell = row.createCell(18);
				cell.setCellValue(yangleeSilverLetter.getInvestmentManageType());
				cell = row.createCell(19);
				cell.setCellValue(yangleeSilverLetter.getInvestmentManager());
				cell = row.createCell(20);
				cell.setCellValue(yangleeSilverLetter.getEscrowLine());
				cell = row.createCell(21);
				cell.setCellValue(yangleeSilverLetter.getEscrowFee());
				cell = row.createCell(22);
				cell.setCellValue(yangleeSilverLetter.getDistributionType());
				cell = row.createCell(23);
				cell.setCellValue(yangleeSilverLetter.getRedemptiveRate());
				cell = row.createCell(24);
				cell.setCellValue(yangleeSilverLetter.getMatureTime());
				cell = row.createCell(25);
				cell.setCellValue(yangleeSilverLetter.getEffectiveRate());
				cell = row.createCell(26);
				cell.setCellValue(yangleeSilverLetter.getDealStructure());
				cell = row.createCell(27);
				cell.setCellValue(yangleeSilverLetter.getCreditEnhancement());
				cell = row.createCell(28);
				cell.setCellValue(yangleeSilverLetter.getProductFeature());
				cell = row.createCell(29);
				cell.setCellValue(yangleeSilverLetter.getOtherInformation());
				cell = row.createCell(30);
				cell.setCellValue(yangleeSilverLetter.getDetailurl());
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

	public YangleeSilverLetterService getYangleeSilverLetterService() {
		return yangleeSilverLetterService;
	}

	public void setYangleeSilverLetterService(
			YangleeSilverLetterService yangleeSilverLetterService) {
		this.yangleeSilverLetterService = yangleeSilverLetterService;
	}

}
