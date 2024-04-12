package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Cartes;
import jeu.ZoneDeJeu;
import jeu.Joueur;

public class TestTP4 {

	public static void main(String[] args) {
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		
		System.out.println("Deposer carte Feu rouge");
		boolean b = zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		System.out.println("dépôt ok ? " + b);
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte attaque - accident");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Attaque(0, Type.ACCIDENT)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte botte - accident");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Botte(0, Type.ACCIDENT)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte Feu vert");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(Cartes.FEU_VERT));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte attaque - essence");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Attaque(0, Type.ESSENCE)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte parade - essence");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Parade(0, Type.ESSENCE)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte Feu vert");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(Cartes.FEU_VERT));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte borne - 100");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte limite - 50");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new DebutLimite(0)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte borne - 100");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte borne - 25");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 25)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte fin limite - 50");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new FinLimite(0)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		
		System.out.println("Deposer carte borne - 100");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
	}

}
