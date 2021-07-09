	package oop.globalict.project.virus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Virus implements Controller, showStructure{
	protected int id;
	protected String name;
	protected String generalImg;
	protected String acidDesc;
	protected String capsidDesc;
	protected String infectionMethod;
	protected String otherComponents;
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
	
	
	public Stage getStage(int i) {
		return stages.get(i);
	}
	
	// Constructor
		public Virus(String name, String generalImg, String acidDesc, String capsidDesc, String infectionMethod, String otherComponents) {
			super();
			this.name = name;
			this.infectionMethod = infectionMethod;
			this.generalImg = generalImg;
			this.acidDesc = acidDesc;
			this.capsidDesc = capsidDesc;
			this.otherComponents = otherComponents;
		}
	
	public void addStage(Stage stage) {
		stages.add(stage);
	}
}
