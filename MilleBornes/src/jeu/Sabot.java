package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable <Carte>{
	private Carte[] cartes;
	private int nbCartes = 0;
	private int nbMax;
	private int nbOperations;

	public Sabot(int nbMax) {
		//this.nbCartes = nbCartes;
		this.cartes = new Carte[nbMax];
	}
	
	public Iterator <Carte> iterator() {
		return new Iterateur();
	}
	
	/* DEBUT CLASSE INTERNE ITERATEUR */
	private class Iterateur implements Iterator <Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsRef = nbOperations;
		
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			int i = indiceIterateur;
			while (i < nbCartes) {
				cartes[i-1] = cartes[i];
				i++;
			}
			nbCartes--;
			nextEffectue = false;
			indiceIterateur--;
			nbOperations++;
			nbOperationsRef++;
		}
		
		private void verificationConcurrence() {
			if (nbOperationsRef != nbOperations) {
				throw new ConcurrentModificationException();
			}
		}
	}
	/* FIN CLASSE INTERNE ITERATEUR */
	 
	
	public boolean estVide() {
		if (nbCartes == 0) return true;
		return false;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes < this.cartes.length) {
			this.cartes[nbCartes] = carte;
			nbCartes++;
			nbOperations++;
		} else throw new ArrayIndexOutOfBoundsException("Plus de place");
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		int i = 0;
		while (i < carte.getNombre()) {
			ajouterCarte(carte);
			i++;
		}
	}
	
	public void ajouterFamilleCarte(Carte...cartes) {
		int i = 0;
		while (i < cartes.length) {
			Carte carte = cartes[i];
			ajouterFamilleCarte(carte);
			i++;
		}
	}
	
	public Carte piocher() {
		Carte carte = null;
		Iterator<Carte> iterCarte = iterator();
		//if (iterCarte.hasNext()) {
			carte = iterCarte.next();
			iterCarte.remove();
		//}
		return carte;
	}
}
