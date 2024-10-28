/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pojo.Rol;

/**
 * FXML Controller class
 *
 * @author reyes
 */
public class FXMLFormularioColaboradoresController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private TextField tfNumeroPersonal;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfRfc;
    @FXML
    private TextField tfCurp;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private ComboBox <Rol> cbRol;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CargarTiposUsuarios();
    }    

    
    private void CargarTiposUsuarios(){
        ObservableList <Rol> tiposColaboradores = FXCollections.observableArrayList();
        tiposColaboradores.add(new Rol(1, "Colaborador"));
        tiposColaboradores.add(new Rol(2, "Cliente"));
        cbRol.setItems(tiposColaboradores);
    }

    @FXML
    private void clickGuardarColaborador(ActionEvent event) {
    }
}
