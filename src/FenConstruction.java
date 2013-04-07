import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenConstruction extends JPanel {
	
	// choix du composant 
	private JPanel choixcompo; // conteneur images composant plus boutons de sélection
	private JButton [] bcompo; //boutons de sélection
	private JButton [] ajouter; // boutons d'ajout
	private PanneauComposant [] compo; //conteneur images composant

	private JPanel construction1; // conteneur boutons d'ajout (en haut)
	private JPanel construction2; // conteneurs boutons d'ajout (en bas)
	private JPanel h[]; // conteneurs images composants du vehicule en cours de construction
	private JPanel ligneh; // conteneurs  des h[]
	
	private JLabel test; // test boucles
	
	private boolean c[]; // mémoire d'appui sur bcompo[]
	
	// boutons "c'est parti!"  et "retour"
	private JButton bjeu;
	private JButton bretour;
	private JPanel boutons;
	
	Composant roue =new CRoue();
	Composant skis = new CSki();
	Composant ailes = new CAiles();
	Composant boost = new CBoost();  
	Vehicule vehicule = new Vehicule ();
	
	public FenConstruction (){
		super();
		// 1)Choix des composants images + boutons
			//Images
		choixcompo = new JPanel ();
		compo = new PanneauComposant [6];
		compo[0] = new PanneauRoue ();	
		compo[1] = new PanneauSki();		
		compo[2] = new PanneauAiles();
		compo[3] = new PanneauBoost();
		compo[4] = new PanneauRoue();
		compo[4].setBackground(Color.YELLOW);
		compo[5]= new PanneauAiles();
		compo[5].setBackground(Color.ORANGE);
		
		/**compo[4] = new JPanel ();
		compo[4].setBackground(Color.YELLOW);
		compo[4].setSize(200,200);
		
		compo[5] = new JPanel ();
		compo[5].setBackground(Color.ORANGE);
		compo[5].setSize(200,200);*/
		

		choixcompo.setLayout(new GridLayout(2,0));
		choixcompo.setBackground(new Color(0,true));
		for(int i =0; i<compo.length;i++){
			choixcompo.add(compo[i]);
		}
		
			//Boutons
		bcompo = new JButton [6];
		bcompo[0] = new JButton (roue.nom);
		bcompo[1] = new JButton (skis.nom);
		bcompo[2] = new JButton (ailes.nom);
		bcompo[3] = new JButton (boost.nom);
		bcompo[4] = new JButton ("compo[4]");
		bcompo[5] = new JButton ("compo[5]");
		
		c = new boolean [bcompo.length];
		
		for(int i=0; i<bcompo.length;i++ ){
			choixcompo.add(bcompo[i]);
			bcompo[i].addActionListener(new ConstructionVehicule());
			c[i]=false;
		}
		
		// Assemblage vehicule
		// a) Selection emplacement piece
		construction1 = new JPanel();
		construction1.setLayout(new GridLayout());
		construction1.setBackground(new Color(0,true));
		construction2 = new JPanel();
		construction2.setLayout(new GridLayout(1,0));
		construction2.setBackground(new Color(0,true));
		
		ajouter= new JButton[6];
		
		/** affiche la première moitié des boutons au dessus de l'image du véhicule ==> construction1
		 * 		    la deuxième moitié des boutons en dessous de l'image du véhcule ==> construction2
		 */
		
		for(int i=0; i<ajouter.length/2; i++){ 
			ajouter[i] = new JButton("Ajouter");
			construction1.add(ajouter[i]);
			ajouter[i].addActionListener(new AffichageVehicule());
		}
		
		for(int i=ajouter.length/2; i<ajouter.length;i++){
			ajouter[i] = new JButton("Ajouter");
			construction2.add(ajouter[i]);
			ajouter[i].addActionListener(new AffichageVehicule());
		}
		
		//b) Positionnement pieces
		ligneh = new JPanel();
		h = new JPanel [6];
		ligneh.setLayout(new GridLayout(2,0));
		for(int i=0; i<h.length;i++){
			h[i]=new JPanel();
			h[i].setBackground(new Color (0,true));	
			ligneh.add(h[i]);
		}
		
		ligneh.setBackground(Color.GRAY);
		
		
		
		// 2) boutons jeu et retour
		bjeu = new JButton("C'est parti!");
		bjeu.addActionListener(new AppuiBouton());
		bretour = new JButton("Retour");
		bretour.addActionListener(new AppuiBouton());
		boutons = new JPanel();
		boutons.setLayout(new FlowLayout());
		boutons.add(bjeu);
		boutons.add(bretour);
		boutons.setBackground(new Color(0,true));
		
		// Test
		test = new JLabel(); 
		test.setSize(100,100);
		
		// 3) Agencement global
		JPanel p = new JPanel ();
		p.setLayout(new GridLayout(0,1));
		p.add(choixcompo);
		p.add(construction1);
		p.add(ligneh);
		p.add(construction2);
		p.add(boutons);
		p.add(test);
		this.add(p);		
		this.setVisible(true);
	}
	class AppuiBouton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==bretour){
				test.setText("retour");
			}
			if(e.getSource()==bjeu){
				test.setText("c'est parti!");
			}
		}
	}
	
	class ConstructionVehicule implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<c.length; i++){
				c[i]=false;
			}
			for(int i=0; i<c.length; i++){
				if((e.getSource()==bcompo[i])&&!c[i]){
					vehicule.addcomposant(compo[i].composant);
					c[i]=true;
					test.setText("t'es une machine"+" " + vehicule.poids+" "+c[i]+" "+c[3]);
					
				}
			}
	}
	}
	class AffichageVehicule implements ActionListener{
		public void actionPerformed(ActionEvent e){
			for(int i=0; i<ajouter.length; i++){
				if(e.getSource()==ajouter[i]){
					h[i].removeAll();
					for(int j=0; j<c.length;j++){
						if(c[j]){
							h[i].add(compo[i]);
							test.setText("ajout"+ compo[i].composant.nomimage);}
					}
				}
			}
		}
	}


public static void main(String[] args) {
    FenConstruction uneFenetre = new FenConstruction();
}

}
			
		
		
	