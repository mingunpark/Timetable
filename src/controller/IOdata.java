package controller;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.Subject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOdata {
	
	
	List<Subject> list;
	FileInputStream inputExcel;
	XSSFWorkbook workbook;
	
	@SuppressWarnings({ "resource", "deprecation" })
	public List<Subject> bringData(String filepath){
		
		list=new ArrayList<Subject>();
		
		try{
			
			inputExcel=new FileInputStream(new File(filepath));
			
			workbook =new XSSFWorkbook(inputExcel);
			
			XSSFSheet exSheet;
			XSSFRow exRow;
			XSSFCell exCell;
			Subject sub;
			
			for(int i=0;i<workbook.getNumberOfSheets();i++){
				exSheet = workbook.getSheetAt(i);
				
				for(int row=0;row<exSheet.getPhysicalNumberOfRows();row++){

					exRow = exSheet.getRow(row);
					sub = new Subject();
					String value;
					
					if(exRow!=null){
						for(int cell=0;cell<exRow.getPhysicalNumberOfCells();cell++){
							
							exCell = exRow.getCell(cell);
							
							if(true){
								value="";
								
								switch(exCell.getCellType()){
								case XSSFCell.CELL_TYPE_FORMULA:
									value = exCell.getCellFormula();
									break;
								case XSSFCell.CELL_TYPE_NUMERIC:
									value =""+ exCell.getNumericCellValue();
									break;
								case XSSFCell.CELL_TYPE_STRING:
									value =""+exCell.getStringCellValue();
									break;
								case XSSFCell.CELL_TYPE_BLANK:
									value =" ";
									break;
								case XSSFCell.CELL_TYPE_ERROR:
									value=exCell.getErrorCellValue()+"";
									break;
								default:
									value = new String();
									break;
								}//swith(exCell)
								//값 가져오기
								
								
								switch(cell){
								case 0:
									sub.setIndex(value);
									break;
								case 1:
									sub.setMajor(value);
									break;
								case 2:
									sub.setSubNum(value);
									break;
								case 3:
									sub.setDivClass(value);
									break;
								case 4:
									sub.setTitle(value);
									break;
								case 5:
									sub.setType(value);
									break;
								case 6:
									sub.setScore(value);
									break;
								case 7:
									sub.setGrade(value);
									break;
								case 8:
									sub.setManageDept(value);
									break;
								case 9:
									sub.setProfessor(value);
									break;
								case 10:
									sub.setClassTime(value);
									break;
								case 11:
									sub.setClassRoom(value);
									break;
								case 12:
									sub.setLanguage(value);
									break;
								default:
									break;
								}//switch(cell)
								//가져온값 리스트에 넣기
								
							}//if
							
						}//for(cell)
						
						
					}//if(exRow!=null)
					
					if(sub.getMajor().compareTo("컴퓨터공학과")==0 || sub.getMajor().compareTo("디지털콘텐츠학과")==0  )
						list.add(sub);
					
				}
				
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(workbook!=null) workbook.close();
				if(inputExcel!=null) inputExcel.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	
	public void storeData(List<Subject> myTimetable){
		
		workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		
		cell = row.createCell(0);
		cell.setCellValue("NO");

		cell = row.createCell(1);
		cell.setCellValue("개설학과전공");
		
		cell = row.createCell(2);
		cell.setCellValue("학수번호");
		
		cell = row.createCell(3);
		cell.setCellValue("분반");
		
		cell = row.createCell(4);
		cell.setCellValue("교과목명");
		
		cell = row.createCell(5);
		cell.setCellValue("이수구분");

		cell = row.createCell(6);
		cell.setCellValue("학점/이론/실습");
		
		cell = row.createCell(7);
		cell.setCellValue("학년");
		
		cell = row.createCell(8);
		cell.setCellValue("주관학과");
		
		cell = row.createCell(9);
		cell.setCellValue("교수명");
		
		cell = row.createCell(10);
		cell.setCellValue("요일 및 강의시간");
		
		cell = row.createCell(11);
		cell.setCellValue("강의실");
		
		cell = row.createCell(12);
		cell.setCellValue("강의언어");
		
		
		Subject sub;
		for(int i=0;i<myTimetable.size();i++){
			
			sub=myTimetable.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell(0);
			cell.setCellValue(sub.getIndex());
			
			cell = row.createCell(1);
			cell.setCellValue(sub.getMajor());

			cell = row.createCell(2);
			cell.setCellValue(sub.getSubNum());

			cell = row.createCell(3);
			cell.setCellValue(sub.getDivClass());

			cell = row.createCell(4);
			cell.setCellValue(sub.getTitle());

			cell = row.createCell(5);
			cell.setCellValue(sub.getType());

			cell = row.createCell(6);
			cell.setCellValue(sub.getScore());

			cell = row.createCell(7);
			cell.setCellValue(sub.getGrade());

			cell = row.createCell(8);
			cell.setCellValue(sub.getManageDept());

			cell = row.createCell(9);
			cell.setCellValue(sub.getProfessor());

			cell = row.createCell(10);
			cell.setCellValue(sub.getClassTime());

			cell = row.createCell(11);
			cell.setCellValue(sub.getClassRoom());

			cell = row.createCell(12);
			cell.setCellValue(sub.getLanguage());	
			
		}
		
		FileOutputStream outputExcel = null;
		
		try{
			
			outputExcel = new FileOutputStream("src/myTimetable.xlsx");
			workbook.write(outputExcel);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(workbook!=null) workbook.close();
				if(outputExcel!=null) outputExcel.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
