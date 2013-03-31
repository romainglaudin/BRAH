import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	
	Random r = new Random();
	int random = 10 + r.nextInt(40 - 10);
	int xnuage = -50;
	int ynuage = 10;
	
	
	  public void paintComponent(Graphics g){
		    try {
		      BufferedImage fond = ImageIO.read(new File("image/fond.png"));
		      Image nuage = ImageIO.read(new File("image/nuage.png"));
		      Image accueil = ImageIO.read(new File ("image/accueil_transp.png"));
		    		  
		      g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		      g.drawImage(accueil, 0, 0, this.getWidth(), this.getHeight(), this);
		      g.drawImage(nuage, xnuage, ynuage, this.getWidth()/8, this.getHeight()/7, this);
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }
  }  