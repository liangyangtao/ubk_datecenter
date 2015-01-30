package com.unbank.spider.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.unbank.spider.mybatis.vo.Jdbill;

public class ExcelTools {

	public static void main(String[] args) {
		List<Jdbill> jingdongbill = new ArrayList<Jdbill>();
		String rows[] = new String[] { "产品名称 ", "产品期数", "承兑银行", "发布日期", "发布时间",
				"预期年化收益率", "募集金额", "理财期限" };
		Jdbill jdbill = new Jdbill();
		jdbill.setBillBank("1");
		jingdongbill.add(jdbill);
		writerExcel(jingdongbill, rows, "");
	}

	public static void writerExcel(List<Jdbill> list, String[] rows,
			String excelpath) {
		XSSFWorkbook xwb = new XSSFWorkbook();
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.createSheet();
		// 定义 row、cell
		XSSFRow row;
		// 第一行
		row = sheet.createRow(0);
		for (int i = 0; i < rows.length; i++) {
			Cell cell = row.createCell(i + 1);
			cell.setCellValue(rows[i]);
		}

		for (int i = 0; i < list.size(); i++) {
			row = sheet.getRow(i);
			Jdbill jdbill = list.get(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(jdbill.getProName());
			cell = row.createCell(1);
			cell.setCellValue(jdbill.getProNum());
			cell = row.createCell(2);
			cell.setCellValue(jdbill.getBillBank());
			cell = row.createCell(3);
			cell.setCellValue(jdbill.getPublishDate());
			cell = row.createCell(4);
			cell.setCellValue(jdbill.getPublishTime());
			cell = row.createCell(5);
			cell.setCellValue(jdbill.getBillRate());
			cell = row.createCell(6);
			cell.setCellValue(jdbill.getBillMoney());
			cell = row.createCell(7);
			cell.setCellValue(jdbill.getBillDay());
		}

		// Write the output to a file
		try {
			FileOutputStream fileOut = new FileOutputStream("D://asdfsdf.xlsx");
			xwb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
