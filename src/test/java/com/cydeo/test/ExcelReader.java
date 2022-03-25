package com.cydeo.test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx"; //creating string with a file path name

        //to read from excel we need to load it to FileInput Stream

        FileInputStream fileInputStream = new FileInputStream(path);
        //as FileInputStream is coming as exception we need to add 'throws' to signature

        //workbook>sheet>row>cell
        //1.Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        //as XSSFWorkbook is exception but higher than  FileInputStream then we throws
        //it in a method signature

        //2. We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");
        //getting exact sheet from created object 'workbook'

//3.We need to get specific raw and cell from currently opened sheet
        //print out Mary's cell //use index numbers, starting with 0

        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));
//locating the Mary's cell is to get a raw by index num and chain it with cloumn(cell) by index num

    //print out "Developer" cell
        System.out.println(sheet.getRow(3).getCell(2));

        //Return the count of used cells only
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();//allows you to count used rows in workbook
        System.out.println(usedRows);

        //return number from top cell to bottom
        //does not matter if cell is empty or not
        //Start counting from 0
        int lastUsedRow = sheet.getLastRowNum();//count all cells

        System.out.println(lastUsedRow);

        //TODO: create logic to print Vinod's name
//to find specific cell we may apply 'for loop' and depends on whether
// the data does't have empty you may use getPhysicalNumberOfRows if it has then getLastRowNum
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
//start iteration from 0 index for row (rownum) while this num is less than usedRows

//while row index number and known column(cell) index num '0' (and all converted to String)
// will be equal to required one
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
                //print this iterated raw from 0 column (cell)
            }
        }

        //TODO: 2 - CREATE A LOGIC TO PRINT OUT Mansoor Khan'S JOB_ID
        // CHECK IF NAME IS Mansoor --> PRINT OUT JOB_ID

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Mansoor")){
                System.out.println("Steven's JOB_ID is " + sheet.getRow(rowNum).getCell(2));
            }
        }
    }


}
