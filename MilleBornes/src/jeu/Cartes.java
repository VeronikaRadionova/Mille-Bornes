package jeu;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Probleme.Type;

public interface Cartes {
	public static Botte PRIORITAIRE = new Botte (1, Type.FEU);
	public static Attaque FEU_ROUGE = new Attaque (1, Type.FEU);
	public static Parade FEU_VERT = new Parade (1, Type.FEU);
}
