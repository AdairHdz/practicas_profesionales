/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.NoFileChosenException;
import file.DocxFileReader;
import file.DocxFileWriter;
import file.FileReader;
import file.FileWriter;
import inputvalidators.DateValidator;
import inputvalidators.NumberValidator;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Report;
import pojo.ReportPojo;
import utils.FileChooserWindow;

/**
 * FXML Controller class
 *
 * @author Adair Hernández
 */
public class UploadProgressReportController extends DashboardController implements Initializable {

    @FXML
    private TextField documentPathTextField;
    @FXML
    private Button chooseDocumentButton;
    @FXML
    private DatePicker initialDateDatePicker;
    @FXML
    private DatePicker finalDateDatePicker;
    @FXML
    private TextField hoursCoveredTextField;
    @FXML
    private Button uploadDocumentButton;

    @FXML
    private TableView<ReportPojo> uploadedDocumentsTableView;

    @FXML
    private TableColumn<ReportPojo, String> nameTableColumn;
    @FXML
    private TableColumn<ReportPojo, Date> uploadDateTableColumn;

    private File chosenFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData();
    }

    public void chooseDocumentButtonClicked() {
        try {
            FileChooserWindow fileChooser = new FileChooserWindow();
            this.chosenFile = fileChooser.selectFile();
            FileReader fileReader = new DocxFileReader(this.chosenFile.getPath());
            FileWriter fileWriter = new DocxFileWriter("myDirectory/" + this.chosenFile.getName());
            fileWriter.writeParagraphs(fileReader.getParagraphs());
            documentPathTextField.setText(this.chosenFile.getName());

        } catch (NoFileChosenException e) {
            documentPathTextField.setText(e.getMessage());
        } catch (IOException e2) {

        }

    }

    public void uploadDocumentButtonClicked() throws ParseException {

        //String initialDate = initialDateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate initialDate = initialDateDatePicker.getValue();
        LocalDate finalDate = finalDateDatePicker.getValue();
        DateValidator dateValidator = new DateValidator();
        boolean validDates = dateValidator.validateStartingAndEndingDate(initialDate, finalDate);
        NumberValidator numberValidator = new NumberValidator();
        boolean validHoursFormat = numberValidator.isValid(hoursCoveredTextField.getText());
        if(validDates && validHoursFormat){
            ReportPojo report = new ReportPojo();
            report.setName(this.chosenFile.getName());
            
        }
        //DocxFileReader fr = new DocxFileReader(this.documentPathTextField.getText());
        //System.out.println(this.documentPathTextField.getText());
    }

    private void initTable() {
        initCols();
        uploadedDocumentsTableView.setItems(loadData());
    }

    private void initCols() {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        uploadDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));
    }

    public ObservableList<ReportPojo> loadData() {
        Report report = new Report();
        ArrayList<ReportPojo> reports = report.getReports("S18012122");
        ObservableList<ReportPojo> reportsObservableList = FXCollections.observableArrayList(reports);
        return reportsObservableList;
    }

}
