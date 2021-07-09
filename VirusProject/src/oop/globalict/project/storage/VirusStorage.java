package oop.globalict.project.storage;

import javax.naming.LimitExceededException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oop.globalict.project.virus.Virus;

public class VirusStorage {
	public static final int MAX_VIRUS_STORAGE = 20;
	private ObservableList<Virus> storage = FXCollections.observableArrayList();
	
	public void addVirus(Virus virus) throws LimitExceededException {
		if (storage.size() < MAX_VIRUS_STORAGE) {
			storage.add(virus);
			System.out.println("Add virus successfully!");
		}
		else {
			throw new LimitExceededException("ERROR: The number of virus has reached its limit");
		}
	}
	
	public ObservableList<Virus> getVirus() {
		return storage;
	}
	
	public Virus getVirus(int i) {
		return storage.get(i);
	}
}
