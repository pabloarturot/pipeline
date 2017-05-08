package com.bdb.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcelRead {

	private static final String FILE_NAME = "/tmp/myExcelEjemplo.xlsx";

	public static void main(String[] args) {

		try {

			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {
					
					System.out.print("Procesing the file...");
					

					Cell currentCell = cellIterator.next();
			
					if (currentCell.getCellType()== Cell.CELL_TYPE_STRING) {
						System.out.print(currentCell.getStringCellValue() + "|");
					} else if (currentCell.getCellType()== Cell.CELL_TYPE_NUMERIC) {
						System.out.print(currentCell.getNumericCellValue() + "|");
					}

				}
				System.out.println();
				System.out.print("file Procesed :)");

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}