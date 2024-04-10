package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte{
	public enum Type {FEU, ESSENCE, CREVAISON, ACCIDENT};
	protected Type type;

	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
	
}
