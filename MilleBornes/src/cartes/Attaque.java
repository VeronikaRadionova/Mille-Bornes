package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (getType()) {
		case FEU: 
			return "Feu rouge";
		case ESSENCE: 
			return "Panne d'essence";
		case ACCIDENT: 
			return "Accident";
		case CREVAISON:
			return "Crevaison";
		}
		return "Erreur";
	}
}
