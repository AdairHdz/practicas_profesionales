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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;


public class StudentProgressController extends DashboardController implements Initializable {
    
    @FXML
    private Label studentName;
    @FXML
    private Label studentEnrollment;
    @FXML
    private Label nameLinkedOrganization;
    @FXML
    private Label defaultTagContact;
    @FXML
    private Label studentEmail;
    @FXML
    private Label studentPhone;
    @FXML
    private Label projectName;
    @FXML
    private ProgressBar studentProgress;
    @FXML
    private ProgressIndicator studentProgressIndicator;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void getData(){
        
    }
    public void calculateProgress(){
        
    }
}
