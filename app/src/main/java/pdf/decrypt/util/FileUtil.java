package pdf.decrypt.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    private static int retries = 0;

    public static File retrieveFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists() && retries < 2) {
            String currentDirectory = System.getProperty("user.dir");
            retries += 1;
            file = retrieveFile(currentDirectory + "\\" + filename);
        } else if (retries == 2) {
            throw new IOException("File does not exists");
        }
        return file;
    }
}
