/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    
    public void buttonClicked(){
        
    }
    
}
