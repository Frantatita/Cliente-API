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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.dao.LoginDAO;
import pojo.Login;

/**
 *
 * @author reyes
 */ 

public class FXMLInicioSesionController implements Initializable {

    @FXML
    private Label errorCorreo;
    @FXML
    private Label errorContraseña;
    @FXML
    private TextField tfCorreo;
    @FXML
    private PasswordField pfContrasena;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    private void verificarCredencialesSistema(String noPersonal, String contrasena){
        /*
        Alert alertaBienvenido = new Alert(Alert.AlertType.INFORMATION);
        alertaBienvenido.setTitle("Notificacion");
        alertaBienvenido.setHeaderText("Bienvenido al sistema");
        alertaBienvenido.setContentText("En un momento seras dirigido al menu principal");
        alertaBienvenido.showAndWait(); 
       
        Utilidades.mostrarAlertaSimple("Autentificacion Correcta", "Bienvenido al sistema", Alert.AlertType.INFORMATION); */
        
        Login respuestaLogin = LoginDAO.iniciarSesion(noPersonal, contrasena);
        if(!respuestaLogin.getError()){
            Utilidades.mostrarAlertaSimple("Bienvenido(a)", 
                    "Bienvenido(a)" + respuestaLogin.getColaborador().getNombre() + " al sistema" 
                    , Alert.AlertType.INFORMATION);
                    irPantallaPrincipal();
        } else {
            Utilidades.mostrarAlertaSimple("ERROR", respuestaLogin.getMensaje(), Alert.AlertType.ERROR);
        }
    }
      
    
    private void irPantallaPrincipal(){
        try {
            Stage escenarioBase = (Stage) errorCorreo.getScene().getWindow();
            
            Parent principal = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
            Scene escenaPrincipal = new Scene(principal);
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("Pantlla Principal :3");
            escenarioBase.show();
        } catch (IOException ex) {
           // Logger.getLogger(FXMLInicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
           Utilidades.mostrarAlertaSimple("Error", "No podemos ir a la pantalla principal :(", Alert.AlertType.ERROR);
        }   
    }
    
    
    private boolean validarCampos(String correo, String contrasena){
        boolean camposValidos = true;
        errorCorreo.setText("");
        errorContraseña.setText("");

        if(correo.isEmpty()){
            camposValidos = false;
            errorCorreo.setText("Correo electronico boligatorio");
        }
        if(contrasena.isEmpty()){
            camposValidos = false;
            errorContraseña.setText("Contraseña obligatoria");
        }
        return camposValidos;
    }

    @FXML
    private void clickIngresar(ActionEvent event) {
         String correo = tfCorreo.getText();
        String contrasena = pfContrasena.getText();
        
        if(validarCampos(correo, contrasena)){
            verificarCredencialesSistema(correo, contrasena);
        } 
    }
}
