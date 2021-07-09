package oop.globalict.project.gui;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.globalict.project.storage.VirusStorage;
import oop.globalict.project.virus.Virus;

public class ChoosingScreenController {
	private VirusStorage usedStorage;
	private VirusStorage totalStorage;
	private String typeOfVirus;
	private JFXPanel fxPanel;
	
	@FXML
    void btnHelpPressed(ActionEvent event) {
		new HelpScreen();
    }

    @FXML
    void btnHomePressed(ActionEvent event) {
    	new MainScreen(totalStorage, fxPanel);
    }

	
	@FXML
    private Label lblTitle;
	
	@FXML
    private TextField tfFilter;

	@FXML
    private RadioButton radioBtnFilterName;

	@FXML
    private RadioButton radioBtnFilterInfectionMethod;
	
    @FXML
    private TableView<Virus> tblVirus;

    @FXML
    private TableColumn<Virus, Integer> colVirusID;

    @FXML
    private TableColumn<Virus, String> colVirusName;

    @FXML
    private TableColumn<Virus, String> colVirusInfectionMethod;

    @FXML
    private Button btnInvestigation;

    @FXML
    void btnInvestigatePressed(ActionEvent event) {
    	Virus virus = tblVirus.getSelectionModel().getSelectedItem();
    	new DemonstrationScreen(virus, totalStorage, typeOfVirus, fxPanel);
    }
    
    public ChoosingScreenController(VirusStorage finalStorage, VirusStorage totalStorage, String type, JFXPanel fxPanel) {
		// TODO Auto-generated constructor stub
    	super();
    	this.usedStorage = finalStorage;
    	this.totalStorage = totalStorage;
    	this.typeOfVirus = type;
    	this.fxPanel = fxPanel;
    }
    
    @FXML
    private void initialize() {
    	colVirusID.setCellValueFactory(new PropertyValueFactory<Virus, Integer>("id"));
    	colVirusName.setCellValueFactory(new PropertyValueFactory<Virus, String>("name"));
    	colVirusInfectionMethod.setCellValueFactory(new PropertyValueFactory<Virus, String>("infectionMethod"));
    	tblVirus.setItems(this.usedStorage.getVirus());
    	
    	
    	btnInvestigation.setVisible(false);
    	
    	tblVirus.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Virus>() {

			@Override
			public void changed(ObservableValue<? extends Virus> arg0, Virus oldMedia, Virus newMedia) {
				if (newMedia != null) {
					btnInvestigation.setVisible(true);
				}
			}
    		
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredVirus(newValue);
			}
    	});
    }
    
    void showFilteredVirus(String value) {
    	ObservableList<Virus> list = FXCollections.observableArrayList();
		
		if (radioBtnFilterName.isSelected()){
			for (Virus item : usedStorage.getVirus()) {
				if (item.getName().toLowerCase().contains(value.toLowerCase())) {
					list.add(item);
				}
			}
			tblVirus.setItems(list);
		}
		else {
			for (Virus item : usedStorage.getVirus()) {
				if (item.getInfectionMethod().toLowerCase().contains(value.toLowerCase())) {
					list.add(item);
				}
			}
			tblVirus.setItems(list);
		}
    }
}
