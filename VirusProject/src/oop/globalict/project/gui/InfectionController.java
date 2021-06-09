package oop.globalict.project.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import oop.globalict.project.virus.Virus;
import oop.globalict.project.virus.WithEnvelop;

public class InfectionController{
	private Virus virus = DemonstrationScreen.virus;
	@FXML
	private RadioButton stage1;
	
	@FXML
	private RadioButton stage2;
	
	@FXML
	private RadioButton stage3;
	
	@FXML
	private RadioButton stage4;
	
	@FXML
	private ToggleGroup stages;
	
	@FXML
	private Button start;
	
	@FXML
	private TextArea text;
	
	@FXML
	private ImageView infectionView;
	
	public void setImage(String path) throws IOException{
		Image image = new Image(path);
		infectionView.setImage(image);
	}
	public void setText(String description) throws IOException{
		
		text.setText(description);
		
	}
	
	public void stageLabel() {
		stage1.setText(virus.stage1Label());
		stage2.setText(virus.stage2Label());
		stage3.setText(virus.stage3Label());
		stage4.setText(virus.stage4Label());
		
	}

	public void generalMechanism() {
		try {
			setText(virus.generalMechanism());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnOnAction() throws IOException{
		stageLabel();
		generalMechanism(); 
		stage1.setDisable(false);
		stage2.setDisable(false);
		stage3.setDisable(false);
		if (virus instanceof WithEnvelop)
			stage4.setDisable(false);
		if(stage1.isSelected()) {
			String path = new String(virus.getStage(0).getStageImg());
			setImage(path);			
			setText(virus.getStage(0).getStageDesc());
		}
		else if(stage2.isSelected()) {
			String path = new String(virus.getStage(1).getStageImg());
			setImage(path);			
			setText(virus.getStage(1).getStageDesc());
		}
		else if (stage3.isSelected()) {
			String path = new String(virus.getStage(2).getStageImg());
			setImage(path);			
			setText(virus.getStage(2).getStageDesc());
		}
		else if (stage4.isSelected()) {
			String path = new String(virus.getStage(3).getStageImg());
			setImage(path);			
			setText(virus.getStage(3).getStageDesc());
		}
		
	}
	
	
}
