package by.htp.equipment.entity;

public class Scooter extends Equipment {
	private int speed;

	public Scooter() {
		super();
		super.setTitle("Scooter");
		// TODO Auto-generated constructor stub
	}

	public Scooter(int id, String title, String type, String speed) {
		super(id, "Scooter", type);
		this.speed = Integer.parseInt(speed);

	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + speed;
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
		Scooter other = (Scooter) obj;
		if (speed != other.speed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scooter [speed=" + speed + ", toString()=" + super.toString() + "]";
	}

}
