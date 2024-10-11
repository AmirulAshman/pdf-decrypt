package pdf.decrypt;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import pdf.decrypt.util.FileUtil;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: [File] [Password]");
        } else {
            try {
                File file = FileUtil.retrieveFile(args[0]);
                String password = args[1];
                PDDocument document = Loader.loadPDF(file, password);
                document.setAllSecurityToBeRemoved(true);
                String newFileName = file.getCanonicalPath();
                newFileName = newFileName.replace(".pdf", "-decrypted.pdf");
                document.save(newFileName);
                document.close();
            } catch (IOException e) {
                if (e instanceof InvalidPasswordException) {
                    System.out.println("Invalid password");
                } else {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
