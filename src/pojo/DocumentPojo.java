/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Adair Hernández
 */
public class DocumentPojo {
    
    private String name;
    private String path;
    private double size;
    private Date uploadDate;
    
    private File file;
    
    public DocumentPojo(){
        
    }
    
    public DocumentPojo(File file){
        this.file = file;
        this.name = this.file.getName();
        this.path = this.file.getPath();
        this.size = this.file.length();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    
    
}
