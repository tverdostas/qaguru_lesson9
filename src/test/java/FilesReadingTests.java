import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import com.codeborne.pdftest.PDF;
import pojo.Recipe;

import static org.hamcrest.MatcherAssert.assertThat;

public class FilesReadingTests {
    File zipFile = new File("src/test/resources/files_for_tests.zip");
    ZipFile zip;

    public FilesReadingTests() throws IOException {
        zip = new ZipFile(zipFile);
    }

    @Test
    void numberOfCatalogPagesCorrectTest() throws Exception {
        InputStream inputStream = zip.getInputStream(zip.getEntry("NCS_palette.pdf"));
        if (inputStream == null) {
            throw new FileNotFoundException("Файл не найден: NCS_palette.pdf");
        }
        PDF pdf = new PDF(inputStream);
        Assertions.assertEquals(33, pdf.numberOfPages);
    }

    @Test
    void correctCheckAmountTest() throws Exception {
        InputStream inputStream = zip.getInputStream(zip.getEntry("test_table.xlsx"));
        if (inputStream == null) {
            throw new FileNotFoundException("Файл не найден: test_table.xlsx");
        }
        XLS xls = new XLS(inputStream);

        int actualValue = (int) xls.excel.getSheetAt(0).getRow(5).getCell(3).getNumericCellValue();
        Assertions.assertEquals(2350, actualValue);
    }

    @Test
    void userListSizeCorrectTest() throws Exception {
        InputStream inputStream = zip.getInputStream(zip.getEntry("user_migration.csv"));
        if (inputStream == null) {
            throw new FileNotFoundException("Файл не найден: user_migration.csv");
        }
        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));

            List<String[]> data = csvReader.readAll();
            Assertions.assertEquals(4, data.size());
    }
    }

