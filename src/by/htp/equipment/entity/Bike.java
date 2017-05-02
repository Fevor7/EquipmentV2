package by.htp.equipment.entity;

public class Bike extends Equipment {
	private String grade;
	private String gqqq;

	public Bike() {
		super();
		super.setTitle("Bike");
	}

	public Bike(int id, String title, String type, String grade) {
		super(id, "Bike", type);
		this.grade = grade;
		// TODO Auto-generated constructor stub
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade (String grade) {
		this.grade = grade;
	}

	public String getGqqq() {
		return gqqq;
	}

	public void setGqqq(String gqqq) {
		this.gqqq = gqqq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gqqq == null) ? 0 : gqqq.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
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
		Bike other = (Bike) obj;
		if (gqqq == null) {
			if (other.gqqq != null)
				return false;
		} else if (!gqqq.equals(other.gqqq))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bike [grade=" + grade + ", gqqq=" + gqqq + "]";
	}
}
