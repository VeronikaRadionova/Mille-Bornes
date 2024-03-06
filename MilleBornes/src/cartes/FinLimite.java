package cartes;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "Fin Limite de vitesse";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof FinLimite) {
			return true;
		}
		return false;
	}
}
