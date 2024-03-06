package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}

	public int getKm() {
		return km;
	}
	
	@Override
	public String toString() {
		return "Borne de " + km + " km";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return km == borne.getKm() ;
		}
		return false;
	}
}
