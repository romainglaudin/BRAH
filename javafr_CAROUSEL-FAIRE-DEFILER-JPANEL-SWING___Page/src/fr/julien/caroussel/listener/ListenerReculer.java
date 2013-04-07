package fr.julien.caroussel.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.julien.caroussel.Carousel;

public class ListenerReculer implements MouseListener{
	
	private Carousel caroussel;
	
	public ListenerReculer(Carousel c){
		this.caroussel=c;
	}
	
	public void mouseReleased(MouseEvent arg0) {
		caroussel.reculer();
	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseClicked(MouseEvent arg0) {

	}

}
