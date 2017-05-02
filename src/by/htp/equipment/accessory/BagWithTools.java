package by.htp.equipment.accessory;

import by.htp.equipment.entity.Scooter;

public class BagWithTools extends Accessory {
	private int numberOfTools;
	private Scooter affiliation = null;

	public BagWithTools() {
		super();
		super.setTitle("BagWithTools");
	}

	public BagWithTools(int id, int numberOfTools) {
		super(id, "BagWithTools");
		this.numberOfTools = numberOfTools;
	}

	public int getNumberOfTools() {
		return numberOfTools;
	}

	public void setNumberOfTools(int numberOfTools) {
		this.numberOfTools = numberOfTools;
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
		result = prime * result + numberOfTools;
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
		BagWithTools other = (BagWithTools) obj;
		if (numberOfTools != other.numberOfTools)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BagWithTools [numberOfTools=" + numberOfTools + ", affiliation=" + affiliation + ", toString()="
				+ super.toString() + "]";
	}
}
