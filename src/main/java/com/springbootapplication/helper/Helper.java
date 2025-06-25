package com.springbootapplication.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.springbootapplication.entity.Student;

public class Helper {

	//check that file is of excel type or not
	public static boolean checkexcelformat(MultipartFile file) {
		
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
	}
		//convert excel to list of student 
		public static List<Student> convertExcelToListOfStudent(InputStream is){
			
			List<Student> list = new ArrayList<>();
			
		     try{
		    	 
		    	  XSSFWorkbook workbook = new XSSFWorkbook(is);
		    	 XSSFSheet sheet = workbook.getSheet("Sheet1");
		    	 
		    	 int rowno=0;
		    	 Iterator<Row> iterator = sheet.iterator();
		    	 
		    	 while(iterator.hasNext()) {
		    		 Row row = iterator.next();
		    		 
		    		 if(rowno == 0) {
		    			 rowno++;
		    			 continue;
		    		 }
		    		 Iterator<Cell> cells = row.iterator();
		    		 int cid=0;
		    		 
		    		 Student s = new Student();
		    		 
		    		 while(cells.hasNext()) {
		    			 
		    			 Cell cell = cells.next();
		    			 
		    		
		    			 switch(cid)
		    			 {
		    			      case 0:
		    			    	 s.setNo((int)cell.getNumericCellValue());
		    			    	 break;
		    			      case 1:
		    			    	  s.setName(cell.getStringCellValue());
		    			    	  break;
		    			      case 2:
			    			    s.setPhone((int)cell.getNumericCellValue());
			    			    break;
			    			  case 3:
			    			     s.setAddress(cell.getStringCellValue());
			    			     break;
			    			  default:
			    				  break;
		    			      
		    			 }
		    			  cid++;
		    			 
		    		 }
		    		 list.add(s);
		    	 }
		  }catch(Exception e) {
		    	 e.printStackTrace();
		    	 }
		    return list;
	 }
 }


