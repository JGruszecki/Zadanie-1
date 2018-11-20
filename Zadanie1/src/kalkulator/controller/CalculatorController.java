package kalkulator.controller;

import java.net.URL;
import java.util.ResourceBundle;

import kalkulator.model.CalculatorModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Klasa kontrolera implementujaca metode z klasy Initializable
 * @author Kuba
 *
 */
public class CalculatorController implements Initializable{
	
	private CalculatorModel calcModel;
	
	@FXML
	public TextField textField;
	
	/**
	 * Inicjalizacja kontrolera
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		calcModel = new CalculatorModel();
	}
	
	/**
	 * Metoda wykrywajaca wcisniety przycisk, stosowana dla przyciskow cyfr
	 * @param event - klikniecie przycisku
	 */
	@FXML
	public void buttonClick(ActionEvent event) {
		Button clicked = (Button) event.getSource();
		String buttonText = clicked.getText();
		calcModel.addValue(buttonText);
		setTextField(calcModel.output);
		calcModel.digitClicked();
	}
	
	/**
	 * Metoda wykrywajaca wcisniety przycisk, stosowana dla przycisku kropki
	 * Jesli przed wcisnieciem znaku kropki wystepowal znak lub pole tekstowe bylo puste, dopisuje przed nia "0"
	 * @param event - klikniecie przycisku
	 */
	@FXML
	public void dotButtonClick(ActionEvent event) {
		Button clicked = (Button) event.getSource();
		String buttonText = clicked.getText();
		if(textField.getText().equals("") || calcModel.ifOperationClicked())
			calcModel.addValue("0");
		calcModel.addValue(buttonText);
		setTextField(calcModel.output);
		calcModel.dotClicked();
	}
	
	/**
	 * Metoda wykrywajaca wcisniety przycisk, stosowana dla przyciskow operacji +,-,/,* oraz nawiasow
	 * Jesli przed wcisnieciem znaku liczba nie zawierala znaku . (liczba zawierala czescia calkowita) dodawane jest ".0"
	 * @param event - klikniecie przycisku
	 */
	@FXML
	public void operationButtonClick(ActionEvent event) {
		Button clicked = (Button) event.getSource();
		String buttonText = clicked.getText();
		if(!calcModel.ifDotClicked() && !calcModel.ifOperationClicked()) {
			calcModel.addValue(".0");
		}
		calcModel.operationClicked();
		calcModel.addValue(buttonText);
		setTextField(calcModel.output);
	}
	
	/**
	 * Metoda wykrywajaca wcisniecie znaku ^
	 */
	@FXML
	public void powBtnClick() {
		calcModel.jShellCalculate(calcModel.output);
		calcModel.calculatePow();
		setTextField(calcModel.output);
	}
	
	/**
	 * Metoda wykrywajaca wcisniecie znaku sqrt
	 */
	@FXML
	public void sqrtBtntClick() {
		calcModel.jShellCalculate(calcModel.output);
		calcModel.calculateSqrt();
		setTextField(calcModel.output);
	}
	
	/**
	 * Metoda wykrywajaca wcisniecie przycisku Clear
	 */
	@FXML
	public void clearBtnClick() {
		calcModel.clear();
		setTextField(calcModel.output);
	}
	
	/**
	 * Metoda wykrywajaca wcisniecie przycisku Back
	 */
	@FXML
	public void backspaceBtnClick() {
		calcModel.backspace();
		setTextField(calcModel.output);
	}
	
	/**
	 * Metoda wykrywajaca wcisniecie przycisku -/+
	 */
	@FXML
	public void changeSignBtnClick() {
		calcModel.changeSign();
		setTextField(calcModel.output);
	}
	
	/**
	 * Metoda wykrywajaca wcisniecie przycisku =
	 */
	@FXML
	public void equalsBtnCLick() {
		calcModel.equalSing();
		setTextField(calcModel.output);
		calcModel.dotClicked();
	}
	
	/**
	 * Metoda zmieniajaca zawartosc pola textField
	 */
	public void setTextField(String text) {
		textField.setText(text);
	}

	
}