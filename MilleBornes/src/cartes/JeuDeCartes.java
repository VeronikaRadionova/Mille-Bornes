package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {
	private Carte[] typesDeCartes = {
			new Botte(1, Type.FEU), new Botte(1, Type.ESSENCE), new Botte(1, Type.CREVAISON), new Botte(1, Type.ACCIDENT),
            new Attaque(5, Type.FEU), new Attaque(3, Type.ESSENCE), new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ACCIDENT), 
            new Parade(14, Type.FEU), new Parade(6, Type.ESSENCE), new Parade(6, Type.CREVAISON), new Parade(6, Type.ACCIDENT), 
            new Borne(10, 25), new Borne(10, 50), new Borne(10, 75), new Borne(12, 100), new Borne(4, 200),
            new DebutLimite(4), new FinLimite(6)};

	private List<Carte> listeCartes = new ArrayList<Carte>();

	public JeuDeCartes() {
		for (int i = 0; i < typesDeCartes.length; i++) {
			for (int j = 0; j < typesDeCartes[i].getNombre(); j++) {
				listeCartes.add(typesDeCartes[i]);
			}
		}
		listeCartes = Utils.melanger(listeCartes);
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	public boolean checkCount() {
		for (int i = 0; i < typesDeCartes.length; i++) {
			if (Collections.frequency(listeCartes, typesDeCartes[i]) != typesDeCartes[i].getNombre()) {
				return false;
			}
		}
		return true;
	}
	
}
