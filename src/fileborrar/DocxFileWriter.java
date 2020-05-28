/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileborrar;

import java.io.File;

/**
 *
 * @author Adair Hernández
 */
public class DocxFileWriter implements FileWriter{

    
    
    public DocxFileWriter(File file){
        
    }
    
    @Override
    public void write() {
        System.out.println("Writing a docx file");
    }
    
    
}
