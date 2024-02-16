package cartes;

public class Parade extends Bataille{

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (getType()) {
		case FEU: 
			return "Feu vert";
		case ESSENCE: 
			return "Essence";
		case ACCIDENT: 
			return "Réparations";
		case CREVAISON:
			return "Roue de secours";
		}
		return "Erreur";
	}

}
