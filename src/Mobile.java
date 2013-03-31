
public abstract class  Mobile extends Elements {
	
	double [] vitesse = new double [2];
	double [] posapres = new double [2];
	int poids;
	
	public Mobile (String pnom, double[] pposition, Image pimage, double []pvitesse, double []pposapres, int ppoids){
		super(pnom,pposition,pimage);
		vitesse = pvitesse;
		posapres = pposapres;
		poids=ppoids;
		
	
	}
	
	

}
