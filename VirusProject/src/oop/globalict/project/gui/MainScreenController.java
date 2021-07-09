package oop.globalict.project.gui;

import javax.swing.JOptionPane;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import oop.globalict.project.storage.VirusStorage;

public class MainScreenController {
	private VirusStorage storage;
	private JFXPanel fxPanel;
	
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
    	String typeOfVirus = "WithEnvelop";
    	new ChoosingScreen(storage, typeOfVirus, fxPanel);
    }

    @FXML
    void btnWithoutEnvelopPressed(ActionEvent event) {
    	String typeOfVirus = "WithoutEnvelop";
    	new ChoosingScreen(storage, typeOfVirus, fxPanel);
    	
    }    
    // function for main screen
    
    public MainScreenController(VirusStorage storage, JFXPanel fxPanel) {
		// TODO Auto-generated constructor stub
    	super();
    	this.storage = storage;
    	this.fxPanel = fxPanel;
    }
}
