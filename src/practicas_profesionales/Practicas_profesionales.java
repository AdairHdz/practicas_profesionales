/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_profesionales;


import exceptions.NoFileChosenException;
import fileborrar.DocxFileWriter;
import fileborrar.FileWriter;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.FileChooserWindow;


/**
 *
 * @author Adair Hernández
 */
public class Practicas_profesionales extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/StudentProgress.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoFileChosenException, IOException {
        FileChooserWindow fcw = new FileChooserWindow();
        File userFile = fcw.selectFile();
        File newFile = new File("myDirectory/" + userFile.getName());
        FileWriter fw = new DocxFileWriter(newFile);
        //Y si le pasas a FileWriter el archivo del usuario, y que dentro lo lea y escriba el contenido en uno nuevo?
        launch(args);
    }
    
}
