package oop.globalict.project.virus;

public class WithoutEnvelop extends Virus implements showStructure {
	private static int nbNotEnVirus = 0;
	
	public WithoutEnvelop(String name, String generalImg, String acidDesc, String capsidDesc, String infectionMethod, String otherComponents) {
		super(name, generalImg, acidDesc, capsidDesc, infectionMethod, otherComponents);
		this.id = nbNotEnVirus++;
	}

	public static void setNbNotEnVirus(int nbNotEnVirus) {
		WithoutEnvelop.nbNotEnVirus = nbNotEnVirus;
	}

	@Override
	public String stage1Label() {
		String string = "Attachment";
		return string; 
	}
	
	@Override
	public String stage2Label() {
		String string = "Injection";
		return string; 
	}
	
	@Override
	public String stage3Label() {
		String string = "Duplication";
		return string; 
	}
	
	@Override
	public String stage4Label() {
		String string = "";
		return string; 
	}
	
	@Override
	public String generalMechanism() {
		return "General Mechanism:\n"
				+ "+ Attachment\n"
				+ "+ Injection\n"
				+ "+ Duplication\n";
	}
	
	@Override
	public String generalStructure() {
		return "General Structure:\n"
				+ "+ Capsid\n"
				+ "+ Acid nucleic\n";
	}

	@Override
	public String showStructure(String comName) {
		// TODO Auto-generated method stub
		String componentDesc = "";
		if (comName.contains("Acid")) {
			componentDesc = acidDesc;
		}
		else if (comName.contains("Capsid")) {
			componentDesc = capsidDesc;
		}
		else if (comName.contains("Other")) {
			componentDesc = otherComponents;
		}
		return componentDesc;
	}
	
}
