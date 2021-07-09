package oop.globalict.project.gui;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import oop.globalict.project.storage.VirusStorage;
import oop.globalict.project.virus.Stage;
import oop.globalict.project.virus.Virus;
import oop.globalict.project.virus.WithEnvelop;
import oop.globalict.project.virus.WithoutEnvelop;


public class MainScreen extends JFrame {
	private static int state = 0;
	
	public MainScreen(VirusStorage storage, JFXPanel panel) {
		
		if (state == 0) {
			JFXPanel fxPanel = new JFXPanel();
			this.add(fxPanel);
			this.setTitle("The world of virus");
			this.setVisible(true);
			this.setSize(896, 672);
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("new");
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/MainScreen.fxml"));
						MainScreenController controller = new MainScreenController(storage, fxPanel);
						loader.setController(controller);
						Parent root = loader.load();
						fxPanel.setScene(new Scene(root));
						state = 1;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			this.state++;
		}
		else {
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("running");
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/MainScreen.fxml"));
						MainScreenController controller = new MainScreenController(storage, panel);
						loader.setController(controller);
						Parent root = loader.load();
						panel.setScene(new Scene(root));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public static void main(String[] args) {
//		VirusStorage envelopStorage = new VirusStorage();
//		VirusStorage nonEnvelopStorage = new VirusStorage();
		VirusStorage storage = new VirusStorage();
		WithEnvelop.setNbEnVirus(0);
		WithoutEnvelop.setNbNotEnVirus(0);
		//------------------------------------------Corona-----------------------------------
		Virus vr1 = new WithEnvelop("Corona", "/oop/globalict/project/image/corona/corona-Structure.png", "Capsid (Nucleocapsid): protein coat, protect RNA", "RNA (RNA ciral genome): ribonucleic acid, stores genetic data in organization", "Body fluids, mother to child ",
				"Viral envelope: Comprise glycoproteins", "- Glycoproteins(Spike glycoprotein): help the virus identify and bind to its target\n- Membrane: binding proteins of Corona virus\r\n");
		Stage vr1Stage1 = new Stage("/oop/globalict/project/image/corona/corona-stage1.png","Approach the cell:\nWhen Corona virus enter the cell system, Glycoproteins binds to cell surface, then fusion progress occurs with fusion proteins in cell");
		Stage vr1Stage2 = new Stage("/oop/globalict/project/image/corona/corona-stage2.png", "Enter the cell:\nThe Corona virus enters in the cell\n");
		Stage vr1Stage3 = new Stage("/oop/globalict/project/image/corona/corona-stage3.png", "Resolve components: \nCorona virus controls core of the cell and be resolved to viral proteins and RNA");
		Stage vr1Stage4 = new Stage("/oop/globalict/project/image/corona/corona-stage4.png", "Duplication:\nNew Corona viruses, which is the same component with Ebola virus, are released from the cell.");
		
		vr1.addStage(vr1Stage1);
		vr1.addStage(vr1Stage2);
		vr1.addStage(vr1Stage3);
		vr1.addStage(vr1Stage4);
		
		//----------------------------------------HIV---------------------------------------------
		Virus vr2 = new WithEnvelop("HIV", "/oop/globalict/project/image/HIV/HIV-Structure.png", "Capsid (Nucleocapsid): protein coat, protect RNA", "RNA (RNA ciral genome): ribonucleic acid, stores genetic data in organization\n", "Body fluids, air",
				"Viral envelope: comprise glycoproteins", "- Glycoproteins: help the virus identify and bind to its target\r\n- Reverse transcriptase: uses to infect it’s host and replicate\r\n");
		Stage vr2Stage1 = new Stage("/oop/globalict/project/image/HIV/HIV-stage1.png","Approach the cell:\nWhen HIV virus enter the cell system, Glycoproteins binds to cell surface\r\n");
		Stage vr2Stage2 = new Stage("/oop/globalict/project/image/HIV/HIV-stage2.png", "Enter the cell:\nThe HIV virus enters in the cell\n");
		Stage vr2Stage3 = new Stage("/oop/globalict/project/image/HIV/HIV-stage3.png", "Duplication:\nNew HIV viruses, temporarily called type A, which is the same component\n with HIV virus, are released from the cell");
		Stage vr2Stage4 = new Stage("/oop/globalict/project/image/HIV/HIV-stage4.png", "Realease new dangerous virus:\nNew viruses, temporarily called type B,\n which is changed in Glycoproteins, are realeased");
		
		vr2.addStage(vr2Stage1);
		vr2.addStage(vr2Stage2);
		vr2.addStage(vr2Stage3);
		vr2.addStage(vr2Stage4);
				
		//-----------------------------------------Ebola---------------------
		Virus vr3 = new WithEnvelop("Ebola", "/oop/globalict/project/image/ebola/ebola-Structure.png", "Capsid (Nucleoprotein): protein coat, protect RNA", "- RNA (RNA genome): ribonucleic acid, stores genetic data in organization", "Body fluids, animals",
				"Viral envelope: comprise glycoproteins", "- Glycoproteins: help the virus identify and bind to its target\n- VP40, VP24: proteins enable virus reproduction");
		Stage vr3Stage1 = new Stage("/oop/globalict/project/image/ebola/ebola-stage1.png", "Approach the cell:\nWhen Ebola virus enter the cell system, Glycoproteins binds to cell surface");
		Stage vr3Stage2 = new Stage("/oop/globalict/project/image/ebola/ebola-stage2.png", "Enter the cell:\nThe Ebola virus enters in the cell");
		Stage vr3Stage3 = new Stage("/oop/globalict/project/image/ebola/ebola-stage3.png", "Duplication:\nNew ebola viruses, temporarily called type A, which is the same component with ebola virus, are released from the cell");
		Stage vr3Stage4 = new Stage("/oop/globalict/project/image/ebola/ebola-stage4.png", "Realease new dangerous virus:\nNew viruses, temporarily called type B,\n which is changed in Glycoproteins, are realeased");
		
		
		vr3.addStage(vr3Stage1);
		vr3.addStage(vr3Stage2);
		vr3.addStage(vr3Stage3);
		vr3.addStage(vr3Stage4);
				
		//------------------------------------------Rhino----------------------
		Virus vr4 = new WithoutEnvelop("Rhino", "/oop/globalict/project/image/rhino/rhino-Structure.png", "Acid nucleic (RNA or DNA): genetic material, stores genetic data in organization", "Capsid (Protein casing): protein coat, protect acid nucleic", "Air, body fluids", "none");
		Stage vr4Stage1 = new Stage("/oop/globalict/project/image/rhino/rhino-stage1.png", "Attachment:\nRhinovirus particles attach to host cells by binding to specific host cell.");
		Stage vr4Stage2 = new Stage("/oop/globalict/project/image/rhino/rhino-stage2.png", "Injection:\nThe rhinovirus RNA is injected directly into the host cell");
		Stage vr4Stage3 = new Stage("/oop/globalict/project/image/rhino/rhino-stage3.png", "Duplication:\nOut of the host cell, many rhinovirus particles are made, as many as 100000 virions per cell");
		
		vr4.addStage(vr4Stage1);
		vr4.addStage(vr4Stage2);
		vr4.addStage(vr4Stage3);
				
		//------------------------------------------Polio----------------------
		Virus vr5 = new WithoutEnvelop("Polio", "/oop/globalict/project/image/poliovirus/polio-Structure.png", "Acid nucleic (RNA or DNA): genetic material, stores genetic data in organization\n*Vpg: encoded protein, be linked to RNA", "Capsid (Protein casing):  Protein coat, protect acid nucleic","air, mouth", "none");
		Stage vr5Stage1 = new Stage("/oop/globalict/project/image/poliovirus/polio-stage1.png", "Atachment:\nIf the virus finds a cell with the correct receptor, infection begins");
		Stage vr5Stage2 = new Stage("/oop/globalict/project/image/poliovirus/polio-stage2.png", "Injection:\nThe poliovirus genome (RNA) enters the cell");
		Stage vr5Stage3 = new Stage("/oop/globalict/project/image/poliovirus/polio-stage3.png", "Duplication:\nNew RNA and new capsids (shells) create new poliovirus. Thousands of new poliovirus brust out of the cell and into the bloodstream");
		
		vr5.addStage(vr5Stage1);
		vr5.addStage(vr5Stage2);
		vr5.addStage(vr5Stage3);		
		
		//------------------------------------------Parvo----------------------
		Virus vr6 = new WithoutEnvelop("Parvo", "/oop/globalict/project/image/parvo/parvo_Structure.png", "Acid nucleic (RNA or DNA): ribonucleic acid, stores genetic data in organization", "Capsid: protein coat, protect RNA", "Excrement, air", "none");
		Stage vr6Stage1 = new Stage("/oop/globalict/project/image/parvo/parvo-stage1.png", "Atachment:\nParvovirus  attaches to target host cells");
		Stage vr6Stage2 = new Stage("/oop/globalict/project/image/parvo/parvo-stage2.png", "Duplication:\nMany parvovirus are made out of the host cells");
		Stage vr6Stage3 = new Stage("/oop/globalict/project/image/parvo/parvo-stage3.png", "Going to bloodstream:\nParvovirus goes into the bloodstream, and destroy the epithelium, and it can not be recovered");
		
		vr6.addStage(vr6Stage1);
		vr6.addStage(vr6Stage2);
		vr6.addStage(vr6Stage3);
		try {
			storage.addVirus(vr4);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			storage.addVirus(vr5);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			storage.addVirus(vr1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			storage.addVirus(vr2);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			storage.addVirus(vr3);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			storage.addVirus(vr6);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFXPanel panel = new JFXPanel();
		new MainScreen(storage, panel);
	}
}
