package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;

public class TestTP1 {

	public static void main(String[] args) {
		System.out.println("TEST A:\n");
		
		// initialisation
		Sabot sabot = new Sabot(10);
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asVolant = new Botte(1, Type.ACCIDENT);
		
		// ajouter des cartes et piocher
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);
		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("je pioche " + carte);
		}
		
		System.out.println("\n");
		System.out.println("TEST B:\n");
		
		// réinitialisation d'un sabot
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);

		Iterator<Carte> iterCarte = sabot.iterator();
        while (iterCarte.hasNext()) {
            Carte carte = iterCarte.next();
            System.out.println("je pioche " + carte);
            iterCarte.remove();
        }
        
        System.out.println("\n");
        System.out.println("TEST C:\n");
        
        // réinitialisation d'un sabot
     		sabot.ajouterFamilleCarte(accident, reparation, asVolant);
        
        Iterator<Carte> iterCarte2 = sabot.iterator();
        while (iterCarte2.hasNext()) {
        	//Carte cartePiochee = iterCarte.next();
            Carte cartePiochee = sabot.piocher();
            System.out.println("je pioche " + cartePiochee);
            // si on ajoute l'ajout de la carte dans cette boucle, il ne va pas s'arrêter
        }

        // essaie d'ajout de "As du volant" après avoir utilisé la méthode piocher
        try {
            sabot.ajouterCarte(new Botte(1, Type.ACCIDENT));
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception : " + e.getMessage());
        }
	}

}
