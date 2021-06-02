package oop.globalict.project.virus;

public class WithoutEnvelop extends Virus {
	private static int nbNotEnVirus = 0;
	
	public WithoutEnvelop(String name, String generalImg, String acidDesc, String capsidDesc, String infectionMethod) {
		super(name, generalImg, acidDesc, capsidDesc, infectionMethod);
		this.id = nbNotEnVirus++;
	}

	public static void setNbNotEnVirus(int nbNotEnVirus) {
		WithoutEnvelop.nbNotEnVirus = nbNotEnVirus;
	}
}
