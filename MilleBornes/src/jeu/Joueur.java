package jeu;

//import java.util.ArrayList;

//import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainAsListe main;


	public Joueur(String nom) {
		this.nom = nom;
		this.zone = new ZoneDeJeu();
		this.main = new MainAsListe();
	}


	public String getNom() {
		return nom;
	}
	
	public ZoneDeJeu getZone() {
		return zone;
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
			zone.getPileLimite().add((Limite) carte);
		} 
		else if (carte instanceof Bataille) {
			zone.getPileBataille().add((Bataille) carte);
		} 
		else if (carte instanceof Borne) {
			zone.getCollectionBorne().add((Borne) carte);
		} 
		else if (carte instanceof Botte) {
			zone.getEnsembleBotte().add((Botte) carte);
		}
		
		return carte;
	}
	
	public int donnerKmParcourus() {
		int kmParcourus = 0;
		for (Borne borne : zone.getCollectionBorne()) {
			kmParcourus += borne.getKm();
		}
		return kmParcourus;
	}
	
	public boolean possedeBotteType (Type type) {
		for (Botte botte : zone.getEnsembleBotte()) {
			if (botte.getType() == type) {
				return true;
			}
		}
		return false;
	}
	
	public int donnerLimitationVitesse() {
		List <Limite> pL = zone.getPileLimite();
		
		if (pL.isEmpty()) { 
			return 200; 
		}
		
		Carte sommetPile = pL.get(pL.size() - 1);
		if ((sommetPile instanceof FinLimite) || sommetPile == Cartes.PRIORITAIRE) {
			return 200;
		}
		return 50;
		
	}
	
	public boolean estBloque1() {
		List <Bataille> pB = zone.getPileBataille();
		boolean prioritaire = possedeBotteType(Type.FEU);
		
		if (pB.isEmpty() && prioritaire) {
			return false;
		}
		
		Bataille sommetPile = pB.get(pB.size() - 1);
		
		if (sommetPile.equals(Cartes.FEU_VERT)) {
			return false;
		} else if (prioritaire) {
			if (sommetPile instanceof Parade) {
				return false;
			}
			if (sommetPile.equals(Cartes.FEU_ROUGE)) {
				return false;
			} else if (possedeBotteType(sommetPile.getType())) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
	public boolean estBloque() {
		List <Bataille> pB = zone.getPileBataille();
		Set <Botte> eB = zone.getEnsembleBotte();
		boolean prioritaire = eB.contains(Cartes.PRIORITAIRE);
		
		if (pB.isEmpty() && prioritaire) {
			return false;
		}
		
		Bataille sommetPile = pB.get(pB.size() - 1);
		
		if (sommetPile.equals(Cartes.FEU_VERT)) {
			return false;
		} else if (prioritaire) {
			if (sommetPile instanceof Parade) {
				return false;
			}
			
			if (sommetPile instanceof Attaque) {
				if (sommetPile.equals(Cartes.FEU_ROUGE)) {
					return false;
				}
				
				/*for (Botte botte : eB) {
					if (botte.getType() == sommetPile.getType()) {
						return false;
					}
				}*/
				for (Botte botte : eB) {
					System.out.println("AAAAAAA" + botte.equals(new Botte(1, sommetPile.getType())));
				}
				
				
				if (eB.contains(new Botte(1, sommetPile.getType()))) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	

}
