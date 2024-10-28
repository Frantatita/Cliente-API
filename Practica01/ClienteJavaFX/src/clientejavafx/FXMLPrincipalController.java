/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author reyes
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button cerrar;
    @FXML
    private Button irColaborador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCerrarSesion(ActionEvent event) {
         try {
            Stage escenarioBase = (Stage) cerrar.getScene().getWindow();
            Parent principal = FXMLLoader.load(getClass().getResource("FXMLInicioSesion.fxml"));
            Scene escenaPrincipal = new Scene(principal);
            escenarioBase.setScene(escenaPrincipal);
            //escenarioBase.setTitle("Pantlla Principal :3");
            escenarioBase.show();
        } catch (IOException ex) {
            // Logger.getLogger(FXMLInicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mostrarAlertaSimple("Error", "No podemos ir a la pantalla principal :(", Alert.AlertType.ERROR);
        }

        
    }

    @FXML
    private void onActionIrColaborador(ActionEvent event) {
        
        try {
            Stage escenarioAdministrador = new Stage();
            Parent admintrador = FXMLLoader.load(getClass().getResource("/clientejavafx/FXMLAdministradorColaboradores.fxml"));
            Scene scene = new Scene(admintrador);
            escenarioAdministrador.setScene(scene);
            escenarioAdministrador.setTitle("Administradores de colaboradoes");
            escenarioAdministrador.initModality(Modality.APPLICATION_MODAL);
            escenarioAdministrador.showAndWait();
        } catch (IOException ex) {
            Utilidades.mostrarAlertaSimple("Error", "No podemos ir a la pantalla colaboradores", Alert.AlertType.ERROR);
            ex.printStackTrace(); // Para ver más detalles del error en la consola. 
        } 

    }
    
}
