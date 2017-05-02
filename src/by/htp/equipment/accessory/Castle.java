package by.htp.equipment.accessory;

import by.htp.equipment.entity.Scooter;

public class Castle extends Accessory {
	private int cableLength;
	private Scooter affiliation = null;

	public Castle() {
		super();
		super.setTitle("Castle");
	}

	public Castle(int id, int cableLength) {
		super(id, "Castle");
		this.cableLength = cableLength;
	}

	public int getCableLength() {
		return cableLength;
	}

	public void setCableLength(int cableLength) {
		this.cableLength = cableLength;
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
		result = prime * result + cableLength;
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
		Castle other = (Castle) obj;
		if (cableLength != other.cableLength)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Castle [cableLength=" + cableLength + ", affiliation=" + affiliation + ", toString()="
				+ super.toString() + "]";
	}

}
