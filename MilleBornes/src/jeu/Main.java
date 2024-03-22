package jeu;

import java.util.Iterator;

import cartes.Carte;

public interface Main {
	
	Iterator<Carte> iterateur();
	
	public void prendre(Carte carte);
	
	public void jouer(Carte carte);
	
	
	

}
