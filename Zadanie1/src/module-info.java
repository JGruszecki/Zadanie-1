module kalkulator {
	requires jdk.jshell;
	requires transitive javafx.base;
	requires transitive javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;

	opens kalkulator.controller to javafx.fxml;
	
	exports kalkulator;
	exports kalkulator.controller;
	exports kalkulator.model;
	exports kalkulator.view;
}