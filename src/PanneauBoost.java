import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauBoost extends JPanel {
	 public void paintComponent(Graphics g){
		 
		    try {
		      CBoost boost = new CBoost ();
		      //BufferedImage fond = ImageIO.read(new File(roue.nomimage));
		      Image accueil = ImageIO.read(new File (boost.nomimage));
		    		  
		      //g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		      g.drawImage(accueil, 0, 0, this.getWidth(), this.getHeight(), null);
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }

}
