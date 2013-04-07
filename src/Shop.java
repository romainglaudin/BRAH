import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Shop extends JPanel{
	
	private JButton [] bcompo; //boutons de sélection
	
	Composant roue =new CRoue();
	Composant skis = new CSki();
	Composant ailes = new CAiles();
	Composant boost = new CBoost();
	final Font bfont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	
	public void paintComponent(Graphics g){
		 
			try {
		      BufferedImage fond = ImageIO.read(new File("image/im_shop.png"));
		      g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		    }
     		catch (IOException e) {
		      e.printStackTrace();
     		}       
		  }
	 
	public Shop () {
		 
		//Boutons
		bcompo = new JButton [6];
		bcompo[0] = new JButton (roue.nom);
		bcompo[1] = new JButton (skis.nom);
		bcompo[2] = new JButton (ailes.nom);
		bcompo[3] = new JButton (boost.nom);
		bcompo[4] = new JButton ("Corbato");
		bcompo[5] = new JButton ("Autre");
		
		for (int i=0 ; i<bcompo.length ; i++){
			bcompo[i].setPreferredSize(new Dimension(120,80));
			bcompo[i].setBorderPainted(false);
			bcompo[i].setContentAreaFilled(false);
			bcompo[i].setFont(bfont);
			bcompo[i].setBackground(new Color(0,true));
			bcompo[i].addActionListener(new Bcompolisten(this));
		}
			
	         
	    //Le conteneur principal
	    JPanel content = new JPanel();
	    content.setBackground(new Color(0,true));
	    this.setLayout(new BorderLayout());
	    this.add(content, BorderLayout.WEST);
	    //On définit le layout manager
	    content.setLayout(new GridBagLayout());
	         
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    for(int i=0;i<bcompo.length;i++){
	    	gbc.gridy = i;
	    	content.add(bcompo[i],gbc);
	    }
	    
	    //On ajoute le conteneur
	    this.add(content, BorderLayout.WEST);
	    this.setVisible(true);
			 
	 }
	
	public class Bcompolisten implements ActionListener {
        JPanel shop;
         
        public Bcompolisten(Shop shop)
        {
            this.shop = shop;
        }
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == bcompo[0]) {
            	
            	
        	    JPanel liste = new JPanel();
        	    liste.setBackground(new Color(0,true));
        	    shop.setLayout(new BorderLayout());
        	    shop.add(liste, BorderLayout.WEST);
        	    //On définit le layout manager
        	    liste.setLayout(new GridBagLayout());
        	         
        	    //L'objet servant à positionner les composants
        	    GridBagConstraints gbc = new GridBagConstraints();
        	    
        	    JPanel [] compo = new JPanel[4];
        	    
        	    compo[0].setBackground(Color.YELLOW);
        	    compo[1].setBackground(Color.RED);
        	    compo[2].setBackground(Color.GREEN);
        	    compo[3].setBackground(Color.BLACK);

        	    
        	    for(int i=0;i<compo.length;i++){
        	    	compo[i].setPreferredSize(new Dimension(100, 100));
        	    	gbc.gridx = i;
        	    	liste.add(compo[i],gbc);
        	    }
            	
            }
            else if (e.getSource() == bcompo[1]) {
            	
            }
            else if (e.getSource() == bcompo[2]) {
            	
            }
            else if (e.getSource() == bcompo[3]) {
            	
            }
            else if (e.getSource() == bcompo[4]) {
            	
            }
            else if (e.getSource() == bcompo[5]) {
	
            }
            
            //On ajoute le conteneur
    	    //shop.add(liste, BorderLayout.NORTH);
            shop.revalidate();
            
        }
    }
	         
}
