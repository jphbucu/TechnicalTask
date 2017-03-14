package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public List<String[]> getExcelData(String fileLoc) throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		InputStream inp = new FileInputStream(fileLoc);
	    XSSFWorkbook wb = new XSSFWorkbook(inp);
	    XSSFSheet sheet = wb.getSheet("Sheet1");
	    XSSFRow row; 
	    int rowNum = this.getRowCount(fileLoc);
	    XSSFCell cell;
	    String action = null;
	    String parameter = null;
	    String input = null;
	    
	    for (int i = 1; i < rowNum; i++) {
	    	row = sheet.getRow(i);
	    	
	    	cell = row.getCell(0);
	    	if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
	    		action = "";
		    }
		    else action = cell.toString();
	    	
	    	cell = row.getCell(1);
	    	if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
	    		parameter = "";
		    }
		    else parameter = cell.toString();
	    	
	    	cell = row.getCell(2);
	    	if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
	    		input = "";
		    }
		    else input = cell.toString();
	    	
			String data[] = {action, parameter, input};
			list.add(data);
		}
	    
	    wb.close();
	    return list;
	}
	
	public int getRowCount(String fileLoc) throws IOException{
		InputStream inp = new FileInputStream(fileLoc);
	    XSSFWorkbook wb = new XSSFWorkbook(inp);
	    XSSFSheet sheet = wb.getSheet("Sheet1");
	    XSSFRow row;
	    XSSFCell cell;
	    int rowCount = 0;
	    
	    for(int i = 0;i < sheet.getPhysicalNumberOfRows();i++){
	    	row = sheet.getRow(i);
	    	cell = row.getCell(0);
	    	if (!(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK)) {
		    	rowCount++;
		    }
	    }
	    wb.close();
	    return rowCount;
	}
	
}
