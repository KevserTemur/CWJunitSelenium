package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePoiTask {

    /*
Add the Excel file on the resources' folder.
Open the file.
Open the workbook using file input stream.

Open the first worksheet.
Go to first row.

Go to first cell on that first row and print.

Go to second cell on that first row and print.

Go to 2nd row first cell and assert if the data equal to Russia.

Go to 3rd row 2nd cell-chain the row and cell.

Find the number of used row.

Print country, area key value pairs as map object.

     */

    @Test
    public void apacheTask() throws IOException {

        String path = "src\\test\\java\\resources\\excelfile.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workbook.getSheetAt(0);
        Row row1 = sheet1.getRow(0);

        Cell row1cell1 = row1.getCell(0);
        System.out.println(row1cell1);

        Cell row1cell2 = row1.getCell(1);
        System.out.println(row1cell2);

        Row row2 = sheet1.getRow(1);
        Cell row2cell1 = row2.getCell(0);
        Assert.assertEquals("Rusya", row2cell1.toString());

        Cell row3cell2 = sheet1.getRow(2).getCell(1);
        System.out.println(row3cell2);

        System.out.println(sheet1.getPhysicalNumberOfRows());
        System.out.println(sheet1.getLastRowNum()+1);

        int totalRow = sheet1.getPhysicalNumberOfRows();
        Map<String, String> countryAreas = new HashMap<>();
        for (int row = 1; row<totalRow; row++){
            String country = sheet1.getRow(row).getCell(0).toString();
            System.out.println((row+1) + ". satır = " + country); // her satırdaki ülke yazılıyor

            String area = sheet1.getRow(row).getCell(1).toString();
            System.out.println("Country = " + country+ "- Area = "+ area);

            countryAreas.put(country,area); // map in içine attık
            System.out.println(countryAreas);


        }
    }
}
