package oop.globalict.project.gui;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import oop.globalict.project.storage.VirusStorage;

public class ChoosingScreen  extends JFrame{
	private VirusStorage selectedStorage;
	private VirusStorage anotherStorage;
	
	public ChoosingScreen(VirusStorage upperStorage, VirusStorage anoterStorage) {
		super();
		this.selectedStorage = upperStorage;
		this.anotherStorage = anoterStorage;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Choosing Virus");
		this.setVisible(true);
		this.setSize(896, 672);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/ChoosingVirus.fxml"));
					ChoosingScreenController controller = new ChoosingScreenController(selectedStorage, anotherStorage);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
