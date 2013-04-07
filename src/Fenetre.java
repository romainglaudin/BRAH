import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
  
public class Fenetre extends JFrame {

	Bouton jouer;
	Bouton shop;
	Bouton quitter;
	Panneau P = new Panneau ();
	
    public Fenetre() throws InterruptedException{
    	init_param_fenetre();
    	placer_bouton();
    	
    	// On écoute les boutons
        jouer.addActionListener(new Blisten(this));
        quitter.addActionListener(new Blisten(this)); 
        shop.addActionListener(new Blisten(this));
        
        this.setVisible(true);
        go();
    }
     
    public class Blisten implements ActionListener {
        Fenetre fen;
         
        public Blisten(Fenetre fen)
        {
            this.fen = fen;
        }
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == jouer) {
            	fen.setContentPane(new FenConstruction());
            }
            else if (e.getSource() == shop) {
            	fen.setContentPane(new Shop());
            }
            else if (e.getSource() == quitter) {
            	System.exit(0);
            }
            
            fen.revalidate();
            
        }
    }
     
    void init_param_fenetre() throws InterruptedException {
        this.setTitle("BRAH");
        this.setMinimumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);  
        this.setContentPane(P);
    }
    
    void placer_bouton() {
    	jouer=new Bouton("", "image/Jouer.png", "image/Jouer_souris.png", "image/Jouer_clic.png",0);
        jouer.setPreferredSize(new Dimension(200, 80));
        jouer.setBorderPainted(false);
        shop=new Bouton("", "image/Shop.png", "image/Shop_souris.png", "image/Shop_clic.png",1);
        shop.setPreferredSize(new Dimension(200, 80));
        shop.setBorderPainted(false);
        quitter =new Bouton("", "image/Quitter.png", "image/Quitter_souris.png", "image/QUitter_clic.png",2);
        quitter.setPreferredSize(new Dimension(200, 80));
        quitter.setBorderPainted(false);
        
        JPanel [] p = new JPanel[3];
        
        for (int i=0 ; i<3 ; i++){
            p[i]= new JPanel();
            p[i].setBackground(null);
            }
            
            p[0].add(jouer);
            p[1].add(shop);
            p[2].add(quitter);
            
            JPanel pbouton = new JPanel();
            
            GridBagLayout gbl = new GridBagLayout();
            pbouton.setLayout(gbl);
                 
            GridBagConstraints gbc = new GridBagConstraints();
                 
            
            gbc.gridy = 0;
            
            pbouton.add(p[0], gbc);
            
            gbc.gridy = 1;
            pbouton.add(p[1], gbc);
            
            gbc.gridy = 2;      
            pbouton.add(p[2], gbc);
            
            pbouton.setBackground(new Color(0,true));
            
            this.setLayout(new BorderLayout());
            this.add(pbouton, BorderLayout.EAST);
    }
    
    public void go() throws InterruptedException {
		P.defNuage();
		int [] x = P.GetXNuage();
		
		while (true){
			for(int i=0; i<P.nbrNuage;i++){
				x[i]++;
				Thread.sleep(10);
				P.SetXNuage(x);
				P.repaint();
				if(x[i]-20>P.getWidth()){
					x[i]=-100;
				}
			}
		}
	}
    
    public static void main(String[] args) throws InterruptedException{
    	new Fenetre();
    }
    
}