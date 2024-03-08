package testsFonctionnels;

import java.util.ArrayList;
import java.util.Arrays;
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
import utils.Utils;

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
		System.out.println("\nVérification des quantités d'exeplaires pour toutes les cartes: " + cartes.checkCount() + "\n\n");
		
		
		System.out.println("TEST des méthodes 'melanger', 'rassembler' et 'verifierRassemblement':\n");
		
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee); System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? " + Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes + "\n");
		
		// sur des tableaux proposés
		Integer[] tableau0 = {};
        List<Integer> liste0 = Arrays.asList(tableau0);
        System.out.println("[]: " /*+ Utils.verifierRassemblement(liste0)*/);
        liste0 = Utils.rassembler(liste0);
        System.out.println(liste0.toString() + ": " /*+ Utils.verifierRassemblement(liste0)*/ + "\n");
        
		Integer[] tableau1 = {1, 1, 2, 1, 3};
        List<Integer> liste1 = Arrays.asList(tableau1);
        System.out.println("[1, 1, 2, 1, 3]: " /*+ Utils.verifierRassemblement(liste1)*/);
        liste1 = Utils.rassembler(liste1);
        System.out.println(liste1.toString() + ": " + /*Utils.verifierRassemblement(liste1) +*/ "\n");
		
        Integer[] tableau2 = {1, 4, 3, 2};
        List<Integer> liste2 = Arrays.asList(tableau2);
        System.out.println("[1, 4, 3, 2]: " /*+ Utils.verifierRassemblement(liste2)*/);
        liste2 = Utils.rassembler(liste2);
        System.out.println(liste2.toString() + ": " + /*Utils.verifierRassemblement(liste2) +*/ "\n");
        
        Integer[] tableau3 = {1, 1, 2, 3, 1};
        List<Integer> liste3 = Arrays.asList(tableau3);
        System.out.println("[1, 1, 2, 3, 1]: " /*+ Utils.verifierRassemblement(liste3)*/);
        liste3 = Utils.rassembler(liste3);
        System.out.println(liste3.toString() + ": " + /*Utils.verifierRassemblement(liste3) +*/ "\n");
	}

}
