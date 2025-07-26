import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.codeborne.pdftest.PDF;



public class FilesReadingTests {

/*    @Test
    void numberOfCatalogPagesCorrect() throws Exception {
        File pdfTestFile = new File("src/test/resources/NCS_palette.pdf");
        PDF pdf = new PDF(pdfTestFile);
        Assertions.assertEquals(33, pdf.numberOfPages);
    }*/

    @Test
    void numberOfCatalogPagesCorrectTest() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/NCS_palette.pdf");
        if (inputStream == null) {
            throw new FileNotFoundException("Файл не найден: NCS_palette.pdf");
        }
        PDF pdf = new PDF(inputStream);
        Assertions.assertEquals(33, pdf.numberOfPages);
    }

    @Test
    void exelTest() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/test_table.xlsx");
        if (inputStream == null) {
            throw new FileNotFoundException("Файл не найден: test_table.xlsx");
        }
        XLS xls = new XLS(inputStream);

        int actualValue = (int) xls.excel.getSheetAt(0).getRow(5).getCell(3).getNumericCellValue();
        Assertions.assertEquals(2350, actualValue);
    }
    @Test
    void csvTest() throws Exception {
        try (InputStream is = getClass().getResourceAsStream("user_migration.csv");
        CSVReader csvReader = new CSVReader(new InputStreamReader(is)){
            List<String[]> data = csvReader.readAll();
            Assertions.assertEquals(10, data.size()); // Проверяем количество строк в файле
        }
    }
    }

