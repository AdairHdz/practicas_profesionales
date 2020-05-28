/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileborrar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Adair Hernández
 */
public class DocxWriterFacade {

    XWPFDocument document;
    XWPFParagraph paragraph;
    XWPFRun run;
    File file;
    

    public DocxWriterFacade(File file) {
        this.document = new XWPFDocument();
        this.paragraph = this.document.createParagraph();
        this.run = this.paragraph.createRun();
        this.file = file;
    }

    public void writeParagraphs(List<XWPFParagraph> paragraphs) {
        try {
            writeDocumentParagraphs(paragraphs);
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    private void writeDocumentParagraphs(List<XWPFParagraph> paragraphs) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.file.getPath());
        for (XWPFParagraph paragraph : paragraphs) {
            run.setText(paragraph.getText());
        }
        document.write(fileOutputStream);
    }

    public void write() {

    }

}
