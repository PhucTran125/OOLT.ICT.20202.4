package oop.globalict.project.gui;

import java.io.IOException;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import oop.globalict.project.storage.VirusStorage;
import oop.globalict.project.virus.Virus;

public class DemonstrationScreenController {
	private Virus virus = DemonstrationScreen.virus;
	private VirusStorage storage;
	private String typeOfVirus;
	private JFXPanel fxPanel;
	private Scene scene;
	private Stage stage;
	//-----------FXML-------------//
	
	@FXML
	private Button home;

	@FXML
	private Button back;
	
	@FXML 
	private StructureController structureController;
	
	@FXML
	private InfectionController infectionController;
	
	@FXML
	public void handleBackButtonAction(ActionEvent event) throws IOException{
		new ChoosingScreen(storage, typeOfVirus, fxPanel);
	}
	
	@FXML
	public void handleHomeButtonAction(ActionEvent event) {
	    new MainScreen(storage, fxPanel);
	}
	//------------FXML---------------------//
	
	public DemonstrationScreenController(Virus v,VirusStorage storage, String type, JFXPanel panel) {
		super();
		this.virus = v;
		this.storage = storage;
		this.typeOfVirus = type;
		this.fxPanel = panel;
	}
}
