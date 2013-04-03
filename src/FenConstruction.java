import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenConstruction extends Fenetre {
	
	private JPanel choixcompo;
	private JButton bjeu;
	private JButton bretour;
	private JButton bcompo1;
	private JButton bcompo2;
	private JButton bcompo3;
	private JButton bcompo4;
	private JButton bcompo5;
	private JButton bcompo6;
	private JButton ajouter1;
	private JButton ajouter2;
	private JButton ajouter3;
	private JButton ajouter4;
	private JButton ajouter5;
	private JButton ajouter6;
	private JPanel compo5;
	private JPanel compo6;
	private JPanel boutons;
	private JPanel hg;
	private JPanel h;
	private JPanel hd;
	private JPanel bg;
	private JPanel b;
	private JPanel bd;
	private JPanel ligneh;
	private JPanel ligneb;
	private JLabel test;
	private JPanel bchoixcompo;
	private JPanel construction1;
	private JPanel construction2;
	private boolean c1 = false;
	private boolean c2 = false;
	private boolean c3 = false;
	private boolean c4 = false;
	private boolean c5 = false;
	private boolean c6 = false;
	Composant roue =new CRoue();
	Composant skis = new CSki();
	Composant ailes = new CAiles();
	Composant boost = new CBoost();  
	Vehicule vehicule = new Vehicule ();
	
	public FenConstruction (){
		super();
		
		JPanel cadre = new JPanel ();
		
		// 1)Choix des composants images + boutons
			//Images
		choixcompo = new JPanel ();
		
		PanneauRoue compo1 = new PanneauRoue ();
		
		PanneauSki compo2 = new PanneauSki();
		
		PanneauAiles compo3 = new PanneauAiles();
		
		PanneauBoost compo4 = new PanneauBoost();
		
		compo5 = new JPanel ();
		compo5.setBackground(Color.YELLOW);
		compo5.setSize(200,200);
		
		compo6 = new JPanel ();
		compo6.setBackground(Color.ORANGE);
		compo6.setSize(200,200);
		

		choixcompo.setLayout(new GridLayout(1,0));
		choixcompo.setBackground(new Color(0,true));
		choixcompo.add(compo1);
		choixcompo.add(compo2);
		choixcompo.add(compo3);
		choixcompo.add(compo4);
		choixcompo.add(compo5);
		choixcompo.add(compo6);
		
			//Boutons
		bchoixcompo = new JPanel();
		bchoixcompo.setLayout(new FlowLayout());
		bchoixcompo.setBackground(new Color(0,true));
		bcompo1 = new JButton (roue.nom);
		bcompo2 = new JButton (skis.nom);
		bcompo3 = new JButton (ailes.nom);
		bcompo4 = new JButton (boost.nom);
		bcompo5 = new JButton ("compo5");
		bcompo6 = new JButton ("compo6");
		
		bchoixcompo.add(bcompo1);
		bchoixcompo.add(bcompo2);
		bchoixcompo.add(bcompo3);
		bchoixcompo.add(bcompo4);
		bchoixcompo.add(bcompo5);
		bchoixcompo.add(bcompo6);
		bcompo1.addActionListener(new ConstructionVehicule());
		bcompo2.addActionListener(new ConstructionVehicule());
		bcompo3.addActionListener(new ConstructionVehicule());
		bcompo4.addActionListener(new ConstructionVehicule());
		bcompo5.addActionListener(new ConstructionVehicule());
		bcompo6.addActionListener(new ConstructionVehicule());
		
		// Assemblage vehicule
		// a) Selection emplacement piece
		construction1 = new JPanel();
		construction1.setLayout(new GridLayout(1,0));
		construction1.setBackground(new Color(0,true));
		construction2 = new JPanel();
		construction2.setLayout(new GridLayout(1,0));
		construction2.setBackground(new Color(0,true));
		
		ajouter1 = new JButton("Ajouter");
		ajouter2 = new JButton("Ajouter");
		ajouter3 = new JButton("Ajouter");
		construction1.add(ajouter1);
		construction1.add(ajouter2);
		construction1.add(ajouter3);
		
		ajouter4 = new JButton("Ajouter");
		ajouter5 = new JButton("Ajouter");
		ajouter6 = new JButton("Ajouter");
		construction2.add(ajouter4);
		construction2.add(ajouter5);
		construction2.add(ajouter6);
		
		ajouter1.addActionListener(new AffichageVehicule());
		ajouter2.addActionListener(new AffichageVehicule());
		ajouter3.addActionListener(new AffichageVehicule());
		ajouter4.addActionListener(new AffichageVehicule());
		ajouter5.addActionListener(new AffichageVehicule());
		ajouter6.addActionListener(new AffichageVehicule());
		
		//b) Positionnement pieces
		ligneh = new JPanel();
		ligneb= new JPanel();
		hg = new JPanel(); h = new JPanel(); hd = new JPanel(); bg = new JPanel(); b = new JPanel(); bd = new JPanel();
		ligneh.setLayout(new GridLayout(1,0));
		ligneb.setLayout(new GridLayout(1,0));
		ligneh.setBackground(new Color(0,true));
		ligneb.setBackground(new Color(0,true));
		h.setBackground(new Color(0,true));
		hg.setBackground(new Color(0,true));
		hd.setBackground(new Color(0,true));
		b.setBackground(new Color(0,true));
		bg.setBackground(new Color(0,true));
		bd.setBackground(new Color(0,true));
		ligneh.add(hg);
		ligneh.add(h);
		ligneh.add(hd);
		ligneb.add(bg);
		ligneb.add(b);
		ligneb.add(bd);
		
		
		
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
		Panneau p = new Panneau ();
		p.setLayout(new GridLayout(0,1));
		p.add(choixcompo);
		p.add(bchoixcompo);
		p.add(construction1);
		p.add(ligneh);
		p.add(ligneb);
		p.add(construction2);
		p.add(boutons);
		p.add(test);
		this.setContentPane(p);		
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
			if(e.getSource()==bcompo1){
				vehicule.addcomposant(roue);
				test.setText("t'es une machine"+" " + vehicule.poids);
				c1=true;
				c2=false; c3=false; c4=false; c5=false; c6=false;
			}
			if(e.getSource()==bcompo2){
				vehicule.addcomposant(skis);
				test.setText("t'es une machine2"+" "+vehicule.poids);
				c2=true;
				c1=false; c3=false; c4=false; c5=false; c6=false;
			}
			if(e.getSource()==bcompo3){
				vehicule.addcomposant(ailes);
				test.setText("t'es une machine3"+" "+vehicule.poids);
				c3=true;
				c2=false; c1=false; c4=false; c5=false; c6=false;
			}
			if(e.getSource()==bcompo4){
				vehicule.addcomposant(boost);
				test.setText("t'es une machine4"+" "+vehicule.poids);
				c4=true;
				c2=false; c3=false; c1=false; c5=false; c6=false;
			}
			if(e.getSource()==bcompo5){
				test.setText("t'es une machine5");
				c5=true;
				c2=false; c3=false; c4=false; c1=false; c6=false;
			}
			if(e.getSource()==bcompo6){
				test.setText("t'es une machine6");
				c6=true;
				c2=false; c3=false; c4=false; c5=false; c1=false;
			}
	}
	}
	class AffichageVehicule implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==ajouter1){
				hg.removeAll();
				if(c1){
					PanneauRoue roue = new PanneauRoue();
					hg.add(roue);
					test.setText("ajout roue");}
				if(c2){
					PanneauSki ski = new PanneauSki();
					hg.add(ski);
					test.setText("ajout skis");}
				if(c3){
					PanneauAiles ailes = new PanneauAiles();
					hg.add(ailes);
					test.setText("ajout ailes");}
				if(c4){
					PanneauBoost boost = new PanneauBoost();
					hg.add(boost);
					test.setText("ajout boost");}
				if(c5){}
				if(c6){}
			}
			if(e.getSource()==ajouter2){
					h.removeAll();
					if(c1){
						PanneauRoue roue = new PanneauRoue();
						h.add(roue);
						test.setText("ajout roue");}
					if(c2){
						PanneauSki ski = new PanneauSki();
						h.add(ski);
						test.setText("ajout skis");}
						
					if(c3){
						PanneauAiles ailes = new PanneauAiles();
						h.add(ailes);
						test.setText("ajout ailes");}
					if(c4){
						PanneauBoost boost = new PanneauBoost();
						h.add(boost);
						test.setText("ajout ailes");}
					if(c5){}
					if(c6){}
			}	if(e.getSource()==ajouter3){
						hd.removeAll();
						if(c1){
							PanneauRoue roue = new PanneauRoue();
							hd.add(roue);
							test.setText("ajout roue");}
					if(c2){
						PanneauSki ski = new PanneauSki();
						hd.add(ski);
						test.setText("ajout skis");}
						
					if(c3){
						PanneauAiles ailes = new PanneauAiles();
						hd.add(ailes);
						test.setText("ajout ailes");}
					if(c4){
						PanneauBoost boost = new PanneauBoost();
						hd.add(boost);
						test.setText("ajout ailes");}
					if(c5){}
					if(c6){}
			}	if(e.getSource()==ajouter4){
						bg.removeAll();
						if(c1){
							PanneauRoue roue = new PanneauRoue();
							bg.add(roue);
							test.setText("ajout roue");}
					if(c2){
						PanneauSki ski = new PanneauSki();
						bg.add(ski);
						test.setText("ajout skis");}
						
					if(c3){
						PanneauAiles ailes = new PanneauAiles();
						bg.add(ailes);
						test.setText("ajout ailes");}
					if(c4){
						PanneauBoost boost = new PanneauBoost();
						bg.add(boost);
						test.setText("ajout ailes");}
					if(c5){}
					if(c6){}
			}	if(e.getSource()==ajouter5){
					b.removeAll();
					if(c1){
						PanneauRoue roue = new PanneauRoue();
						b.add(roue);
						test.setText("ajout roue");}
					if(c2){
						PanneauSki ski = new PanneauSki();
						b.add(ski);
						test.setText("ajout skis");}
						
					if(c3){
						PanneauAiles ailes = new PanneauAiles();
						b.add(ailes);
						test.setText("ajout ailes");}
					if(c4){
						PanneauBoost boost = new PanneauBoost();
						b.add(boost);
						test.setText("ajout ailes");}
					if(c5){}
					if(c6){}
			}
			if(e.getSource()==ajouter6){
					bd.removeAll();
					if(c1){
						PanneauRoue roue = new PanneauRoue();
						bd.add(roue);
						test.setText("ajout roue");}
					if(c2){
						PanneauSki ski = new PanneauSki();
						bd.add(ski);
						test.setText("ajout skis");}
						
					if(c3){
						PanneauAiles ailes = new PanneauAiles();
						bd.add(ailes);
						test.setText("ajout ailes");}
					if(c4){
						PanneauBoost boost = new PanneauBoost();
						bd.add(boost);
						test.setText("ajout ailes");}
					if(c5){}
					if(c6){}
			}
		
		}
	
	}

public static void main(String[] args) {
    FenConstruction uneFenetre = new FenConstruction();
}

}
			
		
		
	