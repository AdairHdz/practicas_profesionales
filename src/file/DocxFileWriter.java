/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

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
public class DocxFileWriter implements FileWriter{
    
    private String filePath;
    private FileOutputStream fileOutputStream;
    
    public DocxFileWriter(String filePath){
        this.filePath = filePath;
    }    
    
    public void writeParagraphs(List<XWPFParagraph> paragraphs){
        try {
            writeDocumentParagraphs(paragraphs);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }    
    
    private void writeDocumentParagraphs(List<XWPFParagraph> paragraphs) throws FileNotFoundException, IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph myParagraph = document.createParagraph();
        XWPFRun run = myParagraph.createRun();
        this.fileOutputStream = new FileOutputStream(this.filePath);
        for (XWPFParagraph paragraph : paragraphs) {
            run.setText(paragraph.getText());
        }
        document.write(this.fileOutputStream);
    }            
    
}
