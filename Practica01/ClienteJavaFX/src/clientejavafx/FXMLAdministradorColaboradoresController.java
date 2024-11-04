package clientejavafx;

import clientejavafx.observador.NotificadorOperacion;
import clientejavafx.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.dao.ColaboradorDAO;
import pojo.Colaborador;
import pojo.Mensaje;

/**
 * FXML Controller class
 *
 * @author reyes
 */
public class FXMLAdministradorColaboradoresController implements Initializable, NotificadorOperacion {

    private ObservableList<Colaborador> colaboradores;

    @FXML
    private TableView<Colaborador> tablaColaborador;
    @FXML
    private TableColumn colNoPersonal;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private TableColumn colFechaNacimiento;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TextField tfColaborador;
    @FXML
    private Button btnAgregarColaborador;
    @FXML
    private Button btnEliminarColaborador;
    @FXML
    private Button btnEditarColaborador;

    private NotificadorOperacion observador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarTabla();
        cargarInformacionTabla();
    }

    @FXML
    private void agregraColaborador(ActionEvent event) {
        irFormulario(this, null);
    }

    @FXML
    private void eliminarColaborador(ActionEvent event) {
        Colaborador colaborador = tablaColaborador.getSelectionModel().getSelectedItem();
        if (colaborador != null) {
            eliminarColaboradorIdColaborador(colaborador.getIdColaborador());
            System.out.println("Id colaborador es: " + colaborador.getIdColaborador());
        } else {
            Utilidades.mostrarAlertaSimple("Selecciona", "Por favor seleccionado un colaborador de la tabla", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void editarColaborador(ActionEvent event) {
        Colaborador colaborador = tablaColaborador.getSelectionModel().getSelectedItem();
        if (colaborador != null) {
            irFormulario(this, colaborador);
        } else {
            Utilidades.mostrarAlertaSimple("Selecciona", "Por favor seleccionado un colaborador de la tabla", Alert.AlertType.WARNING);
        }

    }

    private void irFormulario(NotificadorOperacion observador, Colaborador colaborador) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLFormularioColaboradores.fxml"));
            Parent root = loader.load();

            FXMLFormularioColaboradoresController controlador = loader.getController();
            controlador.inicializarValores(observador, colaborador);

            //Parent root = FXMLLoader.load(getClass().getResource("FXMLFormularioColaboradores.fxml"));
            Stage escenarioForm = new Stage();
            Scene escenaFormulario = new Scene(root);
            escenarioForm.setScene(escenaFormulario);
            escenarioForm.setTitle("Formulario Colaborador");
            escenarioForm.initModality(Modality.APPLICATION_MODAL);
            escenarioForm.showAndWait();

        } catch (IOException ex) {
            Utilidades.mostrarAlertaSimple("Error", "Lo sentimos", Alert.AlertType.NONE);
        }
    }

    private void configurarTabla() {
        colNoPersonal.setCellValueFactory(new PropertyValueFactory("noPersonal"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        colTipo.setCellValueFactory(new PropertyValueFactory("Rol"));
    }

    private void cargarInformacionTabla() {
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> listaWS = ColaboradorDAO.obtenerColaboradores();
        if (listaWS != null) {
            colaboradores.addAll(listaWS);
            tablaColaborador.setItems(colaboradores);
            //CerrarVentana();
        } else {
            Utilidades.mostrarAlertaSimple("ERROR", "Por el momento no podemos acceder a los datos de los"
                    + "colaboradores, intente mas tarde", Alert.AlertType.ERROR);
        }
        //CerrarVentana();
    }

    private void CerrarVentana() {

        //Una forma de representar lo mismo
        Stage escenarioActual = (Stage) btnEliminarColaborador.getScene().getWindow();
        escenarioActual.close();

        // ((Stage) tfColaborador.getScene().getWindow()).close();
    }

    private void eliminarColaboradorIdColaborador(int idColaborador) {
    boolean confirmado = Utilidades.mostrarConfirmacion("Confirmar Eliminación", 
            "¿Estás seguro de que deseas eliminar al colaborador seleccionado?");    
    if (confirmado) {
        Mensaje mensaje = ColaboradorDAO.eliminarColaborador(idColaborador);
        
        if (!mensaje.isError()) {
            Utilidades.mostrarAlertaSimple("Eliminación Exitosa", "El colaborador ha sido eliminado correctamente", Alert.AlertType.INFORMATION);
            cargarInformacionTabla();  // Método para refrescar la tabla de colaboradores
            observador.notificarOperacion("Eliminación", "Colaborador con ID " + idColaborador + " ha sido eliminado");
        } else {
            Utilidades.mostrarAlertaSimple("ERROR", mensaje.getMensaje(), Alert.AlertType.ERROR);
            System.out.println("ERROR: " + mensaje.getMensaje());
        }
    }
}

    @Override
    public void notificarOperacion(String tipo, String nombre) {
        System.out.println("Tipo de operacion: " + tipo);
        System.out.println("Nombre: " + nombre);
        cargarInformacionTabla();
    }

}
