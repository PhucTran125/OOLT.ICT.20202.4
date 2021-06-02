package oop.globalict.project.gui;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import oop.globalict.project.storage.VirusStorage;
import oop.globalict.project.virus.Virus;

public class DemonstrationScreen extends JFrame{
	protected static Virus virus;
	protected VirusStorage selected = new VirusStorage();
	protected VirusStorage theOther = new VirusStorage();
	
	public DemonstrationScreen(Virus v,VirusStorage select, VirusStorage other) {
		super();
		this.virus = v;
		this.selected = select;
		this.theOther = other;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		setTitle("Demonstration");
		setVisible(true);
		setSize(896, 672);
			
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/Demonstration.fxml"));
					DemonstrationScreenController controller = new DemonstrationScreenController(v,selected,theOther);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}	catch(IOException e) {
					e.printStackTrace();
				}				
			}
		});	
		
	}
}
