package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Joueur;

public class TestTP3_Joueur {
	
	public static void main(String[] args) {
		System.out.println("TEST d'un méthode 'getKM':\n");
		
		Joueur bob = new Joueur("Bob");
		
		List<Carte> sabot = new ArrayList<>();
		sabot.add(new Borne(2, 55));
		sabot.add(new Borne(3, 20));
		sabot.add(new Attaque(1, Type.ACCIDENT));
		sabot.add(new Borne(4, 150));
		sabot.add(new Borne(7, 65));
        
		// test unitaire du méthode getKM()
        Carte carte = bob.prendreCarte(sabot);
        System.out.println("Carte prise par " + bob + ": " + carte);
        System.out.println("Nombre km parcourus par " + bob + ": " + bob.getKM() + "\n\n");
        
        // test de getKM() avec plusieurs cartes prises:
        while (!sabot.isEmpty()) {
        	Carte carte1 = bob.prendreCarte(sabot);
            System.out.println("Carte prise par " + bob + ": " + carte1);
            System.out.println("Nombre km parcourus par " + bob + ": " + bob.getKM() + "\n");
        }
        System.out.println("Bob a parcouru " + bob.getKM() + "km\n\n");
        
        
        
        System.out.println("TEST d'un méthode 'donnerLimitationVitesse':\n");
        
        System.out.println("Pile Limite de " + bob + " est vide");
        System.out.println("Valeur getLimite(): " + bob.donnerLimitationVitesse() + "\n");
        
        // ajout des cartes Limite dans le sabot
        sabot.add(new DebutLimite(2));
        sabot.add(new FinLimite(1));
        sabot.add(new Botte(1, Type.FEU));
        sabot.add(new DebutLimite(3));
        
        // tests de tous les cas possibles
        carte = bob.prendreCarte(sabot);
        
        System.out.println("Carte prise par " + bob + ": " + carte);
        System.out.println("Valeur getLimite(): " + bob.donnerLimitationVitesse() + "\n");
       
        carte = bob.prendreCarte(sabot);
        System.out.println("Carte prise par " + bob + ": " + carte);
        System.out.println("Valeur getLimite(): " + bob.donnerLimitationVitesse() + "\n");
        
        carte = bob.prendreCarte(sabot);
        bob.prendreCarte(sabot);
        System.out.println(bob + " possède une carte: " + carte);
        System.out.println("Valeur getLimite(): " + bob.donnerLimitationVitesse() + "\n\n");
        
	} 
        
}
