import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
  
public class Accueil extends JFrame implements ActionListener{
	
	Panneau P = new Panneau ();
	JPanel Pactif = new JPanel ();
	
public Accueil() throws InterruptedException{
    this.setTitle("BRAH");
    this.setSize(800,600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(P);
    
    Bouton jouer=new Bouton("", "image/Jouer.png", "image/Jouer_souris.png", "image/Jouer_clic.png",0);
    jouer.setPreferredSize(new Dimension(200, 80));
    jouer.setBorderPainted(false);
    Bouton shop=new Bouton("", "image/Shop.png", "image/Shop_souris.png", "image/Shop_clic.png",1);
    shop.setPreferredSize(new Dimension(200, 80));
    shop.setBorderPainted(false);
    Bouton quitter =new Bouton("", "image/Quitter.png", "image/Quitter_souris.png", "image/QUitter_clic.png",2);
    quitter.setPreferredSize(new Dimension(200, 80));
    quitter.setBorderPainted(false);
    
    JPanel [] p = new JPanel[3];
    for (int i=0 ; i<3 ; i++){
    p[i]= new JPanel();
    p[i].setBackground(null);
    }
    
    p[0].add(jouer);
    p[1].add(shop);
    p[2].add(quitter);
    
    JPanel pbouton = new JPanel();
    //On définit le layout manager
    GridBagLayout gbl = new GridBagLayout();
    pbouton.setLayout(gbl);
         
    //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
         
    //On positionne la case de départ du composant
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    pbouton.add(p[0], gbc);
    //---------------------------------------------
    gbc.gridy = 1;
    pbouton.add(p[1], gbc);
    //---------------------------------------------
    gbc.gridy = 2;      
    pbouton.add(p[2], gbc);
    
    pbouton.setBackground(new Color(0,true));
    
    this.setLayout(new BorderLayout());
    this.add(pbouton, BorderLayout.EAST);
    this.setVisible(true);
    go();
    
    
    
  }  

	public void go() throws InterruptedException {
		P.defNuage();
		int [] x = P.GetXNuage();
		
		while (true){
			for(int i=0; i<P.nbrNuage;i++){
				if(i!=0){
					x[i]=x[i]+i;
				}
				else
					x[i]++;
			P.SetXNuage(x);
			Thread.sleep(5);
			P.repaint();
			if(x[i]-20>P.getWidth()){
				x[i]=-100;
			}
			
			}
		}
		
	}
	

  
	public static void main(String[] args) throws InterruptedException {
		new Accueil();
	}

	@Override
	public void actionPerformed(ActionEvent Event) {
		
		
	}
  
}