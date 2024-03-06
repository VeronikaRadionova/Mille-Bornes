package testsFonctionnels;

import java.util.List;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Probleme.Type;

public class TestTP2 {

	public static void main(String[] args) {
		System.out.println("TEST des méthodes 'equals':\n");
		
		// initialisation
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asVolant = new Botte(1, Type.ACCIDENT);
		Botte asVolant2 = new Botte(3, Type.ACCIDENT);
		Borne borne = new Borne(2, 5);
		FinLimite fin = new FinLimite(4);
		DebutLimite debut = new DebutLimite(3);
		
		// tests
		boolean egaux = fin.equals(debut);
		System.out.println("finLimite et debutLimite : " + egaux);
		boolean egaux1 = accident.equals(borne);
		System.out.println("accident et borne : " + egaux1);
		boolean egaux2 = reparation.equals(fin);
		System.out.println("parade et finLimite : " + egaux2);
		boolean egaux3 = asVolant.equals(asVolant2);
		System.out.println("botte et botte : " + egaux3 + "\n");
		
		
		System.out.println("TEST des méthodes 'getListeCartes' et 'checkCount':\n");
		
		// getListeCartes
		JeuDeCartes cartes = new JeuDeCartes();
		System.out.println("Toutes les cartes:\n");
		List <Carte> toutesCartes = cartes.getListeCartes();
		for (int i = 0; i < toutesCartes.size(); i++) {
			System.out.println(toutesCartes.get(i));
		}
		
		// checkCount
		System.out.println("\nVérification des quantités d'exeplaires pour toutes les cartes: " + cartes.checkCount() + "\n");
		
	}

}
