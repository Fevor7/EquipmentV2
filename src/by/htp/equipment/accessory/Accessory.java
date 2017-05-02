package by.htp.equipment.accessory;

public abstract class Accessory {
	private String title;
	private int id;
	private boolean availabilityInStock = true;
	private String nameOfTenant;

	public Accessory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accessory(int id, String title) {
		super();
		this.title = title;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAvailabilityInStock() {
		return availabilityInStock;
	}

	public void setAvailabilityInStock(boolean availabilityInStock) {
		this.availabilityInStock = availabilityInStock;
	}

	public String getNameOfTenant() {
		return nameOfTenant;
	}

	public void setNameOfTenant(String nameOfTenant) {
		this.nameOfTenant = nameOfTenant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (availabilityInStock ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((nameOfTenant == null) ? 0 : nameOfTenant.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Accessory other = (Accessory) obj;
		if (availabilityInStock != other.availabilityInStock)
			return false;
		if (id != other.id)
			return false;
		if (nameOfTenant == null) {
			if (other.nameOfTenant != null)
				return false;
		} else if (!nameOfTenant.equals(other.nameOfTenant))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accessory [title=" + title + ", id=" + id + ", availabilityInStock=" + availabilityInStock
				+ ", nameOfTenant=" + nameOfTenant + "]";
	}

}
