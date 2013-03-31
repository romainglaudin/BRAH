
public  abstract class Composant extends Mobile{
	
	double [] ptassemblage = new double [2];
	
	public Composant (String pnom,  double[] pposition,Image pimage,double[] pvitesse,double[] pposapres, double [] pptassemblage, int ppoids){
		super(pnom,pposition,pimage,pvitesse,pposapres, ppoids);
		ptassemblage = pptassemblage;
	}

}
