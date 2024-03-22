package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Limite;

public class Joueur {
	private String nom;
	private List <Limite> pileLimite;
	private List <Bataille> pileBataille;
	private List <Borne> collectionBorne;
	private Set <Botte> ensembleBotte;
	private MainAsListe main;


	public Joueur(String nom) {
		this.nom = nom;
		pileLimite = new ArrayList<Limite>();
		pileBataille = new ArrayList<Bataille>();
		collectionBorne = new ArrayList<Borne>();
		ensembleBotte = new HashSet<Botte>();
	}


	public String getNom() {
		return nom;
	}


	public List<Limite> getPileLimite() {
		return pileLimite;
	}


	public List<Bataille> getPileBataille() {
		return pileBataille;
	}


	public List<Borne> getCollectionBorne() {
		return collectionBorne;
	}


	public Set<Botte> getEnsembleBotte() {
		return ensembleBotte;
	}


	public MainAsListe getMain() {
		return main;
	}


	@Override
	public String toString() {
		return nom;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return nom == joueur.toString();
		}
		return false;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
		// post-condition est déjà dans le méthode prendre
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if (sabot.isEmpty()) {
			return null;
		}
		Carte carte = sabot.get(0);
		sabot.remove(carte);
		donner(carte);
		
		if (carte instanceof Limite) {
			pileLimite.add((Limite) carte);
		} else if (carte instanceof Bataille) {
			pileBataille.add((Bataille) carte);
		} else if (carte instanceof Borne) {
			collectionBorne.add((Borne) carte);
		} else if (carte instanceof Botte) {
			ensembleBotte.add((Botte) carte);
		}
		
		return carte;
	}
	
	public int getKM() {
		
	}
	
	

}
