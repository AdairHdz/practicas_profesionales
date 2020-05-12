/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Adair Hernández
 */
public class ParagraphWriter {
    private Document document;
    private XWPFParagraph paragraph;
    private XWPFRun run;
    
    public ParagraphWriter(){
        this.document = new Document();
        this.paragraph = this.document.createParagraph();
        this.run = this.paragraph.createRun();
    }
    
    public void write(){
        
    }
}
