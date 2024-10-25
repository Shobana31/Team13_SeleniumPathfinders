package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelReader(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(String header, int rowNum) {
        int colNum = getColumnIndex(header);
        if (colNum == -1 || rowNum < 0) {
            return null; // Return null if column index is not found or row number is invalid
        }
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        // Check cell type and return the appropriate value
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
            	// Check if the number is an integer
                if (cell.getCellStyle().getDataFormatString().contains("General") || 
                    (cell.getNumericCellValue() % 1 == 0)) {
                    return String.valueOf((int) cell.getNumericCellValue()); // Cast to int for integer values
                } else {
                    return String.valueOf(cell.getNumericCellValue()); // Keep decimal for non-integers
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                // Handle formulas if needed (for now just return empty string)
                return "";
            case BLANK:
                return ""; // Return empty string for blank cells
            default:
                return ""; // Return empty string for any unexpected cell types
        }
        }

    private int getColumnIndex(String header) {
        Row firstRow = sheet.getRow(0); // Assuming the first row contains headers
        for (int i = 0; i < firstRow.getPhysicalNumberOfCells(); i++) {
            if (firstRow.getCell(i).getStringCellValue().equalsIgnoreCase(header)) {
                return i;
            }
        }
        return -1; // Header not found
    }

    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
