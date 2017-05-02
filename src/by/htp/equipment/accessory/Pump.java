package by.htp.equipment.accessory;

import by.htp.equipment.entity.Scooter;

public class Pump extends Accessory{
	private double weight;
	private Scooter affiliation = null;

	public Pump() {
		super();
		super.setTitle("Pump");
		// TODO Auto-generated constructor stub
	}

	public Pump(int id, double weight) {
		super(id, "Pump");
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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
		int result = 1;
		result = prime * result + ((affiliation == null) ? 0 : affiliation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pump other = (Pump) obj;
		if (affiliation == null) {
			if (other.affiliation != null)
				return false;
		} else if (!affiliation.equals(other.affiliation))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pump [weight=" + weight + ", affiliation=" + affiliation + ", toString()=" + super.toString() + "]";
	}

}
