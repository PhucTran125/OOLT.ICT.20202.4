package oop.globalict.project.gui;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import oop.globalict.project.storage.VirusStorage;
import oop.globalict.project.virus.Virus;
import oop.globalict.project.virus.WithEnvelop;
import oop.globalict.project.virus.WithoutEnvelop;

public class ChoosingScreen  extends JFrame{
	
	public ChoosingScreen(VirusStorage storage, String type, JFXPanel fxPanel) {
		VirusStorage tmpStorage = new VirusStorage();
		if (type.equals("WithEnvelop")) {
			for (Virus virus: storage.getVirus()) {
				if (virus instanceof WithEnvelop) {
					try {
						tmpStorage.addVirus(virus);
					} catch (LimitExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		if (type.equals("WithoutEnvelop")) {
			for (Virus virus: storage.getVirus()) {
				if (virus instanceof WithoutEnvelop) {
					try {
						tmpStorage.addVirus(virus);
					} catch (LimitExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/ChoosingVirus.fxml"));
					ChoosingScreenController controller = new ChoosingScreenController(tmpStorage, storage, type, fxPanel);
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
