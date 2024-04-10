package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {
	private List <Limite> pileLimite;
	private List <Bataille> pileBataille;
	private List <Borne> collectionBorne;
	private Set <Botte> ensembleBotte;
	
	public ZoneDeJeu() {
		pileLimite = new ArrayList<Limite>();
		pileBataille = new ArrayList<Bataille>();
		collectionBorne = new ArrayList<Borne>();
		ensembleBotte = new HashSet<Botte>();
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
	
	boolean estDepotLimiteAutorise(Limite carte) {
		if (carte instanceof DebutLimite) {
			Limite sommetPile = pileLimite.get(pileLimite.size() - 1);
			
			if (!ensembleBotte.contains(Cartes.PRIORITAIRE) && (pileLimite.isEmpty() || sommetPile instanceof FinLimite)) {
				return true;
			}
		}
		
		if (carte instanceof FinLimite) {
			Limite sommetL = pileLimite.get(pileLimite.size() - 1);
			
			if (!ensembleBotte.contains(Cartes.PRIORITAIRE) && !(pileLimite.isEmpty() || sommetL instanceof FinLimite)) {
				return true;
			}
		}
		return false;
	}
	
	boolean estDepotBatailleAutorise(Bataille carte){
		if (!ensembleBotte.contains(new Botte(1, ((Bataille)carte).getType()))) {
			return true;
		}
		
		if (carte instanceof Attaque && !Joueur.estBloque()) {
			return true;
		}
		
		
		if (carte instanceof Parade) {
			Bataille sommetB = pileBataille.get(pileBataille.size() - 1);
			
			if (carte.equals(Cartes.FEU_VERT)) {
				if (pileBataille.isEmpty()) {
					return true;
				}
				
				if (sommetB.equals(Cartes.FEU_ROUGE)) {
					return true;
				}
				
				if (sommetB instanceof Parade && !sommetB.equals(Cartes.FEU_VERT)) {
					return true;
				}
			} else {
				if (!pileBataille.isEmpty() && sommetB instanceof Attaque && sommetB.equals(new Attaque(1, ((Parade)carte).getType()))) {
					return true;
				}
			}
				
		}
		return false;
	}
	
	
	boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Botte) {
			return true;
		}
		
		if (carte instanceof Borne) {
			Borne borne = (Borne) carte;
			
			if (!Joueur.estBloque() && borne.getKm() <= Joueur.donnerLimitationVitesse() && Joueur.donnerKmParcourus() <= 1000) {
				return true;
			}
		}
		
		if (carte instanceof Limite) {
			if (estDepotLimiteAutorise((Limite)carte)) {
				return true;
			}
		}
		
		if (carte instanceof Bataille) {
			if (estDepotBatailleAutorise((Bataille)carte)) {
				return true;
			}
		}
		
		return false;
	}

}
