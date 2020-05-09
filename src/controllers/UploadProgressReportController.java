/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.NoFileChosenException;
import inputvalidators.DateValidator;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import utils.FileChooserWindow;



/**
 * FXML Controller class
 *
 * @author Adair Hernández
 */
public class UploadProgressReportController extends DashboardController implements Initializable {
    
    
     @FXML private TextField documentPathTextField;
     @FXML private Button chooseDocumentButton;
     @FXML private DatePicker initialDateDatePicker;
     @FXML private DatePicker finalDateDatePicker;
     @FXML private TextField hoursCoveredTextField;
     @FXML private Button uploadDocumentButton;
     @FXML private TableView uploadedDocumentsTableView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void chooseDocumentButtonClicked(){
        try{
            FileChooserWindow fileChooser = new FileChooserWindow();
            File chosenFile = fileChooser.selectFile();
            documentPathTextField.setText(chosenFile.getName());
        }catch(NoFileChosenException e){
            documentPathTextField.setText(e.getMessage());
        }
        
        
    }
    
    public void uploadDocumentButtonClicked() throws ParseException{
        
        
        //String initialDate = initialDateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate initialDate = initialDateDatePicker.getValue();
        LocalDate finalDate = finalDateDatePicker.getValue();
        
        DateValidator dateValidator = new DateValidator();
        if(dateValidator.validateStartingAndEndingDate(initialDate, finalDate)){
            System.out.println("Datos válidos");
        }else{
            System.out.println("Datos inválidos");
        }
        
        
    }
    
}

