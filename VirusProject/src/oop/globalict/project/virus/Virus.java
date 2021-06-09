package oop.globalict.project.virus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Virus {
	protected int id;
	protected String name;
	protected String generalImg;
	protected String acidDesc;
	protected String capsidDesc;
	protected String infectionMethod;
	public ObservableList<Stage> stages = FXCollections.observableArrayList();
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getInfectionMethod() {
		return infectionMethod;
	}
	
	public String getGeneralImage() {
		return generalImg;
	}
	
	public String getAcidDesc() {
		return acidDesc;
	}

	public String getCapsidDesc() {
		return capsidDesc;
	}
	
	public Stage getStage(int i) {
		return stages.get(i);
	}
	
	// Constructor
	public Virus(String name, String generalImg, String acidDesc, String capsidDesc, String infectionMethod) {
		super();
		this.name = name;
		this.infectionMethod = infectionMethod;
		this.generalImg = generalImg;
		this.acidDesc = acidDesc;
		this.capsidDesc = capsidDesc;
	}
	
	public void addStage(Stage stage) {
		stages.add(stage);
	}
	public abstract String stage1Label();
	public abstract String stage2Label();
	public abstract String stage3Label();
	public abstract String stage4Label();
	public abstract String generalMechanism();
	public abstract String generalStructure();
	
}
