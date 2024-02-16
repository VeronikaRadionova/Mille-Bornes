package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (getType()) {
		case FEU: 
			return "Véhicule prioritaire";
		case ESSENCE: 
			return "Citerne d'essence";
		case ACCIDENT: 
			return "As du volant";
		case CREVAISON:
			return "Increvable";
		}
		return "Erreur";
	}
}
