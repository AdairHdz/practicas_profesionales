/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Adair Hernández
 */
public class DocxFileReader {
    
    private String filePath;
    
    public DocxFileReader(String filePath){
        this.filePath = filePath;
    }
    
    public void read(){
        try{
          readDocument();
        }catch(FileNotFoundException e){
            showExceptionMessage(e);
        }catch(IOException e2){
            showExceptionMessage(e2);
        }  
    }
    
    public List<XWPFParagraph> getParagraphs() {
        try {
            List<XWPFParagraph> paragraphs = getDocumentParagraphs();
            return paragraphs;
        } catch (FileNotFoundException e) {
            showExceptionMessage(e);
        } catch (IOException e2) {
            showExceptionMessage(e2);
        }
        return null;
    }   
    
    private List<XWPFParagraph> getDocumentParagraphs() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(this.filePath);
        XWPFDocument docx = new XWPFDocument(fis);
        List<XWPFParagraph> paragraphList;
        paragraphList = docx.getParagraphs();
        return paragraphList;
    }
    
    private void readDocument() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(this.filePath);
        XWPFDocument docx = new XWPFDocument(fis);
        List<XWPFParagraph> paragraphList = docx.getParagraphs();
        for(XWPFParagraph paragraph : paragraphList){
              System.out.println(paragraph.getText());
        }
    }
    
    private void showExceptionMessage(Exception e){
        System.out.println(e.getMessage());
    }
    
    
}
