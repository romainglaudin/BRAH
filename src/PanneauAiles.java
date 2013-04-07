import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauAiles extends PanneauComposant {
	public PanneauAiles(){
		this.composant = new CAiles();
		
	}
	 public void paintComponent(Graphics g){
		 
		    try {
		      CAiles ailes = new CAiles ();
		      //BufferedImage fond = ImageIO.read(new File(roue.nomimage));
		      Image accueil = ImageIO.read(new File (ailes.nomimage));
		    		  
		      //g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		      g.drawImage(accueil, 0, 0, this.getWidth(), this.getHeight(), null);
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }

}
