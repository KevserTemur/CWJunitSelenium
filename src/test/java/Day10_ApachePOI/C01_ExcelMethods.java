package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {

    public static void main(String[] args) throws IOException {

        String path = "src\\test\\java\\resources\\excelfile.xlsx"; // dosyanın path ini aldık

        FileInputStream fileInputStream = new FileInputStream(path); // dosyayı açtık

        Workbook workbook = WorkbookFactory.create(fileInputStream); //excel workbook a çevirdik

        Sheet sheet1 = workbook.getSheetAt(0); // workbook dan sheet e geçiş
        Row row1 = sheet1.getRow(0);

        Cell cell1 = row1.getCell(0);
        System.out.println(cell1.toString().toLowerCase());

    }
}
