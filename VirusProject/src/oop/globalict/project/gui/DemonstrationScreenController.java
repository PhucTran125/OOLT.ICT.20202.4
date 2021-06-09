package oop.globalict.project.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import oop.globalict.project.storage.VirusStorage;
import oop.globalict.project.virus.Virus;

public class DemonstrationScreenController {
	private Virus virus = DemonstrationScreen.virus;
	private VirusStorage selected;
	private VirusStorage theOther;
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
		new ChoosingScreen(selected, theOther);
	}
	
	@FXML
	public void handleHomeButtonAction(ActionEvent event) {
	    MainScreen.main(null);
	}
	//------------FXML---------------------//
	
	public DemonstrationScreenController(Virus v,VirusStorage selected2, VirusStorage theOther2) {
		super();
		this.virus = v;
		this.selected = selected2;
		this.theOther = theOther2;
	}
}
