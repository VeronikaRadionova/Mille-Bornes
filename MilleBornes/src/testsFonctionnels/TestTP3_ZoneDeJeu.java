package testsFonctionnels;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
//import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Cartes;
import jeu.Joueur;

public class TestTP3_ZoneDeJeu {

	public static void main(String[] args) {
		System.out.println("TEST d'un méthode 'estBloque':\n");
        
        Joueur tom = new Joueur("Tom");
        
        List<Carte> sabot = new ArrayList<>();
        sabot.add(Cartes.FEU_ROUGE);
        sabot.add(Cartes.PRIORITAIRE);
        sabot.add(new Attaque(1, Type.ACCIDENT));
        sabot.add(new Botte(1, Type.ACCIDENT));
        sabot.add(new Attaque(1, Type.ESSENCE));
        sabot.add(new Botte(1, Type.ESSENCE));
        sabot.add(Cartes.FEU_VERT);
       
        
        tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());
		
		tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());

		tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());

		tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());
		
		tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());

		tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());
		
		// On efface les bottes et on ajoute un feu vert
		Set<Botte> bottes = tom.getZone().getEnsembleBotte();
		bottes.clear();
		System.out.println(tom.estBloque());
        
		tom.prendreCarte(sabot);
		System.out.println(tom.estBloque());
	}

}
