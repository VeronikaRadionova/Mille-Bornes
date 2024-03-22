package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements Main {
	protected List<Carte> listeMain;
	
	
	public MainAsListe() {
		this.listeMain = new ArrayList <Carte>();
	}
	
	@Override
	public Iterator<Carte> iterateur() {
		return null;
	}

	@Override
	public void prendre(Carte carte) {
		listeMain.add(carte);
		assert listeMain.contains(carte): "la carte n'est pas dans la main du joueur";
		
	}

	@Override
	public void jouer(Carte carte) {
		assert listeMain.contains(carte): "la carte n'est pas dans la main du joueur";
		listeMain.remove(carte);
	}

	

}
