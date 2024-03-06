package cartes;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "Debut Limite de vitesse";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof DebutLimite) {
			return true;
		}
		return false;
	}
}
