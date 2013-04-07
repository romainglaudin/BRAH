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
  
public class BoutonShop extends JButton implements MouseListener{
  private String name;
  private Image img;
 
  public BoutonShop(String str){
    super(str);
    this.name = str;
    try {
      img = ImageIO.read(new File("image/Shop.png"));
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
      img = ImageIO.read(new File("image/Shop_souris.png"));   
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
 
  public void mouseExited(MouseEvent event) {
    try {
      img = ImageIO.read(new File("image/Shop.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
 
  public void mousePressed(MouseEvent event) {
    try {
      img = ImageIO.read(new File("image/Shop_clic.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
 
  public void mouseReleased(MouseEvent event) {
    if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
      try {
        img = ImageIO.read(new File("image/Shop_souris.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else{
      try {
        img = ImageIO.read(new File("image/Shop.png")); 
      } catch (IOException e) {
        e.printStackTrace();
      }
    }   
  }   
}