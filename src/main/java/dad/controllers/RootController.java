package dad.controllers;

import dad.models.EmailData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // Model
    EmailData email_data = new EmailData();

    Email email = new SimpleEmail();


    // View
    @FXML
    private TextField asuntoTextField;

    @FXML
    private Button cerrarButton;

    @FXML
    private Button enviarButton;

    @FXML
    private TextField fromTextField;

    @FXML
    private TextArea mensajeTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField puertoTextField;

    @FXML
    private GridPane root;

    @FXML
    private TextField servidorTextField;

    @FXML
    private CheckBox sslCheckBox;

    @FXML
    private TextField toTextField;

    @FXML
    private Button vaciarButton;

    public GridPane getRoot() {
        return root;
    }

    @FXML
    void onCerrarAction(ActionEvent event) {
        System.exit(0);
    }

    private boolean CheckNull() {
        StringBuilder emptyFields = new StringBuilder();

        if (email_data.getHost_name().isEmpty()) {
            emptyFields.append("Nombre del Servidor\n");
        }
        if (email_data.getPort().isEmpty()) {
            emptyFields.append("Puerto\n");
        }
        if (email_data.getUser().isEmpty()) {
            emptyFields.append("Usuario\n");
        }
        if (email_data.getPassword().isEmpty()) {
            emptyFields.append("Contraseña\n");
        }
        if (email_data.getTo().isEmpty()) {
            emptyFields.append("Destinatario\n");
        }
        if (email_data.getSubject().isEmpty()) {
            emptyFields.append("Asunto\n");
        }
        if (email_data.getMessage().isEmpty()) {
            emptyFields.append("Mensaje\n");
        }

        if (emptyFields.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Campos Vacíos");
            alert.setContentText("Los siguientes campos están vacíos:\n" + emptyFields.toString());
            alert.showAndWait();
            return true;
        }
        return false;
    }

    @FXML
    void onEnviarAction(ActionEvent event) {
        if (CheckNull()) {
            return;
        }

        email.setHostName(email_data.getHost_name());

        try {
            int port = Integer.parseInt(email_data.getPort());
            email.setSmtpPort(port);
        } catch (NumberFormatException e) {
            System.err.println("Número de puerto inválido: " + email_data.getPort());
            return;
        }

        email.setAuthenticator(new DefaultAuthenticator(email_data.getUser(), email_data.getPassword()));
        email.setSSLOnConnect(email_data.isSsl());

        try {
            email.setFrom(email_data.getUser());
            email.setSubject(email_data.getSubject());
            email.setMsg(email_data.getMessage());
            email.addTo(email_data.getTo());
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onVaciarAction(ActionEvent event) {
        asuntoTextField.clear();
        fromTextField.clear();
        mensajeTextField.clear();
        passwordTextField.clear();
        puertoTextField.clear();
        servidorTextField.clear();
        sslCheckBox.setSelected(false);
        toTextField.clear();
    }


    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        email_data.host_nameProperty().bind(servidorTextField.textProperty());
        email_data.sslProperty().bind(sslCheckBox.selectedProperty());
        email_data.portProperty().bind(puertoTextField.textProperty());
        email_data.userProperty().bind(fromTextField.textProperty());
        email_data.passwordProperty().bind(passwordTextField.textProperty());
        email_data.toProperty().bind(toTextField.textProperty());
        email_data.subjectProperty().bind(asuntoTextField.textProperty());
        email_data.messageProperty().bind(mensajeTextField.textProperty());
    }



}


