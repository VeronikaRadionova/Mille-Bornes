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
		
		if (carte instanceof DebutLimite) {
			if (!ensembleBotte.contains(Cartes.PRIORITAIRE) && pileLimite.isEmpty()) {
				return true;
			}
		}
		
		if (carte instanceof FinLimite) {
			if (!ensembleBotte.contains(Cartes.PRIORITAIRE) && !pileLimite.isEmpty()) {
				return true;
			}
		}
		
		if (carte instanceof Bataille) {
			Bataille top = pileBataille.get(pileBataille.size() - 1);
			
			if (top == null) {
				if (ensembleBotte.contains(Cartes.PRIORITAIRE) || carte == Cartes.FEU_ROUGE) {
					top = Cartes.FEU_VERT;
				} else {
					top = Cartes.FEU_ROUGE;
				}
			}
			
			if (top instanceof Attaque && !ensembleBotte.contains(top.getType())) {
				if (carte.equals(new Parade(1, top.getType()))) {
					return true;
				}
			}
			
			if (top instanceof Parade) {
				if (/* qqch avec botte déposée */) {
					return true;
				}
			}
		}
		
		return false;
	}

}
