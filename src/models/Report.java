/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import pojo.ReportPojo;

/**
 *
 * @author Adair Hernández
 */
public class Report {    

    public Report() {

    }

    public ArrayList<ReportPojo> getReports(int userId) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT Documento.nombre, Documento.fechaSubida, "
                    + "Reporte.fechaInicio, Reporte.fechaFin, Reporte.horasCubiertas, Reporte.status "
                    + "FROM Usuario INNER JOIN Estudiante ON Usuario.idUsuario = Estudiante.idUsuario "
                    + "INNER JOIN Participacion ON Estudiante.matricula = Participacion.matricula "
                    + "INNER JOIN Expediente ON Participacion.idParticipacion = Expediente.idParticipacion "
                    + "INNER JOIN Documento ON Expediente.idExpediente = Documento.idExpediente "
                    + "INNER JOIN Reporte ON Documento.idDocumento = Reporte.idDocumento "
                    + "WHERE Usuario.idUsuario = " + userId);
            DatabaseConnector.closeConnection(connection);
            ArrayList<ReportPojo> reports = new ArrayList<>();
            while (result.next()) {
                ReportPojo report = new ReportPojo();
                report.setName(result.getString("nombre"));
                report.setUploadDate(result.getDate("fechaSubida"));
                report.setInitialDate(result.getDate("fechaInicio"));
                report.setEndingDate(result.getDate("fechaFin"));
                report.setCoveredHours(result.getInt("horasCubiertas"));
                report.setStatus(result.getString("status"));
                reports.add(report);
            }
            return reports;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    public boolean saveReport(ReportPojo report) {
        String fileName = report.getName();
        String filePath = report.getPath();
        double fileSize = report.getSize();
        Date initialDateOfReport = report.getInitialDate();
        Date endingDateOfReport = report.getEndingDate();
        int coveredHours = report.getCoveredHours();
        Connection connection = DatabaseConnector.getConnection();
        try {
            Statement query = connection.createStatement();
            //boolean inserted = query.execute("INSERT INTO Reporte VALUES(NULL, );");
        } catch (SQLException e) {

        }
        return false;
    }
}
