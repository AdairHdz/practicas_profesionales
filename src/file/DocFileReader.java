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
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Adair Hernández
 */
public class DocFileReader {
    
    private String filePath;
    
    public DocFileReader(String filePath){
        this.filePath = filePath;
    }
    
        public void read(String filePath){
        try{
          readDocument();
        }catch(FileNotFoundException e){
            
        }catch(IOException e2){
            
        }  
    }
        
        private void readDocument() throws FileNotFoundException, IOException{
            FileInputStream fis = new FileInputStream(this.filePath);
            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(doc);
            String[] fileData = extractor.getParagraphText();
            for(String paragraph : fileData){
              System.out.println(paragraph);
            }
        }
}
