/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


/**
 *
 * @author edgar
 */
public class SelectStudentController extends DashboardController implements Initializable {
    @FXML
    private ComboBox<String> comboboxStudents;
    @FXML
    private ComboBox comboboxStudentType;
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        
    }
    
    public void comboStudents(){

    }
    
    
}
