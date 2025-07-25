import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import com.codeborne.pdftest.PDF;



public class FilesReadingTests {

    @Test
    void numberOfCatalogPagesCorrect() throws Exception {
        File pdfTestFile = new File("src/test/resources/NCS_palette.pdf");
        PDF pdf = new PDF(pdfTestFile);
        Assertions.assertEquals(33, pdf.numberOfPages);
    }
    }

