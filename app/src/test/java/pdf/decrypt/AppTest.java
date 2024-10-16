/*
 * This source file was generated by the Gradle 'init' task
 */
package pdf.decrypt;

import org.junit.jupiter.api.Test;

import pdf.decrypt.util.FileUtil;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testFileUtil_returnsFile() {
        try {
            assertNotNull(FileUtil.retrieveFile("src\\test\\resources\\test.pdf"), "File does not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
