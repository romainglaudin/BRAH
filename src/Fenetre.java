import javax.swing.JFrame;
  
public class Fenetre extends JFrame {
	
  public Fenetre(){                
    this.setTitle("BRAH");
    this.setSize(800,600);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    this.setVisible(true);
  }  
  
  public static void main(String[] args) {
      new Fenetre();
  }
  
}