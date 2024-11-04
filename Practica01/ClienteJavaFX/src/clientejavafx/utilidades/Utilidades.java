package clientejavafx.utilidades;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/*
 *
 * @author reyes
 */

public class Utilidades {
    
    public static void mostrarAlertaSimple(String titulo, String contenido, Alert.AlertType tipo){   
        
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.show();
    }
    
    public static boolean mostrarConfirmacion(String titulo, String mensaje) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);

    Optional<ButtonType> resultado = alert.showAndWait();
    return resultado.isPresent() && resultado.get() == ButtonType.OK;
}
    
}
