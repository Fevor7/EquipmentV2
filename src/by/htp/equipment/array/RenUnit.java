package by.htp.equipment.array;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.accessory.Accessory;
import by.htp.equipment.entity.*;

public class RenUnit {

	private List<Equipment> equip = new ArrayList<Equipment>();
	private List<Accessory> access = new ArrayList<Accessory>();

	public List<Equipment> getEquip() {
		return equip;
	}

	public void setEquip(List<Equipment> equip) {
		this.equip = equip;
	}

	public List<Accessory> getAccess() {
		return access;
	}

	public void setAccess(List<Accessory> access) {
		this.access = access;
	}

}
