package by.htp.equipment.entity;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.accessory.Accessory;

public abstract class Equipment {
	private String title;
	private int id;
	private boolean availabilityInStock = true;
	private String nameOfTenant;
	private String timeStartRenting;
	private String timeStopRenting;
	private String type;
	private List<Accessory> accessory = new ArrayList<Accessory>();
	public Equipment() {
		super();
	}

	public Equipment(int id, String title, String type) {
		super();
		this.title = title;
		this.id = id;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
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

	public String getTimeStartRenting() {
		return timeStartRenting;
	}

	public void setTimeStartRenting(String timeStartRenting) {
		this.timeStartRenting = timeStartRenting;
	}

	public String getTimeStopRenting() {
		return timeStopRenting;
	}

	public void setTimeStopRenting(String timeStopRenting) {
		this.timeStopRenting = timeStopRenting;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessory == null) ? 0 : accessory.hashCode());
		result = prime * result + (availabilityInStock ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((nameOfTenant == null) ? 0 : nameOfTenant.hashCode());
		result = prime * result + ((timeStartRenting == null) ? 0 : timeStartRenting.hashCode());
		result = prime * result + ((timeStopRenting == null) ? 0 : timeStopRenting.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Equipment other = (Equipment) obj;
		if (accessory == null) {
			if (other.accessory != null)
				return false;
		} else if (!accessory.equals(other.accessory))
			return false;
		if (availabilityInStock != other.availabilityInStock)
			return false;
		if (id != other.id)
			return false;
		if (nameOfTenant == null) {
			if (other.nameOfTenant != null)
				return false;
		} else if (!nameOfTenant.equals(other.nameOfTenant))
			return false;
		if (timeStartRenting == null) {
			if (other.timeStartRenting != null)
				return false;
		} else if (!timeStartRenting.equals(other.timeStartRenting))
			return false;
		if (timeStopRenting == null) {
			if (other.timeStopRenting != null)
				return false;
		} else if (!timeStopRenting.equals(other.timeStopRenting))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipment [title=" + title + ", id=" + id + ", availabilityInStock=" + availabilityInStock
				+ ", nameOfTenant=" + nameOfTenant + ", timeStartRenting=" + timeStartRenting + ", timeStopRenting="
				+ timeStopRenting + ", type=" + type + ", accessory=" + accessory + "]";
	}

}
