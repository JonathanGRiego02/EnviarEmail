package dad.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

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

    }

    @FXML
    private TextField asuntoTextField;

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

}

}
