package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class InterfaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;

    @FXML
    private ChoiceBox<String> typeOfAutomaton;

    @FXML
    private TextField NumberOfStates;

    @FXML
    private TextField s1;

    @FXML
    private TextField s2;

    @FXML
    private TextField namesOfStates;

    @FXML
    private ChoiceBox<String> listOfStates;

    @FXML
    private Label onlyMealy1;

    @FXML
    private Label onlyMealy2;

    @FXML
    private Label onyMoore1;

    @FXML
    private Separator onlyMoore2;

    @FXML
    private TextField r;

    @FXML
    private ComboBox<String> destinyIn1;

    @FXML
    private ComboBox<String> stateValue;

    @FXML
    private ComboBox<String> destinyIn2;

    @FXML
    private ComboBox<String> outIn1;

    @FXML
    private ComboBox<String> outIn2;

    @FXML
    void addState(ActionEvent event) {

    }

    @FXML
    void addToSetR(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void doneStep1(ActionEvent event) {

    }

    @FXML
    void doneStep21(ActionEvent event) {

    }

    @FXML
    void doneStep2A(ActionEvent event) {

    }

    @FXML
    void doneStep2B(ActionEvent event) {

    }

    @FXML
    void doneStep2C(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

    @FXML
    void start(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	typeOfAutomaton.getItems().add("Mealy");
        typeOfAutomaton.getItems().add("Moore");
    }
}