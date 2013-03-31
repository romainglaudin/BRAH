
public abstract class Elements {
	
	double [] position = new double [2];
	String nom;
	String nomimage;
	Image image = new Image(nomimage);
	
	public Elements (String pnom, double [] pposition, Image pimage){
		position = pposition; 			
		nom = pnom;
		image = pimage;
	}
	
	public Elements (String pnom, double [] pposition){
		position = pposition; 			
		nom = pnom;
	}
	

}
