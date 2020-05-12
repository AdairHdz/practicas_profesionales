/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Adair Hernández
 */
public class Document {
    
    private XWPFDocument document;
    
    public Document(){
        this.document = new XWPFDocument();
    }
    
    public XWPFParagraph createParagraph(){
        return this.document.createParagraph();
    }
}
