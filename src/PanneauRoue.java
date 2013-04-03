import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PanneauRoue extends JPanel {
	public PanneauRoue(){
		this.setSize(200,200);
	}
	 public void paintComponent(Graphics g){
		    try {
		      CRoue roue = new CRoue ();
		      //BufferedImage fond = ImageIO.read(new File(roue.nomimage));
		      Image accueil = ImageIO.read(new File (roue.nomimage));
		    		  
		      //g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		      g.drawImage(accueil, 0, 0, this.getWidth(), this.getHeight(), null);
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }

}
