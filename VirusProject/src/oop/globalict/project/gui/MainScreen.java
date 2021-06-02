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
import oop.globalict.project.virus.WithEnvelop;
import oop.globalict.project.virus.WithoutEnvelop;


public class MainScreen extends JFrame {
	protected static VirusStorage storage1;
	protected static VirusStorage storage2;
	
	public MainScreen(VirusStorage storage1, VirusStorage storage2) {
		super();
		this.storage1 = storage1;
		this.storage2 = storage2;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("The world of virus");
		this.setVisible(true);
		this.setSize(896, 672);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/MainScreen.fxml"));
					MainScreenController controller = new MainScreenController(storage1,storage2);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		VirusStorage envelopStorage = new VirusStorage();
		VirusStorage nonEnvelopStorage = new VirusStorage();
		WithEnvelop.setNbEnVirus(0);
		WithoutEnvelop.setNbNotEnVirus(0);
		//------------------------------------------Corona-----------------------------------
		WithEnvelop vr1 = new WithEnvelop("Corona", "/oop/globalict/project/image/corona/corona-Structure.png", "Capsid (Nucleocapsid): protein coat, protect RNA", "RNA (RNA ciral genome): ribonucleic acid, stores genetic data in organization", "Body fluids, mother to child ",
				"- Viral envelope: Comprise glycoproteins\n- Glycoproteins(Spike glycoprotein): help the virus identify and bind to its target\n- Membrane: binding proteins of Corona virus\r\n");
		Stage vr1Stage1 = new Stage("/oop/globalict/project/image/corona/corona-stage1.png","Approach the cell:\nWhen Corona virus enter the cell system, Glycoproteins binds to cell surface, then fusion progress occurs with fusion proteins in cell");
		Stage vr1Stage2 = new Stage("/oop/globalict/project/image/corona/corona-stage2.png", "Enter the cell:\nThe Corona virus enters in the cell\n");
		Stage vr1Stage3 = new Stage("/oop/globalict/project/image/corona/corona-stage3.png", "Resolve components: \nCorona virus controls core of the cell and be resolved to viral proteins and RNA");
		Stage vr1Stage4 = new Stage("/oop/globalict/project/image/corona/corona-stage4.png", "Duplication:\nNew Corona viruses, which is the same component with Ebola virus, are released from the cell.");
		
		vr1.addStage(vr1Stage1);
		vr1.addStage(vr1Stage2);
		vr1.addStage(vr1Stage3);
		vr1.addStage(vr1Stage4);
		
		//----------------------------------------HIV---------------------------------------------
		WithEnvelop vr2 = new WithEnvelop("HIV", "/oop/globalict/project/image/HIV/HIV-Structure.png", "Capsid (Nucleocapsid): protein coat, protect RNA", "RNA (RNA ciral genome): ribonucleic acid, stores genetic data in organization\n - Reverse transcriptase: uses to infect it’s host and replicate", "Body fluids, air",
										  "- Viral envelope: comprise glycoproteins \n- Glycoproteins: help the virus identify and bind to its target\r\n");
		Stage vr2Stage1 = new Stage("/oop/globalict/project/image/HIV/HIV-stage1.png","Approach the cell:\nWhen HIV virus enter the cell system, Glycoproteins binds to cell surface\r\n");
		Stage vr2Stage2 = new Stage("/oop/globalict/project/image/HIV/HIV-stage2.png", "Enter the cell:\nThe HIV virus enters in the cell\n");
		Stage vr2Stage3 = new Stage("/oop/globalict/project/image/HIV/HIV-stage3.png", "Duplication:\nNew HIV viruses, temporarily called type A, which is the same component\n with HIV virus, are released from the cell");
		Stage vr2Stage4 = new Stage("/oop/globalict/project/image/HIV/HIV-stage4.png", "Realease new dangerous virus:\nNew viruses, temporarily called type B,\n which is changed in Glycoproteins, are realeased");
		
		vr2.addStage(vr2Stage1);
		vr2.addStage(vr2Stage2);
		vr2.addStage(vr2Stage3);
		vr2.addStage(vr2Stage4);
				
		//-----------------------------------------Ebola---------------------
		WithEnvelop vr3 = new WithEnvelop("Ebola", "/oop/globalict/project/image/ebola/ebola-Structure.png", "Capsid (Nucleoprotein): protein coat, protect RNA", "- RNA (RNA genome): ribonucleic acid, stores genetic data in organization", "Body fluids, animals",
				"- Viral envelope: comprise glycoproteins\n- Glycoproteins: help the virus identify and bind to its target");
		Stage vr3Stage1 = new Stage("/oop/globalict/project/image/ebola/ebola-stage1.png", "Approach the cell:\nWhen Ebola virus enter the cell system, Glycoproteins binds to cell surface");
		Stage vr3Stage2 = new Stage("/oop/globalict/project/image/ebola/ebola-stage2.png", "Enter the cell:\nThe Ebola virus enters in the cell");
		Stage vr3Stage3 = new Stage("/oop/globalict/project/image/ebola/ebola-stage3.png", "Duplication:\nNew ebola viruses, temporarily called type A, which is the same component with ebola virus, are released from the cell");
		Stage vr3Stage4 = new Stage("/oop/globalict/project/image/ebola/ebola-stage4.png", "Realease new dangerous virus:\nNew viruses, temporarily called type B,\n which is changed in Glycoproteins, are realeased");
		
		
		vr3.addStage(vr3Stage1);
		vr3.addStage(vr3Stage2);
		vr3.addStage(vr3Stage3);
		vr3.addStage(vr3Stage4);
				
		//------------------------------------------Rhino----------------------
		WithoutEnvelop vr4 = new WithoutEnvelop("Rhino", "/oop/globalict/project/image/rhino/rhino-Structure.png", "Acid nucleic (RNA or DNA): genetic material, stores genetic data in organization", "Capsid (Protein casing): protein coat, protect acid nucleic", "Air, body fluids");
		Stage vr4Stage1 = new Stage("/oop/globalict/project/image/rhino/rhino-stage1.png", "Attachment:\nRhinovirus particles attach to host cells by binding to specific host cell.");
		Stage vr4Stage2 = new Stage("/oop/globalict/project/image/rhino/rhino-stage2.png", "injection:\nThe rhinovirus RNA is injected directly into the host cell");
		Stage vr4Stage3 = new Stage("/oop/globalict/project/image/rhino/rhino-stage3.png", "Duplication:\nOut of the host cell, many rhinovirus particles are made, as many as 100000 virions per cell");
		
		vr4.addStage(vr4Stage1);
		vr4.addStage(vr4Stage2);
		vr4.addStage(vr4Stage3);
				
		//------------------------------------------Polio----------------------
		WithoutEnvelop vr5 = new WithoutEnvelop("Polio", "/oop/globalict/project/image/poliovirus/polio-Structure.png", "Acid nucleic (RNA or DNA): genetic material, stores genetic data in organization\n*Vpg: encoded protein, be linked to RNA", "Capsid (Protein casing):  Protein coat, protect acid nucleic","air, mouth");
		Stage vr5Stage1 = new Stage("/oop/globalict/project/image/poliovirus/polio-stage1.png", "Atachment:\nIf the virus finds a cell with the correct receptor, infection begins");
		Stage vr5Stage2 = new Stage("/oop/globalict/project/image/poliovirus/polio-stage2.png", "Injection:\nThe poliovirus genome (RNA) enters the cell");
		Stage vr5Stage3 = new Stage("/oop/globalict/project/image/poliovirus/polio-stage3.png", "Duplication:\nNew RNA and new capsids (shells) create new poliovirus. Thousands of new poliovirus brust out of the cell and into the bloodstream");
		
		vr5.addStage(vr5Stage1);
		vr5.addStage(vr5Stage2);
		vr5.addStage(vr5Stage3);		
		
		try {
			nonEnvelopStorage.addVirus(vr4);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			nonEnvelopStorage.addVirus(vr5);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			envelopStorage.addVirus(vr1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			envelopStorage.addVirus(vr2);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			envelopStorage.addVirus(vr3);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MainScreen(envelopStorage, nonEnvelopStorage);
	}
}
