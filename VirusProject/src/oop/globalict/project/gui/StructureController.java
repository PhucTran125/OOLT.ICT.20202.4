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
	@FXML
	public void btnOnAction() throws IOException{
		
		if(virus instanceof WithEnvelop)
			setText("General Structure:\n"
					+ "+ Capsid\n"
					+ "+ Acid nucleic\n"
					+ "+ Envelop");
		else setText("General Structure:\n"
					+ "+ Capsid\n"
					+ "+ Acid nucleic");
		capsid.setDisable(false);
		nucleic.setDisable(false);
		if (virus instanceof WithEnvelop)
			envelop.setDisable(false);
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
	}
}
