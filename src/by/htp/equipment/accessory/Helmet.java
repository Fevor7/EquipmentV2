package by.htp.equipment.accessory;

import by.htp.equipment.entity.Scooter;

public class Helmet extends Accessory {
	private String color;
	private Scooter affiliation = null;

	public Helmet() {
		super();
		super.setTitle("Helmet");
	}

	public Helmet(int id, String color) {
		super(id, "Helmet");
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Scooter getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(Scooter affiliation) {
		this.affiliation = affiliation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Helmet other = (Helmet) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Helmet [color=" + color + ", affiliation=" + affiliation + ", toString()=" + super.toString() + "]";
	}

}
