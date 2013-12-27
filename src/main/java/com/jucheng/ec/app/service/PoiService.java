package com.jucheng.ec.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucheng.ec.app.dao.MenuDefDAO;
import com.jucheng.ec.app.model.Menu;

@Service(value = "poiService")
public class PoiService {

	@Autowired
	private transient MenuDefDAO menuDefDAO;

	/**
	 * 读取报表
	 * 
	 * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
	 */
	public void readReport(InputStream inp)
			throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {


		try {
			String cellStr = null;

			Workbook wb = WorkbookFactory.create(inp);

			Sheet sheet = wb.getSheetAt(0);// 取得第一个sheets

			// 从第四行开始读取数据
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Menu menu = new Menu();
				Menu addmenu = new Menu();

				Row row = sheet.getRow(i); // 获取行(row)对象
				System.out.println(row);
				if (row == null) {
					// row为空的话,不处理
					continue;
				}

				for (int j = 1; j < row.getLastCellNum(); j++) {

					Cell cell = row.getCell(j); // 获得单元格(cell)对象

					// 转换接收的单元格
					if(cell==null){
						continue;
					}
					cellStr = ConvertCellStr(cell, cellStr);

					// 将单元格的数据添加至一个对象
					addmenu = addingMenu(j, menu, cellStr);

				}
				// 将添加数据后的对象填充至list中
				addmenu.setStoreId(1);
				menuDefDAO.insert(addmenu);
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inp != null) {
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {

			}
		}
		// return computerList;

	}

	/**
	 * 获得单元格的数据添加至computer
	 * 
	 * @param j
	 *            列数
	 * @param computer
	 *            添加对象
	 * @param cellStr
	 *            单元格数据
	 * @return
	 */
	private Menu addingMenu(int j, Menu menu, String cellStr) {
		switch (j) {
		case 0:
			// computer.setId(0);
			break;
		case 1:
			menu.setTypeId(toTypeId(cellStr.trim()));
			break;
		case 2:
			//menu.setThirdName(cellStr);
			break;
		case 3:
			menu.setName(cellStr);
			break;
		case 4:
			//menu.setSecondName(cellStr);
			break;
		case 5:
			menu.setPrice((int)(Double.valueOf(cellStr)*100));
			break;
		case 6:
			menu.setPicUrl("http://121.199.22.111/1/"+cellStr);
			break;
		case 10:
			menu.setEatType(toEatTeype(cellStr));
			break;
		}
		return menu;
	}

	/**
	 * 把单元格内的类型转换至String类型
	 */
	private String ConvertCellStr(Cell cell, String cellStr) {
       
		switch (cell.getCellType()) {

		case Cell.CELL_TYPE_STRING:
			// 读取String
			cellStr = cell.getStringCellValue().toString();
			break;

		case Cell.CELL_TYPE_BOOLEAN:
			// 得到Boolean对象的方法
			cellStr = String.valueOf(cell.getBooleanCellValue());
			break;

		case Cell.CELL_TYPE_NUMERIC:

			// 先看是否是日期格式
			if (DateUtil.isCellDateFormatted(cell)) {

				// 读取日期格式
				cellStr = cell.getDateCellValue().toString();

			} else {

				// 读取数字
				cellStr = String.valueOf(cell.getNumericCellValue());
			}
			break;

		case Cell.CELL_TYPE_FORMULA:
			// 读取公式
			cellStr = cell.getCellFormula().toString();
			break;
		}
		return cellStr;
	}
	private int toEatTeype(String str){
		if("单点".equals(str)){
		return 1;	
		}else if("自助".equals(str)){
			return 0;
		}
		return 0;
	}
	private int toTypeId(String str) {
      if("烤炸物".equals(str)){
    	  return 1;
      }else if("煮物".equals(str)){
    	  return 2;
      }else if("烤肉".equals(str)){
    	  return 3;
      }else if("一品".equals(str)){
    	  return 4;
      }else if("刺身".equals(str)){
    	  return 5;
      }else if("寿司".equals(str)){
    	  return 6;
      }else if("定食".equals(str)){
    	  return 7;
      }else if("铁板".equals(str)){
    	  return 8;
      }else if("酒水".equals(str)){
    	  return 9;
      }else{
    	  return 0;
      }
	}
}
