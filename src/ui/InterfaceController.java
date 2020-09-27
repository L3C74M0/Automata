package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.Automaton;
import model.State;

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
	private TextField numberOfStates;

	@FXML
	private TextField s1;

	@FXML
	private TextField s2;

	@FXML
	private Label field1;

	@FXML
	private Label field2;

	@FXML
	private TextField namesOfStates;

	@FXML
	private ChoiceBox<String> listOfStates;

	@FXML
	private Label onlyMealy1;

	@FXML
	private Label onlyMealy2;

	@FXML
	private Label onlyMoore1;

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
	private ChoiceBox<String> initialState;
	
	@FXML
	private Button step1;
	
	@FXML
	private Button step2;
	
	@FXML
	private Button step3;
	
	@FXML
	private Button step4;
	
	@FXML
	private Button step5;
	
	@FXML
	private Button step6;
	
	@FXML
	private Button step7;
	
	@FXML
	private Button step8;
	
	@FXML
	private Button step9;
	
	@FXML
	private Button step10;
	
    @FXML
    private ImageView img;

	protected String typeAutomaton;
	protected int amountOfStates;
	protected char[] setS;
	protected char[] setR;
	protected int posR;
	protected char[] setStates;
	protected int posStates;

	private Automaton automaton;

	@FXML
	void addFullStatus(ActionEvent event) {
		try {
			State state = null;

			String var1 = listOfStates.getValue();
			String var2 = destinyIn1.getValue();
			String var3 = destinyIn2.getValue();
			String var4 = outIn1.getValue();
			String var5 = outIn2.getValue();
			String var6 = stateValue.getValue();
			
			String tmp = typeOfAutomaton.getValue();
			
			boolean isPosible = false;
			int type=0;
			
			if(tmp.equalsIgnoreCase("Mealy")) {
				if(!var1.equalsIgnoreCase(" ") && !var2.equalsIgnoreCase(" ") && !var3.equalsIgnoreCase(" ") && !var4.equalsIgnoreCase(" ") && !var5.equalsIgnoreCase(" ")) {
					isPosible = true;
				}
			} else {
				if(!var1.equalsIgnoreCase(" ") && !var2.equalsIgnoreCase(" ") && !var3.equalsIgnoreCase(" ") && !var6.equalsIgnoreCase(" ")) {
					isPosible = true;
					type = 1;
				}
			}
			
			if (isPosible) {
				if (tmp.equalsIgnoreCase("Mealy")) {
					state = new State(var1.charAt(0), var2.charAt(0), var3.charAt(0), var4.charAt(0), var5.charAt(0), ' ');
				} else {
					state = new State(var1.charAt(0), var2.charAt(0), var3.charAt(0), ' ', ' ', var6.charAt(0));
				}

				automaton.addState(state, type);

				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("AGREGADO CORRECTAMENTE");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Se ha agregado el valor estado correctamente");
				info.show();
			} else {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Se deben seleccionar todos los campos");
				info.show();
			}
		} catch (Exception e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Se deben seleccionar todos los campos");
			info.show();
		}
	}

	@FXML
	void addState(ActionEvent event) {
		String temp = namesOfStates.getText();
		try {
			if (temp.length() == 1) {
				setStates[posStates] = temp.charAt(0);
				posStates++;
				namesOfStates.setText("");

				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("AGREGADO CORRECTAMENTE");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Se ha agregado el valor " + temp + " correctamente");
				info.show();
			} else {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("El nombre del estado debe ser de un caracter");
				info.show();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText(
					"Ya se llegó al limite de estados maximos permitidos por el valor digitado anteriormente");
			info.show();

			namesOfStates.setText("");
			namesOfStates.setDisable(true);
		}
	}

	@FXML
	void addToSetR(ActionEvent event) {
		String temp = r.getText();
		if (temp.length() == 1) {
			if (posR < 10) {
				setR[posR] = temp.charAt(0);
				r.setText("");

				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("AGREGADO CORRECTAMENTE");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Se ha agregado el valor " + temp + " correctamente");
				info.show();

				posR++;
			} else {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("No se pueden agregar mas de 10 valores al conjunto R");
				info.show();
			}
		} else {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("El valor de R debe ser de sólo un caracter");
			info.show();
		}
	}

	@FXML
	void close(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void doneStep1(ActionEvent event) {
		try {
			if (typeOfAutomaton.getValue().equalsIgnoreCase("Mealy")) {
				typeAutomaton = "Mealy";
				typeOfAutomaton.setDisable(true);
				step1.setDisable(true);
			} else if (typeOfAutomaton.getValue().equalsIgnoreCase("Moore")) {
				typeAutomaton = "Moore";
				typeOfAutomaton.setDisable(true);
				step1.setDisable(true);
			} else {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Por favor seleccione un tipo de automata");
				info.show();
			}
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Por favor seleccione un tipo de automata");
			info.show();
		}
	}

	@FXML
	void doneStep21(ActionEvent event) {
		try {
			amountOfStates = Integer.parseInt(numberOfStates.getText());
			if (amountOfStates >= 1) {
				setStates = new char[amountOfStates];
				numberOfStates.setDisable(true);
				step2.setDisable(true);
			} else {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("El numero de estados debe ser mayor de 0");
				info.show();
			}
		} catch (NumberFormatException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Por favor digite un numero");
			info.show();
		}
	}

	@FXML
	void doneStep22(ActionEvent event) {
		if (posStates <= amountOfStates - 1) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Se deben ingresar " + amountOfStates + " nombres de estados");
			info.show();
		} else {
			namesOfStates.setText("");
			namesOfStates.setDisable(true);
			fillComboBox();
			field1.setText("Entrada: " + s1.getText());
			field2.setText("Entrada: " + s2.getText());
			
			if(typeOfAutomaton.getValue().equals("Mealy")) {
				onlyMoore1.setVisible(false);
				onlyMoore2.setVisible(false);
				stateValue.setVisible(false);
			} else {
				onlyMealy1.setVisible(false);
				onlyMealy2.setVisible(false);
				outIn1.setVisible(false);;
				outIn2.setVisible(false);;
			}
			
			step6.setDisable(true);
			step7.setDisable(true);
		}
	}

	@FXML
	void doneStep2A(ActionEvent event) {
		String temp1 = s1.getText();
		String temp2 = s2.getText();
		if (temp1.length() == 1) {
			if (temp2.length() == 1) {
				setS[0] = temp1.charAt(0);
				setS[1] = temp2.charAt(0);
				s1.setDisable(true);
				s2.setDisable(true);
				step3.setDisable(true);
			} else {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("El valor 2 debe ser de solo un caracter");
				info.show();
			}
		} else {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("El valor 1 debe ser de solo un caracter");
			info.show();
		}
	}

	@FXML
	void doneStep2B(ActionEvent event) {
		if (setR[0] != '^') {
			r.setDisable(true);
			step4.setDisable(true);
			step5.setDisable(true);
		} else {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Se debe agregar al menos un valor al conjunto R");
			info.show();
		}
	}

	@FXML
	void doneStep2C(ActionEvent event) {
		listOfStates.setDisable(true);;
		destinyIn1.setDisable(true);
		destinyIn2.setDisable(true);
		outIn1.setDisable(true);
		outIn2.setDisable(true);
		stateValue.setDisable(true);
		
		for (int i = 0; i < amountOfStates; i++) {
			initialState.getItems().add("" + setStates[i]);
		}
		
		step8.setDisable(true);
		step9.setDisable(true);
	}

	@FXML
	void doneStep2D(ActionEvent event) {
		try {
			if (initialState.getValue().equals("") || initialState.getValue().equals(" ")) {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Se debe elegir un estado inicial");
				info.show();
			} else {
				automaton.setInitialState(initialState.getValue());
				initialState.setDisable(true);
				step10.setDisable(true);
				
				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("ESTADO INICIAL ELEGIDO CORRECTAMENTE");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("Se ha seleccionado el estado inicial correctamente");
				info.show();
			}
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Se debe elegir un estado inicial");
			info.show();
		}
	}

	@FXML
	void start(ActionEvent event) {
		automaton.BFS();
		img.setImage(new Image(getClass().getResourceAsStream("tired.gif")));
	}

	@FXML
	void initialize() {
		typeOfAutomaton.getItems().add("Mealy");
		typeOfAutomaton.getItems().add("Moore");
		typeOfAutomaton.setDisable(false);
		setS = new char[2];
		setR = new char[10];
		setR[0] = '^';
		posR = 0;
		posStates = 0;
		s1.setDisable(false);
		s2.setDisable(false);
		numberOfStates.setDisable(false);
		namesOfStates.setDisable(false);
		automaton = new Automaton();
	}

	protected void fillComboBox() {
		for (int i = 0; i < amountOfStates; i++) {
			listOfStates.getItems().add("" + setStates[i]);
			destinyIn1.getItems().add("" + setStates[i]);
			destinyIn2.getItems().add("" + setStates[i]);
		}

		for (int i = 0; i < setR.length; i++) {
			outIn1.getItems().add("" + setR[i]);
			outIn2.getItems().add("" + setR[i]);
		}

		stateValue.getItems().add("" + setS[0]);
		stateValue.getItems().add("" + setS[1]);
	}
}