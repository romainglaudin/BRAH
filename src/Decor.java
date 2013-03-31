
public class Decor extends Immobile {
	
	Image noirblanc = new Image();
	String revetement;
	int kre;
	
	public Decor (String pnom, double [] pposition,Image pimage,String prevetement, int pkre){
		super(pnom,pposition,pimage);
		revetement = prevetement;
		kre=pkre;
		
	}

}
