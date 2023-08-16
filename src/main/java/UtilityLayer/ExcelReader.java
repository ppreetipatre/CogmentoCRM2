package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook workbook;

	public ExcelReader(String filePath) throws IOException

	{
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		// XSSFSheet Sheet = workbook.getSheetAt(0);
	}

	public int getTotalRowCount(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum() + 1;

	}

	public int getTotalColoumnsCount(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}

	public Object getSpecficSheetData(int sheetIndex, int rows, int cells) {
		XSSFCell cell = workbook.getSheetAt(sheetIndex).getRow(rows).getCell(cells);
		if (cell == null) {
			return "";
		}

		if (cell != null) {

			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();

			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getRawValue();

			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();

			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cell.getCellFormula();
			}
		}
		return null;
	}

	public Object[][] getAllSheetData(int sheetindex) {
		int rows = getTotalRowCount(sheetindex);
		int cells = getTotalColoumnsCount(sheetindex);

		Object[][] data = new Object[rows][cells];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				data[i][j] = getSpecficSheetData(sheetindex, i, j);
			}
		}

		return data;
	}
}
