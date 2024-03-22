package jeu;

import java.util.Iterator;

import cartes.Carte;

public interface Main {
	
	public void prendre(Carte carte);
	
	public void jouer(Carte carte);
	
	Iterator<Carte> iterateur();
	

}
