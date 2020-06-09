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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import models.Report;
import models.Student;
import pojo.ReportPojo;
import pojo.StudentPojo;

/**
 *
 * @author Adair Hernández
 */
public class StudentOverviewController extends ProfessorDashboardController implements Initializable {

    @FXML
    private TableView<StudentPojo> studentsTableView;
    @FXML
    private TableColumn<StudentPojo, String> namesTableColumn;
    @FXML
    private TableColumn<StudentPojo, String> lastNameTableColumn;
    @FXML
    private TableColumn<StudentPojo, String> enrollmentTableColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        loadData();
        this.listenToRowClick();

    }

    public void listenToRowClick() {
        this.studentsTableView.setRowFactory(tv -> {
            TableRow<StudentPojo> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    StudentPojo clickedRow = row.getItem();
                    int selectedStudentId = clickedRow.getUserId();
                    try {
                        ProjectOverviewController poc = new ProjectOverviewController(2);
                        this.redirectToProjectOverviewScreen();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });
            return row;
        });
    }

    public TableView<StudentPojo> getStudentsTableView() {
        return studentsTableView;
    }

    private void initTable() {
        initCols();
        studentsTableView.setItems(loadData());
    }

    private void initCols() {
        namesTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        enrollmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("enrollment"));
    }

    public ObservableList<StudentPojo> loadData() {
        Student student = new Student();

        ArrayList<StudentPojo> studentsList = student.getStudents();
        ObservableList<StudentPojo> studentsObservableList = FXCollections.observableArrayList(studentsList);
        return studentsObservableList;
    }

    public void redirectToProjectOverviewScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/ProjectOverview.fxml"));
        Stage stage = (Stage) studentsTableView.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 510));
    }

}
