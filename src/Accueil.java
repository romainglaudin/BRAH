import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
  
public class Accueil extends JFrame {
	
public Accueil(){
    this.setTitle("BRAH");
    this.setSize(800,600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Panneau P = new Panneau ();
    this.setContentPane(P);
    
    BoutonJouer jouer=new BoutonJouer("");
    jouer.setPreferredSize(new Dimension(200, 80));
    jouer.setBorderPainted(false);
    BoutonShop shop=new BoutonShop("");
    shop.setPreferredSize(new Dimension(200, 80));
    shop.setBorderPainted(false);
    BoutonQuitter quitter=new BoutonQuitter("");
    quitter.setPreferredSize(new Dimension(200, 80));
    quitter.setBorderPainted(false);
    
    JPanel p1 = new JPanel();
    p1.add(jouer);
    p1.setBackground(null);
    JPanel p2 = new JPanel();
    p2.add(shop);
    JPanel p3 = new JPanel();
    p3 = new JPanel();
    p3.add(quitter);
    
    JPanel pbouton = new JPanel();
    pbouton.setBackground(null);
    pbouton.setBackground(null);
    //On définit le layout manager
    GridBagLayout gbl = new GridBagLayout();
    pbouton.setLayout(gbl);
         
    //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
         
    //On positionne la case de départ du composant
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    pbouton.add(p1, gbc);
    //---------------------------------------------
    gbc.gridy = 1;
    pbouton.add(p2, gbc);
    //---------------------------------------------
    gbc.gridy = 2;      
    pbouton.add(p3, gbc);
    
    this.setLayout(new BorderLayout());
    this.getContentPane().add(pbouton, BorderLayout.EAST);
    this.setVisible(true);
  }  
  
  public static void main(String[] args) {
      new Accueil();
  }
  
}