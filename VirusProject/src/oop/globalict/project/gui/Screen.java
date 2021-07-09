package oop.globalict.project.gui;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Screen extends JFrame {
	public JFXPanel screen() {
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("The world of virus");
		this.setVisible(true);
		this.setSize(896, 672);
		return fxPanel;
	}
}
