package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

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
	
	public boolean estValide(Joueur joueur) { // mojet tut ne nado joueur pisat'
		if (joueur.getZone().estDepotAutorise(carte) && (carte instanceof Attaque || carte instanceof DebutLimite)) {
			return true;
		}
		return false;
	}

}
