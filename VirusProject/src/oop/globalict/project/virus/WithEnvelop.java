package oop.globalict.project.virus;

public class WithEnvelop extends Virus{
	public String envelopDesc;
	private static int nbEnVirus = 0;
	
	public WithEnvelop(String name, String generalImg, String acidDesc, String capsidDesc, String infectionMedthod, String envelopDesc) {
		super(name, generalImg, acidDesc, capsidDesc, infectionMedthod);
		this.envelopDesc = envelopDesc;
		this.id = nbEnVirus++;
	}

	public String getEnvelopDesc() {
		return envelopDesc;
	}

	public static void setNbEnVirus(int nbEnVirus) {
		WithEnvelop.nbEnVirus = nbEnVirus;
	}
}