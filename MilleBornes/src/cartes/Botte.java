package cartes;

import java.util.Objects;

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
	
	public boolean equals(Object obj) {
		if (obj instanceof Botte) {
			Botte botte = (Botte) obj;
			return type.equals(botte.getType());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type);
	}
	
}
