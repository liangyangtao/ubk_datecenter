package com.unbank.spider.bhiquery.action;

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
import com.unbank.spider.bhiquery.service.BhiService;
import com.unbank.spider.mybatis.vo.BhiInfo;
import com.unbank.spider.mybatis.vo.SearchCondition;
import com.unbank.spider.tools.MD5;
import com.unbank.spider.tools.SimpleTools;

public class BhiQueryAction extends ActionSupport implements
		ModelDriven<SearchCondition> {
	private static final long serialVersionUID = 1L;
	private SearchCondition searchCondition = new SearchCondition();
	private Integer rows;// 每页显示的记录数
	private Integer page;// 当前第几页
	private String fileName;
	private InputStream inputStream;
	private JSONObject result;
	private BhiService bhiService;

	public String readBhiInfos() {
		int intPage = page == 0 ? 1 : page;
		// 每页显示条数
		int number = rows == 0 ? 20 : rows;
		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;
		List<BhiInfo> courtInfos = bhiService.readBhiInfos(searchCondition,
				start, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// 定义map
		jsonMap.put("total", bhiService.countOfBhiInfos(searchCondition));// total键
		jsonMap.put("rows", courtInfos);// rows键 存放每页记录 list
		result = JSONObject.fromObject(jsonMap);
		return SUCCESS;

	}

	public String exportBhiInfoExcel() {
		List<BhiInfo> courtInfos = bhiService.readBhiInfos(searchCondition);
		String rows[] = new String[] { "项目名称", "地区", "发布时间", "行么性质", "企业性质",
				"行业", "投资总额", "进展阶段", "申报方式", "审批机关", "建设周期", "资金到位", "设备来源",
				"主管单位", "所在地", "主要设备", "建设内容", "单位名称", "姓名", "电话", "传真", "邮编",
				"详细地址", "项目简介" };
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

	public File writerExcel(List<BhiInfo> list, String[] rows) {
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
				BhiInfo bhiInfo = list.get(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(bhiInfo.getProName());
				cell = row.createCell(1);
				cell.setCellValue(bhiInfo.getProArea());
				cell = row.createCell(2);
				cell.setCellValue(bhiInfo.getProTime());
				cell = row.createCell(3);
				cell.setCellValue(bhiInfo.getProNature());
				cell = row.createCell(4);
				cell.setCellValue(bhiInfo.getFirmNature());
				cell = row.createCell(5);
				cell.setCellValue(bhiInfo.getProTrade());
				cell = row.createCell(6);
				cell.setCellValue(bhiInfo.getProAssets());
				cell = row.createCell(7);
				cell.setCellValue(bhiInfo.getProStage());
				cell = row.createCell(8);
				cell.setCellValue(bhiInfo.getProWay());
				cell = row.createCell(9);
				cell.setCellValue(bhiInfo.getProOffice());
				cell = row.createCell(10);
				cell.setCellValue(bhiInfo.getProCycle());
				cell = row.createCell(11);
				cell.setCellValue(bhiInfo.getProFund());
				cell = row.createCell(12);
				cell.setCellValue(bhiInfo.getEquipmentSource());
				cell = row.createCell(13);
				cell.setCellValue(bhiInfo.getGoverningUnit());
				cell = row.createCell(14);
				cell.setCellValue(bhiInfo.getAddress());
				cell = row.createCell(15);
				cell.setCellValue(bhiInfo.getProFacility());
				cell = row.createCell(16);
				cell.setCellValue(bhiInfo.getProContent());
				cell = row.createCell(17);
				cell.setCellValue(bhiInfo.getProDepartment());
				cell = row.createCell(18);
				cell.setCellValue(bhiInfo.getProPeople());
				cell = row.createCell(19);
				cell.setCellValue(bhiInfo.getProTel());
				cell = row.createCell(20);
				cell.setCellValue(bhiInfo.getFax());
				cell = row.createCell(21);
				cell.setCellValue(bhiInfo.getPostcode());
				cell = row.createCell(22);
				cell.setCellValue(bhiInfo.getDetailAddress());
				cell = row.createCell(23);
				cell.setCellValue(bhiInfo.getProIntro());

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

	public BhiService getBhiService() {
		return bhiService;
	}

	public void setBhiService(BhiService bhiService) {
		this.bhiService = bhiService;
	}

}
