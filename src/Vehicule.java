
public class Vehicule extends Mobile {
	
	public boolean perso;
	Image noirblanc = new Image();
	
	public Vehicule (String pnom, double[] pposition,Image pimage,double[] pvitesse,double[] pposapres,int ppoids, Image pnoirblanc){
		super(pnom,pposition,pimage,pvitesse,pposapres,ppoids);
		noirblanc = pnoirblanc;
		perso= false;
			
	}
	
	public void addperso (Perso perso){
		// test presence perso
		this.perso=true;
		
		//centre du perso = centre du vehicule
		perso.position[0]=this.position[0];
		perso.position[1]=this.position[1];
		
		perso.posapres[0]=this.posapres[0];
		perso.posapres[1]=this.posapres[1];				
	}
	

	
	public void addcomposant (Composant compo){
		double decalx = 10;  // valeur d'espace entre les composant en x
		double decaly = 10;  // valeur d'espace entre les composant en y
		
		// le centre du vehicule et du composant espacés de valeur constantes
		compo.position[0]=this.position[0]+decalx;    
		compo.position[1]=this.position[1]+decaly;   
		
		compo.posapres[0]=this.posapres[0]+decalx;
		compo.posapres[1]=this.posapres[1]+decaly;
		
		
		//on ajoute au vehicule le poids du compo
		this.poids=this.poids+compo.poids; 		
	}
	
	
	
	
	
	
	
	

}
