package oop.globalict.project.virus;

public class WithEnvelop extends Virus{
	public String envelopDesc;
	private static int nbEnVirus = 0;
	
	public WithEnvelop(String name, String generalImg, String acidDesc, String capsidDesc, String infectionMedthod, String envelopDesc, String otherComponents) {
		super(name, generalImg, acidDesc, capsidDesc, infectionMedthod, otherComponents);
		this.envelopDesc = envelopDesc;
		this.id = nbEnVirus++;
	}

	public String getEnvelopDesc() {
		return envelopDesc;
	}

	public static void setNbEnVirus(int nbEnVirus) {
		WithEnvelop.nbEnVirus = nbEnVirus;
	}

	@Override
	public String stage1Label() {
		String string = "Approaching";
		return string; 
	}
	
	@Override
	public String stage2Label() {
		String string = "Entering";
		return string; 
	}
	
	@Override
	public String stage3Label() {
		String string = "Duplication";
		return string; 
	}
	
	@Override
	public String stage4Label() {
		String string = "Releasing";
		return string; 
	}
	
	@Override
	public String generalMechanism() {
		return "General Mechanism:\n"
				+ "+ Aproaching the sell\n"
				+ "+ Entering the sell\n"
				+ "+ Duplication\n"
				+ "+ Releasing new virus";
	}
	
	@Override
	public String generalStructure() {
		return "General Structure:\n"
				+ "+ Capsid\n"
				+ "+ Acid nucleic\n"
				+ "+ Envelop";
	}
	
}