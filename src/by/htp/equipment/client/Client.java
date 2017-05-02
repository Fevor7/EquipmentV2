package by.htp.equipment.client;

import java.util.ArrayList;
import java.util.List;
import by.htp.equipment.array.RenUnit;

public class Client {
	private String name;
	private RenUnit renUnit = new RenUnit();
	private List<Integer> arrayID = new ArrayList<Integer>();

	public Client(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RenUnit getRenUnit() {
		return renUnit;
	}

	public void setRenUnit(RenUnit renUnit) {
		this.renUnit = renUnit;
	}

	public List<Integer> getArrayID() {
		return arrayID;
	}

	public void setArrayID(List<Integer> arrayID) {
		this.arrayID = arrayID;
	}

}
