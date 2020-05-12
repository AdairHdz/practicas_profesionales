/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exceptions.NoFileChosenException;
import file.DocxFileReader;
import file.DocxFileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import javafx.stage.FileChooser;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Adair Hernández
 */
public class FileChooserWindow {

    private FileChooser fileChooser;

    public FileChooserWindow() {
        this.fileChooser = new FileChooser();
        this.fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word document (docx)", "*.docx"));
        this.fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word document (doc)", "*.doc"));
    }

    public File selectFile() throws NoFileChosenException, IOException {

        File selectedFile = this.fileChooser.showOpenDialog(null);
        DocxFileReader dfr = new DocxFileReader(selectedFile.getAbsolutePath());

        DocxFileWriter dfw = new DocxFileWriter("myDirectory/myNewFile.docx");
        
        List<XWPFParagraph> paragraphs = dfr.getParagraphs();
        
        for (XWPFParagraph paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }
        dfw.writeParagraphs(paragraphs);
        if (selectedFile != null) {
            return selectedFile;
        }
        throw new NoFileChosenException("No file has been chosen");
    }

}
