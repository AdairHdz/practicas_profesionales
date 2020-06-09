/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.FormInputException;
import exceptions.NoFileChosenException;
import file.DocumentWriter;
import file.DocxWriter;
import inputvalidators.DateValidator;

import inputvalidators.NumberValidator;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Record;
import models.Report;
import pojo.DocumentPojo;
import pojo.RecordPojo;
import pojo.ReportPojo;
import pojo.UserPojo;
import session.UserSession;
import utils.DateFormatter;
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
    TableColumn deleteReportColumn;
    @FXML
    private ProgressBar studentProgressBar;
    private DocumentPojo chosenDocument;
    private UserPojo user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.chosenDocument = null;
        UserSession userSession = UserSession.getInstance();
        user = userSession.getUser();
        initTable();
        loadData();
        int progress = this.getProgress();
        this.setProgressToProgressBar(progress);

    }

    public void chooseDocumentButtonClicked() {
        try {
            this.handleChooseDocumentButtonClicked();
        } catch (NoFileChosenException e) {
            documentPathTextField.setText("");
        } catch (IOException e2) {

        }
    }

    private void handleChooseDocumentButtonClicked() throws NoFileChosenException, IOException {
        FileChooserWindow fileChooser = new FileChooserWindow();
        this.chosenDocument = fileChooser.selectFile();
        documentPathTextField.setText(this.chosenDocument.getName());
        System.out.println(this.chosenDocument.getSize());
    }

    public void uploadDocumentButtonClicked() {
        //this.validateFormFields();
        try {
            boolean documentHasBeenWritten = this.requestWriteDocument();
            boolean documentHasBeenSaved = this.requestSaveDocument();
            if (documentHasBeenWritten && documentHasBeenSaved) {
                System.out.println("Archivo guardado");
            } else {
                System.out.println("Archivo no guardado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UploadProgressReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean requestWriteDocument() {
        if (this.chosenDocument != null) {
            DocumentWriter docxWriter = new DocxWriter(this.chosenDocument);
            return docxWriter.write();
        }
        return false;
    }

    public boolean requestSaveDocument() throws SQLException {
        if (this.chosenDocument != null) {
            Report report = new Report();
            DateFormatter dateFormatter = new DateFormatter();
            Date initialDate = dateFormatter.getLocalDate(initialDateDatePicker);
            Date finalDate = dateFormatter.getLocalDate(finalDateDatePicker);

            String reportName = this.chosenDocument.getName();
            String reportPath = this.chosenDocument.getPath();
            double reportSize = this.chosenDocument.getSize();
            int hoursCovered = Integer.parseInt(this.hoursCoveredTextField.getText());

            ReportPojo reportToBeUploaded = new ReportPojo(reportName, reportPath,
                    reportSize, initialDate, finalDate, hoursCovered);
            return report.saveReport(reportToBeUploaded);
        }
        return false;
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
        ArrayList<ReportPojo> reports = report.getReports(user.getUserId());
        ObservableList<ReportPojo> reportsObservableList = FXCollections.observableArrayList(reports);
        return reportsObservableList;
    }

    private int getProgress() {
        Record record = new Record();
        RecordPojo recordPojo = record.getRecord(user.getUserId());
        return recordPojo.getTotalHoursCovered();
    }

    private void setProgressToProgressBar(int hoursCovered) {
        this.studentProgressBar.setProgress((hoursCovered * 100) / 480);
    }

    /*
    private void validateFormFields() {
        
        try {
            this.validateFileHasBeenSelected();
            this.validateFileSize();
            this.validateDates();
            this.validateHoursCovered();
        } catch (FormInputException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void validateFileSize() throws FormInputException {
        if (this.chosenDocument.getSize() > 100000) {
            throw new FormInputException("Error. El archivo es demasiado pesado. "
                    + "El peso de los archivos usbidos al sistema no debe "
                    + "exceder 10MB");
        }
    }

    private void validateFileHasBeenSelected() throws FormInputException {
        if (this.chosenDocument == null) {
            throw new FormInputException("Por favor llene todos los campos e "
                    + "intente nuevamente");
        }
    }

    private void validateHoursCovered() throws FormInputException {
        this.validateHoursCoveredHasBeenFilled();
        NumberValidator hoursCoveredValidator = new NumberValidator();
        boolean isValid = hoursCoveredValidator.isValid(this.hoursCoveredTextField.getText());
        if (!isValid) {
            throw new FormInputException("Algunos de los campos contienen "
                    + "datos no válidos");
        }
    }

    private void validateHoursCoveredHasBeenFilled() throws FormInputException {
        if (this.hoursCoveredTextField.getText().equals("")) {
            throw new FormInputException("Por favor llene todos los campos e "
                    + "intente nuevamente");
        }
    }

    private void validateDates() throws ParseException, FormInputException {
        this.validateDatesHaveBeenSpecified();
        DateValidator dateValidator = new DateValidator();
        LocalDate initialDate = this.initialDateDatePicker.getValue();
        LocalDate endingDate = this.finalDateDatePicker.getValue();
        boolean isValid = dateValidator.validateStartingAndEndingDate(initialDate, endingDate);
        if (!isValid) {
            throw new FormInputException("Fechas no válidas");
        }
    }

    private void validateDatesHaveBeenSpecified() throws FormInputException {
        if (this.initialDateDatePicker.getValue() == null || this.finalDateDatePicker.getValue() == null) {
            throw new FormInputException("Por favor llene todos los campos e "
                    + "intente nuevamente");
        }
    }
    */

}
