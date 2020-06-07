/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import models.Report;
import models.Student;
import static org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data;
import pojo.ReportPojo;
import pojo.StudentPojo;




public class SelectStudentController extends ProfessorDashboardController implements Initializable {
    @FXML
    private ComboBox comboStudentsNames;
    @FXML
    private ComboBox comboStudentType;
    @Override
    public void initialize(URL url, ResourceBundle rb){
         startComboStudents();
    }
    
    public void startComboStudents(){
        comboStudentsNames.setMaxHeight(10);
        comboStudentType.setMaxHeight(10);
        ObservableList<StudentPojo> getStudents = this.getStudents();
        comboStudentsNames.setItems(this.getStudentNames(getStudents));
    }
    
    public ObservableList<StudentPojo> getStudents(){
        Student student = new Student();        
        ArrayList<StudentPojo> students = student.getStudents();
        ObservableList<StudentPojo> studentsObservableList = FXCollections.observableArrayList(students);
        return studentsObservableList;
    }
    
    private ObservableList<String> getStudentNames(ObservableList<StudentPojo> ol){
        ObservableList<String> names = FXCollections.observableArrayList();
        for(int i=0;i<getStudents().size();i++){
            names.add(ol.get(i).getName());
        }
        return names;
    }
    
    public void checkStudentProgress(){
        try {
            System.out.println(comboStudentsNames.getValue());
            StudentProgressController spc = new StudentProgressController("S18012122");
            super.redirectToCheckProgressScreen();
        } catch (IOException ex) {
            
        }
        
    }
}
