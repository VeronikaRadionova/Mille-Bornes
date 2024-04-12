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
	
	/*public boolean estBloque() {
		return estBloque();
	}*/
	
	public boolean estBloque() {
		List <Bataille> pB = getPileBataille();
		Set <Botte> eB = getEnsembleBotte();
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
				
				if (eB.contains(new Botte(1, sommetPile.getType()))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	/*public void deposer(Botte carte) {
		ensembleBotte.add((Botte)carte);
	}
	
	public void deposer(Borne carte) {
		collectionBorne.add((Borne)carte);
	}
	
	public void deposer(Limite carte) {
		pileLimite.add((Limite)carte);
	}
	
	public void deposer(Bataille carte) {
		pileBataille.add((Bataille)carte);
	}*/
	
	
	boolean estDepotLimiteAutorise(Limite carte) {
		Limite sommetPile = pileLimite.get(pileLimite.size() - 1);
		
		if (carte instanceof DebutLimite) {
			if (!ensembleBotte.contains(Cartes.PRIORITAIRE) && (pileLimite.isEmpty() || sommetPile instanceof FinLimite)) {
				return true;
			}
		}
		
		if (carte instanceof FinLimite) {
			if (ensembleBotte.contains(Cartes.PRIORITAIRE) || (pileLimite.isEmpty() || sommetPile instanceof FinLimite)) {
				return true;
			}
		}
		return false;
	}
	
	boolean estDepotBatailleAutorise(Bataille carte){
		// problème !!!
		if (!ensembleBotte.contains(new Botte(1, ((Bataille)carte).getType()))) {
			return true; 
		}
		
		if (carte instanceof Attaque && !estBloque()) {
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
			
			if (!estBloque() && borne.getKm() <= Joueur.donnerLimitationVitesse() && Joueur.donnerKmParcourus() <= 1000) {
				return true;
			}
		}
		
		if (carte instanceof Limite) {
			return estDepotLimiteAutorise((Limite)carte);
		}
		
		if (carte instanceof Bataille) {
			return estDepotBatailleAutorise((Bataille)carte);
		}
		
		return false;
	}
	
	public boolean deposer(Carte carte) {
		if (!estDepotAutorise(carte)) {
			return false;
		} else {
			if (carte instanceof Limite) {
				pileLimite.add((Limite)carte);
			} 
			else if (carte instanceof Bataille) {
				pileBataille.add((Bataille)carte);
			} 
			else if (carte instanceof Borne) {
				collectionBorne.add((Borne)carte);
			} 
			else if (carte instanceof Botte) {
				ensembleBotte.add((Botte)carte);
				
				Attaque attaque = new Attaque (1, ((Botte)carte).getType());
				if (pileBataille.contains(attaque)) {
					pileBataille.remove(attaque);
				}
			}
			return true;
		}
	}
	
	
	
	
	
	
	
	

}
