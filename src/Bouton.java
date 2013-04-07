import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.JButton;
  
public class Bouton extends JButton implements MouseListener{
  private Image img;
  private String Simage;
  private String Simg_souris;
  private String Simg_clic;
  int categorie;
 
  public Bouton(String str, String image, String image_souris, String image_clic, int nbr){
    super(str);
    categorie=nbr;
    this.Simage = image;
    this.Simg_souris = image_souris;
    this.Simg_clic = image_clic;
    try {
      this.img = ImageIO.read(new File(image));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.addMouseListener(this);
  }
 
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
  }
 
  public void mouseClicked(MouseEvent event) {    
  }
 
  public void mouseEntered(MouseEvent event) {    
    try {
      img = ImageIO.read(new File(Simg_souris));   
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
 
  public void mouseExited(MouseEvent event) {
    try {
      img = ImageIO.read(new File(Simage));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
 
  public void mousePressed(MouseEvent event) {
    try {
      img = ImageIO.read(new File(Simg_clic));      
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
 
  public void mouseReleased(MouseEvent event) {
	  if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
      try {
        img = ImageIO.read(new File(Simg_souris));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    else{
      try {
        img = ImageIO.read(new File(Simage)); 
      } catch (IOException e) {
        e.printStackTrace();
      }
    }   
  }   
  
  public int getCategorie (){
	  return categorie;
  }

}