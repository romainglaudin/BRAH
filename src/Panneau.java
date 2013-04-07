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
	
	int nbrNuage = 10;
	int[] ynuage = new int[nbrNuage];
	int[] xnuage = new int[nbrNuage];
	int random;
	
	public void defNuage (){
		for(int i=0;i<xnuage.length;i++){
			Random r = new Random();
			random =-150 + r.nextInt(80 - (-150));
			xnuage[i]=-20+random+i*80;
			if(i%3==0)
				ynuage[i]=10*i;
			else if (i%2==0)
				ynuage[i] =-20+i*30;
			else
				ynuage[i] = random + 60;
			}
	}
			
	  public void paintComponent(Graphics g){
		    try {
		      BufferedImage fond = ImageIO.read(new File("image/fond.png"));
		      Image nuage = ImageIO.read(new File("image/nuage.png"));
		      Image accueil = ImageIO.read(new File ("image/accueil_transp.png"));
		      
		      Image Tnuage [] = new Image [nbrNuage];
		    		  
		      g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		      g.drawImage(accueil, 0, 0, this.getWidth(), this.getHeight(), this);
		      
		      
		      
		      for (int i=0; i<Tnuage.length;i++){
		    	  g.drawImage(nuage, xnuage[i], ynuage[i], this.getWidth()/8, this.getHeight()/7, this);
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }
	  
	  public int[] GetXNuage (){
		  return xnuage;
	  }
	  
	  public int[] GetYNuage (){
		  return ynuage;
	  }
	  
	  public void SetXNuage (int[] x){
		  this.xnuage = x;
	  }
	  
	  public void SetYNuage (int[] y){
		  this.ynuage = y;
	  }
  
}  