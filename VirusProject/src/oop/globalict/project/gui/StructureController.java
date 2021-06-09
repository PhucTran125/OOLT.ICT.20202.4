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

public class StructureController {
	private Virus virus = DemonstrationScreen.virus;
	
	@FXML
	private Button start;
	
    @FXML
    private RadioButton nucleic;

    @FXML
    private ImageView structureView;

    @FXML
    private RadioButton capsid;

    @FXML
    private RadioButton envelop;
    
    @FXML
    private RadioButton otherComponents;
    
    @FXML 
    private ToggleGroup selections;

    @FXML
    private TextArea structureDesc;

	public void setImage(String path) throws IOException{
		Image image = new Image(path);
		structureView.setImage(image);
	
	}
	public void setText(String description) throws IOException{
		
		structureDesc.setText(description);
		
	}

	public void generalStructure() {
		try {
			setText(virus.generalStructure());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnOnAction() throws IOException{
		
		generalStructure();
		capsid.setDisable(false);
		nucleic.setDisable(false);
		if (virus instanceof WithEnvelop)
			envelop.setDisable(false);
		if (virus.getOtherComponents() != "none") otherComponents.setDisable(false);
		String path = new String(virus.getGeneralImage());
		setImage(path);		
		if(capsid.isSelected()) {
				
			setText(virus.getCapsidDesc());
		}
		else if(nucleic.isSelected()) {
			setText(virus.getAcidDesc());
		}
		else if (envelop.isSelected()) {
			WithEnvelop tmp = (WithEnvelop)virus;
			setText(tmp.getEnvelopDesc());
		}
		else if (otherComponents.isSelected()) {
			WithEnvelop tmp = (WithEnvelop)virus;
			setText(tmp.getOtherComponents());
		}
	}
}
