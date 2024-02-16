package cartes;

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
