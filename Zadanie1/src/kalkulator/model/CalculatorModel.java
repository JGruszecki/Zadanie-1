package kalkulator.model;

import kalkulator.view.CalculatorView;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.util.List;

/**
 * Klasa model
 * @author Kuba
 *
 */
public class CalculatorModel{
	
	/**
	 * Zmienna typu String, zawierajaca dzialanie, majace zostac obliczone przez JShell API
	 */
	public String output = "";
	
	private boolean dotClicked = false;
	private boolean operationClicked = false;
	
	private CalculatorView calcView;

	public CalculatorModel(){
		calcView = new CalculatorView();
	}
	
	/**
	 * Metoda sluzaca do obliczania wartosci wejsciowej w postaci String za pomoca JShell API
	 * @param input - warosc wejsciowa majaca byc obliczona
	 */
	public void jShellCalculate(String input){
		JShell jshell = JShell.create();
        try (jshell){
            List<SnippetEvent> events = jshell.eval(input);
            SnippetEvent e = events.get(0);
                if(e.causeSnippet() == null)
                    switch (e.status()) {
                        case VALID:
                            if (e.value() == null || e.value().equals("Infinity") || e.value().equals("NaN"))
                            	output = "Error";
                            else
                                output = e.value();                            	
                            break;
                            default:
                            	output = "Error";
                    }
        }
    }
    
	/**
	 * Metoda dodajaca do zmiennej output zmienna value
	 * Jesli output = "Error" zeruje zmienna output
	 * @param value - wartosc majaca zostac dodana do ciagu znakow output
	 */
	public void addValue(String value) {
		if(output.equals("Error"))
			output = "";
		output = output + value;
	}
	
	/**
	 * Metoda sluzaca do poprawnego ustawienia zmiennej output w celu policzenia jej kwadratu
	 */
	public void calculatePow() {
		output = "Math.pow(" + output + "," + 2 + ")";
	}
	
	/**
	 * Metoda sluzaca do poprawnego ustawienia zmiennej output w celu policzenia jej pierwiastka kwadratowego
	 */
	public void calculateSqrt() {
		output = "Math.sqrt(" + output + ")";
	}
	
	/**
	 * Metoda sluzaca do zmiany znaku wyrazenia output
	 */
	public void changeSign() {
		if(output == "");
		else if(output.charAt(0) == '-')
			output = output.substring(1, output.length());
		else {
			output = "-" + output;
		}
	}
	
	/**
	 * Metoda sluzaca do usuniecia jednego znaku ze zmiennej output
	 * Jesli output == "Error" ustawia ""
	 */
	public void backspace() {
		if(output == "Error")
			output = "";
		if(output.length() == 0) {   }
		else
			output = output.substring(0, output.length() - 1);
	}
	
	/**
	 * Metoda sluzaca do usuwania wszystkich znakow ze zmiennej output
	 */
	public void clear() {
		output = "";
	}
	
	/**
	 * Metoda bedaca odpowiednikiem znaku =, uruchania metoda jShellCalculate i wyswietla Alert w razie bledu
	 */
	public void equalSing() {
		jShellCalculate(output);
		if(output == "Error")
			calcView.showAlert("Nieprawidlowe wyrazenie!");
	}
	
	/**
	 * 
	 * @return zwraca wartosc flagi dotClicked
	 */
	public boolean ifDotClicked() {
		return dotClicked;
	}
	
	/**
	 * 
	 * @return zwraca wartosc flagi operationClicked
	 */
	public boolean ifOperationClicked() {
		return operationClicked;
	}
	
	/**
	 * Metoda zmieniajaca wartosc flagi dotClicked na true
	 */
	public void dotClicked() {
		dotClicked = true;
	}
	
	/**
	 * Metoda zmieniajaca wartosc flagi operationClicked na true oraz dotClicked na false
	 */
	public void operationClicked() {
		operationClicked = true;
		dotClicked = false;
	}
	
	/**
	 * Metoda zmieniajaca wartosc flagi operationClicked na false
	 */
	public void digitClicked() {
		operationClicked = false;
	}
}
