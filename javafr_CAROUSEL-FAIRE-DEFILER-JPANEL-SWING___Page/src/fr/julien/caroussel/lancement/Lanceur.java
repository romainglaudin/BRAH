package fr.julien.caroussel.lancement;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.julien.caroussel.Carousel;

public class Lanceur {

	public static void main(String[] args) {
		List<JPanel> entree = new ArrayList<JPanel>();
		JPanel p1 = new JPanel();
		p1.setBackground(Color.BLUE);
		entree.add(p1);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.MAGENTA);
		entree.add(p2);
		JPanel p3 = new JPanel();
		p3.setBackground(Color.GRAY);
		entree.add(p3);
		JPanel p4 = new JPanel();
		p4.setBackground(Color.PINK);
		entree.add(p4);
		JPanel p5 = new JPanel();
		p5.setBackground(Color.GREEN);
		entree.add(p5);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 300, 200);
		f.add(new Carousel(3, entree));
		f.setVisible(true);
	}

}
