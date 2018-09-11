package com;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;


public class ExportUtil {
	/**
	 * @param headers
	 *            表头
	 * @param keys
	 *            用来在 rows里获取每一个单元格数据
	 * @param rows
	 * @param title
	 * @param isOrderNumber
	 */
	public static String exportExcel(String[] headers, String[] keys,
			List<Map<String, Object>> rows, String title, boolean isOrderNumber) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(title);// 创建table工作薄

		title = title + new Date().getTime();

		HSSFRow row;
		HSSFCell cell;
		// 第一列是序号
		if (isOrderNumber) {
			// 创建表头行
			row = sheet.createRow(0);
			cell = row.createCell(0);
			// 设置样式
			HSSFCellStyle style = wb.createCellStyle();
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
			// 颜色
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			HSSFFont f = wb.createFont();
			f.setFontHeightInPoints((short) 11);// 字号
			f.setBold(true);
			style.setFont(f);
			cell.setCellStyle(style);
			cell.setCellValue("序号");
			for (int i = 0; i < headers.length; i++) {
				cell = row.createCell(i + 1);// 根据表格行创建单元格
				// 设置样式
				f.setFontHeightInPoints((short) 11);// 字号
				f.setBold(true);
				style.setFont(f);
				cell.setCellStyle(style);

				cell.setCellValue(headers[i]);
			}
			// 填充表格内容
			int j = 1;
			for (Map<String, Object> map : rows) {
				row = sheet.createRow(j);// 创建表格行
				cell = row.createCell(0);
				// 设置样式
				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
				style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
				style1.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
				style1.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
				style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
				HSSFFont f1 = wb.createFont();
				f1.setFontHeightInPoints((short) 11);// 字号
				f1.setBold(true);
				style.setFont(f1);
				cell.setCellStyle(style1);

				cell.setCellValue(String.valueOf(j));

				for (int k = 0; k < keys.length; k++) {
					cell = row.createCell(k + 1);// 根据表格行创建单元格
					// 设置样式
					cell.setCellStyle(style1);
//					cell.setCellValue(String.valueOf(MapUtils.getObject(map,
//							keys[k], null)));
				}
				j++;
			}
			// 设置列宽
			for (int i = 0; i < headers.length + 1; i++) {
				if (0 == i) {
					sheet.setColumnWidth(i, 1000); // 设置列宽
				} else {
					sheet.setColumnWidth(i, 6000); // 设置列宽
				}

			}

			// 第一列没有序号
		} else {
			// 创建表头行
			row = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				cell = row.createCell(i);// 根据表格行创建单元格
				// 设置样式
				HSSFCellStyle style = wb.createCellStyle();
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
				// 颜色
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
				HSSFFont f = wb.createFont();
				f.setFontHeightInPoints((short) 11);// 字号
				f.setBold(true);
				style.setFont(f);
				cell.setCellStyle(style);

				cell.setCellValue(headers[i]);
			}
			// 填充表格内容
			int j = 1;
			for (Map<String, Object> map : rows) {
				row = sheet.createRow(j);// 创建表格行
				for (int k = 0; k < keys.length;k++ ) {
					cell = row.createCell(k);// 根据表格行创建单元格
					// 设置样式
					HSSFCellStyle style = wb.createCellStyle();
					style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
					style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
					style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
					style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
					style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
					HSSFFont f = wb.createFont();
					f.setFontHeightInPoints((short) 11);// 字号
					f.setBold(false);
					cell.setCellStyle(style);
					
					
					//***************************************
//					String cellval = String.valueOf(MapUtils.getObject(map,keys[k]));
//					int mergeSize = (int) Math.ceil(cellval.length() / 16383);
//					if(mergeSize > 1){
						// sheet.addMergedRegion(new CellRangeAddress(j,j,k,k+=1));//合并单元格						
//						sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));//合并单元格						
//					} //****************************************
					
					
//					cell.setCellValue(String.valueOf(MapUtils.getObject(map,
//							keys[k], null)));
				}
				
//				sheet.addMergedRegion(new CellRangeAddress(j,j+=1,1,1));//合并单元格
				
				j++;
			}
			// 设置列宽
			for (int i = 0; i < headers.length + 1; i++) {
				sheet.setColumnWidth(i, 6000); // 设置列宽
			}
		}
		try {
//			String url = Configuration.getReourcesV("upload") + "/export/"
//					+ title + ".xls";
			String url = null;
			FileOutputStream fileOutputStreamnew = new FileOutputStream(url);
			wb.write(fileOutputStreamnew);
			 wb.write(new FileOutputStream("D:/" + title + ".xls"));
			fileOutputStreamnew.close();
			String[] path = url.split("/");
			return path[4] + "/" + path[5] + "/" + path[6] + "/" + title
					+ ".xls";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param headers
	 *            表头
	 * @param keys
	 *            用来在 rows里获取每一个单元格数据
	 * @param rows
	 * @param title
	 * @param isWrap
	 *            是否换行
	 */
	public static HSSFWorkbook createExcel(HSSFWorkbook wb,String[] headers,String[] keys,List<Map<String,Object>> rows,String title,boolean isOrderNumber,int... isWrap){
		HSSFSheet sheet = wb.createSheet(title);//创建table工作薄
		
		title = title + new Date().getTime();
		
		
		HSSFRow row;
		HSSFCell cell;
		//第一列是序号
		if(isOrderNumber){
			//创建表头行
			row = sheet.createRow(0);
			cell = row.createCell(0);
			//设置样式
			HSSFCellStyle style = wb.createCellStyle(); 
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框    
			style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//靠左
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		    //颜色
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    
			style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index); 
			HSSFFont f  = wb.createFont();      
			f.setFontName("微软雅黑"); 
			f.setFontHeightInPoints((short) 11);//字号       
			f.setBold(true);
			style.setFont(f);  
			cell.setCellStyle(style);
	        
			cell.setCellValue("序号");
			for (int i = 0;i < headers.length;i++) {
				cell = row.createCell(i + 1);//根据表格行创建单元格
				//设置样式  
				f.setFontHeightInPoints((short) 12);//字号       
				f.setBold(true);
				style.setFont(f);  
				cell.setCellStyle(style);
				
				cell.setCellValue(headers[i]);
				//
				sheet.autoSizeColumn(i);
		        sheet.setColumnWidth(i,sheet.getColumnWidth(i)*17/10);
			}
			//填充表格内容
			int j = 1;
			for (Map<String,Object> map : rows) {
				row = sheet.createRow(j);//创建表格行
				cell = row.createCell(0);
				//设置样式
				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
				style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
				style1.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
				style1.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框    
				style1.setAlignment(HSSFCellStyle.ALIGN_LEFT);//靠左
				HSSFFont f1  = wb.createFont(); 
				f1.setFontName("微软雅黑");
				f1.setFontHeightInPoints((short) 11);//字号       
				f1.setBold(true);
				style.setFont(f1);  
				cell.setCellStyle(style1);
				
				cell.setCellValue(String.valueOf(j));
				
				
				for (int k = 0;k < keys.length;k++) {
					cell = row.createCell(k + 1);//根据表格行创建单元格
					if(isWrap!=null && isWrap.length>0 && isWrap[0] == (k+1)){
						style1.setWrapText(true);//先设置为自动换行
					}
					cell.setCellStyle(style1);
					if(isWrap!=null && isWrap.length>0 && isWrap[0] == (k+1)){
						//设置样式 
						//* cell.setCellValue(new HSSFRichTextString(String.valueOf(MapUtils.getObject(map, keys[k],null))));
					}else{
						//设置样式 
						//* String cellval = String.valueOf(MapUtils.getObject(map, keys[k],null));
						//* cell.setCellValue(countCharactersSize(cellval));
					}
					
				}
				j++;
			}
			//设置列宽
			for(int i = 0;i < headers.length + 1;i++){
				if(0 == i ){
					sheet.setColumnWidth(i, 1000); //设置列宽
				}else{
					sheet.setColumnWidth(i, 6000); //设置列宽
				}
			
			}
			
		//第一列没有序号
		}else{
			//创建表头行
			row = sheet.createRow(0);
			for (int i = 0;i < headers.length;i++) {
				cell = row.createCell(i);//根据表格行创建单元格
				row.setHeightInPoints(20);
				//设置样式
				HSSFCellStyle style = wb.createCellStyle(); 
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框    
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//靠左
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直
				//颜色
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    
				style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);   
				HSSFFont f  = wb.createFont();      
				f.setFontName("黑体");
				f.setFontHeightInPoints((short) 11);//字号       
				f.setBold(true);
				style.setFont(f);  
				cell.setCellStyle(style);
				
				cell.setCellValue("  " +headers[i]);
				
			}
			//填充表格内容
			int j = 1;
			for (Map<String,Object> map : rows) {
				row = sheet.createRow(j);//创建表格行
//				row.setHeightInPoints(20);
				if(title.contains("个人指标监控")){
					sheet.addMergedRegion(new CellRangeAddress(j,j+=1,8,8));  //**************************					
				}else if(title.contains("个人负责技术问题清单")){
					sheet.addMergedRegion(new CellRangeAddress(j,j+=10,3,3));  //**************************					
				}else if(title.contains("近期机组重要问题")){
					sheet.addMergedRegion(new CellRangeAddress(j,j+=10,3,3));  //**************************
				}
				for (int k = 0;k < keys.length;k++) {
					cell = row.createCell(k);//根据表格行创建单元格
					//设置样式
					HSSFCellStyle style = wb.createCellStyle();
					if(isWrap!=null && isWrap.length>0 && isWrap[0] == (k+1)){
						style.setWrapText(true);//先设置为自动换行
					}
					style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
					style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
					style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
					style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框    
					style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//靠左
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直
					HSSFFont f  = wb.createFont(); 
					f.setFontName("黑体");
					f.setFontHeightInPoints((short) 11);//字号       
					f.setBold(false);
					style.setFont(f); 
					cell.setCellStyle(style);
					if(isWrap!=null && isWrap.length>0 && isWrap[0] == (k+1)){
						//*cell.setCellValue(new HSSFRichTextString(String.valueOf(MapUtils.getObject(map, keys[k],null))));
					}else{						
						//*String cellval = String.valueOf(MapUtils.getObject(map, keys[k],null));
			        	//*cell.setCellValue(countCharactersSize(cellval));
					}
					
					
				}
				// j = j + rownum;
				j++;
			}
			//设置列宽
			for(int i = 0;i < headers.length + 1;i++){
				//
				if(isWrap!=null && isWrap.length>0 ){
					for(int l =0 ;l<isWrap.length;l++){
						if((isWrap[l]-1) == i){
							sheet.setColumnWidth(i, 14000);
							break;
						}else{
							sheet.autoSizeColumn(i);
							 sheet.setColumnWidth(i,5000);
//					        sheet.setColumnWidth(i,sheet.getColumnWidth(i)*12/10);
						}
					}
					 
				}else{
					sheet.autoSizeColumn(i);
//					 sheet.setColumnWidth(i,5000);
			        sheet.setColumnWidth(i,sheet.getColumnWidth(i)*12/10);
				}
				
//				sheet.setColumnWidth(i, 6000); //设置列宽
			}
		}
		return wb;
	}

	public static String exportExcelBySheet(HSSFWorkbook wb, String title) {
		try {
			title = title + new Date().getTime();
//			String url = Configuration.getReourcesV("upload") + "/export/"
//					+ title + ".xls";
			String url = null;
			FileOutputStream fileOutputStreamnew = new FileOutputStream(url);
			wb.write(fileOutputStreamnew);
			// wb.write(new FileOutputStream("D:/" + title + ".xls"));
			fileOutputStreamnew.close();
			String[] path = url.split("/");
			return path[3] + "/" + path[4] + "/" + path[5] + "/" + title
					+ ".xls";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String[] a = { "表头1", "表头2", "表头3" };
		String[] b = { "1", "2", "3" };
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("1", "内容11");
		map1.put("2", "内容12");
		map1.put("3", "内容13");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("1", "内容21");
		map2.put("2", "内容22");
		map2.put("3", "内容23");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("1", "内容31");
		map3.put("2", "内容32");
		map3.put("3", "内容33");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("1", "内容41");
		map4.put("2", "内容42");
		map4.put("3", "内容43");
		rows.add(map1);
		rows.add(map2);
		rows.add(map3);
		rows.add(map4);
		exportExcel(a, b, rows, "测试", false);
	}

	
	public static String countCharactersSize(String cellval){
//		if(cellval.length() > 16383){
//			cellval = cellval.substring(0, 16382);
//		}
		return cellval;
	}
}
