package jeu;

import cartes.Carte;

public class Coup {
	private Carte carte;
	private Joueur jCible;

	
	public Coup(Carte carte, Joueur jCible) {
		super();
		this.carte = carte;
		this.jCible = jCible;
	}
	
	public Carte getCarte() {
		return carte;
	}
	
	public Joueur getjCible() {
		return jCible;
	}
	
	

}
