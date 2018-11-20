package kalkulator.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Klasa View
 * @author Kuba
 *
 */
public class CalculatorView{

	public CalculatorView() {   }
	
	/**
	 * Metoda sluzaca do wyswietlania alertow
	 * @param message - wiadomosc majaca byc wyswietlona na Alercie
	 */
	public void showAlert(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText(null);
		alert.setTitle("ERROR");
		alert.setContentText(message);
		alert.showAndWait();
	}
	
}