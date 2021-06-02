package oop.globalict.project.gui;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import oop.globalict.project.storage.VirusStorage;

public class MainScreenController {
	private VirusStorage storage1;
	private VirusStorage storage2;
	
	// function for main screen

	@FXML
    void btnHelpPressed(ActionEvent event) {
		new HelpScreen();
    }

    @FXML
    void btnQuitPressed(ActionEvent event) {
    	int input = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Confirm to quit", JOptionPane.YES_NO_CANCEL_OPTION);
    	if (input == 0) System.exit(0);
    }

    @FXML
    void btnWithEnvelopPressed(ActionEvent event) {
    	new ChoosingScreen(storage1, storage2);
    }

    @FXML
    void btnWithoutEnvelopPressed(ActionEvent event) {
    	new ChoosingScreen(storage2, storage1);
    	
    }    
    // function for main screen
    
    public MainScreenController(VirusStorage storage1, VirusStorage storage2) {
		// TODO Auto-generated constructor stub
    	super();
    	this.storage1 = storage1;
    	this.storage2 = storage2;
	}
}
