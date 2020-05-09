/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exceptions.NoFileChosenException;
import java.io.File;
import javafx.stage.FileChooser;
/**
 *
 * @author Adair Hernández
 */
public class FileChooserWindow {
    
    public File selectFile() throws NoFileChosenException{
        FileChooser fileChooser = new javafx.stage.FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            return selectedFile;
        }
        throw new NoFileChosenException("No file has been chosen");
    }
    
}
